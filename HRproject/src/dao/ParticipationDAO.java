package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Participation;

public class ParticipationDAO {

	public void insert(Participation part) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(part);
        session.getTransaction().commit();
    }
	
	public void delete(Participation part) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		part.setArch(1);
        session.beginTransaction();
        session.update(part);
        session.getTransaction().commit();
        
	}
	
	public void deleteById(Integer id) {
		
		delete(getById(id));
		
	}
	
	public void update(Participation a) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
	}
	
	
	public Participation getById(Integer id) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Participation part = (Participation) session.get(Participation.class, id);
        session.getTransaction().commit();

        return part;
    }
	
	@SuppressWarnings("unchecked")
	public List<Participation> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Participation> partlijst = (List<Participation>) session.createQuery("from Participation").list();
		session.getTransaction().commit();
		
		return partlijst;
	}
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Participation> getBySessionId(Integer id){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Participation.class);
		cr.add(Restrictions.eq("sessionId", id));
				
		List<Participation> partlijst = cr.list();
		
		return partlijst;
	}
	
	
	
	
	
	
}
