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
@Table(name = "animals")
public class Animals {
	@Id
	@GeneratedValue
	@Column(name="ANIMAL")
	private String animalType;
	@Column(name="HABITAT")
	private String habitat;
	@Column(name="TRACKING_NUMBER")
	private int trackingNum;
	/**
	 * @return the animalType
	 */
	
	public Animals() {
		super();
	}
	
	public Animals(String type, String habitat, int track) {
		super();
		this.animalType = type;
		this.habitat = habitat;
		this.trackingNum = track;
	}
	
	public Animals(String type, String habitat) {
		super();
		this.animalType = type;
		this.habitat = habitat;
	}

	public String getAnimalType() {
		return animalType;
	}
	/**
	 * @param animalType the animalType to set
	 */
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	/**
	 * @return the habitat
	 */
	public String getHabitat() {
		return habitat;
	}
	/**
	 * @param habitat the habitat to set
	 */
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	/**
	 * @return the trackingNum
	 */
	public int getTrackingNum() {
		return trackingNum;
	}
	/**
	 * @param trackingNum the trackingNum to set
	 */
	public void setTrackingNum(int trackingNum) {
		this.trackingNum = trackingNum;
	}
	
	public String returnAnimalDetails() {
		return this.animalType + ": " + this.habitat + ": " + this.trackingNum;
	}
	
	@Override
	public String toString() {
		return "Animals [animalType=" + animalType + ", habitat=" + habitat + ", trackingNum=" + trackingNum + "]";
	}
	
}
