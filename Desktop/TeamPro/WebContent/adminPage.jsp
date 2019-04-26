<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

<!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/custom/index.css" rel="stylesheet" type="text/css">
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/clean-blog.min.css" rel="stylesheet">

<title>Admin Page</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="home.jsp">Quizlet</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="home.jsp">Home</a>
          </li>
          <li class="nav-item">
			<a class="nav-link a" href="allWord.word">단어검색</a>
            <!-- <a class="nav-link a" href="search.jsp">단어검색</a> -->
          </li>
          <li class="nav-item">
	        <a class="nav-link" href="home.jsp" data-toggle="modal" data-target="#myModal">My Page</a>
	      </li>
	      <li class="nav-item">
          	<a class="nav-link" href="MyWordBook.jsp">"${login_user.user_id }" + 님의 단어장</a>
       	  </li>
          <li class="nav-item">
			<a class="nav-link" href="study.jsp">학습하기</a>
           </li>
	       <li class="nav-item">
	       	<a class="nav-link" href="logout.member">Logout</a>
	       </li>        
        </ul>
      </div>
    </div>
  </nav>
<!-- 종류별 키워드 검색(각각 삭제 버튼 추가 + 멤버 등급관리) -->
<!-- 총 회원 수 보기 -->
<!-- 게시물 공지 -->
<!-- 문의사항 보기 -->  
</body>
</html>