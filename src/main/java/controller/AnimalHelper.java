/**
 *@author Riley Ahlrichs riahl12 - rpahlrichs
 *CIS175 - Spring 2023
 *Mar 1, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Animals;


public class AnimalHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WildlifeReserve");
	
	public void insertAnimal(Animals ani) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ani);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Animals> showAllAnimals(){
		EntityManager em = emfactory.createEntityManager();
		List<Animals> allAnimals = em.createQuery("SELECT a FROM Animals a").getResultList();
		return allAnimals;
	}
	
	public void deleteAnimal(Animals toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animals> typedQuery = em.createQuery("select a from Animals a where a.animalType = :selectedAnimalType and a.habitat = :selectedHabitat and a.trackingNum = :selectedTrackingNum", Animals.class);
		
		typedQuery.setParameter("selectedAnimalType", toDelete.getAnimalType());
		typedQuery.setParameter("selectedHabitat", toDelete.getHabitat());
		typedQuery.setParameter("selectedTrackingNum", toDelete.getTrackingNum());
		
		typedQuery.setMaxResults(1);
		
		Animals result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Animals searchForAnimalsById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Animals found = em.find(Animals.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateAnimals(Animals toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Animals> searchForAnimalByAnimalType(String animalType){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animals> typedQuery = em.createQuery("select a from Animals a where a.animalType = :selectedAnimalType", Animals.class);
		typedQuery.setParameter("selectedAnimalType", animalType);
		
		List<Animals>foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	public List<Animals> searchForAnimalByHabitat(String habitat){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animals> typedQuery = em.createQuery("select a from Animals a where a.habitat = :selectedHabitat", Animals.class);
		typedQuery.setParameter("selectedHabitat", habitat);
		
		List<Animals>foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
		
	}
	public void cleanUp() {
		emfactory.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
