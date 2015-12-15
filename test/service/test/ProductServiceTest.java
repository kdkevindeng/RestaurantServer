package service.test;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.manage.product.ProductService;
import dao.mybatis.model.Product;




public class ProductServiceTest extends TestCase {
	private BeanFactory beanFactory;
	ProductService testService;
	Logger logger;

	@Override
	protected void setUp() throws Exception {
		this.beanFactory = new ClassPathXmlApplicationContext(
				"/spring/ApplicationContext.xml");
		logger = Logger.getLogger(this.getClass());
		testService = (ProductService) this.beanFactory.getBean("productService");
	}

	public void testaddProduct() {
		Product product = new Product();
		product.setProductid(UUID.randomUUID().toString());
		product.setMc("试试");
		product.setPrice(""+12);
		product.setAlterDate(Calendar.getInstance().getTime());
		product.setAlterUser("ssssss");
		product.setCreateDate(Calendar.getInstance().getTime());
		product.setCreateUser("ssssss");
		//product.setAlterUser("22222222");
		String result = this.testService.addSingleProduct(product);
		logger.info(result);
		

	}

	public void testgetSingleProduct() {
		Product product = new Product();
		product.setProductid("43d6ef77-2680-462b-b588-14db15a563d7");
		Product selectedproduct=this.testService.getSingleProduct(product);
		logger.info(selectedproduct.getMc());
	}

	public void testgetListOfProduct() {
		Product product=new Product();
		product.setCreateUser("3347749a-c618-4c1b-b1b1-6b178bffae06");
		List<Product> list=this.testService.getListOfProduct(product);
		for(int i=0;i<list.size();i++){

			logger.info(list.get(i).getMc());
		}
	}

	public void testupdateSingleProduct() {
		Product product = new Product();
		product.setProductid("43d6ef77-2680-462b-b588-14db15a563d7");
		product.setAlterDate(Calendar.getInstance().getTime());
		logger.info(this.testService.updateSingleProduct(product));
	}

	public void testdeleteSingleProduct() {
		Product product = new Product();
		product.setProductid("43d6ef77-2680-462b-b588-14db15a563d7");
		logger.info(this.testService.deleteSingleProduct(product));
	}
}