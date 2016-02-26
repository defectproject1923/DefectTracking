package utils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import acceltree.beans.model.CreateDefect;
import acceltree.beans.model.DefectCategory;
import acceltree.beans.model.IssuedType;
import acceltree.beans.model.Usermaster;
import acceltree.dbconnection.HibernateUtil;

public class CreateDefectUtils{
	public static List<IssuedType> selectIssueList() {
		List<IssuedType> issueList;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		
		issueList = (List<IssuedType>) session.createQuery("from IssuedType").list();
		
		return issueList;

	}
	
	public static List<DefectCategory> selectDefectCategoryList() {
		List<DefectCategory> defectList;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		
		defectList = (List<DefectCategory>) session.createQuery("from DefectCategory").list();
		
		return defectList;

	}
	
	public static String maxDefectNo() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		int defectNo=0;
//		String hql = "select count(*) from Voucher where voucherType='"+voucherType+"'";//total count of voucher row 
//
//		Query query = session.createQuery(hql);
//		int duplicateId = ((Number) query.uniqueResult()).intValue();
//
//		if(duplicateId>0){
		Query  query = session.createQuery("select COALESCE(max(defectNo),0) from CreateDefect"); 
			defectNo =  Integer.valueOf((String) query.uniqueResult());
//		}
		
			defectNo=defectNo+1;
		String defectNoString=String.valueOf(defectNo);
		return defectNoString;
	}
	
	
	public static String countDefectNo() {
		try {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		int defectNo=0;

		Query  query = session.createQuery("select count(defectNo) from CreateDefect"); 
//			defectNo =  Integer.valueOf((String) query.uniqueResult().toString());
			 defectNo = ((Number) query.uniqueResult()).intValue();
		
		
		String defectNoString=String.valueOf(defectNo);
		return defectNoString;
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
	
	public static int addDefectDetails(CreateDefect createdefect)
	{
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();// session maintain
			session.beginTransaction();
			
			Integer eventId = (Integer) session.save(createdefect);// save the event
			session.getTransaction().commit();// transaction commits
			session.close();
			return eventId;
		}catch(Exception e){
			return 0;
		}
	}
}