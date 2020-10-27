package com.capgemini.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksIssued;
import com.capgemini.lms.entities.BooksReturned;
import com.capgemini.lms.exception.BookNotFoundException;


public class BooksReturnedDaoImpl implements BooksReturnedDao{
	EntityManagerFactory factory=Persistence.createEntityManagerFactory( "LM_BU" );
	EntityManager manager = factory.createEntityManager( );

	@Override
	public int returnBooks(BooksReturned returned) {
		// TODO Auto-generated method stub
		BooksReturned br= manager.find(BooksReturned.class,returned.getId());
		List<Books> list=br.getBooks();
		int size=list.size();
		
		return size;
	}

	@Override
	public int updateReturnedBookDetails(BooksReturned booksReturned) throws BookNotFoundException {
		// TODO Auto-generated method stub
		EntityTransaction transaction = manager.getTransaction();
		BooksReturned bi=manager.find(BooksReturned.class, booksReturned.getId());
		if(bi==null) {
			try {
				throw new BookNotFoundException("No such Book present for update");
			} catch (BookNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			bi.setReturnedDate(booksReturned.getReturnedDate());
			bi.setUsers(booksReturned.getUsers());
			bi.setBooks(booksReturned.getBooks());
			bi.setDelayed_Days(booksReturned.getDelayed_Days());
			bi.setPenalty(booksReturned.getPenalty());
			bi.setPenalty_Status(booksReturned.getPenalty_Status());
			transaction.begin();
			manager.persist(bi);
			System.out.println(bi);
			transaction.commit();
		}
		return booksReturned.getId();
	}

	@Override
	public List<BooksReturned> viewReturnedBooksList() {
		// TODO Auto-generated method stub
		List<BooksReturned> list;
		String selectQuery="select e from BooksReturned e";
		Query query=manager.createQuery(selectQuery);
		list=query.getResultList();		
		return list;
	}

	@Override
	public List<BooksReturned> viewDelayedBooksList() {
		// TODO Auto-generated method stub
		List<BooksReturned> list;
		String selectQuery="select e from BooksReturned e where delayed_Days!=0";
		Query query=manager.createQuery(selectQuery);
		list=query.getResultList();		
		return list;
	}

}
