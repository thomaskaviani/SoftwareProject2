package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import model.Survey;



public class SurveyDAO {

public void insert(Survey s) {
        
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();
        session.close();
        
        
    }
@SuppressWarnings({ "deprecation", "unchecked" })
	public Survey  getByTraining(Integer trainingId) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Survey.class);
		cr.add(Restrictions.eq("trainingId", trainingId));
		
		List<Survey> slijst = cr.list();
		
		session.close();
		
		if (slijst.size() >= 1) {
			return slijst.get(0);
		} else {
			return null;
		}
		
	}
@SuppressWarnings("unchecked")
public List<Survey> getAll() {
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	
	List<Survey> surveylist = (List<Survey>) session.createQuery("from Survey").list();
	session.getTransaction().commit();
	session.close();
	
	return surveylist;
}

}
