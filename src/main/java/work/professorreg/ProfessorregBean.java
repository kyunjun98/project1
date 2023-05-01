package work.professorreg;

import java.io.Serializable;

public class ProfessorregBean implements Serializable{
	private String professorregCode;    //교수담당과목코드
	private String courseCode; 			//과목코드
	private String userCode;    		//유저코드

	public ProfessorregBean() {
		super();
	}

	public ProfessorregBean(String professorregCode, String courseCode,
			String userCode) {
		super();
		this.professorregCode = professorregCode;
		this.courseCode = courseCode;
		this.userCode = userCode;
	}

	public String getProfessorregCode() {
		return professorregCode;
	}

	public void setProfessorregCode(String professorregCode) {
		this.professorregCode = professorregCode;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProfessorregBean [professorregCode=");
		builder.append(professorregCode);
		builder.append(", courseCode=");
		builder.append(courseCode);
		builder.append(", userCode=");
		builder.append(userCode);
		builder.append("]");
		return builder.toString();
	}
}
