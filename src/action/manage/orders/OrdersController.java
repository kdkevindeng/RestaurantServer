package action.manage.orders;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/orders")
public class OrdersController {/*

	@Autowired
	private OrdersService ordersService;

	*//**
	 * add one orders
	 * 
	 * @param orders
	 * @param out
	 * @param session
	 * @return
	 *//*
	@RequestMapping(value = "/addoneorders")
	public void addoneorders(OrderControllerBean orders, PrintWriter out, HttpSession session) {
		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			Date now=Calendar.getInstance().getTime();
			orders.getOrders().setAlerttime(now);
			orders.getOrders().setAlertuser(currentuser.getUserid());
			orders.getOrders().setCreatetime(now);
			orders.getOrders().setCreateuser(currentuser.getUserid());
			out.println(this.ordersService.addSingleOrders(orders));
		} else {
			out.println("nologin");
		}
	}

	*//**
	 * delete one orders
	 * 
	 * @param orders
	 * @param out
	 * @return
	 *//*
	@RequestMapping(value = "/deleteoneorders")
	public void deleteoneorders(Orders orders, PrintWriter out) {
		out.println(this.ordersService.deleteSingleOrders(orders));
	}

	*//**
	 * update one orders
	 * 
	 * @param orders
	 * @param out
	 * @param session
	 * @return
	 *//*
	@RequestMapping(value = "/updateoneorders")
	public void updateoneorders(Orders orders, PrintWriter out, HttpSession session) {

		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			orders.setAlerttime(Calendar.getInstance().getTime());
			orders.setAlertuser(currentuser.getUserid());
			out.println(this.ordersService.updateSingleOrders(orders));
		} else {
			out.println("nologin");
		}
	
	}
	*//**
	 * 厨师备完菜以后点击按钮
	 * 将一定数量的同类型的菜的状态改为1
	 * 
	 * @param orders
	 * @param out
	 * @param session
	 * @return
	 *//*
	@RequestMapping(value = "/makeitover4cook")
	public void makeitover4cook(Ordermx ordermx, PrintWriter out, HttpSession session) {

		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			ordermx.setCreateuser(currentuser.getUserid());
			out.println(this.ordersService.updateMxState2oneBycount(ordermx));
		} else {
			out.println("nologin");
		}
	
	}
	*//**
	 * 顾客将菜取走以后
	 * 服务员将订单作为完成状态
	 * 
	 * @param orders
	 * @param out
	 * @param session
	 * @return
	 *//*
	@RequestMapping(value = "/makeitover4waiter")
	public void makeitover4waiter(Ordermx ordermx, PrintWriter out, HttpSession session) {

		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			//ordermx.setCreateuser(currentuser.getUserid());
			out.println(this.ordersService.updateSingleMxState2twoBymxid(ordermx.getId()));
		} else {
			out.println("nologin");
		}
	
	}
	*//**
	 * 顾客的菜还没有进入备菜环节的
	 * 服务员将其删除
	 * 
	 * @param orders
	 * @param out
	 * @param session
	 * @return
	 *//*
	@RequestMapping(value = "/deletenotreadymx4waiter")
	public void deletenotreadymx4waiter(Ordermx ordermx, PrintWriter out, HttpSession session) {

		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			//ordermx.setCreateuser(currentuser.getUserid());
			out.println(this.ordersService.deleteSingleMxBymxid(ordermx.getId()));
		} else {
			out.println("nologin");
		}
	
	}
	*//**
	 * 查询一个订单相应的明细信息
	 * 
	 * @param orders
	 * @param out
	 * @return
	 *//*
	@RequestMapping(value = "/selectmxs4oneorders")
	public void selectmxs4oneorders(Orders orders, PrintWriter out, HttpSession session) {
		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			List<Ordermx> selectedordermxs = this.ordersService.getMxListByOrderid(orders.getId());
			if (selectedordermxs != null) {
				JSONArray json = JSONArray.fromObject(selectedordermxs);
				out.println(json.toString());
			} else {
				out.println("null");
			}
		} else {
			out.println("nologin");
		}
	}*//**
	 * select one orders
	 * 
	 * @param orders
	 * @param out
	 * @return
	 *//*
	@RequestMapping(value = "/selectoneorders")
	public void selectoneorders(Orders orders, PrintWriter out) {
		Orders selectedorders = this.ordersService.getSingleOrders(orders);
		if (selectedorders != null) {
			JSONObject json = JSONObject.fromObject(selectedorders);
			out.println(json.toString());
		} else {
			out.println("null");
		}
	}

	*//**
	 * select all orders
	 * 
	 * @param orders
	 * @param out
	 * @return
	 *//*
	@RequestMapping(value = "/selectallordersfinished")
	public void selectallordersfinished(Orders orders, PrintWriter out, HttpSession session) {
		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			List<Ordermx> selectedorders = this.ordersService.getOrdersList4Cooks(currentuser.getUserid());
			if (selectedorders != null && selectedorders.size() > 0) {
				JSONArray json = JSONArray.fromObject(selectedorders);
				out.println(json.toString());
			} else {
				out.println("null");
			}
		} else {
			out.println("nologin");
		}
	}
	*//**
	 * select all orders
	 * 
	 * @param orders
	 * @param out
	 * @return
	 *//*
	@RequestMapping(value = "/selectallorders4cook")
	public void selectallorders4cook(PrintWriter out, HttpSession session) {
		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			List<Ordermx> selectedorders = this.ordersService.getOrdersList4Cooks(currentuser.getUserid());
			if (selectedorders != null && selectedorders.size() > 0) {
				JSONArray json = JSONArray.fromObject(selectedorders);
				out.println(json.toString());
			} else {
				out.println("null");
			}
		} else {
			out.println("nologin");
		}
	}
	*//**
	 * select all orders
	 * 
	 * @param orders
	 * @param out
	 * @return
	 *//*
	@RequestMapping(value = "/selectallorders4waiter")
	public void selectallorders4waiter(PrintWriter out, HttpSession session) {
		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			List<Ordermx> selectedorders = this.ordersService.getOrdersList4Waiter(currentuser.getUserid());
			if (selectedorders != null && selectedorders.size() > 0) {
				JSONArray json = JSONArray.fromObject(selectedorders);
				out.println(json.toString());
			} else {
				out.println("null");
			}
		}else {
			out.println("nologin");
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,
				true));
	}
*/}
