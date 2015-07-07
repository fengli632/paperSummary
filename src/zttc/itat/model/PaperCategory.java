package zttc.itat.model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="t_paperCategory")
public class PaperCategory {
	private int categoryId;
	private String categoryName;
	private String categoryRemark;
	private Set<PaperSummary> paperSummarySets;
	
	@GeneratedValue
	@Id
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@NotEmpty(message="论文类别名称不能为空")
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryRemark() {
		return categoryRemark;
	}
	public void setCategoryRemark(String categoryRemark) {
		this.categoryRemark = categoryRemark;
	}
	
	@OneToMany(mappedBy="paperCategory")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<PaperSummary> getPaperSummarySets() {
		return paperSummarySets;
	}
	public void setPaperSummarySets(Set<PaperSummary> paperSummarySets) {
		this.paperSummarySets = paperSummarySets;
	}
	
	@Override
	public String toString() {
		return ("类别id:"+categoryId+"---类别名称："+categoryName);
	}
}
