package zttc.itat.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="t_user")
public class User { 
	private int id;
	private String username;
	private String password;
	private String email;
	private String nickname;
	private int userType;
	
	private Set<PaperSummary> paperSumarySets;
	private Set<WeeklyReports> weeklyReportsSets;
	private Set<Inform> informSets;
	
	@OneToMany(mappedBy="infoUser")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<Inform> getInformSets() {
		return informSets;
	}
	public void setInformSets(Set<Inform> informSets) {
		this.informSets = informSets;
	}
	
	@OneToMany(mappedBy="reportsUser")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<WeeklyReports> getWeeklyReportsSets() {
		return weeklyReportsSets;
	}
	public void setWeeklyReportsSets(Set<WeeklyReports> weeklyReportsSets) {
		this.weeklyReportsSets = weeklyReportsSets;
	}
	
	@OneToMany(mappedBy="paperUser")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<PaperSummary> getPaperSumarySets() {
		return paperSumarySets;
	}
	public void setPaperSumarySets(Set<PaperSummary> paperSumarySets) {
		this.paperSumarySets = paperSumarySets;
	}
	

	@GeneratedValue
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@NotEmpty(message="用户名不能为空")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@NotEmpty(message="密码不能为空")
	@Size(min=6,message="密码长度应不少于六位")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Email(message="用户邮件格式不正确")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@NotEmpty(message="用户姓名不能为空")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
}
