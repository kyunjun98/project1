package work.professorreg;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfessorregDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public void createProfessorreg(Map<String, String> professorregParam){
		sqlSession.insert("professorreg.createProfessorreg", professorregParam);
	}

	public List<Map<String, String>> retrieveProfessorregList(Map<String, String> professorregParam){
		return sqlSession.selectList("professorreg.retrieveProfessorregList", professorregParam);
	}

	public List<Map<String, String>> retrieveCourseForScore(Map<String, String> professorregParam){
		return sqlSession.selectList("professorreg.retrieveCourseForScore", professorregParam);
	}

	public void deleteProfessorreg(Map<String, String> professorregParam){
		sqlSession.delete("professorreg.deleteProfessorreg", professorregParam);
	}

	public void deleteProfessorregAll(Map<String, String> professorregParam){
		sqlSession.delete("professorreg.deleteProfessorregAll", professorregParam);
	}

	public List<Map<String, String>> retrieveProfessorregInfo(Map<String, String> professorregParam){
		return sqlSession.selectList("professorreg.retrieveProfessorregInfo", professorregParam);
	}
}
