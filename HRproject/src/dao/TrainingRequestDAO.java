package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.TrainingRequest;

public class TrainingRequestDAO {

	public void insert(TrainingRequest t) {
        
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
        
    }
	
	
	public void delete(TrainingRequest t) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        session.close();
        
	}
	
	public void deleteById(Integer id) {
		
		delete(getById(id));
		
	}
	
	public void update(TrainingRequest t) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
	}
	
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<TrainingRequest> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(TrainingRequest.class);
		cr.add(Restrictions.eq("approval", 2));
		
		List<TrainingRequest> traininglijst = cr.list();
		
		//List<TrainingRequest> traininglijst = (List<TrainingRequest>) session.createQuery("from TrainingRequest").list();
		
		
		
		session.getTransaction().commit();
		session.close();
		
		return traininglijst;
	}
	
	public TrainingRequest getById(Integer id) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        TrainingRequest t = (TrainingRequest) session.get(TrainingRequest.class, id);
        session.getTransaction().commit();
        session.close();

        return t;
    }
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public TrainingRequest getByName(String searchstring) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(TrainingRequest.class);
		cr.add(Restrictions.eq("name", searchstring));
				
		List<TrainingRequest> traininglijst = cr.list();
		
		session.close();
		
		if (traininglijst.size() == 1) {
			return traininglijst.get(0);
		} else {
			return null;
		}
		
	}
}