package service.test;

import java.util.Calendar;
import java.util.UUID;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.manage.vip.VipService;
import dao.mybatis.model.Vip;

public class VipServiceTest extends TestCase {
	private BeanFactory beanFactory;
	VipService testService;
	Logger logger;

	@Override
	protected void setUp() throws Exception {
		this.beanFactory = new ClassPathXmlApplicationContext(
				"/spring/ApplicationContext.xml");
		logger = Logger.getLogger(this.getClass());
		testService = (VipService) this.beanFactory.getBean("vipService");
	}

	public void testaddVip() {
		Vip vip = new Vip();
		vip.setId(UUID.randomUUID().toString());
		vip.setIsuse("22222222");
		vip.setAlterUser("ssssssssssss");
		String result = this.testService.addSingleVip(vip);
		logger.info(result);

	}

	public void testgetSingleVip() {
		Vip vip = new Vip();
		vip.setId("16ef8323-c8ac-48fd-bbcd-5645ea1790fb");
		Vip selectedvip=this.testService.getSingleVip(vip);
		logger.info(selectedvip.getIsuse());
	}

	public void testgetListOfVip() {
		logger.error("not finished!");
	}

	public void testupdateSingleVip() {
		Vip vip = new Vip();
		vip.setId("16ef8323-c8ac-48fd-bbcd-5645ea1790fb");
		vip.setCreateDate(Calendar.getInstance().getTime());
		logger.info(this.testService.updateSingleVip(vip));
	}

	public void testdeleteSingleVip() {
		Vip vip = new Vip();
		vip.setId("111111111");
		logger.info(this.testService.deleteSingleVip(vip));
	}
}