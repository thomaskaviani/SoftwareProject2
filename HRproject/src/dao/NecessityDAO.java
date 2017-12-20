package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Necessity;

public class NecessityDAO {

	public void insert(Necessity necessity) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(necessity);
        session.getTransaction().commit();
        session.close();
    }
	
	public void delete(Necessity necessity) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		necessity.setArch(1);
        session.beginTransaction();
        session.update(necessity);
        session.getTransaction().commit();
        session.close();
        
	}
	
	public void deleteById(Integer id) {
		
		delete(getById(id));
		
	}
	
	public void update(Necessity n) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        session.beginTransaction();
        session.update(n);
        session.getTransaction().commit();
        session.close();
	}
	
	
	public Necessity getById(Integer id) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Necessity necessity = (Necessity) session.get(Necessity.class, id);
        session.getTransaction().commit();
        session.close();

        return necessity;
    }
	
	@SuppressWarnings("unchecked")
	public List<Necessity> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Necessity> nList = (List<Necessity>) session.createQuery("from Necessity").list();
		session.getTransaction().commit();
		session.close();
		
		return nList;
	}
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Necessity> getByBookId(int searchBook){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Necessity.class);
		cr.add(Restrictions.eq("bookId", searchBook));
				
		List<Necessity> nList = cr.list();
		
		session.close();
		
		return nList;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Necessity> getByTrainingId(int searchTraining){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Necessity.class);
		cr.add(Restrictions.eq("trainingId", searchTraining));
				
		List<Necessity> nList = cr.list();
		
		session.close();
		
		return nList;
	}
	
}
