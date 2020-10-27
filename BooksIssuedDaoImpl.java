package com.capgemini.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.lms.entities.BooksIssued;
import com.capgemini.lms.exception.BookNotFoundException;

public class BooksIssuedDaoImpl implements BooksIssuedDao{

	EntityManagerFactory factory=Persistence.createEntityManagerFactory( "LM_BU" );
	EntityManager manager = factory.createEntityManager( );


	@Override
	public int addIssuedBook(BooksIssued issued) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(issued);
		transaction.commit();
		return issued.getIssueId();
	}

	@Override
	public int updateIssuedBookDetails(BooksIssued booksIssued)   {
		// TODO Auto-generated method stub
				EntityTransaction transaction = manager.getTransaction();
				BooksIssued bi=manager.find(BooksIssued.class, booksIssued.getIssueId());
				if(bi==null) {
					try {
						throw new BookNotFoundException("No such Book present for update");
					} catch (BookNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					bi.setIssueDate(booksIssued.getIssueDate());
					bi.setBooks(booksIssued.getBooks());
					bi.setQuantity(booksIssued.getQuantity());
					bi.setDueDate(booksIssued.getDueDate());
					transaction.begin();
					manager.persist(bi);
					System.out.println(bi);
					transaction.commit();
				}
				return booksIssued.getIssueId();
			}


	@Override
	public int deleteIssuedBookS(int bookid) throws BookNotFoundException {
		// TODO Auto-generated method stub
		EntityTransaction transaction = manager.getTransaction();
		BooksIssued bi=manager.find(BooksIssued.class, bookid);
		if(bi==null) {
			throw new BookNotFoundException("No such Book present for update");
		}
		else {
			transaction.begin();
			manager.remove(bi);
			transaction.commit();
		}
		return bookid;
	}

	@Override
	public List<BooksIssued> viewBooksIssuedList() {
		// TODO Auto-generated method stub
		List<BooksIssued> list;
		String selectQuery="select e from BooksIssued e";
		Query query=manager.createQuery(selectQuery);
		list=query.getResultList();		
		return list;
	}

}
