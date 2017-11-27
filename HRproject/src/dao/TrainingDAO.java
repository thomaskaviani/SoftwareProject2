package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Training;

public class TrainingDAO {

	public void insert(Training t) {
        
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
        
    }
	
	
	public void delete(Training t) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		t.setArch(1);
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
        
	}
	
	public void deleteById(Integer id) {
		
		delete(getById(id));
		
	}
	
	public void update(Training t) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Training> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Training> traininglijst = (List<Training>) session.createQuery("from Training").list();
		session.getTransaction().commit();
		session.close();
		
		return traininglijst;
	}
	
	public Training getById(Integer id) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Training t = (Training) session.get(Training.class, id);
        session.getTransaction().commit();
        session.close();

        return t;
    }
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Training getByName(String searchstring) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Training.class);
		cr.add(Restrictions.eq("name", searchstring));
				
		List<Training> traininglijst = cr.list();
		
		session.close();
		
		if (traininglijst.size() == 1) {
			return traininglijst.get(0);
		} else {
			return null;
		}
		
	}
}
