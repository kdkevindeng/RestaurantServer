package service.test;

import junit.framework.TestCase;



public class OrdersServiceTest extends TestCase {/*
	private BeanFactory beanFactory;
	OrdersService testService;
	Logger logger;

	@Override
	protected void setUp() throws Exception {
		this.beanFactory = new ClassPathXmlApplicationContext(
				"/spring/ApplicationContext.xml");
		logger = Logger.getLogger(this.getClass());
		testService = (OrdersService) this.beanFactory.getBean("ordersService");
	}

	public void testaddOrders() {
		Orders orders = new Orders();
		orders.setAlertuser("3347749a-c618-4c1b-b1b1-6b178bffae06");
		orders.setCreateuser("3347749a-c618-4c1b-b1b1-6b178bffae06");
		orders.setAlerttime(new Date());
		orders.setCreatetime(new Date());
		orders.setCount("10");
		orders.setUserid("22");
		List<Ordermx> list=new ArrayList<Ordermx>();
		for(int i=0;i<10;i++){
			Ordermx items=new Ordermx();
			items.setProductid("35c514bf-94b7-48e1-93c7-9f52a85e6d22");
			list.add(items);
		}
		OrderControllerBean bean=new OrderControllerBean();
		bean.setOrders(orders);
		bean.setOrdermxs(list);
		String result = this.testService.addSingleOrders(bean);
		logger.info(result);

	}

	public void testgetSingleOrders() {
		Orders orders = new Orders();
		orders.setId("c4560b85-bd21-4187-b7e1-06c6c93dd7fb");
		Orders selectedorders=this.testService.getSingleOrders(orders);
		logger.info(selectedorders.getState());
	}

	public void testgetListOfOrders() {
		logger.error("not finished!");
	}
	public void testgetListOfOrders4Cooks() {
		List<Ordermx> list=this.testService.getOrdersList4Cooks("3347749a-c618-4cs1b-b1b1-6b178bffae06");
		for(int i=0;i<list.size();i++){
			Ordermx mx=list.get(i);
			logger.info(mx.getProductmc());
			logger.info(mx.getCounts());
		}
	}
	public void testgetListOfOrders4Waiter() {
		List<Ordermx> list=this.testService.getOrdersList4Waiter("3347749a-c618-4c1b-b1b1-6b178bffae06");
		for(int i=0;i<list.size();i++){
			Ordermx mx=list.get(i);
			logger.info(mx.getProductmc());
		}
	}

	public void testupdateSingleOrders() {
		Orders orders = new Orders();
		orders.setId("c4560b85-bd21-4187-b7e1-06c6c93dd7fb");
		orders.setAlerttime(Calendar.getInstance().getTime());
		logger.info(this.testService.updateSingleOrders(orders));
	}

	public void testdeleteSingleOrders() {
		Orders orders = new Orders();
		orders.setId("11111111");
		logger.info(this.testService.deleteSingleOrders(orders));
	}
	public void testUpdateMxState2oneBycount() {
		Ordermx mx=new Ordermx();
		mx.setProductid("c2ccded4-ca31-429c-bda5-691ef8e35293");
		mx.setCounts(6);
		mx.setCreateuser("3347749a-c618-4c1b-b1b1-6b178bffae06");
		logger.info(this.testService.updateMxState2oneBycount(mx));
	}
	public void testcheckAllOrdersIsover() {
		logger.info(this.testService.checkAllOrdersIsover("d0c3b042-434f-4092-8706-690ceb62054a"));
	}
	public void testupdateSingleMxState2twoBymxid() {
		logger.info(this.testService.updateSingleMxState2twoBymxid("d8d19d05-7fe5-4e56-844c-4e1a253376bf"));
	}
	public void testgetMxListByOrderid(){
		List<Ordermx> list = this.testService.getMxListByOrderid("61498edf-b916-4a18-b8c5-ebe68666606e");
		for(int i=0;i<list.size();i++){
			logger.info(list.get(i).getProductmc());
		}
			
	}
	public void testdeleteSingleMxBymxid(){
		logger.info(this.testService.deleteSingleMxBymxid("6e360a7b-f76d-4857-a391-fb9fc383e80a"));
		
	}
	
*/}