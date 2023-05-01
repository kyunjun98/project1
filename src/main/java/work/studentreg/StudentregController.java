package work.studentreg;

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
public class StudentregController {
	@Resource(name = "courseService")
	private CourseService courseService;

	@Resource(name = "studentregService")
	private StudentregService studentregService;

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "codeService")
	private CodeService codeService;

	@RequestMapping(value="/work/studentreg/createStudentreg.do", method=RequestMethod.GET)
	public ModelAndView createStudentreg(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String courseCode = request.getParameter("courseCode");

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> studentregParam = new HashMap<String, String>();
		Map<String, String> courseParam = new HashMap<String, String>();
		Map<String, String> seqParam = new HashMap<String, String>();

		studentregParam.put("courseCode", courseCode);
		studentregParam.put("userCode", userCode);

		seqParam.put("seqType", "STUDENT_REG_SEQ");

		//학생수강신청정보 테이블에 저장
		studentregService.createStudentreg(studentregParam);

		codeService.updateSeq(seqParam);

		courseParam.put("courseCode", courseCode);

		//과목 현재신청원 업데이트
		courseService.updateCurNumberPlus(courseParam);

		mv.setViewName("redirect:/work/studentreg/retrieveStudentregList.do");

		return mv;
	}

	@RequestMapping(value="/work/studentreg/deleteStudentreg.do", method=RequestMethod.GET)
	public ModelAndView deleteStudentreg(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		Map<String, String> studentregParam = new HashMap<String, String>();
		Map<String, String> courseParam = new HashMap<String, String>();

		String studentRegCode = request.getParameter("studentRegCode");
		String courseCode = request.getParameter("courseCode");

		studentregParam.put("studentRegCode", studentRegCode);

		courseParam.put("courseCode", courseCode);

		studentregService.deleteStudentreg(studentregParam);

		courseService.updateCurNumberMinus(courseParam);

		mv.setViewName("redirect:/work/studentreg/retrieveStudentregList.do");

		return mv;
	}

	@RequestMapping(value="/work/studentreg/retrieveStudentregList.do", method=RequestMethod.GET)
	public ModelAndView retrieveStudentregList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> studentregParam = new HashMap<String, String>();
		Map<String, String> courseParam = new HashMap<String, String>();

		studentregParam.put("userCode", userCode);
		courseParam.put("userCode", userCode);

		List<Map<String, String>> dsCourseList = courseService.retrieveCourseList(courseParam);
		List<Map<String, String>> dsStudentregList = studentregService.retrieveStudentregList(studentregParam);

		mv.addObject("dsCourseList", dsCourseList);
		mv.addObject("dsStudentregList", dsStudentregList);

		mv.setViewName("/course/courseListRForStudent");

		return mv;
	}

	@RequestMapping(value="/work/studentreg/retrieveStudentreg.do", method=RequestMethod.GET)
	public ModelAndView retrieveStudentreg(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> studentregParam = new HashMap<String, String>();

		studentregParam.put("userCode", userCode);

		List<Map<String, String>> dsStudentregList = studentregService.retrieveStudentregList(studentregParam);

		mv.addObject("dsStudentregList", dsStudentregList);

		mv.setViewName("/course/courseRForStudent");

		return mv;
	}

	@RequestMapping(value="/work/studentreg/retrieveStudentregInfo.do", method=RequestMethod.GET)
	@ResponseBody
	public String retrieveStudentregInfo(HttpServletRequest request){
		String returnStr = "noexist";

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");

		String courseDay = request.getParameter("courseDay");
		String coursePeriod = request.getParameter("coursePeriod");

		Map<String, String> studentregParam = new HashMap<String, String>();

		studentregParam.put("userCode", userCode);
		studentregParam.put("courseDay", courseDay);
		studentregParam.put("coursePeriod", coursePeriod);

		List<Map<String, String>> dsStudentregInfoList = studentregService.retrieveStudentregInfo(studentregParam);

		for(int i = 0; i < dsStudentregInfoList.size(); i++){
			if("Y".equals(dsStudentregInfoList.get(i).get("ANSWER_YN"))){
				returnStr = "exist";
				break;
			}
		}

		return returnStr;
	}

	@RequestMapping(value="/work/studentreg/updateScore.do", method=RequestMethod.GET)
	@ResponseBody
	public String updateScore(HttpServletRequest request){
		String studentRegCode = request.getParameter("studentRegCode");
		String score = request.getParameter("score");

		Map<String, String> studentregParam = new HashMap<String, String>();

		studentregParam.put("studentRegCode", studentRegCode);
		studentregParam.put("score", score);

		studentregService.updateScore(studentregParam);

		return "true";
	}
}
