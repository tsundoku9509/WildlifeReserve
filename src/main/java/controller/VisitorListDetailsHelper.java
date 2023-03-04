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
import javax.persistence.TypedQuery;

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
	
	public void deleteList(VisitorListDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<VisitorListDetails> typedQuery = em.createQuery("SELECT detail FROM VisitorListDetails detail WHERE detail.id = :selectedId", VisitorListDetails.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		VisitorListDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public VisitorListDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		VisitorListDetails found = em.find(VisitorListDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void updateList(VisitorListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
	
	
	
	
}
