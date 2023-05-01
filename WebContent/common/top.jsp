<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3+1Management</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link href="${context}/css/common.css" rel="stylesheet">
  <script src="${context}/js/common.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<c:set var="homeUrl">${context}/work/course/goMain.do</c:set>

<body>
	<nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
		<div class="container" style="background-color: black;">
			<ul class="nav navbar-nav">
				<li><a href="${homeUrl}"><font color="white"><strong>한국대 3+1Management</strong></font></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<c:if test="${sessionScope.grade == 'S'}">
						<a href="${context}/work/studentreg/retrieveStudentreg.do"><font color="white"><strong>my시간표</strong></font></a>
					</c:if>
					<c:if test="${sessionScope.grade == 'P'}">
						<a href="${context}/work/professorreg/retrieveProfessorreg.do"><font color="white"><strong>my시간표[교수]</strong></font></a>
					</c:if>
					<c:if test="${sessionScope.grade == 'A'}">
						<a href="${context}/work/course/createCourse.do"><font color="white"><strong>과목개설</strong></font></a>
					</c:if>
				</li>
				<li>
					<a href="${context}/work/user/logout.do"><font color="white"><strong>LOGOUT</strong></font></a>
				</li>
			</ul>
		</div>
	</nav>
<!-- <div class="container"> -->
<!-- <div class="navbar-wrapper"> -->
<!--     <div class="container-fluid"> -->
<!--         <nav class="navbar navbar-fixed-top"> -->
<!--             <div class="container"> -->
<!--                 <div class="navbar-header"> -->
<!--                     <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> -->
<!--                     <span class="sr-only">Toggle navigation</span> -->
<!--                     <span class="icon-bar"></span> -->
<!--                     <span class="icon-bar"></span> -->
<!--                     <span class="icon-bar"></span> -->
<!--                     </button> -->
<!--                     <a class="navbar-brand" href="#">Logo</a> -->
<!--                 </div> -->
<!--                 <div id="navbar" class="navbar-collapse collapse"> -->
<!--                     <ul class="nav navbar-nav"> -->
<!--                         <li class="active"><a href="#" class="">Home</a></li> -->
<!--                         <li class=" dropdown"> -->
<!--                             <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Departments <span class="caret"></span></a> -->
<!--                             <ul class="dropdown-menu"> -->
<!--                                 <li class=" dropdown"> -->
<!--                                     <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">View Departments</a> -->
<!--                                 </li> -->
<!--                                 <li><a href="#">Add New</a></li> -->
<!--                             </ul> -->
<!--                         </li> -->
<!--                         <li><a href="#">Add New</a></li> -->
<!--                         <li class=" dropdown"><a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Managers <span class="caret"></span></a> -->
<!--                             <ul class="dropdown-menu"> -->
<!--                                 <li><a href="#">View Managers</a></li> -->
<!--                                 <li><a href="#">Add New</a></li> -->
<!--                             </ul> -->
<!--                         </li> -->
<!--                         <li class=" dropdown"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Staff <span class="caret"></span></a> -->
<!--                             <ul class="dropdown-menu"> -->
<!--                                 <li><a href="#">View Staff</a></li> -->
<!--                                 <li><a href="#">Add New</a></li> -->
<!--                                 <li><a href="#">Bulk Upload</a></li> -->
<!--                             </ul> -->
<!--                         </li> -->
<!--                         <li class=" down"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">HR <span class="caret"></span></a> -->
<!--                             <ul class="dropdown-menu"> -->
<!--                                 <li><a href="#">Change Time Entry</a></li> -->
<!--                                 <li><a href="#">Report</a></li> -->
<!--                             </ul> -->
<!--                         </li> -->
<!--                     </ul> -->
<!--                     <ul class="nav navbar-nav pull-right"> -->
<!--                         <li class=" dropdown"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Signed in as  <span class="caret"></span></a> -->
<!--                             <ul class="dropdown-menu"> -->
<!--                                 <li><a href="#">Change Password</a></li> -->
<!--                                 <li><a href="#">My Profile</a></li> -->
<!--                             </ul> -->
<!--                         </li> -->
<!--                         <li class=""><a href="#">Logout</a></li> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </nav> -->
<!--     </div> -->
<!-- </div> -->
<!-- </div> -->
</body>
</html>