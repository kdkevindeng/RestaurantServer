package action.manage.orders;

import java.util.List;

import dao.mybatis.model.Ordermx;
import dao.mybatis.model.Orders;

public class OrderControllerBean {
private Orders orders;
private List<Ordermx> ordermxs;
public Orders getOrders() {
	return orders;
}
public void setOrders(Orders orders) {
	this.orders = orders;
}
public List<Ordermx> getOrdermxs() {
	return ordermxs;
}
public void setOrdermxs(List<Ordermx> ordermxs) {
	this.ordermxs = ordermxs;
}

}
