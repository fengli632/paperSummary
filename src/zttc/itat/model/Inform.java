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
@Table(name="t_inform")
public class Inform {
	private int infoId;			//֪ͨid
	private String infoTitle;	//֪ͨ����
	private String infoContent;	//֪ͨ����
	private String infoTime;	//֪ͨʱ��
	private String infoFilePath;//����·��
	private String infoFileName;//��������
	private User infoUser;		//֪ͨ������
	
	

	public String getInfoFileName() {
		return infoFileName;
	}
	public void setInfoFileName(String infoFileName) {
		this.infoFileName = infoFileName;
	}
	@Id
	@GeneratedValue
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	
	@NotEmpty(message="֪ͨ���ⲻ��Ϊ��")
	@Lob
	@Column(columnDefinition="TEXT")
	public String getInfoTitle() {
		return infoTitle;
	}
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	
	@NotEmpty(message="֪ͨ���ݲ���Ϊ��")
	@Lob
	@Column(columnDefinition="TEXT",length=65535)
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	
	public String getInfoTime() {
		return infoTime;
	}
	public void setInfoTime(String infoTime) {
		this.infoTime = infoTime;
	}
	
	public String getInfoFilePath() {
		return infoFilePath;
	}
	public void setInfoFilePath(String infoFilePath) {
		this.infoFilePath = infoFilePath;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="informUserId")
	public User getInfoUser() {
		return infoUser;
	}
	public void setInfoUser(User infoUser) {
		this.infoUser = infoUser;
	}
	
	
}
