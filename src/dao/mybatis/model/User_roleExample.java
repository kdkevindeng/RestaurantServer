package dao.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class User_roleExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public User_roleExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()),
					property);
		}

		protected void addCriterionForJDBCDate(String condition,
				List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1,
				Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()),
					new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(String value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("ID like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("ID not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andUseridIsNull() {
			addCriterion("USERID is null");
			return (Criteria) this;
		}

		public Criteria andUseridIsNotNull() {
			addCriterion("USERID is not null");
			return (Criteria) this;
		}

		public Criteria andUseridEqualTo(String value) {
			addCriterion("USERID =", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotEqualTo(String value) {
			addCriterion("USERID <>", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThan(String value) {
			addCriterion("USERID >", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThanOrEqualTo(String value) {
			addCriterion("USERID >=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThan(String value) {
			addCriterion("USERID <", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThanOrEqualTo(String value) {
			addCriterion("USERID <=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLike(String value) {
			addCriterion("USERID like", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotLike(String value) {
			addCriterion("USERID not like", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridIn(List<String> values) {
			addCriterion("USERID in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotIn(List<String> values) {
			addCriterion("USERID not in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridBetween(String value1, String value2) {
			addCriterion("USERID between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotBetween(String value1, String value2) {
			addCriterion("USERID not between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andRoleidIsNull() {
			addCriterion("ROLEID is null");
			return (Criteria) this;
		}

		public Criteria andRoleidIsNotNull() {
			addCriterion("ROLEID is not null");
			return (Criteria) this;
		}

		public Criteria andRoleidEqualTo(String value) {
			addCriterion("ROLEID =", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidNotEqualTo(String value) {
			addCriterion("ROLEID <>", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidGreaterThan(String value) {
			addCriterion("ROLEID >", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidGreaterThanOrEqualTo(String value) {
			addCriterion("ROLEID >=", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidLessThan(String value) {
			addCriterion("ROLEID <", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidLessThanOrEqualTo(String value) {
			addCriterion("ROLEID <=", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidLike(String value) {
			addCriterion("ROLEID like", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidNotLike(String value) {
			addCriterion("ROLEID not like", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidIn(List<String> values) {
			addCriterion("ROLEID in", values, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidNotIn(List<String> values) {
			addCriterion("ROLEID not in", values, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidBetween(String value1, String value2) {
			addCriterion("ROLEID between", value1, value2, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidNotBetween(String value1, String value2) {
			addCriterion("ROLEID not between", value1, value2, "roleid");
			return (Criteria) this;
		}

		public Criteria andDescribleIsNull() {
			addCriterion("DESCRIBLE is null");
			return (Criteria) this;
		}

		public Criteria andDescribleIsNotNull() {
			addCriterion("DESCRIBLE is not null");
			return (Criteria) this;
		}

		public Criteria andDescribleEqualTo(String value) {
			addCriterion("DESCRIBLE =", value, "describle");
			return (Criteria) this;
		}

		public Criteria andDescribleNotEqualTo(String value) {
			addCriterion("DESCRIBLE <>", value, "describle");
			return (Criteria) this;
		}

		public Criteria andDescribleGreaterThan(String value) {
			addCriterion("DESCRIBLE >", value, "describle");
			return (Criteria) this;
		}

		public Criteria andDescribleGreaterThanOrEqualTo(String value) {
			addCriterion("DESCRIBLE >=", value, "describle");
			return (Criteria) this;
		}

		public Criteria andDescribleLessThan(String value) {
			addCriterion("DESCRIBLE <", value, "describle");
			return (Criteria) this;
		}

		public Criteria andDescribleLessThanOrEqualTo(String value) {
			addCriterion("DESCRIBLE <=", value, "describle");
			return (Criteria) this;
		}

		public Criteria andDescribleLike(String value) {
			addCriterion("DESCRIBLE like", value, "describle");
			return (Criteria) this;
		}

		public Criteria andDescribleNotLike(String value) {
			addCriterion("DESCRIBLE not like", value, "describle");
			return (Criteria) this;
		}

		public Criteria andDescribleIn(List<String> values) {
			addCriterion("DESCRIBLE in", values, "describle");
			return (Criteria) this;
		}

		public Criteria andDescribleNotIn(List<String> values) {
			addCriterion("DESCRIBLE not in", values, "describle");
			return (Criteria) this;
		}

		public Criteria andDescribleBetween(String value1, String value2) {
			addCriterion("DESCRIBLE between", value1, value2, "describle");
			return (Criteria) this;
		}

		public Criteria andDescribleNotBetween(String value1, String value2) {
			addCriterion("DESCRIBLE not between", value1, value2, "describle");
			return (Criteria) this;
		}

		public Criteria andCreateuserIsNull() {
			addCriterion("CREATEUSER is null");
			return (Criteria) this;
		}

		public Criteria andCreateuserIsNotNull() {
			addCriterion("CREATEUSER is not null");
			return (Criteria) this;
		}

		public Criteria andCreateuserEqualTo(String value) {
			addCriterion("CREATEUSER =", value, "createuser");
			return (Criteria) this;
		}

		public Criteria andCreateuserNotEqualTo(String value) {
			addCriterion("CREATEUSER <>", value, "createuser");
			return (Criteria) this;
		}

		public Criteria andCreateuserGreaterThan(String value) {
			addCriterion("CREATEUSER >", value, "createuser");
			return (Criteria) this;
		}

		public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
			addCriterion("CREATEUSER >=", value, "createuser");
			return (Criteria) this;
		}

		public Criteria andCreateuserLessThan(String value) {
			addCriterion("CREATEUSER <", value, "createuser");
			return (Criteria) this;
		}

		public Criteria andCreateuserLessThanOrEqualTo(String value) {
			addCriterion("CREATEUSER <=", value, "createuser");
			return (Criteria) this;
		}

		public Criteria andCreateuserLike(String value) {
			addCriterion("CREATEUSER like", value, "createuser");
			return (Criteria) this;
		}

		public Criteria andCreateuserNotLike(String value) {
			addCriterion("CREATEUSER not like", value, "createuser");
			return (Criteria) this;
		}

		public Criteria andCreateuserIn(List<String> values) {
			addCriterion("CREATEUSER in", values, "createuser");
			return (Criteria) this;
		}

		public Criteria andCreateuserNotIn(List<String> values) {
			addCriterion("CREATEUSER not in", values, "createuser");
			return (Criteria) this;
		}

		public Criteria andCreateuserBetween(String value1, String value2) {
			addCriterion("CREATEUSER between", value1, value2, "createuser");
			return (Criteria) this;
		}

		public Criteria andCreateuserNotBetween(String value1, String value2) {
			addCriterion("CREATEUSER not between", value1, value2, "createuser");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNull() {
			addCriterion("CREATETIME is null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNotNull() {
			addCriterion("CREATETIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeEqualTo(Date value) {
			addCriterionForJDBCDate("CREATETIME =", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("CREATETIME <>", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThan(Date value) {
			addCriterionForJDBCDate("CREATETIME >", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("CREATETIME >=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThan(Date value) {
			addCriterionForJDBCDate("CREATETIME <", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("CREATETIME <=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIn(List<Date> values) {
			addCriterionForJDBCDate("CREATETIME in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("CREATETIME not in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("CREATETIME between", value1, value2,
					"createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("CREATETIME not between", value1, value2,
					"createtime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table RESTAURANT.USER_ROLE
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_role
     *
     * @mbggenerated do_not_delete_during_merge Thu Nov 26 10:37:30 CAT 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}