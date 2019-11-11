package com.javatraining0.application.entities;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
@SqlResultSetMapping(name = "mapppinNativeQuery", // same as resultSetMapping
													// above in NativeQuery
classes = { @ConstructorResult(targetClass = com.javatraining0.application.entities.Student.class, columns = {
		@ColumnResult(name = "student_id", type = Integer.class),
		@ColumnResult(name = "student_name", type = String.class),
		@ColumnResult(name = "student_dept", type = String.class),
		@ColumnResult(name = "student_address", type = String.class)
		
		

}) })
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private int sid;
	@Column(name = "student_name")
	private String name;
	@Column(name = "student_dept")
	private String dept;
	@Column(name = "student_address")
	private String address;
	@Column(name = "faculty_id")
	private String facultyId;

	/**
	 * @return the facultyId
	 */
	public String getFacultyId() {
		return facultyId;
	}

	/**
	 * @param facultyId
	 *            the facultyId to set
	 */
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	/**
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", dept=" + dept
				+ ", address=" + address + "]";
	}

	/**
	 * @param sid
	 *            the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public Student(int sid,  String name,String dept, String address) {
		super();
		this.sid = sid;
		this.name = name;
		this.dept = dept;
		this.address = address;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}

	/**
	 * @param dept
	 *            the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
