package com.kruse.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
/*If you want to store the object as a 
 * different table name e.g. 
 * STUDENT_INFORMATION vs default Student_Info
 */
@Table(name="STUDENT_INFORMATION")
public class Student_Info {
	
	@Id
	private int rollNo;
	private String name;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}