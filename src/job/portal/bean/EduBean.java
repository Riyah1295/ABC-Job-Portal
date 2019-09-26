package job.portal.bean;

/**
 * Setter & getter variables of user's education.
 * @author Riyah
 *
 */

public class EduBean extends EntityBean {
	private String qualification, institute, countrySch, yearGrad, grade;
	private int eduId;

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public int getEduId() {
		return eduId;
	}

	public void setEduId(int eduId) {
		this.eduId = eduId;
	}

	public String getCountrySch() {
		return countrySch;
	}

	public void setCountrySch(String countrySch) {
		this.countrySch = countrySch;
	}

	public String getYearGrad() {
		return yearGrad;
	}

	public void setYearGrad(String yearGrad) {
		this.yearGrad = yearGrad;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
