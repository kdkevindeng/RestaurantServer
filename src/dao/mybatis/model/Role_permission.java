package dao.mybatis.model;

import java.util.Date;

public class Role_permission {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ROLE_PERMISSION.ID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ROLE_PERMISSION.ROLEID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private String roleid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ROLE_PERMISSION.PERMISSIONID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private String permissionid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ROLE_PERMISSION.DESCRIBLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private String describle;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ROLE_PERMISSION.CREATETIME
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private Date createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ROLE_PERMISSION.CREATEUSER
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private String createuser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RESTAURANT.ROLE_PERMISSION.ISUSE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	private String isuse;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ROLE_PERMISSION.ID
	 * @return  the value of RESTAURANT.ROLE_PERMISSION.ID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ROLE_PERMISSION.ID
	 * @param id  the value for RESTAURANT.ROLE_PERMISSION.ID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ROLE_PERMISSION.ROLEID
	 * @return  the value of RESTAURANT.ROLE_PERMISSION.ROLEID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ROLE_PERMISSION.ROLEID
	 * @param roleid  the value for RESTAURANT.ROLE_PERMISSION.ROLEID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid == null ? null : roleid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ROLE_PERMISSION.PERMISSIONID
	 * @return  the value of RESTAURANT.ROLE_PERMISSION.PERMISSIONID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getPermissionid() {
		return permissionid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ROLE_PERMISSION.PERMISSIONID
	 * @param permissionid  the value for RESTAURANT.ROLE_PERMISSION.PERMISSIONID
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setPermissionid(String permissionid) {
		this.permissionid = permissionid == null ? null : permissionid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ROLE_PERMISSION.DESCRIBLE
	 * @return  the value of RESTAURANT.ROLE_PERMISSION.DESCRIBLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getDescrible() {
		return describle;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ROLE_PERMISSION.DESCRIBLE
	 * @param describle  the value for RESTAURANT.ROLE_PERMISSION.DESCRIBLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setDescrible(String describle) {
		this.describle = describle == null ? null : describle.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ROLE_PERMISSION.CREATETIME
	 * @return  the value of RESTAURANT.ROLE_PERMISSION.CREATETIME
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ROLE_PERMISSION.CREATETIME
	 * @param createtime  the value for RESTAURANT.ROLE_PERMISSION.CREATETIME
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ROLE_PERMISSION.CREATEUSER
	 * @return  the value of RESTAURANT.ROLE_PERMISSION.CREATEUSER
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getCreateuser() {
		return createuser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ROLE_PERMISSION.CREATEUSER
	 * @param createuser  the value for RESTAURANT.ROLE_PERMISSION.CREATEUSER
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setCreateuser(String createuser) {
		this.createuser = createuser == null ? null : createuser.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RESTAURANT.ROLE_PERMISSION.ISUSE
	 * @return  the value of RESTAURANT.ROLE_PERMISSION.ISUSE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getIsuse() {
		return isuse;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RESTAURANT.ROLE_PERMISSION.ISUSE
	 * @param isuse  the value for RESTAURANT.ROLE_PERMISSION.ISUSE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setIsuse(String isuse) {
		this.isuse = isuse == null ? null : isuse.trim();
	}
}