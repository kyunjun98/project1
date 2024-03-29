package work.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import work.code.CodeBean;
import work.code.CodeService;

@Controller
public class UserController implements HttpSessionListener{
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "codeService")
	private CodeService codeService;

	@RequestMapping(value="/work/user/idCheck.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> idCheck(HttpServletRequest request){
		String id = request.getParameter("id");
		UserBean bean = userService.retrieveUser(id);
		String checkMsg = "<font color='green' size='3px;'><i class='fa fa-check'>&nbsp;사용 가능한 아이디입니다.</i></font>@true";

		if(bean != null){
			checkMsg = "<font color='red' size='3px;'><i class='fa fa-times'>&nbsp;이미 사용중인 아이디입니다.</i></font>@false";
		}

		HttpHeaders resHeader = new HttpHeaders();
		resHeader.add("Content-Type","text/html;charset=UTF-8");
		ResponseEntity resultMsg = new ResponseEntity<String>(checkMsg, resHeader, HttpStatus.OK);
		return resultMsg;
	}

	@RequestMapping(value="/work/user/ajaxLoginCheck.do",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, String> ajaxLogincheck(HttpServletRequest request
											, @RequestParam(value="id", required=false) String id
											, @RequestParam(value="pw", required=false) String pw){
		Map<String, String> loginYnMap = new HashMap<String, String>();

		boolean check = false;
		check = userService.logincheck(id, pw);

		if(check){
			loginYnMap.put("loginYn", "success");
		}else{
			loginYnMap.put("loginYn", "fail");
		}

		return loginYnMap;
	}

	@RequestMapping(value="/work/user/login.do",method=RequestMethod.POST)
	public String login(@ModelAttribute UserBean bean, HttpServletRequest request){
		HttpSession session = request.getSession();

		UserBean userBean = userService.retrieveSessionInfo(bean.getId());

		String userCode = userBean.getUserCode();
		String id = userBean.getId();
		String grade = userBean.getGrade();
  int userCode = user.Bean.getUserCode();
		session.setAttribute("userCode", userCode);
		session.setAttribute("grade", grade);
		session.setAttribute("id", id);
  session.setAttribute(userCode, userCode);

		session.setMaxInactiveInterval(-1); //세션 무한대
		return "redirect:/work/course/goMain.do";
	}

	@RequestMapping(value="/work/user/retrieveUserId.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, String>> retrieveUserId(HttpServletRequest request){
		String checkMsg = "";
		String email = request.getParameter("email");
		String id = userService.retrieveUserId(email);

		Map<String, String> idMap = new HashMap<String, String>();

		if(id == null){
			checkMsg = "<div class='col-md-5 col-md-offset-2'>"
					+ "<p>해당하는 ID가 존재하지 않습니다</p>"
					+ "</div>";
		}else{
			checkMsg = "<div class='col-md-5 col-md-offset-2'>"
					+ "<p>회원님의 ID는 <font color='red'><strong>" + id + "</strong></font>입니다."
					+ " <a href='login.jsp'>로그인 페이지로 이동</a>|<a href='pwFind.jsp'>PW찾기</a></p>"
					+ "</div>";
		}

		idMap.put("checkMsg", checkMsg);

		HttpHeaders resHeader = new HttpHeaders();
		resHeader.add("Content-Type","text/html;charset=UTF-8");
		ResponseEntity resultMsg = new ResponseEntity<Map<String, String>>(idMap, resHeader, HttpStatus.OK);
		return resultMsg;
	}

	@RequestMapping(value="/work/user/retrieveUserPw.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, String>> retrieveUserPw(HttpServletRequest request){
		String checkMsg = "";
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String pw = userService.retrieveUserPw(id, email);
 Strig number = request.getParameter("number");
		Map<String, String> idMap = new HashMap<String, String>();
Id_pw_find: 
if(number == user.userCode) {
 checkMsg = "<div class='col-md-5-col-md-offset-2'>" + "해당 번호가 존재하지 않습니다 ₩n 번호를 추가하시겠습니까?(y/n)"
Scanner sc = new Scanner(System.in);
String yesno = sc.next();
if(yesno.equals("y")) {
resHeader.number = number.userCode;
return number;
checkMsg = "<div class='col-md-5-col-md-offset-2'>" + "번호를 추가하였습니다.";
} else if(yesno.equals("n") {
checkMsg = "<div class='col-md-5-col-md-offset-2'>" + "번호를 추가하지 않으면 서비스 이용이 불가능합니다. 그래도 하시겠습니까?";
String yesno2 = sc.next();
if(yesno2.equals("y") {
break id_pw_find;
} else if(yesno2.equals("n") {
break;} else checkMsg = "<div class='col-md-5-col-md-offset-2'>" + "올바른 입력값이 아님";
}
else checkMsg = "<div class='col-md-5-col-md-offset-2'>" + "올바른 입력값이 아님";
}
		if(pw == null){
			checkMsg = "<div class='col-md-5 col-md-offset-2'>"
					+ "<p>해당하는 ID가 존재하지 않습니다</p>"
					+ "</div>";
		}else{
			checkMsg = "<div class='col-md-4 col-md-offset-2'>"
					+ "<p>회원님의 PW는 <font color='blue'><strong>" + pw + "</strong></font>입니다."
					+ " <a href='login.jsp'>로그인 페이지로 이동</a></p>"
					+ "</div>";
		}

		idMap.put("checkMsg", checkMsg);

		HttpHeaders resHeader = new HttpHeaders();
		resHeader.add("Content-Type","text/html;charset=UTF-8");
		ResponseEntity resultMsg = new ResponseEntity<Map<String, String>>(idMap, resHeader, HttpStatus.OK);
		return resultMsg;
	}

	@RequestMapping(value="/work/user/logout.do")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		session.removeAttribute("userCode");
		session.invalidate();
		return "redirect:/user/login.jsp";

	}

	@RequestMapping(value="/work/user/createUser.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView createUser(@ModelAttribute UserBean bean){
		ModelAndView mv = new ModelAndView();
        String id = bean.getId(); //없으면 GET(create안함), 있으면 POST(create)
		Map<String, String> codeParam = new HashMap<String, String>();

		if(id == null){
			codeParam.put("commTyCd", "CODE0100");
			List<CodeBean> dsCode1 = codeService.retrieveCodeList(codeParam);
			mv.addObject("dsCode1", dsCode1);
			mv.setViewName("/user/userC");
		}else{
			Map<String, String> seqParam = new HashMap<String, String>();

			seqParam.put("seqType", "USER_SEQ");

			codeService.updateSeq(seqParam);

			userService.createUser(bean);
			mv.setViewName("/user/login");
		}
		return mv;
	}

	@RequestMapping(value="/work/user/updateUser.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateUser(HttpServletRequest request, @ModelAttribute UserBean bean){
		HttpSession session = request.getSession();

		ModelAndView mv = new ModelAndView();
        String id = (String) session.getAttribute("id"); //없으면 GET(create안함), 있으면 POST(create)
        String flag = bean.getName();
		Map<String, String> codeParam = new HashMap<String, String>();

		UserBean dsUser = userService.retrieveUser(id);

		if(flag == null){
			codeParam.put("commTyCd", "CODE0100");

			List<CodeBean> dsCode1 = codeService.retrieveCodeList(codeParam);

			mv.addObject("dsUser", dsUser);
			mv.addObject("dsCode1", dsCode1);
			mv.setViewName("/user/userU");
		}else{
			String userCode = dsUser.getUserCode();
			bean.setUserCode(userCode);
			userService.updateUser(bean);
			mv.setViewName("redirect:/work/course/goMain.do");
		}
		return mv;
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		session.removeAttribute("id");
		session.removeAttribute("userCode");
		session.invalidate();
session.removeAttribute("number");

	}

	@RequestMapping(value="/work/applicant/retrievePostByDong.do")
	@ResponseBody
	public ResponseEntity<List<Map<String, String>>> retrievePostByDong(HttpServletRequest request){
		String paramdong = request.getParameter("dong");

		Map<String, String> userParam = new HashMap<String, String>();

		userParam.put("dong", paramdong);

		List<Map<String, String>> dsPost = userService.retrievePostByDong(userParam);

		JSONArray jsonPostArr = new JSONArray();
		JSONObject jsonObj = null;

		for(int i = 0; i < dsPost.size(); i++){
			jsonObj = new JSONObject();
			String zipcode = dsPost.get(i).get("ZIPCODE");
			String sido = dsPost.get(i).get("SIDO");
			String gugun = dsPost.get(i).get("GUGUN");
			String dong = dsPost.get(i).get("DONG");
			String bunji = dsPost.get(i).get("BUNJI");
dsPost.get(i).get("NUMBER");
dsPost.get(i).get("ID:);
			jsonObj.put("zipcode", zipcode);
			jsonObj.put("sido", sido);
			jsonObj.put("gugun", gugun);
			jsonObj.put("dong", dong);
			jsonObj.put("bunji", bunji);
jsonObj.put("numbrr",number);
jsonObj.put("ID",ID);

			jsonPostArr.add(jsonObj);
		}

		HttpHeaders resHeader = new HttpHeaders();
		resHeader.add("Content-Type","text/javascript;charset=UTF-8");

		ResponseEntity resultMsg = new ResponseEntity<List<Map<String, String>>>(jsonPostArr, resHeader, HttpStatus.OK);
		return resultMsg;
	}

//	@RequestMapping(value="/work/user/retrieveRentBookCnt.do", method=RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<Map<String, String>> retrieveRentBookCnt(HttpServletRequest request){
//		String checkMsg = "";
//		HttpSession session = request.getSession();
//
//		String userCode = (String)session.getAttribute("userCode");
//
//		Map<String, String> userParam = new HashMap<String, String>();
//		Map<String, String> resultParam = new HashMap<String, String>();
//
//		userParam.put("userCode", userCode);
//
//		resultParam = userService.retrieveRentBookCnt(userParam);
//
//		int rentBookCnt = Integer.parseInt(String.valueOf(resultParam.get("RENT_BOOK_CNT")));
//		if(rentBookCnt >= 0 && rentBookCnt < LIMITED_RENT_BOOK_CNT){
//			checkMsg = "success";
//		}else{
//			checkMsg = "fail";
//		}
//
//		resultParam.put("checkMsg", checkMsg);
//
//		HttpHeaders resHeader = new HttpHeaders();
//		resHeader.add("Content-Type","text/html;charset=UTF-8");
//		ResponseEntity resultMsg = new ResponseEntity<Map<String, String>>(resultParam, resHeader, HttpStatus.OK);
//		return resultMsg;
//	}


}
