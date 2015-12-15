package service.test;

import java.util.Calendar;
import java.util.UUID;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.manage.news.NewsService;
import dao.mybatis.model.News;



public class NewsServiceTest extends TestCase {
	private BeanFactory beanFactory;
	NewsService testService;
	Logger logger;

	@Override
	protected void setUp() throws Exception {
		this.beanFactory = new ClassPathXmlApplicationContext(
				"/spring/ApplicationContext.xml");
		logger = Logger.getLogger(this.getClass());
		testService = (NewsService) this.beanFactory.getBean("newsService");
	}

	public void testaddNews() {
		News news = new News();
		news.setId(UUID.randomUUID().toString());
		news.setAlertuser("22222222");
		String result = this.testService.addSingleNews(news);
		logger.info(result);

	}

	public void testgetSingleNews() {
		News news = new News();
		news.setId("2a3e0641-0c5d-4290-9580-927751fe5c5b");
		News selectednews=this.testService.getSingleNews(news);
		logger.info(selectednews.getAlertuser());
	}

	public void testgetListOfNews() {
		logger.error("not finished!");
	}

	public void testupdateSingleNews() {
		News news = new News();
		news.setId("2a3e0641-0c5d-4290-9580-927751fe5c5b");
		news.setAlerttime(Calendar.getInstance().getTime());
		logger.info(this.testService.updateSingleNews(news));
	}

	public void testdeleteSingleNews() {
		News news = new News();
		news.setId("2a3e0641-0c5d-4290-9580-927751fe5c5b");
		logger.info(this.testService.deleteSingleNews(news));
	}
}