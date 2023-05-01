package work.studentreg;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentregDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public void createStudentreg(Map<String, String> studentregParam){
		sqlSession.insert("studentreg.createStudentreg", studentregParam);
	}

	public List<Map<String, String>> retrieveStudentregList(Map<String, String> studentregParam){
		return sqlSession.selectList("studentreg.retrieveStudentregList", studentregParam);
	}

	public void deleteStudentreg(Map<String, String> studentregParam){
		sqlSession.delete("studentreg.deleteStudentreg", studentregParam);
	}

	public void deleteStudentregAll(Map<String, String> studentregParam){
		sqlSession.delete("studentreg.deleteStudentregAll", studentregParam);
	}

	public void updateScore(Map<String, String> studentregParam){
		sqlSession.update("studentreg.updateScore", studentregParam);
	}

	public List<Map<String, String>> retrieveStudentregInfo(Map<String, String> studentregParam){
		return sqlSession.selectList("studentreg.retrieveStudentregInfo", studentregParam);
	}
}
