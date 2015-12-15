package service.test;

import java.util.Calendar;
import java.util.UUID;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.manage.ads.AdsService;
import dao.mybatis.model.Ads;



public class AdsServiceTest extends TestCase {
	private BeanFactory beanFactory;
	AdsService testService;
	Logger logger;

	@Override
	protected void setUp() throws Exception {
		this.beanFactory = new ClassPathXmlApplicationContext(
				"/spring/ApplicationContext.xml");
		logger = Logger.getLogger(this.getClass());
		testService = (AdsService) this.beanFactory.getBean("adsService");
	}

	public void testaddAds() {
		Ads ads = new Ads();
		ads.setId(UUID.randomUUID().toString());
		ads.setIsuse("sssssssssssss");;
		String result = this.testService.addSingleAds(ads);
		logger.info(result);

	}

	public void testgetSingleAds() {
		Ads ads = new Ads();
		ads.setId("3765c0b2-729f-45cc-a860-60d2a9597700");
		Ads selectedads=this.testService.getSingleAds(ads);
		logger.info(selectedads.getIsuse());
	}

	public void testgetListOfAds() {
		logger.error("not finished!");
	}

	public void testupdateSingleAds() {
		Ads ads = new Ads();
		ads.setId("3765c0b2-729f-45cc-a860-60d2a9597700");
		ads.setBegintime(Calendar.getInstance().getTime());
		logger.info(this.testService.updateSingleAds(ads));
	}

	public void testdeleteSingleAds() {
		Ads ads = new Ads();
		ads.setId("3765c0b2-729f-45cc-a860-60d2a9597700");
		logger.info(this.testService.deleteSingleAds(ads));
	}
}