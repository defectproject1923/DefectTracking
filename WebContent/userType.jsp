
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<head>
 <script src="js/jquery/jquery.min.js"></script>

</head>
<body>

 <jsp:include page="header.jsp"></jsp:include>
 <jsp:include page="menu.jsp"></jsp:include>
 <sj:head jqueryui="true" />
  </nav>
  
        <div id="page-wrapper">
        <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
           <s:form id="userTypeForm" role="form">
             <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">User Details</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
        <s:url var="editurl" action="userTypeEditurl" />    
       <s:url var="userTypeListGridURL" action="userTypeListGridURL" /> 
 							<sjg:grid href="%{userTypeListGridURL}" id="userTypeListGridId" 
 								width="500" height="315" gridModel="userList" 
 								caption="User Type List" dataType="json" 
								rowNum="0" 
								rownumbers="true" pager="true" scroll="true" scrollrows="true" 
								viewrecords="true"
								editurl="%{editurl}"
								navigatorAddOptions="{height:280, width:500, reloadAfterSubmit:true}"
								navigatorEditOptions="{height:150,width:500,closeAfterEdit:true,reloadAfterSubmit:true}"
								navigatorDeleteOptions="{height:140,  reloadAfterSubmit:true}"
								 navigator="true"
								 onSelectRowTopics="rowselect" navigatorDelete="true"
								 formIds="userTypeForm"
								 
								>
								<sjg:gridColumn name="idusermaster" id="idusermaster" index="idusermaster" title="ID" 
 								 key="true" formatter="integer"  sortable="true"/>  
 								<sjg:gridColumn name="usertype" index="usertype" title="User Type" 
 									editable="true"
									edittype="text"
									editrules="{           required: true, 
		             
		               }"/>
		              
								

 							</sjg:grid>
           <s:hidden id="id" name="id" value=""></s:hidden>
           </s:form>
            </div>
           </div>
           </div>
           </div>
            </body>
            <script type="text/javascript">
$
.subscribe(
		'rowselect',
		function(event, data) {

			$("#id").val(( event.originalEvent.id));
			alert(event.originalEvent.id);
		});
</script>
            </html>
							