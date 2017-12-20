package dao;

import java.util.List;

import org.hibernate.Session;

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
		
		List<Book> blijst = (List<Book>) session.createQuery("from Book").list();
		session.getTransaction().commit();
		session.close();
		
		return blijst;
	}
	
}
