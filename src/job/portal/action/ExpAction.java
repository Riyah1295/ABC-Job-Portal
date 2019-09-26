package job.portal.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import job.portal.bean.ExpBean;
import job.portal.dao.ExpDao;

/**
 * To display the user's experience list.
 * User can add, update & delete their experience.
 * @author Riyah
 *
 */
public class ExpAction extends ActionSupport {

	private static final long serialVersionUID = -8055707140806929795L;
	private ExpBean expBean;
	private String msg="";
	ResultSet rs = null;
	ExpDao expDao = null;
	String submitType;
	int ctr = 0;
	List<ExpBean> expBeanList = null;
	private boolean noData = false;
	
	@Override
	public String execute() throws Exception{
		try {
			//if(submitType.equals("editexp")) {
				expBeanList = new ArrayList<ExpBean>();
				expDao = new ExpDao();
				rs = expDao.fetchExp(expBean);
				int i = 0;
				if(rs != null) {
					while(rs.next()) {
						i++;
						expBean = new ExpBean();
						expBean.setUsername(rs.getString("username"));
						expBean.setExpId(rs.getInt("expId"));
						expBean.setCompName(rs.getString("compName"));
						expBean.setCompAddr(rs.getString("compAddr"));
						expBean.setCountryComp(rs.getString("countryComp"));
						expBean.setYearsExp(rs.getString("yearsExp"));
						expBean.setJobRole(rs.getString("jobRole"));
						expBeanList.add(expBean);
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
		return "FETCHEXP";	
	}
	
	public String addExp() {
		expDao = new ExpDao();
		try {
			
			if(expBean.getCompName().equals("")||expBean.getCompAddr().equals("")||expBean.getCountryComp().equals("")||
					expBean.getYearsExp().equals("")||expBean.getJobRole().equals("")) {
				msg = "All fields cannot be empty!";
			}
			else if(!expBean.getYearsExp().matches("^[0-9]*$")) {
				msg = "Incorrect format! Numbers only!";
			}
			else {
				
				ctr = expDao.insert(expBean);	
				expBeanList = new ArrayList<ExpBean>();
				
				if(ctr > 0) {
						
					rs = expDao.fetchExp(expBean);
					int i = 0;
					if (rs != null) {
						while (rs.next()) {
							i++;
							expBean = new ExpBean();
							expBean.setUsername(rs.getString("username"));
							expBean.setExpId(rs.getInt("expId"));
							expBean.setCompName(rs.getString("compName"));
							expBean.setCompAddr(rs.getString("compAddr"));
							expBean.setCountryComp(rs.getString("countryComp"));
							expBean.setYearsExp(rs.getString("yearsExp"));
							expBean.setJobRole(rs.getString("jobRole"));
							expBeanList.add(expBean);
						}
					}
					if(i==0) {
						noData = false;
					}
						
					else {
						noData = true;
					}
						//compName="";
						//compAddr="";
						//compLoc="";
						//yearsExp="";
					msg = "Experience added successfully!";
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
		return "ADDEXP";
	}
	
	public String deleteExp() {
		try {
			expDao = new ExpDao();
			int isDeleted = expDao.delete(expBean);
			if (isDeleted > 0) {
				expBeanList = new ArrayList<ExpBean>();
				rs = expDao.fetchExp(expBean);
				int i = 0;
				if (rs != null) {
					while (rs.next()) {
						i++;
						expBean = new ExpBean();
						expBean.setUsername(rs.getString("username"));
						expBean.setExpId(rs.getInt("expId"));
						expBean.setCompName(rs.getString("compName"));
						expBean.setCompAddr(rs.getString("compAddr"));
						expBean.setCountryComp(rs.getString("countryComp"));
						expBean.setYearsExp(rs.getString("yearsExp"));
						expBean.setJobRole(rs.getString("jobRole"));
						expBeanList.add(expBean);
					}
				}
				if(i==0) {
					noData = false;
				}
				else {
					noData = true;
				}
				msg = "Experience record deleted successfully!";
			}
			else {
				msg = "Experience record unable to delete!";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "DELETEEXP";
	}
	
	public String updateExp(){
		expDao = new ExpDao();
		try {
			if(submitType.equals("editexp")) {

				rs = expDao.fetchExpEdit(expBean);
				if(rs != null) {
					while(rs.next()) {
						
						expBean.setUsername(rs.getString("username"));
						expBean.setExpId(rs.getInt("expId"));
						expBean.setCompName(rs.getString("compName"));
						expBean.setCompAddr(rs.getString("compAddr"));
						expBean.setCountryComp(rs.getString("countryComp"));
						expBean.setYearsExp(rs.getString("yearsExp"));
						expBean.setJobRole(rs.getString("jobRole"));
					}
				}
			}
			else {
				if(expBean.getCompName().equals("")||expBean.getCompAddr().equals("")||expBean.getCountryComp().equals("")||
						expBean.getYearsExp().equals("")||expBean.getJobRole().equals("")) {
					msg = "All fields cannot be empty!";
				}
				else if(!expBean.getYearsExp().matches("^[0-9]*$")) {
					msg = "Incorrect format! Numbers only!";
				}
				else {
					ctr = expDao.update(expBean);
					if (ctr > 0) {
						expBeanList = new ArrayList<ExpBean>();
						rs = expDao.fetchExp(expBean);
						int i = 0;
						if (rs != null) {
							while (rs.next()) {
								i++;
								expBean = new ExpBean();
								expBean.setUsername(rs.getString("username"));
								expBean.setExpId(rs.getInt("expId"));
								expBean.setCompName(rs.getString("compName"));
								expBean.setCompAddr(rs.getString("compAddr"));
								expBean.setCountryComp(rs.getString("countryComp"));
								expBean.setYearsExp(rs.getString("yearsExp"));
								expBean.setJobRole(rs.getString("jobRole"));
								expBeanList.add(expBean);
							}
						}
						if(i==0) {
							noData = false;
						}
							
						else {
							noData = true;
						}
						msg = "Experience updated successfully!";
						return "UPDATEEXP";
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
		
		return "ERROREXP";
	}

	public ExpBean getExpBean() {
		return expBean;
	}


	public void setExpBean(ExpBean expBean) {
		this.expBean = expBean;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public ResultSet getRs() {
		return rs;
	}


	public void setRs(ResultSet rs) {
		this.rs = rs;
	}


	public ExpDao getExpDao() {
		return expDao;
	}


	public void setExpDao(ExpDao expDao) {
		this.expDao = expDao;
	}


	public String getSubmitType() {
		return submitType;
	}


	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}


	public int getCtr() {
		return ctr;
	}


	public void setCtr(int ctr) {
		this.ctr = ctr;
	}


	public List<ExpBean> getExpBeanList() {
		return expBeanList;
	}


	public void setExpBeanList(List<ExpBean> expBeanList) {
		this.expBeanList = expBeanList;
	}


	public boolean isNoData() {
		return noData;
	}


	public void setNoData(boolean noData) {
		this.noData = noData;
	}
	
}