package service.manage.orders;

import java.util.List;

import dao.mybatis.mapper.OrdermxMapper;
import dao.mybatis.mapper.OrdersMapper;
import dao.mybatis.mapper.ProductMapper;
import dao.mybatis.model.Ordermx;
import dao.mybatis.model.Orders;
import dao.mybatis.model.OrdersExample;

public class OrdersService{
	OrdersMapper ordersMapper;
	OrdermxMapper ordermxMapper;
	ProductMapper productMapper;
	

	public ProductMapper getProductMapper() {
		return productMapper;
	}

	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	public OrdermxMapper getOrdermxMapper() {
		return ordermxMapper;
	}

	public void setOrdermxMapper(OrdermxMapper ordermxMapper) {
		this.ordermxMapper = ordermxMapper;
	}

	public OrdersMapper getOrdersMapper() {
		return ordersMapper;
	}

	public void setOrdersMapper(OrdersMapper ordersMapper) {
		this.ordersMapper = ordersMapper;
	}

	
	public Orders getSingleOrders(Orders orders) {// only use ordersid
		// TODO Auto-generated method stub
		return this.ordersMapper.selectByPrimaryKey(orders.getId());
	}

	
	public String updateSingleOrders(Orders orders) {
		// TODO Auto-generated method stub
		String result = "";
		int ret = this.ordersMapper.updateByPrimaryKeySelective(orders);
		if (ret > 0) {
			result="success";
		} else {
			result="failed";
		}
		return result;
	}

	
	public String deleteSingleOrders(Orders orders) {//only use ordersid
		// TODO Auto-generated method stub
		String result = "";
		int ret = this.ordersMapper.deleteByPrimaryKey(orders.getId());
		if (ret > 0) {
			result="success";
		} else {
			result="failed";
		}
		return result;
	}

	
	public List<Orders> getListOfOrdersFinished(Orders orders) {
		OrdersExample example=new OrdersExample();
		OrdersExample.Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo("1");
		return this.ordersMapper.selectByExample(example);
		
	}

	
	/*public String addSingleOrders(OrderControllerBean orders) {
		// TODO Auto-generated method stub
		String result = "";
		Orders myorders=orders.getOrders();
		myorders.setId(UUID.randomUUID().toString());
		myorders.setState("0");//0为刚下单状态
		int res = this.ordersMapper.insertSelective(myorders);
		List<Ordermx> mxs=orders.getOrdermxs();
		for(int i=0;i<mxs.size();i++){
			//Ordermx mx=mxs.get(i);
			//except productid set all parameter
			mxs.get(i).setId(UUID.randomUUID().toString());
			mxs.get(i).setCreatetime(myorders.getCreatetime());
			mxs.get(i).setCreateuser(myorders.getCreateuser());
			mxs.get(i).setPriority("0");//默认都是0
			mxs.get(i).setState("0");//0为刚下单
			mxs.get(i).setOrderid(myorders.getId());
		}
		System.out.println(mxs);
		int resmx=this.ordermxMapper.insertMultiSelective(mxs);
		System.out.println("res:"+res+"------resmx:"+resmx);
		if (res > 0&&resmx>0) {
			result = "success";
		} else {
			result = "failed";
		}
		return result;
	}

	public List<Ordermx> getOrdersList4Cooks(String userid) {
		// TODO Auto-generated method stub
		List<Ordermx> list=this.ordermxMapper.selectList4Cook(userid);
		for(int i=0;i<list.size();i++){
			String productid=list.get(i).getProductid();
			Product product=this.productMapper.selectByPrimaryKey(productid);
			list.get(i).setProductmc(product.getMc());
		}
		return list;
	}

	根据当前用户的Id获取服务员应该获取到的排序列表
	 * 增加了菜的名称
	 * 增加了订单对应的客户的编号
	 * 
	
	public List<Ordermx> getOrdersList4Waiter(String userid) {
		// TODO Auto-generated method stub
		List<Ordermx> list=this.ordermxMapper.selectList4Waiter(userid);
		for(int i=0;i<list.size();i++){
			String productid=list.get(i).getProductid();
			Product product=this.productMapper.selectByPrimaryKey(productid);
			Orders orders=this.ordersMapper.selectByPrimaryKey(list.get(i).getOrderid());
			list.get(i).setProductmc(product.getMc());
			//list.get(i).setOrderid(orders.getUserid());
			list.get(i).setUserid(orders.getUserid());
		}
		return list;
	}
	
	 * cook change many one type product state to 1
	 * 厨房端将同类型的多个菜的状态同时置为1，为已排菜状态
	 * 需要的参数为productid counts createuserid
	 * 
	 * 
	
	public String updateMxState2oneBycount(Ordermx ordermx) {
		// TODO Auto-generated method stub
		String result = "";
		int ret = this.ordermxMapper.updateState2oneBycount(ordermx);
		if (ret > 0) {
			result="success";
		} else {
			result="failed";
		}
		return result;
	}
	3.从已预订状态的订单中删除一个菜             
	 * 需要参数（订单明细ID）          
	 *  实现原理：根据订单明细的id判断状态是否为已预订（0）状态，
	 *  如果是将其删除

	
	

	根据订单编号获取订单所有的明细项目
	 * 增加了菜的名称
	 * 增加了订单对应的用户的编号
	 * 
	
	public List<Ordermx> getMxListByOrderid(String orderid) {
		OrdermxExample example4ordermx=new OrdermxExample();
		OrdermxExample.Criteria criteria4ordermx=example4ordermx.createCriteria();
		criteria4ordermx.andOrderidEqualTo(orderid);
		List<Ordermx> list=this.ordermxMapper.selectByExample(example4ordermx);
		for(int i=0;i<list.size();i++){
			String productid=list.get(i).getProductid();
			Product product=this.productMapper.selectByPrimaryKey(productid);
			Orders orders=this.ordersMapper.selectByPrimaryKey(list.get(i).getOrderid());
			list.get(i).setProductmc(product.getMc());
			//list.get(i).setOrderid(orders.getUserid());
			list.get(i).setUserid(orders.getUserid());
		}
		return list;
	}*/
	/*1.完成订单
	 *需要参数（订单明细id）            
	 *实现原理：修改订单明细ID对应的状态为2
	 *并判断所有的菜是否都已经上齐了
	 *上齐了将订单状态修改为1完成
	 *make ordermx over
	 **/
	
	/*3.从已预订状态的订单中删除一个菜             
		 * 需要参数（订单明细ID）          
		 *  实现原理：根据订单明细的id判断状态是否为已预订（0）状态，
		 *  如果是将其删除
	*/
		
		public String deleteSingleMxBymxid(String mxid) {
			// TODO Auto-generated method stub
			String result = "";
			Ordermx mx = this.ordermxMapper.selectByPrimaryKey(mxid);
			//mx不是空且状态为0，就将其删除
			if(mx!=null&&("0".equals(mx.getState()))){
				int ret = this.ordermxMapper.deleteByPrimaryKey(mxid);
				if (ret > 0) {
					result="success";
				} else {
					result="failed";
				}
			}else{
				result="failed";
			}
			
			return result;
		}

	/*public String updateSingleMxState2twoBymxid(String mxid) {
		// TODO Auto-generated method stub
		String result = "";
		Ordermx record=new Ordermx();
		record.setId(mxid);
		record.setState(2+"");
		int ret = this.ordermxMapper.updateByPrimaryKeySelective(record);
		if (ret > 0) {
			Ordermx mx = this.ordermxMapper.selectByPrimaryKey(mxid);
			if(checkAllOrdersIsover(mx.getOrderid())==1){
				Orders orders=new Orders();
				orders.setId(mx.getOrderid());
				orders.setState("1");
				int ret4order=this.ordersMapper.updateByPrimaryKey(orders);
				if(ret4order > 0){
					result="success";
				}else{

					result="failed";
				}
			}
		} else {
			result="failed";
		}
		return result;
	}*/
	/*检测该ID下面所有的菜是否都已经上齐全了，
	 * 上齐全了返回1
	 * 否则返回0*/
	
	/*public int checkAllOrdersIsover(String orderid) {
		// TODO Auto-generated method stub
		int result=1;
		List<Ordermx> list = getMxListByOrderid(orderid);
		for(int i=0;i<list.size();i++){
			判断是否所有的状态都是2，
			 * 如果都是2说明订单所有的菜都应经上齐，订单应该处于关闭状态
			if(!"2".equals(list.get(i).getState())){
				result=0;
			}
		}
		return result;
	}*/
	


}
