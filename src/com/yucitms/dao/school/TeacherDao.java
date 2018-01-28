package com.yucitms.dao.school;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.school.Teacher;
/**
 * 课程 教师
 * @author woxiaxiangyang
 *
 */
public interface TeacherDao extends BaseDao<Teacher> {

	Teacher login(String loginName, String loginPas);

}
