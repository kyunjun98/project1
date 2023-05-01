<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="description" content="courseRForStudent.jsp">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>3+1Management</title>

	<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${context}/css/bootstrap-theme.css" rel="stylesheet">
	<link href="${context}/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
	<link href="${context}/css/plugins/dataTables.bootstrap.css" rel="stylesheet">

<%--     <link href="${context}/css/sb-admin-2.css" rel="stylesheet"> --%>

    <!-- Custom Fonts -->
    <link href="${context}/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<script src="${context}/js/jquery-1.9.1.js"></script>
	<script src="${context}/js/bootstrap.min.js"></script>

    <script src="${context}/js/plugins/metisMenu/metisMenu.min.js"></script>

    <script src="${context}/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="${context}/js/plugins/dataTables/dataTables.bootstrap.js"></script>

<%--     <script src="${context}/js/sb-admin-2.js"></script> --%>

    <script>

    $(document).ready(function() {
//         $('#dataTables-example').dataTable();
    });

	function fn_createCourse(paramCourseCode, paramCourseName, paramCourseDay, paramCoursePeriod){
		$.ajax({
   			url:"${context}/work/studentreg/retrieveStudentregInfo.do?courseDay=" + paramCourseDay + "&coursePeriod=" + paramCoursePeriod,
   			success:function(result){
   				if(result == "noexist"){
   					alert(result);
   					if(confirm(paramCourseName + " 과목을 수강과목 하시겠습니까?")){
   						location.href = "${context}/work/studentreg/createStudentreg.do?courseCode=" + paramCourseCode;
   					}
   				}else{
   					alert(paramCourseDay + "요일 " + paramCoursePeriod + "교시에 이미 다른 과목을 신청하셨습니다.");
   				}
   			}
   		});


	}

	function fn_deleteCourse(paramCourseName, paramCourseCode, paramStudentRegCode){
		if(confirm(paramCourseName + " 과목을 취소신청 하시겠습니까?")){
			location.href = "${context}/work/studentreg/deleteStudentreg.do?studentRegCode=" + paramStudentRegCode + "&courseCode=" + paramCourseCode;
		}
	}

    </script>
</head>
<body>
<jsp:include page="../common/top.jsp"></jsp:include>
	<br><br><br>
		<div class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-10">
					<div class="page-header">
						  <h1><span class="glyphicon glyphicon-list-alt" style="vertical-align: middle;"></span>&nbsp;<font color="blue">${sessionScope.id}</font>님의 시간표</h1>
					</div>
				</div>
				<div class="col-md-2">
		            <div class="panel status panel-danger">
		                <div class="panel-heading">
		                    <h1 class="panel-title text-center">
		                    <c:if test="${dsStudentregList[0].COURSE_TOTAL_SCORE != null}">${dsStudentregList[0].COURSE_TOTAL_SCORE}</c:if>
		                    <c:if test="${dsStudentregList[0].COURSE_TOTAL_SCORE == null}">0</c:if>
		                    </h1>
		                </div>
		                <div class="panel-body text-center">
		                    <b>신청학점</b>
		                </div>
		            </div>

		        </div>
			<div class="col-md-12">
			    <div class="panel panel-default">
			        <!-- /.panel-heading -->
			        <div class="panel-body">
			            <div class="table-responsive">
			                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
			                    <thead>
			                        <tr>
			                        	<th style="text-align: center; vertical-align: middle; width: 50px;"></th>
			                            <th style="text-align: center; vertical-align: middle; width: 80px;">월요일</th>
			                            <th style="text-align: center; vertical-align: middle; width: 80px;">화요일</th>
			                            <th style="text-align: center; vertical-align: middle; width: 80px;">수요일</th>
			                            <th style="text-align: center; vertical-align: middle; width: 80px;">목요일</th>
			                            <th style="text-align: center; vertical-align: middle; width: 80px;">금요일</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                    	<c:forEach var="idx" begin="1" end="9">
			                         <tr>
			                         	<td style="text-align: center; vertical-align: middle;">${idx}</td>
	                            		<td style="text-align: center; vertical-align: middle;">
		                            		<c:forEach items="${dsStudentregList}" var="dsStudentregList">
		                            			<c:if test="${dsStudentregList.COURSE_DAY == '월' && dsStudentregList.COURSE_PERIOD == idx}">${dsStudentregList.COURSE_NAME}<br>${dsStudentregList.COURSE_CLASSROOM}</c:if>
		                            		</c:forEach>
	                            		</td>
	                            		<td style="text-align: center; vertical-align: middle;">
	                            			<c:forEach items="${dsStudentregList}" var="dsStudentregList">
		                            			<c:if test="${dsStudentregList.COURSE_DAY == '화' && dsStudentregList.COURSE_PERIOD == idx}">${dsStudentregList.COURSE_NAME}<br>${dsStudentregList.COURSE_CLASSROOM}</c:if>
		                            		</c:forEach>
	                            		</td>
	                            		<td style="text-align: center; vertical-align: middle;">
	                            			<c:forEach items="${dsStudentregList}" var="dsStudentregList">
		                            			<c:if test="${dsStudentregList.COURSE_DAY == '수' && dsStudentregList.COURSE_PERIOD == idx}">${dsStudentregList.COURSE_NAME}<br>${dsStudentregList.COURSE_CLASSROOM}</c:if>
		                            		</c:forEach>
	                            		</td>
	                            		<td style="text-align: center; vertical-align: middle;">
	                            			<c:forEach items="${dsStudentregList}" var="dsStudentregList">
		                            			<c:if test="${dsStudentregList.COURSE_DAY == '목' && dsStudentregList.COURSE_PERIOD == idx}">${dsStudentregList.COURSE_NAME}<br>${dsStudentregList.COURSE_CLASSROOM}</c:if>
		                            		</c:forEach>
	                            		</td>
	                            		<td style="text-align: center; vertical-align: middle;">
	                            			<c:forEach items="${dsStudentregList}" var="dsStudentregList">
		                            			<c:if test="${dsStudentregList.COURSE_DAY == '금' && dsStudentregList.COURSE_PERIOD == idx}">${dsStudentregList.COURSE_NAME}<br>${dsStudentregList.COURSE_CLASSROOM}</c:if>
		                            		</c:forEach>
	                            		</td>
			                         </tr>
			                        </c:forEach>
			                    </tbody>
			                </table>
			            </div>
			            <!-- /.table-responsive -->
			        </div>
			        <!-- /.panel-body -->
			    </div>
			    <!-- /.panel -->
			</div>
				</div>
		</div>
	</div>

<!-- 		<div class="jumbotron"> -->
<!-- 		<div> -->
<!-- 			<div class="row"> -->


<!-- 				</div> -->
<!-- 		</div> -->
<!-- 	</div> -->

</body>
</html>