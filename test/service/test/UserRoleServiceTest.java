package service.test;

import java.text.ParseException;

import junit.framework.TestCase;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.manage.user.UserRoleService;
import action.manage.permission.TreeBean;

public class UserRoleServiceTest extends TestCase {
	private BeanFactory beanFactory;
	UserRoleService testService;
	Logger logger;

	@Override
	protected void setUp() throws Exception {
		this.beanFactory = new ClassPathXmlApplicationContext(
				"/spring/ApplicationContext.xml");
		logger = Logger.getLogger(this.getClass());
		testService = (UserRoleService) this.beanFactory.getBean("userRoleService");
	}
	//pass
	public void testgenerateMyTrees() throws ParseException {
		TreeBean tree = this.testService.generateMyTrees("99817504-b624-4219-a8c8-ea2d7ed9116c");
		JSONObject json=JSONObject.fromObject(tree);
		logger.info(json);
	}
}