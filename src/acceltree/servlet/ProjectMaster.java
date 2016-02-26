package acceltree.servlet;

import java.util.ArrayList;
import java.util.List;

import utils.ProjectMasterUtils;
import acceltree.beans.model.Projectmaster;

public class ProjectMaster{
	List<Projectmaster> projectList=new ArrayList<Projectmaster>();
	public List<Projectmaster> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Projectmaster> projectList) {
		this.projectList = projectList;
	}
	public String projectListmethod() {

		try {
			

			projectList = ProjectMasterUtils.selectProjectList();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}
}