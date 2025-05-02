package restassured.request.createissue.pojos;

public class Fields {

	Project project;
	String summary;
	IssueType issuetype;
	
	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the issuetype
	 */
	public IssueType getIssuetype() {
		return issuetype;
	}
	/**
	 * @param issuetype the issuetype to set
	 */
	public void setIssuetype(IssueType issuetype) {
		this.issuetype = issuetype;
	}
}
