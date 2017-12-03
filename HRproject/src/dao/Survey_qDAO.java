package dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Sessions;
import model.Survey;
import model.Survey_q;
import model.Training;



public class Survey_qDAO {

	

public void insert(Survey_q sq) {
        
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(sq);
        session.getTransaction().commit();
        session.close();
        
        
    }
public void update(Survey_q sq) {
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
    session.beginTransaction();
    session.update(sq);
    session.getTransaction().commit();
    session.close();
}

@SuppressWarnings({ "deprecation", "unchecked" })
public List<Survey_q> getBySurveyId(Integer id){
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	
	Criteria cr = session.createCriteria(Survey_q.class);
	cr.add(Restrictions.eq("surveyId", id));
			
	List<Survey_q> qlist = cr.list();
	
	session.close();
	
	if (qlist.size() >= 1) {
		return qlist;
	} else {
		return null;
	}
}

}
