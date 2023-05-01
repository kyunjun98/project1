package work.course;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Map<String, String>> retrieveCourseList(Map<String, String> courseParam){
		return sqlSession.selectList("course.retrieveCourseList", courseParam);
	}

	public Map<String, String> retrieveCourse(Map<String, String> courseParam){
		return sqlSession.selectOne("course.retrieveCourse", courseParam);
	}

	public void createCourse(CourseBean course){
		sqlSession.insert("course.createCourse", course);
	}

	public void updateCurNumberPlus(Map<String, String> courseParam){
		sqlSession.update("course.updateCurNumberPlus", courseParam);
	}

	public void deleteCourse(Map<String, String> courseParam){
		sqlSession.delete("course.deleteCourse", courseParam);
	}

	public void updateCurNumberMinus(Map<String, String> courseParam){
		sqlSession.update("course.updateCurNumberMinus", courseParam);
	}

	public void updateAssignYn(Map<String, String> courseParam){
		sqlSession.update("course.updateAssignYn", courseParam);
	}

	public void updateCourse(CourseBean course){
		sqlSession.update("course.updateCourse", course);
	}

}
