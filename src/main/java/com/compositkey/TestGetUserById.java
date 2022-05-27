package com.compositkey;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestGetUserById {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		Query query = entityManager.createQuery("Select u from User u where u.userId.email=?1 and u.userId.phone=?2" ) ;
		query.setParameter(1, "nagu@mail.com") ;
		query.setParameter(2, 90718656l ) ;
		
		
		List<User> users = query.getResultList() ;
		
		if( users.size() != 0 ) {
			for(User user : users) {
				System.out.println("User name: "+ user.getName());
				System.out.println("User age: "+ user.getAge());
				System.out.println("User gender: "+ user.getGender());
				System.out.println("User password: "+ user.getPassword());
				System.out.println("User email: "+ user.getUserId().getEmail());
				System.out.println("User phone: "+ user.getUserId().getPhone());
			}
		}
		else {
			System.out.println("No user found");
		}
		
		

	}

}
