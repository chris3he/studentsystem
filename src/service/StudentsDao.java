package service;

import java.util.List;

import entity.Students;

public interface StudentsDao {

	public List<Students> query();
	public void addStudent(Students s);
	public void delStudent(String sid);
}
