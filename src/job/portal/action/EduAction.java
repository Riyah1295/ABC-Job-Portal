package job.portal.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import job.portal.bean.EduBean;
import job.portal.dao.EduDao;

/**
 * To display the user's education list.
 * User can add, update & delete their education.
 * @author Riyah
 *
 */

public class EduAction extends ActionSupport {

	private static final long serialVersionUID = 3066561166448217265L;
	private EduBean eduBean;
	String submitType;
	EduDao eduDao = null;
	ResultSet rs = null;
	int ctr = 0;
	ArrayList<EduBean> eduBeanList = null;
	private String msg;
	private boolean noData = false;
	
	@Override
	public String execute() throws Exception{
		try {
			//if(submitType.equals("editedu")) {
				eduBeanList = new ArrayList<EduBean>();
				eduDao = new EduDao();
				rs = eduDao.fetchEdu(eduBean);
				int i = 0;
				if(rs != null) {
					while(rs.next()) {
						i++;
						eduBean = new EduBean();
						eduBean.setUsername(rs.getString("username"));
						eduBean.setEduId(rs.getInt("eduId"));
						eduBean.setQualification(rs.getString("qualification"));
						eduBean.setInstitute(rs.getString("institute"));
						eduBean.setCountrySch(rs.getString("countrySch"));
						eduBean.setYearGrad(rs.getString("yearGrad"));
						eduBean.setGrade(rs.getString("grade"));
						eduBeanList.add(eduBean);
					}
				}
				if (i == 0) {
					noData = false;
				} else {
					noData = true;
				}
			//}
		}
		catch(Exception e) {
			System.out.println(e);
			//throw e;
			//e.printStackTrace();
		}
		return "FETCHEDU";
	}
	
	public String addEdu() {
		eduDao = new EduDao();
		try {
			// To check if the input fields are empty.
			if(eduBean.getQualification().equals("") || eduBean.getInstitute().equals("") || 
					eduBean.getCountrySch().equals("") || eduBean.getYearGrad().equals("") || eduBean.getGrade().equals("")) {
				msg = "All fields cannot be empty!";
			}
			else {
				 
				//To insert the values into the database.
				//Then list out all the educations of the user  after successfully insert into database.
				ctr = eduDao.insert(eduBean);
				eduBeanList = new ArrayList<EduBean>();
				if(ctr > 0) {	
					rs = eduDao.fetchEdu(eduBean);
					int i = 0;
					if (rs != null) {
						while (rs.next()) {
							i++;
							eduBean = new EduBean();
							eduBean.setUsername(rs.getString("username"));
							eduBean.setEduId(rs.getInt("eduId"));
							eduBean.setQualification(rs.getString("qualification"));
							eduBean.setInstitute(rs.getString("institute"));
							eduBean.setCountrySch(rs.getString("countrySch"));
							eduBean.setYearGrad(rs.getString("yearGrad"));
							eduBean.setGrade(rs.getString("grade"));
							eduBeanList.add(eduBean);
						}
					}
					if(i==0) {
						noData = false;
					}
					else {
						noData = true;
					}
					//eduBean.setQualification("");
					//eduBean.setInstitute("");
					msg = "Education added successfully!";
				}
				else {
					msg = "Failed to add!";
				}
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
			//throw e;
			//e.printStackTrace();
		}
		return "ADDEDU";
	}
	
	public String deleteEdu() {
		try {
			eduDao = new EduDao();
			int isDeleted = eduDao.delete(eduBean);
			if (isDeleted > 0) {
				eduBeanList = new ArrayList<EduBean>();
				rs = eduDao.fetchEdu(eduBean);
				int i = 0;
				if (rs != null) {
					while (rs.next()) {
						i++;
						eduBean = new EduBean();
						eduBean.setUsername(rs.getString("username"));
						eduBean.setEduId(rs.getInt("eduId"));
						eduBean.setQualification(rs.getString("qualification"));
						eduBean.setInstitute(rs.getString("institute"));
						eduBean.setCountrySch(rs.getString("countrySch"));
						eduBean.setYearGrad(rs.getString("yearGrad"));
						eduBean.setGrade(rs.getString("grade"));
						eduBeanList.add(eduBean);
					}
				}
				if(i==0) {
					noData = false;
				}
				else {
					noData = true;
				}
				msg = "Education record deleted successfully!";
			}
			else {
				msg = "Education record unable to delete!";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "DELETEEDU";
	}
	
	public String updateEdu(){
		eduDao = new EduDao();
		try {
			if(submitType.equals("editedu")) {
				rs = eduDao.fetchEduEdit(eduBean);
				if(rs != null) {
					while(rs.next()) {
						eduBean.setUsername(rs.getString("username"));
						eduBean.setEduId(rs.getInt("eduId"));
						eduBean.setQualification(rs.getString("qualification"));
						eduBean.setInstitute(rs.getString("institute"));
						eduBean.setCountrySch(rs.getString("countrySch"));
						eduBean.setYearGrad(rs.getString("yearGrad"));
						eduBean.setGrade(rs.getString("grade"));
					}
				}
			}
			
			else {
				if(eduBean.getQualification().equals("") || eduBean.getInstitute().equals("")|| 
						eduBean.getCountrySch().equals("") || eduBean.getYearGrad().equals("") || eduBean.getGrade().equals("")) {
					msg = "All fields are mandatory!";	
				}
				else if(!eduBean.getQualification().matches("^[a-zA-Z]+$")) {
					msg = "Qualification cannot consist of special characters!";
				}
				else {
					ctr = eduDao.update(eduBean);
					if (ctr > 0) {
						eduBeanList = new ArrayList<EduBean>();
						rs = eduDao.fetchEdu(eduBean);
						int i = 0;
						if (rs != null) {
							while (rs.next()) {
								i++;
								eduBean = new EduBean();
								eduBean.setUsername(rs.getString("username"));
								eduBean.setEduId(rs.getInt("eduId"));
								eduBean.setQualification(rs.getString("qualification"));
								eduBean.setInstitute(rs.getString("institute"));
								eduBean.setCountrySch(rs.getString("countrySch"));
								eduBean.setYearGrad(rs.getString("yearGrad"));
								eduBean.setGrade(rs.getString("grade"));
								eduBeanList.add(eduBean);
							}
						}
						if(i==0) {
							noData = false;
						}				
						else {
							noData = true;
						}
						msg = "Education updated successfully!";
						return "UPDATEEDU";
					}
					else {
						msg = "Failed to update!";
					}
				}
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "ERROREDU";
	}

	public EduBean getEduBean() {
		return eduBean;
	}

	public void setEduBean(EduBean eduBean) {
		this.eduBean = eduBean;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public EduDao getEduDao() {
		return eduDao;
	}

	public void setEduDao(EduDao eduDao) {
		this.eduDao = eduDao;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

	public ArrayList<EduBean> getEduBeanList() {
		return eduBeanList;
	}

	public void setEduBeanList(ArrayList<EduBean> eduBeanList) {
		this.eduBeanList = eduBeanList;
	}

		
}