package com.yucitms.orm.netLesson;

import java.util.Date;

/**
 * 精品课程教师
 * @author qiangzi
 *
 */
public class ExcellentTeacher implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5125201562252087848L;
	private Integer id;
	private String teacherName;//
	private String content;//
	private String jobTitle;//职称
	private String remark;//
	private String imgPath;//头像位置
	private Date createDate;
	private ExcellentCourse course;//外键关联
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public ExcellentCourse getCourse() {
		return course;
	}
	public void setCourse(ExcellentCourse course) {
		this.course = course;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
