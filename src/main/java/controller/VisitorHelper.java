/**
 *@author Riley Ahlrichs riahl12 - rpahlrichs
 *CIS175 - Spring 2023
 *Mar 3, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Visitor;

public class VisitorHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WildlifeReserve");
	
	public void insertVisitor(Visitor v) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Visitor> showAllVisitors(){
		EntityManager em = emfactory.createEntityManager();
		List<Visitor> allVisitors = em.createQuery("SELECT v FROM Visitor v").getResultList();
		return allVisitors;
	}
}
