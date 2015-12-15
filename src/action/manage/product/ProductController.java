package action.manage.product;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import service.common.ServiceResult;
import service.common.utils.FileUploadService;
import service.manage.product.ProductService;
import dao.mybatis.model.Product;
import dao.mybatis.model.User;


@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * add one product
	 * 
	 * @param product
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addoneproduct")
	public void addoneproduct(Product product, PrintWriter out, HttpSession session) {
		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			product.setAlterDate(Calendar.getInstance().getTime());
			product.setAlterUser(currentuser.getUserid());
			product.setCreateDate(Calendar.getInstance().getTime());
			product.setCreateUser(currentuser.getUserid());
			out.println(this.productService.addSingleProduct(product));
		} else {
			out.println("nologin");
		}
	}
	/**
	 * add one product
	 * 
	 * @param product
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addoneproductwithimg")
	public void addoneproductwithimg(HttpServletRequest request,Product product, PrintWriter out, HttpSession session) {

		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {

			ServiceResult uploadres=new FileUploadService().uploadImg(request);
			product.setPhoto(uploadres.getResultdata().toString());
			product.setAlterDate(Calendar.getInstance().getTime());
			product.setAlterUser(currentuser.getUserid());
			product.setCreateDate(Calendar.getInstance().getTime());
			product.setCreateUser(currentuser.getUserid());
			out.println(this.productService.addSingleProduct(product));
		} else {
			out.println("nologin");
		}
	}

	/**
	 * delete one product
	 * 
	 * @param product
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/deleteoneproduct")
	public void deleteoneproduct(Product product, PrintWriter out) {
		out.println(this.productService.deleteSingleProduct(product));
	}

	/**
	 * update one product
	 * 
	 * @param product
	 * @param out
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateoneproduct")
	public void updateoneproduct(Product product, PrintWriter out, HttpSession session) {

		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			product.setAlterDate(Calendar.getInstance().getTime());
			product.setAlterUser(currentuser.getUserid());
			out.println(this.productService.updateSingleProduct(product));
		} else {
			out.println("nologin");
		}
	
	}

	/**
	 * select one product
	 * 
	 * @param product
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/selectoneproduct")
	public void selectoneproduct(Product product, PrintWriter out) {
		Product selectedproduct = this.productService.getSingleProduct(product);
		if (selectedproduct != null) {
			JSONObject json = JSONObject.fromObject(selectedproduct);
			out.println(json.toString());
		} else {
			out.println("null");
		}
	}

	/**
	 * select all product
	 * 
	 * @param product
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/selectallproduct")
	public void selectallproduct(Product product, PrintWriter out, HttpSession session) {
		User currentuser = (User) session.getAttribute("currentuser");
		if (currentuser != null) {
			product.setCreateUser(currentuser.getUserid());
			List<Product> selectedproduct = this.productService.getListOfProduct(product);
			if (selectedproduct != null && selectedproduct.size() > 0) {
				JSONArray json = JSONArray.fromObject(selectedproduct);
				out.println(json.toString());
			} else {
				out.println("null");
			}
		
		} else {
			out.println("nologin");
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,
				true));
	}
}
