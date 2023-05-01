package work.professorreg;

import java.util.List;
import java.util.Map;

public interface ProfessorregService {
	public void createProfessorreg(Map<String, String> professorregParam);
	public List<Map<String, String>> retrieveProfessorregList(Map<String, String> professorregParam);
	public List<Map<String, String>> retrieveCourseForScore(Map<String, String> professorregParam);
	public void deleteProfessorreg(Map<String, String> professorregParam);
	public void deleteProfessorregAll(Map<String, String> professorregParam);

	public List<Map<String, String>> retrieveProfessorregInfo(Map<String, String> professorregParam);

}
