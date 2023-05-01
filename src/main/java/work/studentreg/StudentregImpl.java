package work.studentreg;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("studentregService")
public class StudentregImpl implements StudentregService{
	@Resource(name = "studentregDAO")
	private StudentregDAO studentregDAO;

	public void createStudentreg(Map<String, String> studentregParam){
		studentregDAO.createStudentreg(studentregParam);
	}

	public List<Map<String, String>> retrieveStudentregList(Map<String, String> studentregParam){
		return studentregDAO.retrieveStudentregList(studentregParam);
	}

	public void deleteStudentreg(Map<String, String> studentregParam){
		studentregDAO.deleteStudentreg(studentregParam);
	}

	public void deleteStudentregAll(Map<String, String> studentregParam){
		studentregDAO.deleteStudentregAll(studentregParam);
	}

	public void updateScore(Map<String, String> studentregParam){
		studentregDAO.updateScore(studentregParam);
	}

	public List<Map<String, String>> retrieveStudentregInfo(Map<String, String> studentregParam){
		return studentregDAO.retrieveStudentregInfo(studentregParam);
	}
}
