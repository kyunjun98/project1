<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="description" content="courseListRForAdmin.jsp">
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
        $('#dataTables-example').dataTable();
    });

    function fn_modifyCourse(paramCourseCode){
    	location.href = "${context}/work/course/updateCourse.do?courseCode=" + paramCourseCode;
    }
    </script>
</head>
<body>
<jsp:include page="../common/top.jsp"></jsp:include>
	<br><br><br>
		<div class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header">
						  <h1 align="center"><span class="glyphicon glyphicon-list-alt" style="vertical-align: middle;"></span>&nbsp;수강과목 리스트 현황</h1>
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
				                        	<th style="text-align: center; vertical-align: middle; width: 30px;">과목코드</th>
				                            <th style="text-align: center; vertical-align: middle; width: 80px;">과목명</th>
				                            <th style="text-align: center; vertical-align: middle; width: 30px;">학점</th>
				                            <th style="text-align: center; vertical-align: middle; width: 30px;">신청인원</th>
				                            <th style="text-align: center; vertical-align: middle; width: 30px;">교실</th>
				                            <th style="text-align: center; vertical-align: middle; width: 30px;">요일</th>
				                            <th style="text-align: center; vertical-align: middle; width: 30px;">교시</th>
				                            <th style="text-align: center; vertical-align: middle; width: 30px;">과목분류</th>
				                            <th style="text-align: center; vertical-align: middle; width: 50px;">정보변경</th>
				                        </tr>
				                    </thead>
				                    <tbody>
				                    	<c:forEach items="${dsCourseListForAdmin}" var="dsCourseListForAdmin" varStatus="courseIdx">
				                         <tr>
				                         	<td style="text-align: center; vertical-align: middle;">${dsCourseListForAdmin.COURSE_CODE}</td>
				                            <td style="text-align: center; vertical-align: middle;">${dsCourseListForAdmin.COURSE_NAME}</td>
				                            <td style="text-align: center; vertical-align: middle;">${dsCourseListForAdmin.COURSE_SCORE}학점</td>
				                            <td style="text-align: center; vertical-align: middle;">${dsCourseListForAdmin.COURSE_CUR_NUMBER} / ${dsCourseListForAdmin.COURSE_MAX_NUMBER}</td>
				                            <td style="text-align: center; vertical-align: middle;">${dsCourseListForAdmin.COURSE_CLASSROOM}</td>
				                            <td style="text-align: center; vertical-align: middle;">${dsCourseListForAdmin.COURSE_DAY}요일</td>
				                            <td style="text-align: center; vertical-align: middle;">${dsCourseListForAdmin.COURSE_PERIOD}교시</td>
				                            <td style="text-align: center; vertical-align: middle;">${dsCourseListForAdmin.COURSE_CATEGORY_CD_NM}</td>
				                            <td style="text-align: center; vertical-align: middle;">
												<button type="button" class="btn btn-warning" onclick="fn_modifyCourse('${dsCourseListForAdmin.COURSE_CODE}')">정보변경</button>
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
</body>
</html>