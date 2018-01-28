package com.yucitms.action.netLesson;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.config.Config;
import com.yucitms.orm.netLesson.ExcellentCourse;
import com.yucitms.orm.netLesson.ExcellentTeacher;
import com.yucitms.orm.netLesson.LessionBook;
import com.yucitms.util.FtpUtil;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
import com.yucitms.util.UpLoadUtil;

/**
 * 精品课程action
 * @author qiangzi
 *
 */
public class ExcellentCourseAction extends BaseAction<ExcellentCourse>{
	public String index(){
		if(model.getId()!=null){
			ExcellentCourse excellentCourse=excellentCourseService.getById(model.getId());
			//通过点击的增加浏览次数
			excellentCourse.setClickNum(excellentCourse.getClickNum()+1);
			excellentCourseService.updateCourse(excellentCourse);
			ActionContext.getContext().getValueStack().push(excellentCourse);
		}else{
			//随机的不增加浏览次数
			ExcellentCourse course= excellentCourseService.findZhuXian();
			List<ExcellentCourse> courses= excellentCourseService.findFinish();
			ActionContext.getContext().getSession().put("courses", courses);
			if(course==null){
				if(courses.size()>0){
					//随机获取
					Random rand = new Random();
					int i = rand.nextInt(); //int范围类的随机数
					i = rand.nextInt(courses.size()); //生成随机数
					System.out.println("随机数"+i);
					ActionContext.getContext().getValueStack().push(courses.get(i));
				}	
			}else{
				ActionContext.getContext().getValueStack().push(course);
			}
			
			
			
		}
		return "index";
	}
	/**
	 * 课程介绍
	 */
	public String courseIntroduce(){
		ExcellentCourse excellentCourse=excellentCourseService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(excellentCourse);
		return "courseIntroduce";
	}
	/**
	 * 教学过程
	 */
	public String teachingProcess(){
		ExcellentCourse excellentCourse=excellentCourseService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(excellentCourse);
		return "teachingProcess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//////////////////////////////后台/////////////////////
	private String name;
	private String uploadFileName;
	private File upload;
	private String uploadContentType;
	private ExcellentTeacher teacher;
	private String content;
	private LessionBook book;
	/**
	 * 标识1代表添加或者继续添加   用于判断点击的入口是添加还是修改或者继续添加
	 * 标识0代表修改   
	 */
	private int flag;//
	/**
	 *课程列表 
	 */
	public String getCourseList(){
		HqlHelper hqlHelper = new HqlHelper(ExcellentCourse.class, "ec");
		hqlHelper.addOrderByProperty("ec.createDate", false).
		addWhereCondition(name!=null&&!name.equals(""), "ec.name like ?","%"+name+"%").addWhereCondition("ec.state=?", true);
		PageBean pageBean=excellentCourseService.getCourseList(pageNum,10,hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getCourseList";
	}
	/**
	 * 回收站
	 */
	public String getCourseDeleteList(){
		HqlHelper hqlHelper = new HqlHelper(ExcellentCourse.class, "ec");
		hqlHelper.addOrderByProperty("ec.createDate", false).
		addWhereCondition(name!=null&&!name.equals(""), "ec.name like ?","%"+name+"%").addWhereCondition("ec.state=?", false);
		PageBean pageBean=excellentCourseService.getCourseList(pageNum,10,hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getCourseDeleteList";
	}
	public String recoverCourse(){
		ExcellentCourse course=excellentCourseService.getById(model.getId());
		course.setState(true);
		excellentCourseService.updateCourse(course);
		return "recoverCourse";
	}
	/**
	 * 获取一个课程里的所有东西
	 * @return
	 */
	public String getCourse(){
		ExcellentCourse excellentCourse=excellentCourseService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(excellentCourse);
		return "getCourse";
		
	}
	/**
	 * 添加表单第一步
	 */
	public String addCoursePage1(){
		if(model.getId()!=null){
			ExcellentCourse excellentCourse=excellentCourseService.getById(model.getId());
			ActionContext.getContext().getValueStack().push(excellentCourse);
		}
		return "addCoursePage1";
	}
	public String addCourse1(){
		//更新
		if(model.getId()!=null){
			ExcellentCourse excellentCourse=excellentCourseService.getById(model.getId());
			if(upload!=null){
				//删除 旧文件
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveImgPath+excellentCourse.getThumbnailPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.EXCELLENTCOURSE_SaveImgPath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				excellentCourse.setThumbnailPath(uploadFileName);
			}
			excellentCourse.setName(model.getName());
			excellentCourse.setTeachingThought(model.getTeachingThought());
			excellentCourse.setCourseCode(model.getCourseCode());
			excellentCourseService.updateCourse(excellentCourse);
			
			ActionContext.getContext().getValueStack().push(excellentCourse);
		}else{//添加
			if(upload!=null){
				uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.EXCELLENTCOURSE_SaveImgPath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				model.setThumbnailPath(uploadFileName);
			}
			model.setCreateDate(new Date());
			//model.setAddFinish(false);
			model.setAudit(false);
			model.setState(true);
			model.setZhuxian(false);
			excellentCourseService.addCourse(model);	
			ExcellentCourse excellentCourse=excellentCourseService.getById(model.getId());
			ActionContext.getContext().getValueStack().push(excellentCourse);
		}
		return "addCoursePage2";
	}
	
	/**
	 * 添加表单第二步 添加 教学内容 课程解析
	 */
	public String addCourse2(){
		//更新
		if(model.getId()!=null){
			ExcellentCourse excellentCourse=excellentCourseService.getById(model.getId());
				excellentCourse.setTeachingContent(model.getTeachingContent());
				excellentCourse.setCourseParsing(model.getCourseParsing());
				excellentCourseService.updateCourse(excellentCourse);
				ActionContext.getContext().getValueStack().push(excellentCourse);
				return "addCoursePage3";
		}else{//添加
			return "addCoursePage1";		
		}
	}
	/**
	 * 添加表单第三步 添加 教师团队 修改时 不能在添加页面修改教师
	 */
	public String addCourse3(){
		if(model.getId()!=null){
			if(upload!=null){
				//删除 旧文件
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveImgPath+teacher.getImgPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.EXCELLENTCOURSE_SaveImgPath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				teacher.setImgPath(uploadFileName);
			}
			ExcellentCourse course= excellentCourseService.getById(model.getId());
			teacher.setCreateDate(new Date());
			teacher.setCourse(course);
			excellentTeacherService.addExcellentTeacher(teacher);
			ActionContext.getContext().getValueStack().push(course);
				return "addCoursePage3";
		}else{//添加
			return "addCoursePage1";		
		}
	}
	/**
	 * 添加表单第四步 添加 教师团队 修改时 不能在添加页面修改教师
	 */
	public String addCourse4(){
		//更新
		if(model.getId()!=null){
			if(upload!=null){
				//删除 旧文件
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveImgPath+teacher.getImgPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.EXCELLENTCOURSE_SaveImgPath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				teacher.setImgPath(uploadFileName);
			}
			ExcellentCourse course= excellentCourseService.getById(model.getId());
			teacher.setCreateDate(new Date());
			teacher.setCourse(course);
			excellentTeacherService.addExcellentTeacher(teacher);
			ActionContext.getContext().getValueStack().push(course);
				return "addCoursePage4";
		}else{//添加
			return "addCoursePage1";		
		}
	}
	
	/**
	 * 添加表单第5步
	 */
	public String addCourse5(){
		//更新
		if(model.getId()!=null){
			ExcellentCourse excellentCourse= excellentCourseService.getById(model.getId());
			excellentCourse.setTeachingAim(model.getTeachingAim());
			excellentCourse.setTeachingRequire(model.getTeachingRequire());
			excellentCourse.setScheduling(model.getScheduling());
			excellentCourseService.updateCourse(excellentCourse);
			ActionContext.getContext().getValueStack().push(excellentCourse);
		 return "addCoursePage5";
		}else{//添加
			return "addCoursePage1";		
		}
	}
	
	/**
	 * 添加表单第6步 实训作业
	 */
	public String addCourse6(){
		//更新
		if(model.getId()!=null){
			ExcellentCourse excellentCourse= excellentCourseService.getById(model.getId());
			excellentCourse.setWork(model.getWork());
			excellentCourse.setPractice(model.getPractice());
			excellentCourseService.updateCourse(excellentCourse);
			ActionContext.getContext().getValueStack().push(excellentCourse);
		 return "addCoursePage6";
		}else{//添加
			return "addCoursePage1";		
		}
	}
	/**
	 * 添加表单第7步 保存书籍 完成添加 跳转到具体课程页面
	 */
	public String addCourse7(){
		//更新
		if(model.getId()!=null){
			ExcellentCourse excellentCourse= excellentCourseService.getById(model.getId());
			excellentCourse.setAddFinish(true);
			excellentCourse.setUpdateDate(new Date());
			excellentCourseService.updateCourse(excellentCourse);
			if(upload!=null){
				//删除 旧文件
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveImgPath+book.getImgPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.EXCELLENTCOURSE_SaveImgPath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				book.setImgPath(uploadFileName);
				
			}
			book.setCreateDate(new Date());
			book.setExcellentCourse(excellentCourse);
			lessionBookService.addLessonBook(book);
			ActionContext.getContext().getValueStack().push(excellentCourse);
		 return "addCoursePage6";
		}else{//添加
			return "addCoursePage1";		
		}
	}
	/**
	 * 添加表单第8步 保存书籍 并到具体课程页面
	 */
	public String addCourse8(){
		if(model.getId()!=null){
			ExcellentCourse excellentCourse= excellentCourseService.getById(model.getId());
			excellentCourse.setAddFinish(true);
			excellentCourse.setUpdateDate(new Date());
			excellentCourseService.updateCourse(excellentCourse);
			if(upload!=null){
				//删除 旧文件
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveImgPath+book.getImgPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.EXCELLENTCOURSE_SaveImgPath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				book.setImgPath(uploadFileName);
			}
			book.setCreateDate(new Date());
			book.setExcellentCourse(excellentCourse);
			lessionBookService.addLessonBook(book);
			ActionContext.getContext().getValueStack().push(excellentCourse);
		 return "Course";
		}else{//添加
			return "addCoursePage1";		
		}
	}
	/**
	 * 删除
	 */
	public String deleteCourse(){
		ExcellentCourse course=excellentCourseService.getById(model.getId());
		course.setState(false);
		excellentCourseService.updateCourse(course);
		return "courseList";
	}
	/**
	 * 修改课程
	 */
	public String updateCourse1(){
		ExcellentCourse excellentCourse=excellentCourseService.getById(model.getId());
		excellentCourse.setTeachingContent(model.getTeachingContent());
		excellentCourse.setCourseParsing(model.getCourseParsing());
		excellentCourseService.updateCourse(excellentCourse);
		ActionContext.getContext().getValueStack().push(excellentCourse);
		return "addCoursePage4";
	}
	public String updateCourse2(){
			ExcellentCourse excellentCourse= excellentCourseService.getById(model.getId());
			excellentCourse.setWork(model.getWork());
			excellentCourse.setPractice(model.getPractice());
			excellentCourseService.updateCourse(excellentCourse);
			excellentCourse=excellentCourseService.getById(model.getId());
		    ActionContext.getContext().getValueStack().push(excellentCourse);
		return "getCourse";
	}
	/**
	 * 设置主显
	 * @return
	 */
	public String setZhuXian(){
		excellentCourseService.setZhuxian(model.getId());
		return "courseList";
	}
	/**
	 * 取消主显
	 * @return
	 */
	public String cancelZhuXian(){
		ExcellentCourse excellentCourse=excellentCourseService.getById(model.getId());
		excellentCourseService.updateCourse(excellentCourse);
		return "courseList";
	}
	/*public String updateCourse(){
		ExcellentCourse course= excellentCourseService.getById(model.getId());
		course.setName(model.getName());
		course.setTeachingThought(model.getTeachingThought());
		course.setTeachingContent(model.getTeachingContent());
		course.setCourseParsing(model.getCourseParsing());
		course.setTeachingTeam(model.getTeachingTeam());
		course.setTeachingAim(model.getTeachingAim());
		course.setTeachingRequire(model.getTeachingRequire());
		course.setPractice(model.getPractice());
		course.setWork(model.getWork());
		course.setScheduling(model.getScheduling());
		excellentCourseService.updateCourse(course);
		return "courseList";
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public ExcellentTeacher getTeacher() {
		return teacher;
	}
	public void setTeacher(ExcellentTeacher teacher) {
		this.teacher = teacher;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LessionBook getBook() {
		return book;
	}
	public void setBook(LessionBook book) {
		this.book = book;
	}
	
}
