package beans.user;

import dao.mybatis.model.User;

public class UserBean {
private User daouser;
private String query_start_date;
private String query_end_date;

public User getDaouser() {
	return daouser;
}

public void setDaouser(User daouser) {
	this.daouser = daouser;
}

public String getQuery_start_date() {
	return query_start_date;
}

public void setQuery_start_date(String query_start_date) {
	this.query_start_date = query_start_date;
}

public String getQuery_end_date() {
	return query_end_date;
}

public void setQuery_end_date(String query_end_date) {
	this.query_end_date = query_end_date;
}

}
