package service;

import java.util.List;

import entity.Students;
import entity.Users;

public interface UsersDao {
//�û��߼��ӿ�
	public void regist(Users u);//�û�ע��
	public Boolean existStudent(Students s);//�û���ѯ�Ƿ���ڸ�ѧ��
    public List queryStudent(long id);
    public Boolean userLogin(Users user);
}
