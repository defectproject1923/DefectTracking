

function Show_Popup(title,msg,status,name)
{		

	var Fulllocation = document.location.href;
	var urlParts = Fulllocation.split('DefectTrackingTool');
	var redirectPath = urlParts[0]+ 'DefectTrackingTool/' + name +'.jsp';
	var content = null;
	if(status=="success"){
		content = '<p style="color:green">'+msg+'</p>';
	}else if(status=="error"){
		content = '<p style="color:red">'+msg+'</p>';
	}else{
		content = '<p style="color:blue">'+msg+'</p>';
	}
	alert("Success");
//	 $.modal({
//			content: content,
//			title: title,
//			maxWidth: 500,
//			maxHeight:400,
//			buttons: {
//				'Close': function(win) { 
//				 win.closeModal(); 
//				 window.location.href = redirectPath;}
//			}
//		});
	
  
}
