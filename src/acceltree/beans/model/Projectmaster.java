package acceltree.beans.model;

// Generated 26 Feb, 2016 12:22:10 PM by Hibernate Tools 3.4.0.CR1

/**
 * Projectmaster generated by hbm2java
 */
public class Projectmaster implements java.io.Serializable {

	private Integer projectId;
	private String projectName;

	public Projectmaster() {
	}

	public Projectmaster(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
