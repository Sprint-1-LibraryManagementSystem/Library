package com.capgemini.lms.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class BooksIssued {
	@Id
	@GeneratedValue
	private int issueId;
	@OneToOne(cascade= {CascadeType.ALL})
	private Users users;
	@OneToMany(cascade = CascadeType.ALL) 
	private List<Books> books;
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	private Date issueDate;
	private int quantity;
	private Date dueDate;
	public BooksIssued(Users users, List<Books> books, Date issueDate, int quantity, Date dueDate) {
		super();
		this.users = users;
		this.books = books;
		this.issueDate = issueDate;
		this.quantity = quantity;
		this.dueDate = dueDate;
	}
	public BooksIssued(int issueId, Users users, List<Books> books, Date issueDate, int quantity, Date dueDate) {
		super();
		this.issueId = issueId;
		this.users = users;
		this.books = books;
		this.issueDate = issueDate;
		this.quantity = quantity;
		this.dueDate = dueDate;
	}
	public BooksIssued() {
		// TODO Auto-generated constructor stub
	}
	public int getIssueId() {
		return issueId;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	
}
