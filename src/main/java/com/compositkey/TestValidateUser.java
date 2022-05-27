package com.compositkey;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestValidateUser {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		
		Query query = entityManager.createQuery("Select u from User u where (u.userId.phone=?1 or u.userId.email=?2) and u.password=?3" ) ;
		query.setParameter(1, 0l ) ;
		query.setParameter(2, "chaitra@mail.com" ) ;
		query.setParameter(3, "chai123" ) ;
		
		
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
