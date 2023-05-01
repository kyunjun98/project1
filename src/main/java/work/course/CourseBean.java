package work.course;

import java.io.Serializable;

public class CourseBean implements Serializable{
	private String courseCode;        //과목코두
	private String courseName;        //과목명
	private String courseScore;       //과목이름
 	private String courseCategoryCd;  //과목단가
	private String courseAssignYn;    //과목수량
	private int courseMaxNumber;  	  //과목분류
	private int courseCurNumber;      //과목등록일
	private String courseClassroom;   //교실
	private String courseDay;    	  //요일
	private String coursePeriod;      //교시
	private String courseRegDate;	  //과목개설일

	public CourseBean() {
		super();
	}

	public CourseBean(String courseCode, String courseName, String courseScore,
			String courseCategoryCd, String courseAssignYn,
			int courseMaxNumber, int courseCurNumber, String courseClassroom,
			String courseDay, String coursePeriod, String courseRegDate) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseScore = courseScore;
		this.courseCategoryCd = courseCategoryCd;
		this.courseAssignYn = courseAssignYn;
		this.courseMaxNumber = courseMaxNumber;
		this.courseCurNumber = courseCurNumber;
		this.courseClassroom = courseClassroom;
		this.courseDay = courseDay;
		this.coursePeriod = coursePeriod;
		this.courseRegDate = courseRegDate;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseScore() {
		return courseScore;
	}

	public void setCourseScore(String courseScore) {
		this.courseScore = courseScore;
	}

	public String getCourseCategoryCd() {
		return courseCategoryCd;
	}

	public void setCourseCategoryCd(String courseCategoryCd) {
		this.courseCategoryCd = courseCategoryCd;
	}

	public String getCourseAssignYn() {
		return courseAssignYn;
	}

	public void setCourseAssignYn(String courseAssignYn) {
		this.courseAssignYn = courseAssignYn;
	}

	public int getCourseMaxNumber() {
		return courseMaxNumber;
	}

	public void setCourseMaxNumber(int courseMaxNumber) {
		this.courseMaxNumber = courseMaxNumber;
	}

	public int getCourseCurNumber() {
		return courseCurNumber;
	}

	public void setCourseCurNumber(int courseCurNumber) {
		this.courseCurNumber = courseCurNumber;
	}

	public String getCourseClassroom() {
		return courseClassroom;
	}

	public void setCourseClassroom(String courseClassroom) {
		this.courseClassroom = courseClassroom;
	}

	public String getCourseDay() {
		return courseDay;
	}

	public void setCourseDay(String courseDay) {
		this.courseDay = courseDay;
	}

	public String getCoursePeriod() {
		return coursePeriod;
	}

	public void setCoursePeriod(String coursePeriod) {
		this.coursePeriod = coursePeriod;
	}

	public String getCourseRegDate() {
		return courseRegDate;
	}

	public void setCourseRegDate(String courseRegDate) {
		this.courseRegDate = courseRegDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CourseBean [courseCode=");
		builder.append(courseCode);
		builder.append(", courseName=");
		builder.append(courseName);
		builder.append(", courseScore=");
		builder.append(courseScore);
		builder.append(", courseCategoryCd=");
		builder.append(courseCategoryCd);
		builder.append(", courseAssignYn=");
		builder.append(courseAssignYn);
		builder.append(", courseMaxNumber=");
		builder.append(courseMaxNumber);
		builder.append(", courseCurNumber=");
		builder.append(courseCurNumber);
		builder.append(", courseClassroom=");
		builder.append(courseClassroom);
		builder.append(", courseDay=");
		builder.append(courseDay);
		builder.append(", coursePeriod=");
		builder.append(coursePeriod);
		builder.append(", courseRegDate=");
		builder.append(courseRegDate);
		builder.append("]");
		return builder.toString();
	}
}
