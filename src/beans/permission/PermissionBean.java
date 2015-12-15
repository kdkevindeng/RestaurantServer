package beans.permission;

import dao.mybatis.model.Permission;

public class PermissionBean {
private Permission permission;
private String query_start_date;
private String query_end_date;
public Permission getPermission() {
	return permission;
}
public void setPermission(Permission permission) {
	this.permission = permission;
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
