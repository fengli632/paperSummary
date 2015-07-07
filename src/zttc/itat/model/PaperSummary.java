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
@Table(name="t_paperSummary")
public class PaperSummary {

	private int id;					//id
	private String name;			//������Ŀ
	private String selectTest;
	private PaperCategory paperCategory;		//���
	private String author;			//����
	private String periodical;		//�ڿ�
	private String publishTime;		//����ʱ��
	private String goal;			//Ŀ��
	private String method;			//�������㷨
	private String result;			//���
	private String shortcomings;	//����֮��
	private String outlook;			//չ��
	private String significance;	//��Ҫ��  ��
	private String thought;			//˼��,�Լ��Ŀ���
	private User paperUser;			//�ϴ���
	
	private String filePath;		//�ϴ����ĵ�·��
	private String fileName;
	

	private String keyWords;		//�ؼ���  
	private String addDate;

	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getSelectTest() {
		return selectTest;
	}
	public void setSelectTest(String selectTest) {
		this.selectTest = selectTest;
	}
	@Lob
	@Column(columnDefinition="TEXT")
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="paperCategoryId")
	public PaperCategory getPaperCategory() {
		return paperCategory;
	}
	public void setPaperCategory(PaperCategory paperCategory) {
		this.paperCategory = paperCategory;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="paperUserId")
	public User getPaperUser() {
		return paperUser;
	}
	public void setPaperUser(User paperUser) {
		this.paperUser = paperUser;
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Lob
	@Column(columnDefinition="TEXT")
	@NotEmpty(message="������Ŀ����Ϊ��")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Lob
	@Column(columnDefinition="TEXT")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Lob
	@Column(columnDefinition="TEXT")
	public String getPeriodical() {
		return periodical;
	}
	public void setPeriodical(String periodical) {
		this.periodical = periodical;
	}
	
	@Lob
	@Column(columnDefinition="TEXT")
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	
	@Lob
	@Column(columnDefinition="TEXT")
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	@Lob
	@Column(columnDefinition="TEXT")
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	@Lob
	@Column(columnDefinition="TEXT")
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Lob
	@Column(columnDefinition="TEXT")
	public String getShortcomings() {
		return shortcomings;
	}
	public void setShortcomings(String shortcomings) {
		this.shortcomings = shortcomings;
	}
	
	@Lob
	@Column(columnDefinition="TEXT")
	public String getOutlook() {
		return outlook;
	}
	public void setOutlook(String outlook) {
		this.outlook = outlook;
	}
	
	@Lob
	@Column(columnDefinition="TEXT")
	public String getSignificance() {
		return significance;
	}
	public void setSignificance(String significance) {
		this.significance = significance;
	}
	
	@Lob
	@Column(columnDefinition="TEXT")
	public String getThought() {
		return thought;
	}
	public void setThought(String thought) {
		this.thought = thought;
	}
	
}
