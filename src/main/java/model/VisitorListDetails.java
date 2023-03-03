/**
 *@author Riley Ahlrichs riahl12 - rpahlrichs
 *CIS175 - Spring 2023
 *Mar 3, 2023
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class VisitorListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate tripDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Visitor visitor;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
	private List<Animals> listOfAnimals;
	
	public VisitorListDetails() {
		super();
	}
	
	public VisitorListDetails(int id, String listName, LocalDate tripDate, Visitor visitor, List<Animals> listOfAnimals) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.visitor = visitor;
		this.listOfAnimals = listOfAnimals;
	}
	
	public VisitorListDetails(String listName, LocalDate tripDate, Visitor visitor, List<Animals> listOfAnimals) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.visitor = visitor;
		this.listOfAnimals = listOfAnimals;
	}
	
	public VisitorListDetails(String listName, LocalDate tripDate, Visitor visitor) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.visitor = visitor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public List<Animals> getListOfAnimals() {
		return listOfAnimals;
	}

	public void setListOfAnimals(List<Animals> listOfAnimals) {
		this.listOfAnimals = listOfAnimals;
	}

	@Override
	public String toString() {
		return "VisitorListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", visitor="
				+ visitor + ", listOfAnimals=" + listOfAnimals + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
