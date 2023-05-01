package work.studentreg;

import java.util.List;
import java.util.Map;

public interface StudentregService {
	public void createStudentreg(Map<String, String> studentregParam);
	public List<Map<String, String>> retrieveStudentregList(Map<String, String> studentregParam);
	public void deleteStudentreg(Map<String, String> studentregParam);
	public void deleteStudentregAll(Map<String, String> studentregParam);

	public void updateScore(Map<String, String> studentregParam);

	public List<Map<String, String>> retrieveStudentregInfo(Map<String, String> studentregParam);

}
