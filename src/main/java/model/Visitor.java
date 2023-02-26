package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ajlj - Austin Mays ajmays@dmacc.edu
 * CIS175 - Spring 2023
 * Feb 26, 2023
 */
@Entity
@Table(name="guest")
public class Visitor {
	@Id
	@GeneratedValue
	@Column(name="NAME")
	private String guestName;
	@Column(name="NUMBER OF PARTY")
	private int numOfGuests;
	@Column(name="EXPERIENCE TYPE")
	private String purchasedExp;
	@Column(name="COST")
	private double cost;
	/**
	 * @return the guestName
	 */
	public Visitor() {
		super();
	}
	public Visitor(String name, int numGuests, String exp, double cost) {
		super();
		this.guestName = name;
		this.numOfGuests = numGuests;
		this.purchasedExp = exp;
		this.cost = cost;
	}
	public String getGuestName() {
		return guestName;
	}
	/**
	 * @param guestName the guestName to set
	 */
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	/**
	 * @return the numOfGuests
	 */
	public int getNumOfGuests() {
		return numOfGuests;
	}
	/**
	 * @param numOfGuests the numOfGuests to set
	 */
	public void setNumOfGuests(int numOfGuests) {
		this.numOfGuests = numOfGuests;
	}
	/**
	 * @return the purchasedExp
	 */
	public String getPurchasedExp() {
		return purchasedExp;
	}
	/**
	 * @param purchasedExp the purchasedExp to set
	 */
	public void setPurchasedExp(String purchasedExp) {
		this.purchasedExp = purchasedExp;
	}
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
}
