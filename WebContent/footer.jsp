<%@ page contentType="text/html;charset=UTF-8" %>
<footer>
		
		<div class="float-right">
			<a href="#" class="button">Copyright by AccelTree Software pvt.ltd. Pune</a>
			
		</div>
		
		
		
 	
</footer>
	
	
	
	<%@ page import="java.util.*" %>
			<% 
			HashMap<String,String> didSucced = new HashMap<String,String>();
			didSucced=(HashMap<String,String>)request.getAttribute("popUpMsgData");
		  
			if( didSucced != null && !didSucced.isEmpty()  )
			{
				String title=didSucced.get("title");
				String msg = didSucced.get("msg").replace("'", "");
				String status = didSucced.get("status");	
				String redirectPage = didSucced.get("redirectPage"); 
	 		%>
			<script type="text/javascript">	
			
			Show_Popup('<%=title%>','<%=msg%>','<%=status%>','<%=redirectPage%>');
			</script>
			<% 
			request.removeAttribute("popUpMsgData");
			}	
			%>