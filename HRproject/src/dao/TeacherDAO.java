package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Teacher;

public class TeacherDAO {

	public void insert(Teacher t) {
        
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        
    }
	
	
	public void delete(Teacher t) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		t.setArch(1);
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        
	}
	
	public void deleteById(Integer id) {
		
		delete(getById(id));
		
	}
	
	public void update(Teacher t) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Teacher> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Teacher> traininglijst = (List<Teacher>) session.createQuery("from Teacher").list();
		session.getTransaction().commit();
		
		return traininglijst;
	}
	
	public Teacher getById(Integer id) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Teacher t = (Teacher) session.get(Teacher.class, id);
        session.getTransaction().commit();

        return t;
    }
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Teacher getByName(String searchstring) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Teacher.class);
		cr.add(Restrictions.eq("teacherName", searchstring));
				
		List<Teacher> tlijst = cr.list();
		
		session.close();
		
		if (tlijst.size() == 1) {
			return tlijst.get(0);
		} else {
			return null;
		}
		
	}
}