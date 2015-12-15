package service.test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.common.ServiceResult;
import service.manage.user.UserService;
import beans.user.UserBean;
import dao.mybatis.model.User;

public class UserServiceTest extends TestCase {
	private BeanFactory beanFactory;
	UserService testService;
	Logger logger;

	@Override
	protected void setUp() throws Exception {
		this.beanFactory = new ClassPathXmlApplicationContext(
				"/spring/ApplicationContext.xml");
		logger = Logger.getLogger(this.getClass());
		testService = (UserService) this.beanFactory.getBean("userService");
	}
	//pass
	public void testaddUser() {
		User user = new User();
		user.setAge("24");
		user.setUsername("陈利");
		user.setPassword("23234");
		user.setEmail("3333@qq.com");
		ServiceResult result = this.testService.addSingleUser(user);
		logger.info(result.getResultcode());
		logger.info(result.getDescription());
	
	}

	//pass
	public void testupdateSingleUser() {
		User user = new User();
		user.setAlterDate(new Date());
		user.setId("1b0b016-5f76-47b1-8460-bf2ab53001cc");
		user.setPassword("wanan");
		ServiceResult result = this.testService.updateSingleUser(user);
		logger.info(result.getResultcode());
		logger.info(result.getDescription());
	}

	//pass
	public void testdeleteSingleUser() {
		User user = new User();
		//user.setId("0d0420de-a267-424b-80b4-bb55658f95bb");
		ServiceResult result = this.testService.deleteSingleUser(user);
		logger.info(result.getResultcode());
		logger.info(result.getDescription());
	}
	//pass
	public void testIsUserExit() {
		logger.info(this.testService.isUserExit(""));
	}
	//pass
	public void testLogin() {
		User user=this.testService.login("000002", "wanan");
		if(user!=null){
			logger.info(user.getUsername());
		}else{
			logger.info("can not get user from database");
		}
	}
	//pass
	public void testgetSingleUser() {
		User user=this.testService.getSingleUser("1b0b016e-5f76-47b1-8460-bf2ab53001cc");
		if(user!=null){
			logger.info(user.getUsername());
		}else{
			logger.info("can not get user from database");
		}
	}
	//pass
	public void testgetListOfUser() throws ParseException {
		User user = new User();
		user.setUsername("邓立芝");
		UserBean userbean=new UserBean();
		userbean.setDaouser(user);
		 List<User> list = this.testService.getListOfUser(userbean);
		if(list!=null){
			 logger.info(list.size());
		}else{
			logger.info("list is null");
		}
	}
}