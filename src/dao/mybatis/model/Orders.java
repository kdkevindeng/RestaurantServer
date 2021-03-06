package dao.mybatis.model;

import java.util.Date;

public class Orders {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ORDERS.ID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ORDERS.USERID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private String userid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ORDERS.PRODUCTID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private String productid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ORDERS.CREATETIME
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private Date createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ORDERS.CREATEUSER
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private String createuser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ORDERS.ALERTTIME
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private Date alerttime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ORDERS.ALERTUSER
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private String alertuser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ORDERS.STATE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private String state;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ORDERS.ID
	 * @return  the value of RESTAURANT.ORDERS.ID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ORDERS.ID
	 * @param id  the value for RESTAURANT.ORDERS.ID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ORDERS.USERID
	 * @return  the value of RESTAURANT.ORDERS.USERID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ORDERS.USERID
	 * @param userid  the value for RESTAURANT.ORDERS.USERID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ORDERS.PRODUCTID
	 * @return  the value of RESTAURANT.ORDERS.PRODUCTID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getProductid() {
		return productid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ORDERS.PRODUCTID
	 * @param productid  the value for RESTAURANT.ORDERS.PRODUCTID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setProductid(String productid) {
		this.productid = productid == null ? null : productid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ORDERS.CREATETIME
	 * @return  the value of RESTAURANT.ORDERS.CREATETIME
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ORDERS.CREATETIME
	 * @param createtime  the value for RESTAURANT.ORDERS.CREATETIME
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ORDERS.CREATEUSER
	 * @return  the value of RESTAURANT.ORDERS.CREATEUSER
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getCreateuser() {
		return createuser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ORDERS.CREATEUSER
	 * @param createuser  the value for RESTAURANT.ORDERS.CREATEUSER
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setCreateuser(String createuser) {
		this.createuser = createuser == null ? null : createuser.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ORDERS.ALERTTIME
	 * @return  the value of RESTAURANT.ORDERS.ALERTTIME
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public Date getAlerttime() {
		return alerttime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ORDERS.ALERTTIME
	 * @param alerttime  the value for RESTAURANT.ORDERS.ALERTTIME
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setAlerttime(Date alerttime) {
		this.alerttime = alerttime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ORDERS.ALERTUSER
	 * @return  the value of RESTAURANT.ORDERS.ALERTUSER
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getAlertuser() {
		return alertuser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ORDERS.ALERTUSER
	 * @param alertuser  the value for RESTAURANT.ORDERS.ALERTUSER
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setAlertuser(String alertuser) {
		this.alertuser = alertuser == null ? null : alertuser.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ORDERS.STATE
	 * @return  the value of RESTAURANT.ORDERS.STATE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getState() {
		return state;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ORDERS.STATE
	 * @param state  the value for RESTAURANT.ORDERS.STATE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}
}