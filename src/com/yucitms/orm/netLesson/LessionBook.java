package com.yucitms.orm.netLesson;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 精品课程所需要的书籍
 * @author qiangzi
 *
 */
public class LessionBook implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String bookName;//书籍名称
	private String bookCode;//书籍编码
	private String publishingHouse;//出版社
	private String author;//作者
	private String imgPath;
	private Date createDate;//创建时间
	private String price;//价格
	private String  introduce;     //介绍
	private ExcellentCourse excellentCourse;//对应的精品课程
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getPublishingHouse() {
		return publishingHouse;
	}
	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public ExcellentCourse getExcellentCourse() {
		return excellentCourse;
	}
	public void setExcellentCourse(ExcellentCourse excellentCourse) {
		this.excellentCourse = excellentCourse;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
}
