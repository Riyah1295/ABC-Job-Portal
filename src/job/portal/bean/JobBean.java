package job.portal.bean;

/**
 * Setter & getter variables of user's job post.
 * @author Riyah
 *
 */

public class JobBean extends EntityBean {
	private String jobTitle, jobDesc, countryJob, closeDate;
	private int jobCode;
	
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public int getJobCode() {
		return jobCode;
	}
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}
	public String getCountryJob() {
		return countryJob;
	}
	public void setCountryJob(String countryJob) {
		this.countryJob = countryJob;
	}
	public String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
}
