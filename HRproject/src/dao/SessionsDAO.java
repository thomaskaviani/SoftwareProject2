package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Sessions;

public class SessionsDAO {

	public void insert(Sessions s) {
        
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();
        
    }
	
	
	public void delete(Sessions s) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		s.setArch(1);
        session.beginTransaction();
        session.update(s);
        session.getTransaction().commit();
        
	}
	
	public void deleteById(Integer id) {
		
		delete(getById(id));
		
	}
	
	public void update(Sessions s) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        session.beginTransaction();
        session.update(s);
        session.getTransaction().commit();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Sessions> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Sessions> sessionslist = (List<Sessions>) session.createQuery("from Sessions").list();
		session.getTransaction().commit();
		
		return sessionslist;
	}
	
	public Sessions getById(Integer id) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Sessions s = (Sessions) session.get(Sessions.class, id);
        session.getTransaction().commit();

        return s;
    }
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Sessions getByName(String searchstring) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Sessions.class);
		cr.add(Restrictions.eq("name", searchstring));
				
		List<Sessions> sessionslist = cr.list();
		
		session.close();
		
		if (sessionslist.size() == 1) {
			return sessionslist.get(0);
		} else {
			return null;
		}
		
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Sessions> getByTraining(Integer trainingId) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Sessions.class);
		cr.add(Restrictions.eq("trainingId", trainingId));
		
		List<Sessions> sessionslist = cr.list();
		
		session.close();
		
		if (sessionslist.size() >= 1) {
			return sessionslist;
		} else {
			return null;
		}
		
	}
}
