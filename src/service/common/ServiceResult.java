package service.common;

public class ServiceResult {
	//1:success,0:failed;
	private int resultcode;
	private String description;
	private Object resultdata;
	
	public Object getResultdata() {
		return resultdata;
	}
	public void setResultdata(Object resultdata) {
		this.resultdata = resultdata;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getResultcode() {
		return resultcode;
	}
	public void setResultcode(int resultcode) {
		this.resultcode = resultcode;
	}
	
}
