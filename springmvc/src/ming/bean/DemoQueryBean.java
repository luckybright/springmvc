package ming.bean;

import java.util.Date;

public class DemoQueryBean {
	private String userId;
	private String userName;
	private Date date;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = new Date();
	}
	
	public String toString(){
		return this.userId+this.userName+this.date;
	}
}
