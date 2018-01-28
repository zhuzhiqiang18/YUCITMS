package com.yucitms.orm.exam;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 试卷分类
 * @author qiangzi
 *
 */
public class PaperClassify implements java.io.Serializable{
	private Integer id;
	private String paperClassify;
	private Date createDate;
	private boolean state;
	private Set<ExamPaper> examPapers = new HashSet<ExamPaper>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaperClassify() {
		return paperClassify;
	}
	public void setPaperClassify(String paperClassify) {
		this.paperClassify = paperClassify;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Set<ExamPaper> getExamPapers() {
		return examPapers;
	}
	public void setExamPapers(Set<ExamPaper> examPapers) {
		this.examPapers = examPapers;
	}
	
}
