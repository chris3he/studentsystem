package entity;

public class Users {

	private long account;//�û����˺�
	private String name;//�û�������
	private String password;//�û�������
	private String sex;//����ϵͳ���û��Ա�
	private String uid;//�û���id
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
