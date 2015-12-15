package service.manage.permission;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import service.common.ServiceResult;
import dao.mybatis.mapper.Role_permissionMapper;
import dao.mybatis.model.Role_permission;
import dao.mybatis.model.Role_permissionExample;
import dao.mybatis.model.User_role;
import dao.mybatis.model.Role_permissionExample.Criteria;

public class RolePermissionService {
	Logger logger = Logger.getLogger(this.getClass());
	Role_permissionMapper role_permissionMapper;
	
	public Role_permissionMapper getRole_permissionMapper() {
		return role_permissionMapper;
	}

	public void setRole_permissionMapper(Role_permissionMapper rolePermissionMapper) {
		role_permissionMapper = rolePermissionMapper;
	}

	/*
	 * */
	public ServiceResult grantPermissionToRole(String roleid,List<String> permissionids) {
		ServiceResult result = new ServiceResult();
		if (permissionids!=null&&permissionids.size()>0) {
			Role_permissionExample deletexample=new Role_permissionExample();
			Criteria deleteCriteria = deletexample.createCriteria();
			deleteCriteria.andRoleidEqualTo(roleid);
			this.role_permissionMapper.deleteByExample(deletexample);
			for(int i=0;i<permissionids.size();i++){
				if(permissionids.get(i)!=null&&!"".equals(permissionids.get(i))&&!"0".equals(permissionids.get(i))){

					Role_permission record=new Role_permission();
					record.setId(UUID.randomUUID().toString());
					record.setRoleid(roleid);
					record.setPermissionid(permissionids.get(i));
					this.role_permissionMapper.insertSelective(record);
				
				}
			}

			result.setResultcode(1);
			result.setDescription("grantPermissionToRole success");
		
		} else {
			result.setResultcode(0);
			result.setDescription("TreeBean not allowed null when grantPermissionToRole");
		}
		return result;

	}
	public boolean isRole_permissionsExitAnd(String roleid,String permissionid) {

		boolean res = false;
		if (roleid != null && !"".equals(roleid)&&permissionid != null && !"".equals(permissionid)) {
			Role_permissionExample example=new Role_permissionExample();
			Role_permissionExample.Criteria criteria=example.createCriteria();
			criteria.andRoleidEqualTo(roleid);
			criteria.andPermissionidEqualTo(permissionid);
			List<Role_permission> list = this.role_permissionMapper.selectByExample(example);
			if (list.size() > 0) {
				res = true;
				logger.info(roleid+" and "+permissionid + " already exit");
			} else {

				logger.info(roleid+" and "+permissionid + " not exit");
			}
		} else {
			logger.info("roleid and permissionid do not allowed null");
		}
		return res;
	}
	public boolean isRole_permissionsExitOr(Role_permission rolepermission) {

		boolean res = false;
		if (rolepermission!=null) {
			boolean hasfilter=false;
			Role_permissionExample example=new Role_permissionExample();
			Role_permissionExample.Criteria criteria=example.createCriteria();
			if(rolepermission.getRoleid()!=null && !"".equals(rolepermission.getRoleid())){
				criteria.andRoleidEqualTo(rolepermission.getRoleid());
				hasfilter=true;
			}
			if(rolepermission.getPermissionid()!=null && !"".equals(rolepermission.getPermissionid())){
				criteria.andPermissionidEqualTo(rolepermission.getPermissionid());
				hasfilter=true;
			}
			if(hasfilter){
				List<Role_permission> list = this.role_permissionMapper.selectByExample(example);
				if (list.size() > 0) {
					res = true;
					logger.info(" already exit");
				} else {

					logger.info(" not exit");
				}
			}else{
				logger.info("Roleid or Permissionid  do not allowed both is null");
			
			}
			
		} else {
			logger.info("rolepermission do not allowed null");
		}
		return res;
	}
	public ServiceResult deleteRole_permissionOr(Role_permission rolepermission) {
		ServiceResult result = new ServiceResult();
		if (rolepermission!=null) {
			boolean hasfilter=false;
			Role_permissionExample example=new Role_permissionExample();
			Role_permissionExample.Criteria criteria=example.createCriteria();
			if(rolepermission.getRoleid()!=null && !"".equals(rolepermission.getRoleid())){
				criteria.andRoleidEqualTo(rolepermission.getRoleid());
				hasfilter=true;
			}
			if(rolepermission.getPermissionid()!=null && !"".equals(rolepermission.getPermissionid())){
				criteria.andPermissionidEqualTo(rolepermission.getPermissionid());
				hasfilter=true;
			}
			if(hasfilter){
				int ret = this.role_permissionMapper.deleteByExample(example);
				if (ret > 0) {
					result.setResultcode(1);
					result.setDescription("deleteRole_permissionOr success ");
				} else {
					result.setResultcode(0);
					result.setDescription("deleteRole_permissionOr failed ");
				}
			}else{
				logger.info("Roleid or Permissionid  do not allowed both is null");
			
			}
			
		} else {
			logger.info("rolepermission do not allowed null");
		}
		
		return result;

	}

	public List<Role_permission> getListRole_permission(Role_permission rolepermission){

		// TODO Auto-generated method stub
		boolean ishasfilter = false;
		Role_permissionExample example=new Role_permissionExample();
		Criteria criteria = example.createCriteria();
		if (rolepermission!=null&&rolepermission.getPermissionid() != null && !"".equals(rolepermission.getPermissionid())) {
			criteria.andPermissionidEqualTo(rolepermission.getPermissionid());
			ishasfilter = true;
		}
		if (rolepermission!=null&&rolepermission.getRoleid() != null && !"".equals(rolepermission.getRoleid())) {
			criteria.andRoleidEqualTo(rolepermission.getRoleid());
			ishasfilter = true;
		}
		List<Role_permission> list = null;
		if (ishasfilter) {
			list = this.role_permissionMapper.selectByExample(example);
		}else{
			logger.info(" no filter to query getListRole_permission");
		}
		return list;
	}
	public List<Role_permission> getListRole_permission(List<User_role> listuserole){
		List<Role_permission> returnlist=new ArrayList<Role_permission>();
		if(listuserole!=null&&listuserole.size()>0){
			for(int i=0;i<listuserole.size();i++){
				User_role useroletemp = listuserole.get(i);
				Role_permission rolepermission=new Role_permission();
				rolepermission.setRoleid(useroletemp.getRoleid());
				returnlist.addAll(this.getListRole_permission(rolepermission));			
			}
		}
		return returnlist;
	}
}
