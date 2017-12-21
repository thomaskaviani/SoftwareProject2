package dao;

import java.util.List;

import org.hibernate.Session;

import model.EmployeeDB;

public class EmployeeDAO {


	public void update(EmployeeDB e) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        session.beginTransaction();
        session.update(e);
        session.getTransaction().commit();
        session.close();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<EmployeeDB> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<EmployeeDB> elist = (List<EmployeeDB>) session.createQuery("from EmployeeDB").list();
		session.getTransaction().commit();
		session.close();
		
		return elist;
	}
	
	public EmployeeDB getById(Integer id) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        EmployeeDB s = (EmployeeDB) session.get(EmployeeDB.class, id);
        session.getTransaction().commit();
        session.close();

        return s;
    }
	
	
}
