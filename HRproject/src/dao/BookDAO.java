package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Book;

public class BookDAO {


public void insert(Book b) {

		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        session.save(b);
        session.getTransaction().commit();
        session.close();
    }

	public void delete(Book b) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		b.setArch(1);
    session.beginTransaction();
    session.update(b);
    session.getTransaction().commit();
    session.close();
        
	}
	
	public void deleteById(Integer id) {
		
		delete(getById(id));
		
	}
	
	public void update(Book b) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        session.beginTransaction();
        session.update(b);
        session.getTransaction().commit();
        session.close();
	}
	
	
	public Book getById(Integer id) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Book b = (Book) session.get(Book.class, id);
        session.getTransaction().commit();
        session.close();

        return b;

    }
	
	@SuppressWarnings("unchecked")
	public List<Book> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Book> bookList = (List<Book>) session.createQuery("from Book").list();
		session.getTransaction().commit();
		session.close();
		
		return bookList;
	}
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Book> getByTitle(String searchstring){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Book.class);
		cr.add(Restrictions.eq("title", searchstring));
				
		List<Book> bookList = cr.list();
		
		session.close();
		
		return bookList;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Book> getByAuthor(String searchstring){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Book.class);
		cr.add(Restrictions.eq("author", searchstring));
				
		List<Book> bookList = cr.list();
		
		session.close();
		
		return bookList;
	}
	
}
