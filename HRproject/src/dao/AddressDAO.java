package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Address;

public class AddressDAO {

	public void insert(Address adres) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(adres);
        session.getTransaction().commit();
    }
	
	public void delete(Address adres) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		adres.setArch(1);
        session.beginTransaction();
        session.update(adres);
        session.getTransaction().commit();
        
	}
	
	public void deleteById(Integer id) {
		
		delete(getById(id));
		
	}
	
	public void update(Address a) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
	}
	
	
	public Address getById(Integer id) {
		
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Address adres = (Address) session.get(Address.class, id);
        session.getTransaction().commit();

        return adres;
    }
	
	@SuppressWarnings("unchecked")
	public List<Address> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Address> adreslijst = (List<Address>) session.createQuery("from Address").list();
		session.getTransaction().commit();
		
		return adreslijst;
	}
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Address> getByPlace(String searchstring){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Address.class);
		cr.add(Restrictions.eq("place", searchstring));
				
		List<Address> adreslijst = cr.list();
		
		return adreslijst;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Address> getByCountry(String searchstring){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Address.class);
		cr.add(Restrictions.eq("country", searchstring));
				
		List<Address> adreslijst = cr.list();
		
		return adreslijst;
	}
	
	
}
