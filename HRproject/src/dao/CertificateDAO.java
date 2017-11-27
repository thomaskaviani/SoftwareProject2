package dao;

import java.util.List;

import org.hibernate.Session;

import model.Certificate;

public class CertificateDAO {

	public void insert(Certificate cert) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(cert);
        session.getTransaction().commit();
        session.close();
    }
	
	public void delete(Certificate cert) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		cert.setArch(1);
        session.beginTransaction();
        session.update(cert);
        session.getTransaction().commit();
        session.close();
        
	}
	
	public void deleteById(Integer id) {
		
		delete(getById(id));
		
	}
	
	public void update(Certificate a) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();
	}
	
	
	public Certificate getById(Integer id) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Certificate cert = (Certificate) session.get(Certificate.class, id);
        session.getTransaction().commit();
        session.close();

        return cert;
    }
	
	@SuppressWarnings("unchecked")
	public List<Certificate> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Certificate> certlijst = (List<Certificate>) session.createQuery("from Certificate").list();
		session.getTransaction().commit();
		session.close();
		
		return certlijst;
	}
	
	
	
	
	
}
