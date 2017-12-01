package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.User;

public class UserDAO {

	public void insert(User u) {
        
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        session.close();
        
    }
	
	
	public void delete(User user) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		user.setArch(1);
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        
	}
	
	public void deleteById(Integer id) {
		
		delete(getById(id));
		
	}
	
	public void update(User u) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        session.beginTransaction();
        session.update(u);
        session.getTransaction().commit();
        session.close();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<User> userlijst = (List<User>) session.createQuery("from User").list();
		session.getTransaction().commit();
		session.close();
		
		return userlijst;
	}
	
	public User getById(Integer id) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User u = (User) session.get(User.class, id);
        session.getTransaction().commit();
        session.close();

        return u;
    }
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public User getByUsername(String searchstring) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("username", searchstring));
				
		List<User> userlijst = cr.list();
		
		session.close();
		
		if (userlijst.size() == 1) {
			return userlijst.get(0);
		} else {
			return null;
		}
		
	}
	
}
