package com.compositkey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveUser {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		

		UserId userId = new UserId() ;
		userId.setEmail("prbha@mail.com");
		userId.setPhone(90718666);
		
		User user = new User() ;
		user.setName("prabhavathi");
		user.setAge(24);
		user.setGender("female");
		user.setPassword("prabha123");
		user.setUserId(userId);
		
		
		entityTransaction.begin();
		
		entityManager.persist(user);
		
		entityTransaction.commit();
		
		
		
	}

}
