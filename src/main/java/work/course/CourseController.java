package work.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import work.code.CodeBean;
import work.code.CodeService;
import work.course.CourseBean;
import work.professorreg.ProfessorregService;
import work.studentreg.StudentregService;

@Controller
public class CourseController {
	@Resource(name = "courseService")
	private CourseService courseService;

	@Resource(name = "professorregService")
	private ProfessorregService professorregService;

	@Resource(name = "studentregService")
	private StudentregService studentregService;

	@Resource(name = "codeService")
	private CodeService codeService;

	@RequestMapping(value="/work/course/createCourse.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView createCourse(@ModelAttribute CourseBean course, HttpServletRequest request){
		List<CodeBean> dsCode1 = null; //과목분류

		ModelAndView mv = new ModelAndView();
		Map<String, String> codeParam = new HashMap<String, String>();
		Map<String, String> courseParam = new HashMap<String, String>();

		codeParam.put("commTyCd", "CODE0101");
		dsCode1 = codeService.retrieveCodeList(codeParam); //과목분류

		mv.addObject("dsCode1", dsCode1);

		String flag = course.getCourseName(); //CourseBean 존재여부

		if(flag == null){
			mv.setViewName("/course/courseRegisterC");
		}else if(flag != null){
			//과목 생성
			Map<String, String> seqParam = new HashMap<String, String>();
			courseService.createCourse(course);

			seqParam.put("seqType", "COURSE_SEQ");

			codeService.updateSeq(seqParam);

			mv.addObject("dsCourseList", courseService.retrieveCourseList(courseParam));
			mv.setViewName("redirect:/work/course/retrieveCourseListForAdmin.do");
		}

		return mv;
	}

	@RequestMapping(value="/work/course/updateCourse.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateCourse(@ModelAttribute CourseBean course, HttpServletRequest request){
		String courseCode = null;
		Map<String, String> dsCourse = null;
		List<CodeBean> dsCode1 = null; //분류

		ModelAndView mv = new ModelAndView();
		Map<String, String> codeParam = new HashMap<String, String>();
		Map<String, String> courseParam = new HashMap<String, String>();

		codeParam.put("commTyCd", "CODE0101");
		dsCode1 = codeService.retrieveCodeList(codeParam); //분류

		mv.addObject("dsCode1", dsCode1);

		String flag = course.getCourseName(); //CourseBean 존재여부

		if(flag == null){
			HttpSession session = request.getSession();
			String userCode = (String)session.getAttribute("userCode");
			courseCode = request.getParameter("courseCode");

			courseParam.put("courseCode", courseCode);
			courseParam.put("userCode", userCode);

			dsCourse = courseService.retrieveCourse(courseParam);

			mv.addObject("dsCourse", dsCourse);

			mv.setViewName("/course/courseRegisterU");
		}else if(flag != null){
			//과목 수정
			courseService.updateCourse(course);

			mv.addObject("dsCourseList", courseService.retrieveCourseList(courseParam));
			mv.setViewName("redirect:/work/course/retrieveCourseListForAdmin.do");
		}

		return mv;
	}

	@RequestMapping(value="/work/course/goMain.do", method=RequestMethod.GET)
	public ModelAndView goMain(HttpServletRequest request){
		HttpSession session = request.getSession();
		String grade = (String)session.getAttribute("grade");

		ModelAndView mv = new ModelAndView();

		if("S".equals(grade)){
			mv.setViewName("redirect:/work/studentreg/retrieveStudentregList.do");
		}else if("P".equals(grade)){
			mv.setViewName("redirect:/work/professorreg/retrieveProfessorregList.do");
		}else if("A".equals(grade)){
			mv.setViewName("redirect:/work/course/retrieveCourseListForAdmin.do");
		}
		return mv;
	}

	@RequestMapping(value="/work/course/retrieveCourseListForAdmin.do", method=RequestMethod.GET)
	public ModelAndView retrieveCourseListForAdmin(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		Map<String, String> courseParam = new HashMap<String, String>();

		List<Map<String, String>> dsCourseListForAdmin = courseService.retrieveCourseList(courseParam);

		mv.addObject("dsCourseListForAdmin", dsCourseListForAdmin);
		mv.setViewName("/course/courseListRForAdmin");
		return mv;
	}

	@RequestMapping(value="/work/course/retrieveCourseList.do", method=RequestMethod.GET)
	public ModelAndView retrieveCourseList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		Map<String, String> courseParam = new HashMap<String, String>();

		List<Map<String, String>> dsCourseList = courseService.retrieveCourseList(courseParam);

		mv.addObject("dsCourseList", dsCourseList);
		mv.setViewName("/course/courseListRForStudent");
		return mv;
	}

	@RequestMapping(value="/work/course/deleteCourse.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteCourse(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		Map<String, String> courseParam = new HashMap<String, String>();

		String courseCode = request.getParameter("courseCode");

		courseParam.put("courseCode", courseCode);

		//과목삭제시 이미 신청한 수강생들 정보 먼저 삭제
		professorregService.deleteProfessorregAll(courseParam);
		studentregService.deleteStudentregAll(courseParam);
		courseService.deleteCourse(courseParam);

		mv.setViewName("redirect:/work/course/retrieveCourseListForAdmin.do");

		return mv;
	}

//	@RequestMapping(value="/work/course/retrieveCourse.do", method=RequestMethod.GET)
//	public ModelAndView retrieveCourse(HttpServletRequest request){
//		ModelAndView mv = new ModelAndView();
//
//		HttpSession session = request.getSession();
//
//		String userCode = (String)session.getAttribute("userCode");
//		String courseCode = request.getParameter("courseCode");
//
//		Map<String, String> courseParam = new HashMap<String, String>();
//		Map<String, String> replyParam = new HashMap<String, String>();
//
//		courseParam.put("courseCode", courseCode);
//		courseParam.put("userCode", userCode);
//
//		replyParam.put("courseCode", courseCode);
//
//		Map<String, String> dsCourse = courseService.retrieveCourse(courseParam);
//
//
//		mv.addObject("dsCourse", dsCourse);
//		mv.addObject("dsReplyList", dsReplyList);
//
//		mv.setViewName("/course/courseR");
//		return mv;
//	}

}
