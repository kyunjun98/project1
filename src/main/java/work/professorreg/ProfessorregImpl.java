package work.professorreg;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("professorregService")
public class ProfessorregImpl implements ProfessorregService{
	@Resource(name = "professorregDAO")
	private ProfessorregDAO professorregDAO;

	public void createProfessorreg(Map<String, String> professorregParam){
		professorregDAO.createProfessorreg(professorregParam);
	}

	public List<Map<String, String>> retrieveProfessorregList(Map<String, String> professorregParam){
		return professorregDAO.retrieveProfessorregList(professorregParam);
	}

	public List<Map<String, String>> retrieveCourseForScore(Map<String, String> professorregParam){
		return professorregDAO.retrieveCourseForScore(professorregParam);
	}

	public void deleteProfessorreg(Map<String, String> professorregParam){
		professorregDAO.deleteProfessorreg(professorregParam);
	}

	public void deleteProfessorregAll(Map<String, String> professorregParam){
		professorregDAO.deleteProfessorregAll(professorregParam);
	}

	public List<Map<String, String>> retrieveProfessorregInfo(Map<String, String> professorregParam){
		return professorregDAO.retrieveProfessorregInfo(professorregParam);
	}
}
