package job.portal.bean;

/**
 * Setter & getter variables of user's experience.
 * @author Riyah
 *
 */

public class ExpBean extends EntityBean{
	private String compName, compAddr, countryComp, yearsExp, jobRole;
	private int expId;
	
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompAddr() {
		return compAddr;
	}
	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}
	public String getCountryComp() {
		return countryComp;
	}
	public void setCountryComp(String countryComp) {
		this.countryComp = countryComp;
	}
	public String getYearsExp() {
		return yearsExp;
	}
	public void setYearsExp(String yearsExp) {
		this.yearsExp = yearsExp;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public int getExpId() {
		return expId;
	}
	public void setExpId(int expId) {
		this.expId = expId;
	}
}
