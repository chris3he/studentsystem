package entity;

public class Users {

	private long account;//用户的账号
	private String name;//用户的姓名
	private String password;//用户的密码
	private String sex;//管理系统的用户性别
	private String uid;//用户的id
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId() {
		return uid;
	}
	public void setId(String uid) {
		this.uid = uid;
	}
}
