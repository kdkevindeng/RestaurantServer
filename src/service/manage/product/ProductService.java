package service.manage.product;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import dao.mybatis.mapper.ProductMapper;
import dao.mybatis.model.Product;
import dao.mybatis.model.ProductExample;

public class ProductService{
	Logger logger = Logger.getLogger(this.getClass());

	ProductMapper productMapper;

	public ProductMapper getProductMapper() {
		return productMapper;
	}

	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	
	public String addSingleProduct(Product product) {
		// TODO Auto-generated method stub
		String result = "";
		if (product.getMc()!= null && (!"".equals(product.getMc()))&&product.getPrice()!=null&&(!"".endsWith(product.getPrice()))) {

			if (isProductExit(product)) {
				result = updateSingleProduct(product);
			} else {
				product.setProductid(UUID.randomUUID().toString());
				int res = this.productMapper.insertSelective(product);
				if (res > 0) {
					result = "success";
				} else {
					result = "failed";
				}
			}
		} else {
			logger.info(" Product mc price can not null");
		}

		return result;
	}

	
	public String updateSingleProduct(Product product) {
		// TODO Auto-generated method stub
		String result = "";
		int ret = 0;
		if (product.getProductid() != null && !"".equals(product.getProductid())) {
			ret = this.productMapper.updateByPrimaryKeySelective(product);
		} else {
			logger.info("Productid not null");
		}
		if (ret > 0) {
			result = "success";
		} else {
			result = "failed";
		}
		return result;
	}

	
	public String deleteSingleProduct(Product product) {// only use Productid
		// TODO Auto-generated method stub
		String result = "";
		int ret = 0;
		if (product.getProductid() != null && !"".equals(product.getProductid())) {
			ret = this.productMapper.deleteByPrimaryKey(product.getProductid());
		} else {
			logger.info("Productid not null");
		}

		if (ret > 0) {
			result = "success";
		} else {
			result = "failed";
		}
		return result;
	}

	
	public Product getSingleProduct(Product product) {// only use Productid
		// TODO Auto-generated method stub
		Product product_res = null;
		if (product.getProductid() != null && !"".equals(product.getProductid())) {
			product_res = this.productMapper.selectByPrimaryKey(product.getProductid());
		} else {
			logger.info("Productid not null");
		}

		return product_res;
	}
	/*get my product list
	 * need your userid
	 * */
	
	public List<Product> getListOfProduct(Product product) {
		// TODO Auto-generated method stub
		ProductExample example = new ProductExample();
		ProductExample.Criteria criteria = example.createCriteria();
		//get your product by CreateUser
		criteria.andCreateUserEqualTo(product.getCreateUser());
		List<Product> list = this.productMapper.selectByExample(example);
		return list;
	}

	
	public boolean isProductExit(Product product) {
		// TODO Auto-generated method stub
		boolean res = false;
		Product single = getSingleProduct(product);
		if (single!=null) {
			res = true;
			logger.info(product.getMc() + "already exit");
		}
		return res;
	}


}
