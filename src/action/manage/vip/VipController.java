package action.manage.vip;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import service.manage.vip.VipService;
import dao.mybatis.model.User;
import dao.mybatis.model.Vip;

@Controller
@RequestMapping(value = "/vip")
public class VipController {

	@Autowired
	private VipService vipService;

	/**
	 * add one vip
	 * 
	 * @param vip
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addonevip")
	public void addonevip(Vip vip, PrintWriter out, HttpSession session) {
		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			vip.setAlterDate(Calendar.getInstance().getTime());
			vip.setAlterUser(currentuser.getUserid());
			vip.setCreateDate(Calendar.getInstance().getTime());
			vip.setCreateUser(currentuser.getUserid());
			out.println(this.vipService.addSingleVip(vip));
		} else {
			out.println("nologin");
		}
	}

	/**
	 * delete one vip
	 * 
	 * @param vip
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/deleteonevip")
	public void deleteonevip(Vip vip, PrintWriter out) {
		out.println(this.vipService.deleteSingleVip(vip));
	}

	/**
	 * update one vip
	 * 
	 * @param vip
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateonevip")
	public void updateonevip(Vip vip, PrintWriter out, HttpSession session) {

		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			vip.setAlterDate(Calendar.getInstance().getTime());
			vip.setAlterUser(currentuser.getUserid());
			out.println(this.vipService.updateSingleVip(vip));
		} else {
			out.println("nologin");
		}
	
	}

	/**
	 * select one vip
	 * 
	 * @param vip
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/selectonevip")
	public void selectonevip(Vip vip, PrintWriter out) {
		Vip selectedvip = this.vipService.getSingleVip(vip);
		if (selectedvip != null) {
			JSONObject json = JSONObject.fromObject(selectedvip);
			out.println(json.toString());
		} else {
			out.println("null");
		}
	}

	/**
	 * select all vip
	 * 
	 * @param vip
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/selectallvip")
	public void selectallvip(Vip vip, PrintWriter out) {
		List<Vip> selectedvip = this.vipService.getListOfVip(vip);
		if (selectedvip != null && selectedvip.size() > 0) {
			JSONArray json = JSONArray.fromObject(selectedvip);
			out.println(json.toString());
		} else {
			out.println("null");
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,
				true));
	}
}
