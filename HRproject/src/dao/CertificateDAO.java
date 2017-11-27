package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Address;
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
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Certificate> getByEmpId(String foo){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Certificate.class);
		cr.add(Restrictions.eq("empId", foo));
		
		List<Certificate> certlist = cr.list();
		session.close();
		
		return certlist;
		
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Address getByStreetAndNumber(String street, String number) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Address.class);
		cr.add(Restrictions.eq("street", street));
		cr.add(Restrictions.eq("number", number));
				
		List<Address> adreslist = cr.list();
		
		session.close();
		
		if (adreslist.size() == 1) {
			return adreslist.get(0);
		} else {
			return null;
		}
		
	}
	
	
	
	
	
}
