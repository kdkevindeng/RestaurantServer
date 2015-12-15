package action.manage.permission;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.common.ServiceResult;
import service.manage.permission.PermissionService;
import beans.permission.PermissionBean;
import dao.mybatis.model.Permission;
import dao.mybatis.model.User;

@Controller
@RequestMapping(value = "/permission")
public class PermissionController {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private PermissionService permissionService;

	/**
	 * add one permission
	 * 
	 * @param permission
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addonepermission")
	public void addonepermission(Permission permission, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		ServiceResult result=new ServiceResult();
		User currentuser = (User) session.getAttribute("currentuser");
		//System.out.println(permission.getPermissionMc().toString());
		if (currentuser != null) {
			permission.setAlertUser(currentuser.getUsername());
			permission.setCreateUser(currentuser.getUsername());
			result=this.permissionService.addSinglePermission(permission);
		} else {
			result.setResultcode(0);
			result.setDescription("not login");
		}

		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);
	}

	/**
	 * delete one permission
	 * 
	 * @param permission
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/deleteonepermission")
	public void deleteonepermission(Permission permission, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		ServiceResult result=new ServiceResult();
		result=this.permissionService.deletePermisssionAndChildrens(permission);

		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);
	}

	/**
	 * update one permission
	 * 
	 * @param permission
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateonepermission")
	public void updateonepermission(Permission permission, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		ServiceResult result=new ServiceResult();
		
		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			permission.setAlertUser(currentuser.getUsername());
			result=this.permissionService.updateSinglePermission(permission);
		} else {
			result.setResultcode(0);
			result.setDescription("not login");
		}

		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);
	}

	/**
	 * select one permission
	 * 
	 * @param permission
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/selectonepermission")
	public void selectonepermission(Permission permission, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		Permission selectedpermission = this.permissionService.getSinglePermission(permission);
		if (selectedpermission != null) {
			JSONObject json = JSONObject.fromObject(selectedpermission);
			out.println(json.toString());
		} else {
			out.println("null");
		}
	}

	/**
	 * select all permission
	 * 
	 * @param permission
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/selectallpermission")
	public void selectallpermission(Permission permission, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		PermissionBean permissionbean=new PermissionBean();
		permissionbean.setPermission(permission);
		List<Permission> selectedpermission = this.permissionService.getListPermission(permissionbean);
		if (selectedpermission != null && selectedpermission.size() > 0) {
			JSONArray json = JSONArray.fromObject(selectedpermission);
			out.println(json.toString());
		} else {
			out.println("null");
		}
	}
	/**
	 * select all permission
	 * 
	 * @param permission
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/selectalltrees")
	public void selectalltrees(Permission permission, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		TreeBean tree = this.permissionService.generateAllTrees(requset.getParameter("roledm"));
		if (tree != null) {
			JSONArray json = JSONArray.fromObject(tree);
			out.println(json.toString());
		} else {
			out.println("null");
		}
	}
	
	/**
	 * grantPermissionToRole
	 * 
	 * @param permission
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/grantpermission")
	public void grantPermissionToRole(Permission permission, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		ServiceResult result=new ServiceResult();
		String roleid=requset.getParameter("roleid");
		String treeselect=requset.getParameter("treeselect");
		if (roleid != null&&!"".equals(roleid)&&treeselect != null&&!"".equals(treeselect)) {
			JSONArray jsonarr = JSONArray.fromObject(treeselect);
			String[] permissionids=new String[jsonarr.size()];
			for(int i=0;i<jsonarr.size();i++){
				JSONObject jsonobj = (JSONObject) jsonarr.get(i);
				permissionids[i]=jsonobj.getString("id");
			}
			result=this.permissionService.grantPermissionToRole(roleid, permissionids);
		} else {
			result.setResultcode(0);
			result.setDescription("roleid and jsontree is null");
		}

		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);
	}
	

}
