package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Animals;

/**
 * @author ajlj - Austin Mays ajmays@dmacc.edu
 * CIS175 - Spring 2023
 * Mar 1, 2023
 */
public class AnimalQuery {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Employee");
	public void input(Animals an) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(an);
		em.getTransaction().commit();
		em.close();
	}
	@SuppressWarnings("unchecked")
	public List<Animals> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<Animals> all = em.createQuery("SELECT a FROM Animals a").getResultList();
		return all;
		}
	public Animals searchForAccountByID(int id) {
		return null;
		
	}
	public void updateAccount(Animals edit) {
		
	}
	public void deleteAccount(Animals delete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animals> typedQuery = em.createQuery("SELECT a FROM Animals a where a.animalType = :selectedAnimalType and a.habitat = :selectedHabitat and a.trackingNum = :selectedTrackingNum", Animals.class);
		typedQuery.setParameter("selectedAnimalType", delete.getAnimalType());
		typedQuery.setParameter("selectedHabitat", delete.getHabitat());
		typedQuery.setParameter("selectedTrackingNum", delete.getTrackingNum());
		typedQuery.setMaxResults(1);
		Animals account = typedQuery.getSingleResult();
		em.remove(account);
		em.getTransaction().commit();
		em.close();
	}
	public List<Animals> searchForAccountByType(String type) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animals> typedQuery = em.createQuery("select a from Animals a where a.animalType = :selectedAnimalType", Animals.class);
		typedQuery.setParameter("selectedName", type);List<Animals> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
}


