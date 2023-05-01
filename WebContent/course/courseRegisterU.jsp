<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="description" content="courseRegisterU.jsp">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>3+1Management</title>

	<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${context}/css/bootstrap-theme.css" rel="stylesheet">
	<link href="${context}/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
	<link href="${context}/css/plugins/dataTables.bootstrap.css" rel="stylesheet">
	<link href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css" rel="stylesheet" >
<%--     <link href="${context}/css/sb-admin-2.css" rel="stylesheet"> --%>

    <!-- Custom Fonts -->
    <link href="${context}/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

	<script src="${context}/js/jquery-1.9.1.js"></script>
	<script src="${context}/js/jquery.form.js"></script>
	<script src="${context}/js/bootstrap.min.js"></script>
    <script src="${context}/js/plugins/metisMenu/metisMenu.min.js"></script>

    <script src="${context}/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="${context}/js/plugins/dataTables/dataTables.bootstrap.js"></script>

<%--     <script src="${context}/js/sb-admin-2.js"></script> --%>
    <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>

    <script>

    $(document).ready(function() {
//         $('#dataTables-example').dataTable();

        fn_init();

      //U페이지 해당
		fn_setDetailInfo();
    });

    function fn_setDetailInfo(){
		$("#courseCode").val('${dsCourse.COURSE_CODE}');
		$("#courseName").val('${dsCourse.COURSE_NAME}');
		$("#courseCategoryCd").val('${dsCourse.COURSE_CATEGORY_CD}');
		$("#courseScore").val('${dsCourse.COURSE_SCORE}');
		$("#courseMaxNumber").val('${dsCourse.COURSE_MAX_NUMBER}');
		$("#courseClassroom").val('${dsCourse.COURSE_CLASSROOM}');
		$("#courseDay").val('${dsCourse.COURSE_DAY}');
		$("#coursePeriod").val('${dsCourse.COURSE_PERIOD}');

	}

	function fn_save(){
		if(confirm("변경하시겠습니까?")){
			if(!fn_validation()) return;

			alert("과목정보가 변경되었습니다.");

			$("#updateCourse").submit();
		}
	}

    </script>
</head>
<body>
<jsp:include page="../common/top.jsp"></jsp:include>
	<div class="container">
		<div class="jumbotron jumbotron-info" style="background-color: lightgray;">
			<h1><font color="black"><strong>과목개설 수정</strong>&nbsp;<span class="glyphicon glyphicon-list-alt"></span></font></h1>
			<p>과목개설 수정 페이지입니다.</p>
		</div>
	</div>
	<div class="container">
	<form id="updateCourse" method="post" action="${context}/work/course/updateCourse.do" role="form">
		<div class="form-horizontal">
			<div class="form-group" style="margin-top: 5%;">
				<label for="courseName" class="control-label col-md-2"><b>과목명</b></label>
				<div class="col-md-4">
					<input class="form-control" type="text" name="courseName" id="courseName" required="required" autofocus="autofocus"/>
				</div>
			</div>

			<div class="form-group">
				<label for="courseCategoryCd" class="control-label col-md-2"><b>과목분류</b></label>
				<div class="col-md-2">
		        	<select class="form-control" id="courseCategoryCd" name="courseCategoryCd" required="required" onchange="fn_setCourseCategoryCd()">
						<c:forEach items="${dsCode1}" var="code1">
							<option value="${code1.commCd}">${code1.commCdNm}</option>
						</c:forEach>
		     		</select>
	     		</div>
			</div>

			<div class="form-group">
				<label for="courseScore" class="control-label col-md-2"><b>학점</b></label>
				<div class="col-md-3">
					<input class="form-control" type="text" id="courseScore" name="CourseScore" required="required" maxlength="1" onkeydown="return fn_showKeyCode(event)"/>
				</div>
			</div>

			<div class="form-group">
				<label for="courseMaxNumber" class="control-label col-md-2"><b>과목정원수</b></label>
				<div class="col-md-3">
					<input class="form-control" type="text" id="courseMaxNumber" name="courseMaxNumber" maxlength="2" required="required" onkeydown="return fn_showKeyCode(event)"/>
				</div>
			</div>

			<div class="form-group">
				<label for="courseClassroom" class="control-label col-md-2"><b>교실</b></label>
				<div class="col-md-3">
					<input class="form-control" type="text" id="courseClassroom" name="courseClassroom" required="required"/>
				</div>
			</div>

			<div class="form-group">
				<label for="courseDay" class="control-label col-md-2"><b>요일</b></label>
				<div class="col-md-2">
		        	<select class="form-control" id="courseDay" name="courseDay" required="required">
						<option value="월">월</option>
						<option value="화">화</option>
						<option value="수">수</option>
						<option value="목">목</option>
						<option value="금">금</option>
		     		</select>
	     		</div>
			</div>

			<div class="form-group">
				<label for="coursePeriod" class="control-label col-md-2"><b>교시</b></label>
				<div class="col-md-2">
					<input class="form-control" type="text" id="coursePeriod" name="coursePeriod" required="required" maxlength="1" onkeydown="return fn_showKeyCode(event)"/>
				</div>
			</div>
			<input type="hidden" id="courseCode" name="courseCode">
		</div>
	</form>
	<br><br>
		<div class="form-group">
			<label class="control-label col-md-12"></label>
			<div class="col-md-1 col-md-offset-6">
				<button type="button" class="btn btn-success" onclick="fn_save()">변경하기</button>
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-success" onclick="fn_back()">뒤로가기</button>
			</div>
		</div>
	</div>
</body>
</html>