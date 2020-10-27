package com.capgemini.lms.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class BooksReturned {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne(cascade= {CascadeType.ALL})
	private Users users;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Books> books;
	private Date returnedDate;
	private int delayed_Days;
	private double penalty;
	private String penalty_Status;
	public BooksReturned(int id, Users users, List<Books> books, Date returnedDate, int delayed_Days, double penalty,
			String penalty_Status) {
		super();
		this.id = id;
		this.users = users;
		this.books = books;
		this.returnedDate = returnedDate;
		this.delayed_Days = delayed_Days;
		this.penalty = penalty;
		this.penalty_Status = penalty_Status;
	}
	public BooksReturned(Users users, List<Books> books, Date returnedDate, int delayed_Days, double penalty,
			String penalty_Status) {
		super();
		this.users = users;
		this.books = books;
		this.returnedDate = returnedDate;
		this.delayed_Days = delayed_Days;
		this.penalty = penalty;
		this.penalty_Status = penalty_Status;
	}
	public BooksReturned() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
	public int getDelayed_Days() {
		return delayed_Days;
	}
	public void setDelayed_Days(int delayed_Days) {
		this.delayed_Days = delayed_Days;
	}
	public double getPenalty() {
		return penalty;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	public String getPenalty_Status() {
		return penalty_Status;
	}
	public void setPenalty_Status(String penalty_Status) {
		this.penalty_Status = penalty_Status;
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
