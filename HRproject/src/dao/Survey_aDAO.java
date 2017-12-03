package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import model.Survey_a;


public class Survey_aDAO {

	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Survey_a> getByQuestionId(Integer id){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Survey_a.class);
		cr.add(Restrictions.eq("questionId", id));
				
		List<Survey_a> alist = cr.list();
		
		session.close();
		
		if (alist.size() >= 1) {
			return alist;
		} else {
			return null;
		}
	}

}
