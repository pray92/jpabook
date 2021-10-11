package jpabook.jpashop;

import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	
	public static void main(String[] args){
		// persistence-unit에 있는 것을 파라미터로
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		{
			EntityManager em = emf.createEntityManager();
			{
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				try {
					
					tx.commit();
				} catch (Exception e){
					tx.rollback();
				} finally {
					em.close();
				}
			}
		}
		emf.close();
	}
}
