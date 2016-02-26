package acceltree.user;

import java.util.ArrayList;
import java.util.List;

import acceltree.beans.model.Usermaster;
import utils.UserUtils;


public class User{
	List<Usermaster> userList = new ArrayList<Usermaster>();
	private String  oper;
	private Usermaster usermaster=new Usermaster();
	String usertype;
	private Integer idusermaster;
	private int id;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getIdusermaster() {
		return idusermaster;
	}
	public void setIdusermaster(Integer idusermaster) {
		this.idusermaster = idusermaster;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public Usermaster getUsermaster() {
		return usermaster;
	}
	public void setUsermaster(Usermaster usermaster) {
		this.usermaster = usermaster;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String userTypeListGridMethod() {

		try {
//			System.out.println("List");
			userList = UserUtils.eventGridList();
			
			
			
			return "success";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}
	public String editColor() throws Exception
	{

		if (oper.equalsIgnoreCase("add"))
		{
		usermaster.setUsertype(usertype);
			int addUser=UserUtils.addUserType(usermaster);

			return "success";
		}
		else if (oper.equalsIgnoreCase("edit"))
		{
			usermaster.setIdusermaster(id);
			usermaster.setUsertype(usertype);
//			System.out.println(id+"-------"+usertype);
			UserUtils.updateEvent(usermaster);
			return "success";

		}
		else if (oper.equalsIgnoreCase("del"))
		{
			usermaster.setIdusermaster(id);
			System.out.println(id);
			boolean deleteOper=UserUtils.deleteEvent(usermaster.getIdusermaster());
			
			return "success";
		}
		return "success";
	}

	public List<Usermaster> getUserList() {
		return userList;
	}


	public void setUserList(List<Usermaster> userList) {
		this.userList = userList;
	}
}