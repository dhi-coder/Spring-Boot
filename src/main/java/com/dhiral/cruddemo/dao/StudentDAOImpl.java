package com.dhiral.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhiral.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	// define field for entity manager
	private EntityManager entityManager;
	
	// inject enetity manager using constructor injecttion
	@Autowired
	public StudentDAOImpl(EntityManager theentityManager) {
		this.entityManager = theentityManager;
	}
	
	// im-plement save method

	@Override
	@Transactional
	public void savez(Student thestudent) {
		
		entityManager.persist(thestudent);
		
	}
	
	public Student findByid(Integer id) {
		return entityManager.find(Student.class, id);
		
	}
	
	public List<Student> findAllStudent(){
		// create a query 
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by firstName desc",Student.class); // Student is entity class name not the database table all the names should be of entity class
		// return query result5
		return theQuery.getResultList();
	}
	
	public List<Student> findByLatname(String lastname){
		// create query
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student where lastName= :theData",Student.class); 
		// set query parameter 
		theQuery.setParameter("theData", lastname);
		// return query result
		return theQuery.getResultList();	
		}
	
	@Transactional
	public void update(Student thestudent) {
		entityManager.merge(thestudent);
	}
	
	@Transactional
	public void Delete(Integer id) {
		Student theStudent = entityManager.find(Student.class, id);
		entityManager.remove(theStudent);
	}
	
	@Transactional
	public int DeleteALL() {
		int numOfDeletedRows = entityManager.createQuery("Delete from Student").executeUpdate();
		return numOfDeletedRows;
	}

}
