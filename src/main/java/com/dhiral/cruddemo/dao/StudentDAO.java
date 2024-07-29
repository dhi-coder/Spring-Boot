package com.dhiral.cruddemo.dao;

import java.util.List;

import com.dhiral.cruddemo.entity.Student;

public interface StudentDAO {

	public void savez(Student thestudent);
	public Student findByid(Integer id);
	public List<Student> findAllStudent();
	public List<Student> findByLatname(String lastNamer);
	public void update(Student theStudent);
	public void Delete(Integer id);
	public int DeleteALL();
}
