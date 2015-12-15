package action.manage.user;

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
import service.manage.user.UserRoleService;
import service.manage.user.UserService;
import action.manage.permission.TreeBean;
import beans.user.UserBean;
import dao.mybatis.model.User;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	Logger logger = Logger.getLogger(this.getClass());
	/**
	 * login
	 * 
	 * @param user
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login")
	public void login(User user, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		ServiceResult result=new ServiceResult();
		User selecteduser=this.userService.login(user.getUserid(), user.getPassword());
		if (selecteduser != null) {
			session.setAttribute("currentuser", selecteduser);
			result.setResultcode(1);
			result.setDescription("login success");
		}else{
			result.setResultcode(0);
			result.setDescription("login failed");
		}

		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);
	}
	/**
	 * changemypass
	 * 
	 * @param user
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/changemypass")
	public void changemypass(User user, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
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

			String oldpass=requset.getParameter("oldpass");
			String newpass1=requset.getParameter("newpass1");
			String newpass2=requset.getParameter("newpass2");
			if(oldpass!=null&&!"".equals(oldpass)&&newpass1!=null&&!"".equals(newpass1)&&newpass2!=null&&!"".equals(newpass2)){

				result=this.userService.changemypass(currentuser, oldpass, newpass1, newpass2);
			}else{
				result.setResultcode(0);
				result.setDescription("parameters is null");
			}
			
		} else {
			result.setResultcode(0);
			result.setDescription("not login");
		}
		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);
	}

	/**
	 * register or add one user
	 * 
	 * @param user
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addoneuser")
	public void addoneuser(User user, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
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
			user.setAlterUser(currentuser.getUsername());
			user.setCreateUser(currentuser.getUsername());
			result=this.userService.addSingleUser(user);
			
		} else {
			result.setResultcode(0);
			result.setDescription("not login");
		}
		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);
	}

	/**
	 * delete one user
	 * 
	 * @param user
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/deleteoneuser")
	public void deleteoneuser(User user, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		ServiceResult result=this.userService.deleteSingleUser(user);
		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);
	}

	/**
	 * update one user
	 * 
	 * @param user
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateoneuser")
	public void updateoneuser(User user, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
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
			user.setAlterUser(currentuser.getUsername());
			result=this.userService.updateSingleUser(user);
			
		} else {
			result.setResultcode(0);
			result.setDescription("not login");
		}
		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);

	}

	/**
	 * select one user
	 * 
	 * @param user
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/selectoneuser")
	public void selectoneuser(User user, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		User selecteduser = this.userService.getSingleUser(user.getId());
		if (selecteduser != null) {
			JSONObject json = JSONObject.fromObject(selecteduser);
			out.println(json.toString());
		} else {
			out.println("null");
		}
	}

	/**
	 * select all user
	 * 
	 * @param user
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/queryuser")
	public void queryuser(User user, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		UserBean userbean=new UserBean();
		userbean.setDaouser(user);
		userbean.setQuery_start_date(requset.getParameter("startdate"));
		userbean.setQuery_end_date(requset.getParameter("enddate"));
		List<User> selecteduser = this.userService.getListOfUser(userbean);
		if (selecteduser != null && selecteduser.size() > 0) {
			JSONArray json = JSONArray.fromObject(selecteduser);
			out.println(json.toString());
			//logger.info(json.toString());
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
	@RequestMapping(value = "/grantrole")
	public void grantRoleToUser(User user, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session) {
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		ServiceResult result=new ServiceResult();
		String userid=requset.getParameter("userid");
		String roleselect=requset.getParameter("roleselect");
		logger.info("userid:"+userid);
		logger.info("roleselect:"+roleselect);
		if (userid != null&&!"".equals(userid)&&roleselect != null&&!"".equals(roleselect)) {
			JSONArray jsonarr = JSONArray.fromObject(roleselect);
			String[] roleids=new String[jsonarr.size()];
			for(int i=0;i<jsonarr.size();i++){
				JSONObject jsonobj = (JSONObject) jsonarr.get(i);
				roleids[i]=jsonobj.getString("roleid");
			}
			result=this.userService.grantRoleToUser(userid, roleids);
		} else {
			result.setResultcode(0);
			result.setDescription("userid and roles is null");
		}

		JSONObject jsonresult =JSONObject.fromObject(result);
		out.println(jsonresult);
	}
	/**
	 * generateMyTrees
	 * 
	 * @param User
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/generateusertrees")
	public void generateUserTrees(User user, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session){
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		if(user!=null&&user.getId()!=null&&!"".equals(user.getId())){
			TreeBean tree=this.userRoleService.generateMyTrees(user.getId());
			if (tree!=null) {
				JSONArray json = JSONArray.fromObject(tree);
				out.println(json.toString());
				//logger.info(json.toString());
			} else {
				out.println("null");
			}
		}
	}
	/**
	 * generateMyTrees
	 * 
	 * @param User
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/generatemytrees")
	public void generateMyTrees(User user, PrintWriter out,HttpServletRequest requset,HttpServletResponse response, HttpSession session){
		try {
			requset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("UnsupportedEncodingException");
		}
		response.setContentType("application/json;charset=utf-8");
		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			TreeBean tree=this.userRoleService.generateMyTrees(currentuser.getId());
			if (tree!=null) {
				JSONArray json = JSONArray.fromObject(tree);
				out.println(json.toString());
				//logger.info(json.toString());
			} else {
				out.println("null");
			}
		}else{
			out.println("nologin");
		}
	}
}
