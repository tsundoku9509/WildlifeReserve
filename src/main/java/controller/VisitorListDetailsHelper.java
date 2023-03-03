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

import model.VisitorListDetails;

public class VisitorListDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WildlifeReserve");
	
	public void insertNewVisitorListDetails(VisitorListDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<VisitorListDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<VisitorListDetails> allDetails = em.createQuery("SELECT d FROM VisitorListDetails d").getResultList();
		return allDetails;
	}
}
