package work.studentreg;

import java.io.Serializable;

public class StudentregBean implements Serializable{
	private String studentregCode;    //학생수강신청코드
	private String courseCode; 			//과목코드
	private String userCode;    		//유저코드
	private String score;    		//유저코드

	public StudentregBean() {
		super();
	}

	public StudentregBean(String studentregCode, String courseCode,
			String userCode, String score) {
		super();
		this.studentregCode = studentregCode;
		this.courseCode = courseCode;
		this.userCode = userCode;
		this.score = score;
	}

	public String getStudentregCode() {
		return studentregCode;
	}

	public void setStudentregCode(String studentregCode) {
		this.studentregCode = studentregCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentregBean [studentregCode=");
		builder.append(studentregCode);
		builder.append(", courseCode=");
		builder.append(courseCode);
		builder.append(", userCode=");
		builder.append(userCode);
		builder.append(", score=");
		builder.append(score);
		builder.append("]");
		return builder.toString();
	}

}
