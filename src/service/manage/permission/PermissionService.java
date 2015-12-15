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
import action.manage.permission.TreeBean;
import beans.permission.PermissionBean;
import dao.mybatis.mapper.PermissionMapper;
import dao.mybatis.model.Permission;
import dao.mybatis.model.PermissionExample;
import dao.mybatis.model.Role_permission;

public class PermissionService {
	Logger logger = Logger.getLogger(this.getClass());
	PermissionMapper permissionMapper;
	RolePermissionService rolePermissionService;
	
	public RolePermissionService getRolePermissionService() {
		return rolePermissionService;
	}

	public void setRolePermissionService(RolePermissionService rolePermissionService) {
		this.rolePermissionService = rolePermissionService;
	}

	public PermissionMapper getPermissionMapper() {
		return permissionMapper;
	}

	public void setPermissionMapper(PermissionMapper permissionMapper) {
		this.permissionMapper = permissionMapper;
	}

	public boolean isPermissionExit(String url) {
		boolean res = false;
		if (url != null && !"".equals(url)) {
			PermissionBean permissionbean = new PermissionBean();
			Permission permission = new Permission();
			permission.setUrl(url);
			permissionbean.setPermission(permission);
			List<Permission> list = getListPermission(permissionbean);
			if (list.size() > 0) {
				res = true;
				logger.info(url + " already exit");
			} else {

				logger.info(url + " not exit");
			}
		} else {
			logger.info("url do not allowed null");
		}
		return res;
	}
	public boolean hasChildren(String permissionid) {
		boolean res = false;
		if (permissionid != null && !"".equals(permissionid)) {
			PermissionBean permissionbean = new PermissionBean();
			Permission permission = new Permission();
			permission.setParentcode(permissionid);
			permissionbean.setPermission(permission);
			List<Permission> list = getListPermission(permissionbean);
			if (list.size() > 0) {
				res = true;
				logger.info(" has "+list.size()+" Children");
			} else {

				logger.info(" has no Children");
			}
		} else {
			logger.info("permissionid do not allowed null");
		}
		return res;
	}

	public ServiceResult addSinglePermission(Permission permission) {

		ServiceResult result = new ServiceResult();
		if (permission.getParentcode() != null
				&& !"".equals(permission.getParentcode())
				&& permission.getPermissionMc() != null
				&& !"".equals(permission.getPermissionMc())
				) {

			if (isPermissionExit(permission.getUrl())) {
				result.setResultcode(0);
				result.setDescription("permission has exit in system with url:"
						+ permission.getUrl());

			} else {
				permission.setPermissionDm(UUID.randomUUID().toString());
				permission.setAlertDate(new Date());
				permission.setCreateDate(new Date());
				permission.setIsuse("1");
				int res = this.permissionMapper.insertSelective(permission);
				if (res > 0) {
					result.setResultcode(1);
					result.setDescription("addSinglePermission success");
				} else {
					result.setResultcode(0);
					result.setDescription("addSinglePermission to database failed");

				}
			}
		} else {
			result.setResultcode(0);
			result.setDescription(" Parentcode and permissionmc not allowed null when addSinglePermission");
		}

		return result;

	}

	public ServiceResult updateSinglePermission(Permission permission) {

		ServiceResult result = new ServiceResult();
		if (permission.getPermissionDm() != null
				&& !"".equals(permission.getPermissionDm())) {

			permission.setAlertDate(new Date());
			int ret = this.permissionMapper
					.updateByPrimaryKeySelective(permission);
			if (ret > 0) {
				result.setResultcode(1);
				result.setDescription("updateSinglePermission success");
			} else {
				result.setResultcode(0);
				result.setDescription("updateSinglePermission failed");
			}
		} else {
			result.setResultcode(0);
			result.setDescription("PermissionDm not allowed null when updateSinglePermission");
		}
		return result;
	}
	public ServiceResult deletePermisssionAndChildrens(Permission permission) {
		ServiceResult result = new ServiceResult();
		if (permission.getPermissionDm() != null
				&& !"".equals(permission.getPermissionDm())) {
			//get childrens of this permission
			PermissionBean permissionbean=new PermissionBean();
			Permission parentpermission=new Permission();
			parentpermission.setParentcode(permission.getPermissionDm());
			permissionbean.setPermission(parentpermission);
			List<Permission> childrens = this.getListPermission(permissionbean);
			//if has childrens ,delete childrens first,then delete itself
			if(childrens!=null&&childrens.size()>0){
				for(int i=0;i<childrens.size();i++){
					Permission children = childrens.get(i);
					result=deletePermisssionAndChildrens(children);
				}
				result=deletePermisssionAndChildrens(permission);
			}else{
				//if don`t have childrens ,delete itself
				result=deleteSinglePermisssion(permission);
			}
		} else {
			result.setResultcode(0);
			result.setDescription("PermissionDm not allowed null when deleteSinglePermisssion");
		}
		return result;

	}
	public ServiceResult deleteSinglePermisssion(Permission permission) {
		ServiceResult result = new ServiceResult();
		if (permission.getPermissionDm() != null
				&& !"".equals(permission.getPermissionDm())) {
			Role_permission rolepermission=new Role_permission();
			rolepermission.setPermissionid(permission.getPermissionDm());
			if(rolePermissionService.isRole_permissionsExitOr(rolepermission)){
				result=this.rolePermissionService.deleteRole_permissionOr(rolepermission);
			}

			int ret = this.permissionMapper.deleteByPrimaryKey(permission
					.getPermissionDm());
			if (ret > 0) {
				result.setResultcode(1);
				result.setDescription("deleteSinglePermisssion success with PermissionDm is"+permission.getPermissionDm());
			} else {
				result.setResultcode(0);
				result.setDescription("deleteSinglePermisssion failed with PermissionDm is"+permission.getPermissionDm());
			}
		} else {
			result.setResultcode(0);
			result.setDescription("PermissionDm not allowed null when deleteSinglePermisssion");
		}
		return result;

	}

	public Permission getSinglePermission(Permission permission) {

		Permission permission_return = null;
		if (permission.getPermissionDm() != null
				&& !"".equals(permission.getPermissionDm())) {

			permission_return = this.permissionMapper
					.selectByPrimaryKey(permission.getPermissionDm());
		} else {
			logger.info("PermissionDm not allowed null when getSinglePermission");
		}
		return permission_return;
	}

	public List<Permission> getListPermission(PermissionBean permissionbean) {
		// TODO Auto-generated method stub
		boolean ishasfilter = false;
		Permission permission = permissionbean.getPermission();
		PermissionExample example = new PermissionExample();
		PermissionExample.Criteria criteria = example.createCriteria();
		if (permission.getPermissionDm() != null
				&& !"".equals(permission.getPermissionDm())) {
			criteria.andPermissionDmEqualTo(permission.getPermissionDm());
			ishasfilter = true;
		}
		if (permission.getPermissionMc() != null
				&& !"".equals(permission.getPermissionMc())) {
			criteria.andPermissionMcEqualTo(permission.getPermissionMc());
			ishasfilter = true;
		}
		if (permission.getIsuse() != null && !"".equals(permission.getIsuse())) {
			criteria.andIsuseEqualTo(permission.getIsuse());
			ishasfilter = true;
		}
		if (permission.getParentcode() != null
				&& !"".equals(permission.getParentcode())) {
			criteria.andParentcodeEqualTo(permission.getParentcode());
			ishasfilter = true;
		}
		if (permission.getUrl() != null
				&& !"".equals(permission.getUrl())) {
			criteria.andUrlEqualTo(permission.getUrl());
			ishasfilter = true;
		}
		if (!"".equals(permissionbean.getQuery_start_date())
				&& permissionbean.getQuery_start_date() != null
				&& !"".equals(permissionbean.getQuery_end_date())
				&& permissionbean.getQuery_end_date() != null) {

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				ishasfilter = true;
				criteria.andAlertDateBetween(
						df.parse(permissionbean.getQuery_start_date()),
						df.parse(permissionbean.getQuery_end_date()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block

				logger.info("date parse error");
			}
		}
		List<Permission> list = null;
		if (ishasfilter) {
			list = this.permissionMapper.selectByExample(example);
		}
		return list;
	}
	/*
	 * */
	public ServiceResult grantPermissionToRole(String roleid,String[] permissionids) {
		List<String> list=new ArrayList<String>();
		for(int i=0;i<permissionids.length;i++){
			if(!hasChildren(permissionids[i])){
				list.add(permissionids[i]);
			}
		}
		return rolePermissionService.grantPermissionToRole(roleid, list);
	}
	public TreeBean generateAllTrees(String roledm) {
		// TODO Auto-generated method stub
		TreeBean tree = new TreeBean();
		tree.setId("0");
		tree.setText("根菜单");
		tree.setChildren(generateTrees("0",roledm));
		return tree;
	}
	//root 0
	public int getTreeDeep(TreeBean tree,int deep){
		if(tree!=null){
			deep++;
			List<TreeBean> child = tree.getChildren();
			if(child!=null&&child.size()>0){
				deep=getTreeDeep(child.get(0),deep);
			}
		}
		return deep;
	}
	public TreeBean generateAllTrees(List<Role_permission> permissionids) {
		// TODO Auto-generated method stub
		TreeBean tree = new TreeBean();
		tree.setId("0");
		tree.setText("根菜单");
		tree.setChildren(generateTreesChilds("0"));
		int deep=getTreeDeep(tree, 0);
		for(int i=0;i<deep-1;i++){
			tree=filterTrees(tree, permissionids);
		}
		return tree;
	}
	
	public TreeBean filterTrees(TreeBean tree,List<Role_permission> permissionids) {
		if(tree!=null){

			// TODO Auto-generated method stub
			if(permissionids!=null&&permissionids.size()>0){
				List<TreeBean> children = tree.getChildren();
				logger.info(tree.getText()+" has "+children.size()+" childs");
				if(children!=null&&children.size()>0){
					for(int i=0;i<children.size();i++){
						TreeBean newchild = filterTrees(children.get(i), permissionids);
						children.remove(i);
						if(newchild==null){
							i--;
						}else{

							children.add(i,newchild);
						}
						logger.info("now "+tree.getText()+" has "+children.size()+" childs");
						
					}
				}else{// if is leaf node,
					boolean isexit=false;
					for(int i=0;i<permissionids.size();i++){
						logger.info(i+"tree.getId()------------------------------"+tree.getId());
						logger.info(i+"permissionids.get(i).getPermissionid()----"+permissionids.get(i).getPermissionid());
						logger.info(tree.getId().equals(permissionids.get(i).getPermissionid()));
						
						if("0".equals(tree.getId())||tree.getId().equals(permissionids.get(i).getPermissionid())){
							isexit=true;
						}
					}
					if(!isexit){

						logger.info(tree.getText()+" has deleted");
						tree=null;
					}else{


						logger.info(tree.getText()+" has kept");
					}
					
				}
			}else{
				tree.getChildren().clear();
			}
		
		}
		return tree;
	}
	
	public List<TreeBean> generateTrees(String parentcode,String roledm) {
		// TODO Auto-generated method stub
		List<TreeBean> result = new ArrayList<TreeBean>();
		// construct permission
		Permission permission = new Permission();
		permission.setParentcode(parentcode);
		PermissionBean permissionbean = new PermissionBean();
		permissionbean.setPermission(permission);

		List<Permission> list = getListPermission(permissionbean);
		for (int i = 0; i < list.size(); i++) {
			Permission temp = list.get(i);
			TreeBean tree = new TreeBean();
			tree.setId(temp.getPermissionDm());
			tree.setText(temp.getPermissionMc());
			tree.setChildren(generateTrees(temp.getPermissionDm(),roledm));
			tree.setUrl(temp.getUrl());
			tree.setAlertDate(temp.getAlertDate());
			tree.setAlertUser(temp.getAlertUser());
			tree.setBeizhu(temp.getBeizhu());
			tree.setDescribes(temp.getDescribes());
			tree.setIsuse(temp.getIsuse());
			tree.setParentcode(temp.getParentcode());
			if(roledm!=null&&!"".equals(roledm)){
				tree.setChecked(rolePermissionService.isRole_permissionsExitAnd(roledm, temp.getPermissionDm()));
			}
			result.add(tree);
		}
		return result;

	}
	public List<TreeBean> generateTreesChilds(String parentcode) {
		// TODO Auto-generated method stub
		
		List<TreeBean> result = new ArrayList<TreeBean>();
		// construct permission
		Permission permission = new Permission();
		permission.setParentcode(parentcode);
		PermissionBean permissionbean = new PermissionBean();
		permissionbean.setPermission(permission);

		List<Permission> list = getListPermission(permissionbean);
		for (int i = 0; i < list.size(); i++) {
			Permission temp = list.get(i);
			TreeBean tree = new TreeBean();
			tree.setId(temp.getPermissionDm());
			tree.setText(temp.getPermissionMc());
			tree.setChildren(generateTreesChilds(temp.getPermissionDm()));
			tree.setUrl(temp.getUrl());
			tree.setAlertDate(temp.getAlertDate());
			tree.setAlertUser(temp.getAlertUser());
			tree.setBeizhu(temp.getBeizhu());
			tree.setDescribes(temp.getDescribes());
			tree.setIsuse(temp.getIsuse());
			tree.setParentcode(temp.getParentcode());
			result.add(tree);
		}
		return result;

	}

	
}
