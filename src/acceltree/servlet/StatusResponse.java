package acceltree.servlet;



import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;




public class StatusResponse  {
	
	private static HashMap<String,String> popUpMsg = new HashMap<String, String>();
	


	
	

	
	
	
	
public static HashMap<String, String> getPopUpMsg() {
		return popUpMsg;
	}










	public static void setPopUpMsg(HashMap<String, String> popUpMsg) {
		StatusResponse.popUpMsg = popUpMsg;
	}










public static  HashMap<String, String> response(String status,String title,String msg,String redirectPage,HttpServletRequest request)
{
	popUpMsg = new HashMap<String, String>();
	popUpMsg.put("status", status);
	popUpMsg.put("title", title);
	popUpMsg.put("msg", msg);
	popUpMsg.put("redirectPage", redirectPage);
	request.setAttribute("popUpMsgData", popUpMsg);
	
	return popUpMsg;
}
	

}
