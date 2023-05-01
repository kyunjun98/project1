package work.course;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("courseService")
public class CourseServiceImpl implements CourseService{
	@Resource(name = "courseDAO")
	private CourseDAO courseDAO;

	public List<Map<String, String>> retrieveCourseList(Map<String, String> courseParam){
		return courseDAO.retrieveCourseList(courseParam);
	}

	public Map<String, String> retrieveCourse(Map<String, String> courseParam){
		return courseDAO.retrieveCourse(courseParam);
	}

	public void createCourse(CourseBean course){
		courseDAO.createCourse(course);
	}

	public void updateCurNumberPlus(Map<String, String> courseParam){
		courseDAO.updateCurNumberPlus(courseParam);
	}

	public void updateCurNumberMinus(Map<String, String> courseParam){
		courseDAO.updateCurNumberMinus(courseParam);
	}

	public void updateAssignYn(Map<String, String> courseParam){
		courseDAO.updateAssignYn(courseParam);
	}

	public void deleteCourse(Map<String, String> courseParam){
		courseDAO.deleteCourse(courseParam);
	}

	public void updateCourse(CourseBean course){
		courseDAO.updateCourse(course);
	}
}
