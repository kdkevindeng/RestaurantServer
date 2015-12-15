package service.test;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.manage.permission.RolePermissionService;
import dao.mybatis.model.Role_permission;


public class RolePermissionServiceTest extends TestCase {
	private BeanFactory beanFactory;
	RolePermissionService testService;
	Logger logger;

	@Override
	protected void setUp() throws Exception {
		this.beanFactory = new ClassPathXmlApplicationContext(
				"/spring/ApplicationContext.xml");
		logger = Logger.getLogger(this.getClass());
		testService = (RolePermissionService) this.beanFactory.getBean("rolePermissionService");
	}
	public void testIsRole_permissionsExit(){
		logger.info(this.testService.isRole_permissionsExitAnd("4c4d8e46-3a0c-4107-a2fc-a18b966ebf30","7504df90-4f8b-4f8c-956c-694f426128e9"));
	}
	public void testIsRole_permissionsOr(){
		Role_permission rolepermission=new Role_permission();
		rolepermission.setRoleid("");
		logger.info(this.testService.isRole_permissionsExitOr(rolepermission));
	}
}