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
import service.manage.permission.RoleService;
import beans.role.RoleBean;
import dao.mybatis.model.Role;
import dao.mybatis.model.User;

@Controller
@RequestMapping(value = "/role")
public class RoleController {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private RoleService roleService;

	/**
	 * add one role
	 * 
	 * @param role
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addonerole")
	public void addonerole(Role role, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
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
			role.setAlertuser(currentuser.getUsername());
			role.setCreateuser(currentuser.getUsername());
			result=this.roleService.addSingleRole(role);
		} else {
			result.setResultcode(0);
			result.setDescription("not login");
		}

		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);
	}

	/**
	 * delete one role
	 * 
	 * @param role
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/deleteonerole")
	public void deleteonerole(Role role, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");

		ServiceResult result=this.roleService.deleteSingleRole(role);
		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);
	}

	/**
	 * update one role
	 * 
	 * @param role
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateonerole")
	public void updateonerole(Role role, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
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
			role.setAlertuser(currentuser.getUsername());
			result=this.roleService.updateSingleRole(role);
		} else {
			result.setResultcode(0);
			result.setDescription("not login");
		}

		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);
	
	}

	/**
	 * select one role
	 * 
	 * @param role
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/selectonerole")
	public void selectonerole(Role role, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		Role selectedrole = this.roleService.getSingleRole(role);
		if (selectedrole != null) {
			JSONObject json = JSONObject.fromObject(selectedrole);
			out.println(json.toString());
		} else {
			out.println("null");
		}
	}

	/**
	 * select all role
	 * 
	 * @param role
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/queryrole")
	public void queryrole(Role role, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		RoleBean rolebean=new RoleBean();
		rolebean.setDaorole(role);
		rolebean.setQuery_start_date(requset.getParameter("startdate"));
		rolebean.setQuery_end_date(requset.getParameter("enddate"));
		logger.info(requset.getParameter("roleMc"));
		logger.info(requset.getParameter("startdate"));
		logger.info(requset.getParameter("enddate"));
		List<Role> selectedrole = this.roleService.getListRole(rolebean);
		if (selectedrole != null && selectedrole.size() > 0) {
			JSONArray json = JSONArray.fromObject(selectedrole);
			out.println(json.toString());
		} else {
			out.println("null");
		}
	}
	@RequestMapping(value = "/querymyrole")
	public void querymyrole(Role role, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		String userid=requset.getParameter("userid");
		List<RoleBean4Select> selectedrole = this.roleService.getListMyRole(userid);
		if (selectedrole != null && selectedrole.size() > 0) {
			JSONArray json = JSONArray.fromObject(selectedrole);
			out.println(json.toString());
		} else {
			out.println("null");
		}
	}


}
