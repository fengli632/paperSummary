package zttc.itat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="t_weeklyReports")
public class WeeklyReports {

	private int id;
	private String summary;
	private String plan;
	private String time;		//周报时间
	private User reportsUser;

	private String reportsFilePath;  //周报附件路径
	private String fileName;	     //附件名称
	
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getReportsFilePath() {
		return reportsFilePath;
	}
	public void setReportsFilePath(String reportsFilePath) {
		this.reportsFilePath = reportsFilePath;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@NotEmpty(message="周报总结不能为空")
	@Lob
	@Column(columnDefinition="TEXT",length=65535)
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	@Lob
	@Column(columnDefinition="TEXT")
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	
	@Lob
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="reportsUserId")
	public User getReportsUser() {
		return reportsUser;
	}
	public void setReportsUser(User reportsUser) {
		this.reportsUser = reportsUser;
	}
	
	
}
