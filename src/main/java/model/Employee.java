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
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="NAME")
	private String empName;
	@Column(name="ID")
	private int empID;
	@Column(name="AREA OF WORK")
	private String areaOfWork;
	/**
	 * @return the empName
	 */
	public Employee() {
		super();
	}
	public Employee(String name, int id, String workArea) {
		super();
		this.empName = name;
		this.empID = id;
		this.areaOfWork = workArea;
	}
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the empID
	 */
	public int getEmpID() {
		return empID;
	}
	/**
	 * @param empID the empID to set
	 */
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	/**
	 * @return the areaOfWork
	 */
	public String getAreaOfWork() {
		return areaOfWork;
	}
	/**
	 * @param areaOfWork the areaOfWork to set
	 */
	public void setAreaOfWork(String areaOfWork) {
		this.areaOfWork = areaOfWork;
	}
}
