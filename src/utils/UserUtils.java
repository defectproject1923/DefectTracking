package utils;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import acceltree.beans.model.Usermaster;
import acceltree.dbconnection.HibernateUtil;

public class UserUtils{
	public static List<Usermaster> eventGridList() {
		try {
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Usermaster obj = new Usermaster();
			List<Usermaster> eventList = (List<Usermaster>) session.createQuery("from Usermaster").list();
			for (Iterator<Usermaster> iter = eventList.iterator(); iter.hasNext();) {
				obj = iter.next();
				if (obj != null) {

				}
			}
			return eventList;
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
	}
	
	
	public static int addUserType(Usermaster usermaster)
	{
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();// session maintain
			session.beginTransaction();
			
			Integer eventId = (Integer) session.save(usermaster);// save the event
			session.getTransaction().commit();// transaction commits
			session.close();
			return eventId;
		}catch(Exception e){
			return 0;
		}
	}
	
	public static int updateEvent(Usermaster usermaster) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();// initiaise
																	// the
																	// connection
			Session session = sf.openSession();
			session.beginTransaction();

			Usermaster usermaster1 = (Usermaster) session.merge(usermaster);// merge used to update
														// the details of event
			session.getTransaction().commit();
			session.close();
			return 223;
		} catch (Exception e) {
			e.printStackTrace();
			return 234;
		}
	}
	
	public static boolean deleteEvent(int masterId) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			Usermaster usermaster = new Usermaster();
			usermaster.setIdusermaster(masterId);
			session.delete(usermaster);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			throw new RuntimeException(
					"Unable to Delete! The field is set to a Reference at another place");
			
		}
	}
}