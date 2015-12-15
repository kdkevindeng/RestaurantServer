package service.manage.permission;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import service.common.ServiceResult;
import service.manage.user.UserRoleService;
import action.manage.permission.RoleBean4Select;
import beans.role.RoleBean;
import dao.mybatis.mapper.RoleMapper;
import dao.mybatis.model.Role;
import dao.mybatis.model.RoleExample;
import dao.mybatis.model.Role_permission;
import dao.mybatis.model.User_role;

public class RoleService{
	Logger logger = Logger.getLogger(this.getClass());
	RoleMapper roleMapper;
	RolePermissionService rolePermissionService;
	UserRoleService userRoleService;
	
	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	public RolePermissionService getRolePermissionService() {
		return rolePermissionService;
	}

	public void setRolePermissionService(RolePermissionService rolePermissionService) {
		this.rolePermissionService = rolePermissionService;
	}

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	/*according to rolemc
	 * if this rolemc have exit
	 * in system
	 * */
	public boolean isRoleExit(String rolemc) {
		boolean res = false;
		if(rolemc!=null&&!"".equals(rolemc)){
			RoleBean rolebean=new RoleBean();
			Role daorole=new Role();
			daorole.setRoleMc(rolemc);
			rolebean.setDaorole(daorole);
			List<Role> list = getListRole(rolebean);
			if (list.size() > 0) {
				res = true;
				logger.info(rolemc + " already exit");
			}else{

				logger.info(rolemc + " not exit");
			}
		}else{
			logger.info("rolemc do not allowed null");
		}
		return res;
	}
	
	public ServiceResult addSingleRole(Role role) {
		ServiceResult result = new ServiceResult();
		if(role.getRoleMc()!=null&&!"".equals(role.getRoleMc())){
			if(isRoleExit(role.getRoleMc())){
				result.setResultcode(0);
				result.setDescription(role.getRoleMc()+" already exit ");
			}else{
				role.setRoleDm(UUID.randomUUID().toString());
				role.setIsuse("1");
				role.setAlerttime(new Date());
				role.setCreatetime(new Date());
				int res = this.roleMapper.insertSelective(role);
				if (res > 0) {
					result.setResultcode(1);
					result.setDescription("addSingleRole success");
				} else {
					result.setResultcode(0);
					result.setDescription("addSingleRole failed");
				}
			}
			
		}else{
			result.setResultcode(0);
			result.setDescription("RoleMc not allowed null when addSingleRole");
		}
		return result;
	}

	
	public ServiceResult updateSingleRole(Role role) {
		ServiceResult result=new ServiceResult();
		if(role.getRoleDm()!=null&&!"".equals(role.getRoleDm())){

			role.setAlerttime(new Date());
			int ret = this.roleMapper.updateByPrimaryKeySelective(role);
			if (ret > 0) {
				result.setResultcode(1);
				result.setDescription("updateSingleRole success");
			} else {
				result.setResultcode(0);
				result.setDescription("updateSingleRole failed");
			}
		}else{
			result.setResultcode(0);
			result.setDescription("roledm not allowed null when updateSingleRole");
		}
		return result;
	}

	public ServiceResult deleteSingleRole(Role role) {
		ServiceResult result=new ServiceResult();
		if(role.getRoleDm()!=null&&!"".equals(role.getRoleDm())){
			Role_permission rolepermission=new Role_permission();
			rolepermission.setRoleid(role.getRoleDm());
			if(rolePermissionService.isRole_permissionsExitOr(rolepermission)){
				result=this.rolePermissionService.deleteRole_permissionOr(rolepermission);
			}
			User_role userrole=new User_role();
			userrole.setRoleid(role.getRoleDm());
			if(userRoleService.isUserRoleExitOr(userrole)){
				result=this.userRoleService.deleteUserRoleOr(userrole);
			}
			int ret = this.roleMapper.deleteByPrimaryKey(role.getRoleDm());
			if (ret > 0) {
				result.setResultcode(1);
				result.setDescription("deleteSingleRole success");
			} else {
				result.setResultcode(0);
				result.setDescription("deleteSingleRole failed");
			}
		}else{
			result.setResultcode(0);
			result.setDescription("roledm not allowed null when deleteSingleRole");
		}
		return result;
	}

	public Role getSingleRole(Role role) {

		Role role_return=null;
		if(role.getRoleDm()!=null&&!"".equals(role.getRoleDm())){

			role_return=this.roleMapper.selectByPrimaryKey(role.getRoleDm());
		}else{
			logger.info("RoleDm not allowed null when getSingleRole");
		}
		return role_return;
	}

	
	public List<Role> getListRole(RoleBean rolebean) {
		// TODO Auto-generated method stub
		List<Role> list=null;
		boolean ishasfilter=false;
		Role role=rolebean.getDaorole();
		RoleExample example = new RoleExample();
		RoleExample.Criteria criteria = example.createCriteria();
		if (role.getRoleMc()!= null && !"".equals(role.getRoleMc())) {
			criteria.andRoleMcEqualTo(role.getRoleMc());
			ishasfilter=true;
		}
		if (role.getRoleDm()!= null && !"".equals(role.getRoleDm())) {
			criteria.andRoleDmEqualTo(role.getRoleDm());
			ishasfilter=true;
		}
		if (role.getIsuse()!= null && !"".equals(role.getIsuse())) {
			criteria.andIsuseEqualTo(role.getIsuse());
			ishasfilter=true;
		}
		if (!"".equals(rolebean.getQuery_start_date())&&rolebean.getQuery_start_date() != null
				&&!"".equals(rolebean.getQuery_end_date())&& rolebean.getQuery_end_date() != null) {
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			try {
				ishasfilter=true;
				criteria.andAlerttimeBetween(df.parse(rolebean.getQuery_start_date()), df.parse(rolebean.getQuery_end_date()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block

				logger.info("date parse error");
			}
		}
		if(ishasfilter){
			list = this.roleMapper.selectByExample(example);
		}
		return list;
	}
	public List<RoleBean4Select> getListMyRole(String userid) {
		List<RoleBean4Select> selectlist=new ArrayList<RoleBean4Select>();
		if(userid!=null&&!"".equals(userid)){
			RoleBean rolebean=new RoleBean();
			Role daorole=new Role();
			daorole.setIsuse("1");
			rolebean.setDaorole(daorole);
			List<Role> list = this.getListRole(rolebean);
			for(int i=0;i<list.size();i++){
				Role temp=list.get(i);
				RoleBean4Select select=new RoleBean4Select();
				select.setRoleid(temp.getRoleDm());
				select.setRolemc(temp.getRoleMc());
				if(this.userRoleService.isUserRoleExitAnd(userid, temp.getRoleDm())){
					select.setIsselect(true);
				}else{
					select.setIsselect(false);
				}
				selectlist.add(select);
			}
		}
		
		return selectlist;
	}

}
