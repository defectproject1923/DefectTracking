package acceltree.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import utils.CreateDefectUtils;
import acceltree.beans.model.CreateDefect;
import acceltree.beans.model.DefectCategory;
import acceltree.beans.model.IssuedType;


public class CreateDefectServlet implements ServletRequestAware{
	List<IssuedType> issueList=new ArrayList<IssuedType>();
	List<DefectCategory> defectCategoryList=new ArrayList<DefectCategory>();
	CreateDefect createdefect= new CreateDefect();
	public CreateDefect getCreatedefect() {
		return createdefect;
	}

	public void setCreatedefect(CreateDefect createdefect) {
		this.createdefect = createdefect;
	}
	private String defectNo;
	private HttpServletRequest request;
	public String getDefectNo() {
		return defectNo;
	}

	public void setDefectNo(String defectNo) {
		this.defectNo = defectNo;
	}

	public String issuedListmethod() {

		try {
			

			issueList = CreateDefectUtils.selectIssueList();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}
	
	public String defectCategoryListmethod() {

		try {
			

			defectCategoryList = CreateDefectUtils.selectDefectCategoryList();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}
	
	public String maxDefectNoMethod()
	{
		try
		{
		
			defectNo=CreateDefectUtils.maxDefectNo();
			
		return "success";
		}catch(Exception e){
			return "error";
		}
	}
	
	public String countDefectNoMethod()
	{
		try
		{
		
			defectNo=CreateDefectUtils.countDefectNo();
		
		return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
	
	
	public String addDefectDetailsMethod() {
		String titleMsg = null;
		String oprMsg = null;
		try {
			int isInserted=0;

				
				createdefect.setDefectNo(createdefect.getDefectNo().substring(4));
					isInserted = CreateDefectUtils.addDefectDetails(createdefect);
					titleMsg = "Add Defect";
					oprMsg = "Add";
			

				StatusResponse.response("success", titleMsg, "Defect " + oprMsg
						+ " successfully", "createDefect", request);
				return "success";
			
		} catch (Exception e) {
			e.printStackTrace();
			StatusResponse.response("error", titleMsg, e.getMessage(),
					"createDefect", request);
			return "error";
		}

	}

	public List<DefectCategory> getDefectCategoryList() {
		return defectCategoryList;
	}

	public void setDefectCategoryList(List<DefectCategory> defectCategoryList) {
		this.defectCategoryList = defectCategoryList;
	}

	public List<IssuedType> getIssueList() {
		return issueList;
	}

	public void setIssueList(List<IssuedType> issueList) {
		this.issueList = issueList;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	

	
}