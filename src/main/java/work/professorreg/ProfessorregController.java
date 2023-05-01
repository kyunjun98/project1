package work.professorreg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import work.code.CodeService;
import work.course.CourseService;
import work.user.UserService;

@Controller
public class ProfessorregController {
	@Resource(name = "courseService")
	private CourseService courseService;

	@Resource(name = "professorregService")
	private ProfessorregService professorregService;

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "codeService")
	private CodeService codeService;

	@RequestMapping(value="/work/professorreg/createProfessorreg.do", method=RequestMethod.GET)
	public ModelAndView createProfessorreg(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String courseCode = request.getParameter("courseCode");

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> professorregParam = new HashMap<String, String>();
		Map<String, String> courseParam = new HashMap<String, String>();
		Map<String, String> seqParam = new HashMap<String, String>();

		professorregParam.put("courseCode", courseCode);
		professorregParam.put("userCode", userCode);

		//학생수강신청정보 테이블에 저장
		professorregService.createProfessorreg(professorregParam);

	    seqParam.put("seqType", "PROFESSOR_REG_SEQ");

		codeService.updateSeq(seqParam);

		courseParam.put("courseCode", courseCode);
		courseParam.put("courseAssignYn", "Y");

		//과목 현재신청원 업데이트
		courseService.updateAssignYn(courseParam);

		mv.setViewName("redirect:/work/professorreg/retrieveProfessorregList.do");

		return mv;
	}

	@RequestMapping(value="/work/professorreg/deleteProfessorreg.do", method=RequestMethod.GET)
	public ModelAndView deleteProfessorreg(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		Map<String, String> professorregParam = new HashMap<String, String>();
		Map<String, String> courseParam = new HashMap<String, String>();

		String professorRegCode = request.getParameter("professorRegCode");
		String courseCode = request.getParameter("courseCode");

		professorregParam.put("professorRegCode", professorRegCode);

		courseParam.put("courseCode", courseCode);
		courseParam.put("courseAssignYn", "N");

		professorregService.deleteProfessorreg(professorregParam);

		courseService.updateAssignYn(courseParam);

		mv.setViewName("redirect:/work/professorreg/retrieveProfessorregList.do");

		return mv;
	}

	@RequestMapping(value="/work/professorreg/retrieveProfessorregList.do", method=RequestMethod.GET)
	public ModelAndView retrieveProfessorregList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> professorregParam = new HashMap<String, String>();
		Map<String, String> courseParam = new HashMap<String, String>();

		professorregParam.put("userCode", userCode);
		courseParam.put("userCode", userCode);

		List<Map<String, String>> dsCourseList = courseService.retrieveCourseList(courseParam);
		List<Map<String, String>> dsProfessorregList = professorregService.retrieveProfessorregList(professorregParam);

		mv.addObject("dsCourseList", dsCourseList);
		mv.addObject("dsProfessorregList", dsProfessorregList);

		mv.setViewName("/course/courseListRForProfessor");

		return mv;
	}

	@RequestMapping(value="/work/professorreg/retrieveProfessorreg.do", method=RequestMethod.GET)
	public ModelAndView retrieveProfessorreg(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> professorregParam = new HashMap<String, String>();

		professorregParam.put("userCode", userCode);

		List<Map<String, String>> dsProfessorregList = professorregService.retrieveProfessorregList(professorregParam);

		mv.addObject("dsProfessorregList", dsProfessorregList);

		mv.setViewName("/course/courseRForProfessor");

		return mv;
	}

	@RequestMapping(value="/work/professorreg/retrieveProfessorregInfo.do", method=RequestMethod.GET)
	@ResponseBody
	public String retrieveProfessorregInfo(HttpServletRequest request){
		String returnStr = "noexist";

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");

		String courseDay = request.getParameter("courseDay");
		String coursePeriod = request.getParameter("coursePeriod");

		Map<String, String> professorregParam = new HashMap<String, String>();

		professorregParam.put("userCode", userCode);
		professorregParam.put("courseDay", courseDay);
		professorregParam.put("coursePeriod", coursePeriod);

		List<Map<String, String>> dsProfessorregInfoList = professorregService.retrieveProfessorregInfo(professorregParam);

		for(int i = 0; i < dsProfessorregInfoList.size(); i++){
			if("Y".equals(dsProfessorregInfoList.get(i).get("ANSWER_YN"))){
				returnStr = "exist";
				break;
			}
		}

		return returnStr;
	}

	@RequestMapping(value="/work/professorreg/retrieveCourseForScore.do", method=RequestMethod.GET)
	public ModelAndView retrieveCourseForScore(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> professorregParam = new HashMap<String, String>();

		professorregParam.put("userCode", userCode);

		if("P".equals(session.getAttribute("grade"))){
			professorregParam.put("grade", "P");
			mv.setViewName("/course/scoreListC");
		}else{
			professorregParam.put("grade", "S");
			mv.setViewName("/course/scoreListRD");
		}

		List<Map<String, String>> dsCourseForScoreList = professorregService.retrieveCourseForScore(professorregParam);

		mv.addObject("dsCourseForScoreList", dsCourseForScoreList);

		return mv;
	}
}
