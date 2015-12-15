package service.test;

import java.util.List;
import java.util.UUID;

import junit.framework.TestCase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.common.ServiceResult;
import service.manage.permission.PermissionService;
import action.manage.permission.TreeBean;
import beans.permission.PermissionBean;
import dao.mybatis.model.Permission;


public class PermissionServiceTest extends TestCase {
	private BeanFactory beanFactory;
	PermissionService testService;
	Logger logger;

	@Override
	protected void setUp() throws Exception {
		this.beanFactory = new ClassPathXmlApplicationContext(
				"/spring/ApplicationContext.xml");
		logger = Logger.getLogger(this.getClass());
		testService = (PermissionService) this.beanFactory.getBean("permissionService");
	}
	public void testIsPermissionExit(){
		logger.info(this.testService.isPermissionExit("www.baidu.com"));
	}
	public void testaddPermission() {
		Permission permission = new Permission();
		permission.setPermissionDm(UUID.randomUUID().toString());
		permission.setPermissionMc("百度1");
		permission.setUrl("http://www.baidu.com.cn");
		permission.setParentcode("0");
		ServiceResult result = this.testService.addSinglePermission(permission);
		logger.info(result.getResultcode());
		logger.info(result.getDescription());

	}

	public void testupdateSinglePermission() {
		Permission permission = new Permission();
		permission.setPermissionDm("ca85ed48-08fb-4c2b-be07-beec4618c033");
		permission.setPermissionMc("百度1");
		permission.setUrl("http://www.baidu.com");
		ServiceResult result = this.testService.updateSinglePermission(permission);
		logger.info(result.getResultcode());
		logger.info(result.getDescription());

	}
	public void testdeleteSinglePermission() {
		Permission permission = new Permission();
		permission.setPermissionDm("ca85ed48-08fb-4c2b-be07-beec4618c033");

		ServiceResult result = this.testService.deleteSinglePermisssion(permission);
		logger.info(result.getResultcode());
		logger.info(result.getDescription());

	}
	public void testgetListOfPermission() {
		Permission permission = new Permission();
		permission.setPermissionMc("百度1");
		PermissionBean ermissionbean=new PermissionBean();
		ermissionbean.setPermission(permission);
		 List<Permission> list = this.testService.getListPermission(ermissionbean);
		if(list!=null){
			 logger.info(list.size());
		}else{
			logger.info("list is null");
		}
	}
	public void testGenerateAllTrees() {
		TreeBean res=this.testService.generateAllTrees("4c4d8e46-3a0c-4107-a2fc-a18b966ebf30");
		JSONObject json=JSONObject.fromObject(res);
		logger.info(json);
	}

	public void testgetSinglePermission() {
		Permission permission = new Permission();
		permission.setPermissionDm("0");
		Permission selectedpermission=this.testService.getSinglePermission(permission);
		if(selectedpermission!=null){
			logger.info(selectedpermission.getPermissionMc());
		}else{

			logger.info("can not get "+ permission.getPermissionDm());
		}
	}
	public void testJson(){
		String jsonstr="[{\"id\":\"5df0e81a-6dc8-4b2e-909f-8937d5b75fb0\"},{\"id\":\"5a247a5a-09ee-4cde-835e-dca9ca896272\"},{\"id\":\"300debfc-7ed9-48b4-84de-699170d3ef22\"}]";
		JSONArray jsonobj = JSONArray.fromObject(jsonstr);
		logger.info(((JSONObject)jsonobj.get(0)).get("id"));
	}
}