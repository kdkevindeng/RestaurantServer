package service.manage.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import service.common.ServiceResult;
import service.manage.permission.PermissionService;
import service.manage.permission.RolePermissionService;
import action.manage.permission.TreeBean;
import dao.mybatis.mapper.User_roleMapper;
import dao.mybatis.model.Role_permission;
import dao.mybatis.model.User_role;
import dao.mybatis.model.User_roleExample;
import dao.mybatis.model.User_roleExample.Criteria;

public class UserRoleService {
	Logger logger = Logger.getLogger(this.getClass());
	User_roleMapper user_roleMapper;
	RolePermissionService rolePermissionService;
	PermissionService permissionService;

	
	public PermissionService getPermissionService() {
		return permissionService;
	}
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
	public RolePermissionService getRolePermissionService() {
		return rolePermissionService;
	}
	public void setRolePermissionService(RolePermissionService rolePermissionService) {
		this.rolePermissionService = rolePermissionService;
	}
	public User_roleMapper getUser_roleMapper() {
		return user_roleMapper;
	}
	public void setUser_roleMapper(User_roleMapper user_roleMapper) {
		this.user_roleMapper = user_roleMapper;
	}
	/*
	 * */
	public ServiceResult grantRoleToUser(String userid,List<String> roleids) {
		ServiceResult result = new ServiceResult();
		if (roleids!=null&&roleids.size()>0) {
			User_roleExample deletexample=new User_roleExample();
			User_roleExample.Criteria deleteCriteria = deletexample.createCriteria();
			deleteCriteria.andUseridEqualTo(userid);
			this.user_roleMapper.deleteByExample(deletexample);
			for(int i=0;i<roleids.size();i++){
				if(roleids.get(i)!=null&&!"".equals(roleids.get(i))&&!"0".equals(roleids.get(i))){

					User_role record=new User_role();
					record.setId(UUID.randomUUID().toString());
					record.setUserid(userid);
					record.setRoleid(roleids.get(i));
					this.user_roleMapper.insertSelective(record);
				
				}
			}

			result.setResultcode(1);
			result.setDescription("grantRoleToUser success");
		
		} else {
			result.setResultcode(0);
			result.setDescription("roleids not allowed null when grantPermissionToRole");
		}
		return result;

	}
	public boolean isUserRoleExitAnd(String userid,String roleid) {

		boolean res = false;
		if (roleid != null && !"".equals(roleid)&&userid != null && !"".equals(userid)) {
			User_roleExample example=new User_roleExample();
			User_roleExample.Criteria criteria = example.createCriteria();
			criteria.andUseridEqualTo(userid);
			criteria.andRoleidEqualTo(roleid);
			 List<User_role> list = this.user_roleMapper.selectByExample(example);
			if (list.size() > 0) {
				res = true;
				logger.info(roleid+" and "+userid + " already exit");
			} else {

				logger.info(roleid+" and "+userid + " not exit");
			}
		} else {
			logger.info("roleid and permissionid do not allowed null");
		}
		return res;
	}
	public boolean isUserRoleExitOr(User_role userrole) {

		boolean res = false;
		if (userrole!=null) {
			boolean hasfilter=false;
			User_roleExample example=new User_roleExample();
			User_roleExample.Criteria criteria = example.createCriteria();
			if(userrole.getRoleid()!=null && !"".equals(userrole.getRoleid())){
				criteria.andRoleidEqualTo(userrole.getRoleid());
				hasfilter=true;
			}
			if(userrole.getUserid()!=null && !"".equals(userrole.getUserid())){
				criteria.andUseridEqualTo(userrole.getUserid());
				hasfilter=true;
			}
			if(hasfilter){
				List<User_role> list = this.user_roleMapper.selectByExample(example);
				if (list.size() > 0) {
					res = true;
					logger.info(" already exit");
				} else {

					logger.info(" not exit");
				}
			}else{
				logger.info("Roleid or userid  do not allowed both is null");
			
			}
			
		} else {
			logger.info("userrole do not allowed null");
		}
		return res;
	}
	public ServiceResult deleteUserRoleOr(User_role userrole) {
		ServiceResult result = new ServiceResult();
		if (userrole!=null) {
			boolean hasfilter=false;
			User_roleExample example=new User_roleExample();
			User_roleExample.Criteria criteria = example.createCriteria();
			if(userrole.getRoleid()!=null && !"".equals(userrole.getRoleid())){
				criteria.andRoleidEqualTo(userrole.getRoleid());
				hasfilter=true;
			}
			if(userrole.getUserid()!=null && !"".equals(userrole.getUserid())){
				criteria.andUseridEqualTo(userrole.getUserid());
				hasfilter=true;
			}
			if(hasfilter){
				int ret = this.user_roleMapper.deleteByExample(example);
				if (ret > 0) {
					result.setResultcode(1);
					result.setDescription("delete User_role success ");
				} else {
					result.setResultcode(0);
					result.setDescription("delete User_role failed ");
				}
			}else{
				logger.info("Roleid or userid  do not allowed both is null");
			
			}
			
		} else {
			logger.info("User_role do not allowed null");
		}
		
		return result;

	}
	public List<User_role> getListUser_role(User_role userrole){

		// TODO Auto-generated method stub
		boolean ishasfilter = false;
		User_roleExample example=new User_roleExample();
		Criteria criteria = example.createCriteria();
		if (userrole!=null&&userrole.getUserid() != null && !"".equals(userrole.getUserid())) {
			criteria.andUseridEqualTo(userrole.getUserid());
			ishasfilter = true;
		}
		if (userrole!=null&&userrole.getRoleid() != null && !"".equals(userrole.getRoleid())) {
			criteria.andRoleidEqualTo(userrole.getRoleid());
			ishasfilter = true;
		}
		List<User_role> list = null;
		if (ishasfilter) {
			list = this.user_roleMapper.selectByExample(example);
		}else{
			logger.info(" no filter to query getListUser_role");
		}
		return list;
	}
	public TreeBean generateMyTrees(String userid) {
		// TODO Auto-generated method stub
		TreeBean mytree=new TreeBean();
		if(userid!=null&&!"".equals(userid)){
			List<Role_permission> permissionids=getMypermissions(userid);
			if(permissionids!=null&&permissionids.size()>0){
				mytree=this.permissionService.generateAllTrees(permissionids);
			}else{
				logger.info("userid not allowed null when getMypermissions");
			}
		}else{
			logger.info("userid not allowed null when getMypermissions");
		}
		return mytree;
	}
	public List<Role_permission> getMypermissions(String userid) {
		// TODO Auto-generated method stub
		List<Role_permission> permissionids=new ArrayList<Role_permission>();
		if(userid!=null&&!"".equals(userid)){
			User_role userrole=new User_role();
			userrole.setUserid(userid);
			List<User_role> listuserrole = this.getListUser_role(userrole);
			logger.info(""+userid+" hava "+listuserrole.size()+" role");
			permissionids=this.rolePermissionService.getListRole_permission(listuserrole);

			logger.info(""+userid+" hava "+permissionids.size()+" permission");
		}else{
			logger.info("userid not allowed null when getMypermissions");
		}
		return permissionids;
	}

	
}
