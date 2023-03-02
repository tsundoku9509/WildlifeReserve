package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Employee;

/**
 * @author ajlj - Austin Mays ajmays@dmacc.edu
 * CIS175 - Spring 2023
 * Mar 1, 2023
 */
public class EmployeeQuery {
	
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Employee");
		public void input(Employee emp) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(emp);
			em.getTransaction().commit();
			em.close();
		}
		@SuppressWarnings("unchecked")
		public List<Employee> showAllItems(){
			EntityManager em = emfactory.createEntityManager();
			List<Employee> all = em.createQuery("SELECT e FROM Employee e").getResultList();
			return all;
			}
		public Employee searchForAccountByID(int id) {
			return null;
			
		}
		public void updateAccount(Employee edit) {
			
		}
		public void deleteAccount(Employee delete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Employee> typedQuery = em.createQuery("SELECT e FROM Employee e where e.name = :selectedEmpName and e.id = :selectedEmpID", Employee.class);
			typedQuery.setParameter("selectedEmpName", delete.getEmpName());
			typedQuery.setParameter("selectedEmpID", delete.getEmpID());
			typedQuery.setMaxResults(1);
			Employee account = typedQuery.getSingleResult();
			em.remove(account);
			em.getTransaction().commit();
			em.close();
		}
		public List<Employee> searchForAccountByName(String name) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Employee> typedQuery = em.createQuery("select e from Employee e where e.name = :selectedEmpName", Employee.class);
			typedQuery.setParameter("selectedName", name);List<Employee> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}
}
