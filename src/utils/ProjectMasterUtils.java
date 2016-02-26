package utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import acceltree.beans.model.Projectmaster;
import acceltree.dbconnection.HibernateUtil;

public class ProjectMasterUtils{
	public static List<Projectmaster> selectProjectList() {
		List<Projectmaster> projectList;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		
		projectList = (List<Projectmaster>) session.createQuery("from Projectmaster").list();
		
		return projectList;

	}
}
