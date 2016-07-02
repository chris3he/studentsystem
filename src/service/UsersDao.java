package service;

import java.util.List;

import entity.Students;
import entity.Users;

public interface UsersDao {
//用户逻辑接口
	public void regist(Users u);//用户注册
	public Boolean existStudent(Students s);//用户查询是否存在该学生
    public List queryStudent(long id);
    public Boolean userLogin(Users user);
}
