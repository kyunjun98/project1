package work.course;

import java.util.List;
import java.util.Map;

public interface CourseService {
	public List<Map<String, String>> retrieveCourseList(Map<String, String> courseParam);

	public Map<String, String> retrieveCourse(Map<String, String> courseParam);

	public void createCourse(CourseBean course);
	public void updateCourse(CourseBean course);

	public void updateCurNumberPlus(Map<String, String> courseParam);
	public void updateCurNumberMinus(Map<String, String> courseParam);
	public void updateAssignYn(Map<String, String> courseParam);
	public void deleteCourse(Map<String, String> courseParam);


}
