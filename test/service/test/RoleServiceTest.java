package service.test;

import java.text.ParseException;
import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.common.ServiceResult;
import service.manage.permission.RoleService;
import beans.role.RoleBean;
import dao.mybatis.model.Role;


public class RoleServiceTest extends TestCase {
	private BeanFactory beanFactory;
	RoleService testService;
	Logger logger;

	@Override
	protected void setUp() throws Exception {
		this.beanFactory = new ClassPathXmlApplicationContext(
				"/spring/ApplicationContext.xml");
		logger = Logger.getLogger(this.getClass());
		testService = (RoleService) this.beanFactory.getBean("roleService");
	}
	public void testIsRoleExit(){
		logger.info(this.testService.isRoleExit("管理員"));
	}
	public void testaddRole() {
		Role role = new Role();
		role.setRoleMc("管理員1");
		ServiceResult result = this.testService.addSingleRole(role);
		logger.info(result.getResultcode());
		logger.info(result.getDescription());

	}

	public void testupdateSingleRole() {
		Role role = new Role();
		role.setRoleDm("76507c59-013f-44ad-859b-290a3710eece");
		role.setRoleMc("管理员");
		ServiceResult result = this.testService.updateSingleRole(role);

		logger.info(result.getResultcode());
		logger.info(result.getDescription());
	}

	public void testdeleteSingleRole() {
		Role role=new Role();
		role.setRoleDm("1b3a6986-197e-482a-ac5e-25c37fb279eb");
		ServiceResult result=this.testService.deleteSingleRole(role);
		logger.info(result.getResultcode());
		logger.info(result.getDescription());
	}

	public void testgetSingleRole() {
		Role role = new Role();
		//role.setRoleDm("");
		Role selectedrole=this.testService.getSingleRole(role);
		if(selectedrole!=null){
			logger.info(selectedrole.getRoleMc());
		}else{

			logger.info("can not get "+ role.getRoleDm());
		}
	}

	public void testgetListOfRole() throws ParseException {
		Role role = new Role();
//		role.setRoleMc("管理员1");
		RoleBean rolebean=new RoleBean();
		rolebean.setDaorole(role);
		rolebean.setQuery_start_date("2015-11-01");
		rolebean.setQuery_end_date("2015-11-30");
		 List<Role> list = this.testService.getListRole(rolebean);
		if(list!=null){
			 logger.info(list.size());
		}else{
			logger.info("list is null");
		}
	}
}