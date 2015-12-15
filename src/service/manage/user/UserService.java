package service.manage.user;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import service.common.ServiceResult;
import beans.user.UserBean;
import dao.mybatis.mapper.UserMapper;
import dao.mybatis.model.User;
import dao.mybatis.model.UserExample;
import dao.mybatis.model.User_role;

public class UserService {
	Logger logger = Logger.getLogger(this.getClass());

	UserMapper userMapper;
	UserRoleService userRoleService;
	
	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	public ServiceResult changemypass(User currentuser,String oldpass,String newpass1,String newpass2) {
		ServiceResult result = new ServiceResult();
		if (oldpass.equals(currentuser.getPassword())) {

			if (newpass1.equals(newpass2)) {
				currentuser.setPassword(newpass2);
				result=this.updateSingleUser(currentuser);
			} else {
				result.setResultcode(0);
				result.setDescription("new password is different ，please try again");
				// //logger.info(" Username password not allowed null when add one user to the system");
			}
		} else {
			result.setResultcode(0);
			result.setDescription("old password is wrong");
			// //logger.info(" Userid must be null when add one user to the system");
		}

		return result;
	}

	/*
	 * add one user to the system username and password is must
	 */
	public ServiceResult addSingleUser(User user) {
		ServiceResult result = new ServiceResult();
		if (user.getUserid() == null || "".equals(user.getUsername())) {

			if (user.getUsername() != null && !"".equals(user.getUsername())
					&& user.getPassword() != null
					&& !"".equals(user.getPassword())) {

				if (isUserExit(user.getUsername())) {
					result.setResultcode(0);
					result.setDescription("User has exit in system with username:"
							+ user.getUsername());

				} else {
					user.setId(UUID.randomUUID().toString());
					user.setAlterDate(new Date());
					user.setCreateDate(new Date());
					user.setIsuse("1");
					int res = this.userMapper.insertSelective(user);
					if (res > 0) {
						result.setResultcode(1);
						result.setDescription("addSingleUser success");
					} else {
						result.setResultcode(0);
						result.setDescription("addSingleUser to database failed");

					}
				}
			} else {
				result.setResultcode(0);
				result.setDescription(" Username and password not allowed null when add one user to the system");
				// //logger.info(" Username password not allowed null when add one user to the system");
			}
		} else {
			result.setResultcode(0);
			result.setDescription(" Userid must be null when add one user to the system");
			// //logger.info(" Userid must be null when add one user to the system");
		}

		return result;
	}

	/* 修改单个用户的信息，必须要有用户的uuid */
	public ServiceResult updateSingleUser(User user) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult();
		if (user.getId() != null && !"".equals(user.getId())) {
			user.setAlterDate(new Date());
			int ret = this.userMapper.updateByPrimaryKeySelective(user);
			if (ret > 0) {
				result.setResultcode(1);
				result.setDescription("updateSingleUser success");
			} else {
				result.setResultcode(0);
				result.setDescription("update database failed");

			}
		} else {

			result.setResultcode(0);
			result.setDescription("user uuid not allowed  null, when you want update user info");
			// logger.info("user uuid not allowed  null, when you want update user info");
		}
		return result;
	}

	/*
	 * when delete one user only use uuid
	 */
	public ServiceResult deleteSingleUser(User user) {

		ServiceResult result = new ServiceResult();
		if (user.getId() != null && !"".equals(user.getId())) {

			User_role userrole=new User_role();
			userrole.setUserid(user.getUserid());
			if(userRoleService.isUserRoleExitOr(userrole)){
				result=this.userRoleService.deleteUserRoleOr(userrole);
			}
			int ret = this.userMapper.deleteByPrimaryKey(user.getId());
			if (ret > 0) {
				result.setResultcode(1);
				result.setDescription("deleteSingleUser success");
			} else {
				result.setResultcode(0);
				result.setDescription("delete database failed");

			}
		} else {
			result.setResultcode(0);
			result.setDescription("user uuid not allowed null when delete one user");
			// logger.info("user uuid not null when delete one user");
		}
		return result;
	}

	public User getSingleUser(String id) {// only use userid
		// TODO Auto-generated method stub

		User user_res = null;
		if (id != null && !"".equals(id)) {
			user_res = this.userMapper.selectByPrimaryKey(id);
		} else {
			logger.info("id not allowed null when getSingleUser");
		}

		return user_res;
	}

	/*
	 * 根据userid，username，telephone，email，最后修改日期等信息 进行条件查询
	 */
	public List<User> getListOfUser(UserBean userbean) {
		// TODO Auto-generated method stub
		boolean ishasfilter = false;
		User user = userbean.getDaouser();
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		if (user.getUserid() != null && !"".equals(user.getUserid())) {
			criteria.andUseridEqualTo(user.getUserid());
			ishasfilter = true;
		}
		if (user.getUsername() != null && !"".equals(user.getUsername())) {
			criteria.andUsernameEqualTo(user.getUsername());
			ishasfilter = true;
		}
		if (user.getTelphone() != null && !"".equals(user.getTelphone())) {
			criteria.andTelphoneEqualTo(user.getTelphone());
			ishasfilter = true;
		}
		if (user.getEmail() != null && !"".equals(user.getEmail())) {
			criteria.andEmailEqualTo(user.getEmail());
			ishasfilter = true;
		}
		if (user.getIsuse() != null && !"".equals(user.getIsuse())) {
			criteria.andIsuseEqualTo(user.getIsuse());
			ishasfilter = true;
		}
		if (!"".equals(userbean.getQuery_start_date())
				&& userbean.getQuery_start_date() != null
				&& !"".equals(userbean.getQuery_end_date())
				&& userbean.getQuery_end_date() != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			try {
				ishasfilter = true;
				criteria.andAlterDateBetween(
						df.parse(userbean.getQuery_start_date()),
						df.parse(userbean.getQuery_end_date()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				 logger.info("date parse error");
			}
		}
		if (user.getDomain() != null && !"".equals(user.getDomain())) {
			criteria.andDomainEqualTo(user.getDomain());
		}
		List<User> list = null;
		if (ishasfilter) {
			list = this.userMapper.selectByExample(example);
		}else{
			logger.info(" no filter to query userinfo");
		}
		return list;
	}

	/*
	 * according to username if this username have exit in system
	 */

	public boolean isUserExit(String username) {
		boolean res = false;
		if (username != null && !"".equals(username)) {
			UserBean userbean = new UserBean();
			User user = new User();
			user.setUsername(username);
			userbean.setDaouser(user);
			List<User> list = getListOfUser(userbean);
			if (list.size() > 0) {
				res = true;
				logger.info(user.getUsername() + " already exit");
			} else {

				logger.info(user.getUsername() + " not exit");
			}
		} else {
			logger.info("username do not allowed null");
		}
		return res;
	}
	public ServiceResult grantRoleToUser(String userid,String[] roleids) {
		List<String> list=new ArrayList<String>();
		for(int i=0;i<roleids.length;i++){
			list.add(roleids[i]);
		}
		return this.userRoleService.grantRoleToUser(userid, list);
	}
	public User login(String userid, String password) {
		User res = null;
		if (userid != null && !"".equals(userid) && password != null
				&& !"".equals(password)) {

			UserBean userbean = new UserBean();
			User user = new User();
			user.setUserid(userid);
			userbean.setDaouser(user);
			List<User> list = this.getListOfUser(userbean);
			if (list != null && list.size() > 0) {
				if (list.size() == 1) {
					if (list.get(0).getPassword().equals(password)) {
						res = list.get(0);
						logger.info(user.getUserid() + " login success");
					} else {
						logger.info("username:" + user.getUserid()
								+ ",password wrong");
					}
				} else {
					logger.error("system for " + user.getUserid() + " has "
							+ list.size() + " result");
				}
			} else {
				logger.info(user.getUserid() + " not exit in system");
			}
		} else {
			logger.info("userid and password not allowed null when login");
		}

		return res;
	}

}
