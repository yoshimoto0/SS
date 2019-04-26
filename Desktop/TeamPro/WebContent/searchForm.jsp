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

  <title>Quizlet</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/custom/index.css" rel="stylesheet" type="text/css">
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/clean-blog.min.css" rel="stylesheet">
  
</head>

<body>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
		<div class="modal-content card" style="width: 80%; height: 80%;">
			<div class="card-header">
				<h3>Sign In</h3>
			</div>
			<div class="card-body">
				<form action="login.member" method="post">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="user_id" name="user_id">
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="user_pass" name="user_pass">
					</div>
					<div class="row align-items-center remember">
						<input type="checkbox">Remember Me
					</div>
					<div class="form-group">
						<input type="submit" value="Login" class="btn float-right login_btn">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Don't have an account?<a class="nav-link" href="home.jsp" data-toggle="modal" data-target="#myModal2">Sign Up</a>
				</div>
				<div class="d-flex justify-content-center">
					<a href="searchForm.member" class="text-success">Forgot your password?</a>
				</div>
			</div>
		</div>
      
    </div>
  </div>
  
  <!-- Modal sign-up -->
  <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    	
		<div class="modal-content card" style="width: 80%; height: 80%;">
			<div class="card-header">
				<h3>Sign Up</h3>
			</div>
			<div class="card-body">
				<form action="create.member" method="post">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="username" name = "user_id">
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="password" name = "user_pass">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">

							<span class="input-group-text"><i class="fas fa-check"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="password confirm" name = "re_user_pass">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">

							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="user_name" name = "user_name">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">

							<span class="input-group-text"><i class="fas fa-at"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="e-mail" name = "email">						
					</div>
					<c:if test="${kindList != null}">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-at"></i></span>
							</div>
								<c:forEach var="kind" items="${kindList }" varStatus="status">
									<input type="radio" name="favor" value="${kind.kind_id }">${kind.kind_name }<br>
								</c:forEach>
						</div>
					</c:if>
					<div class="form-group">
						<input type="submit" value="Sign Up" class="btn float-right login_btn">
					</div>
				</form>
			</div>
			<div class="card-footer">
			</div>
		</div>
      
    </div>
  </div>
  <!-- Navigation -->
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
          <c:choose>
          	<c:when test="${login_user == null }">
	          <li class="nav-item">
	            <a class="nav-link" href="home.jsp" data-toggle="modal" data-target="#myModal">Login</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="home.jsp" data-toggle="modal" data-target="#myModal2">Sign-up</a>
	          </li>          	
          	</c:when>
          	<c:otherwise>
          		 <c:if test="${login_user.user_id eq 'AAA' }">
          			<li class="nav-item">
	            		<a class="nav-link" href="adminPage.jsp" >admin page</a>
	            	</li>
          		</c:if>
          		<li class="nav-item">
	            	<a class="nav-link" href="#" >My Page</a>
	            </li>
	        <!--<li class="nav-item">
          		  	<a class="nav-link" href="MyWordBook.jsp">${login_user.user_id }  님의 단어장</a>
       		    </li>-->
        	    <li class="nav-item">
					<a class="nav-link" href="study.jsp">학습하기</a>
          	    </li>
	          	<li class="nav-item">
	            	<a class="nav-link" href="logout.member">Logout</a>
	          	</li>
          	</c:otherwise>
          </c:choose>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="site-heading">
      <div class="d-flex justify-content-center h-100">
        <div class="searchbar">
        	<form action="SearchMain.word" class="searchbar">
	          <input class="search_input" type="text" name="" placeholder="Word Search...">
	          <i class="fas fa-search"><input type="submit" class="search_icon"></i>
        	</form>
        </div>
      </div>
          </div>
        </div>
      </div>
    </div>
  </header>
  <c:choose>
  	<c:when test="${dd = 'id'}">
  		<form action="search.member" method="post">
  			<input type="text" class="form-control" placeholder="email" name="email">
  			<input type="password" class="form-control" placeholder="password" name="password">
  		</form>
  	</c:when>
  	<c:otherwise >
  		<form action="search.member" method="post">
			<div class="form-group">
  				<input type="text" class="form-control" placeholder="user_id" name="user_id">
  			</div>
  			<div class="form-group">
  				<input type="text" class="form-control" placeholder="email" name="email">
			</div>
			<div class="form-group">
				<input type="submit" value="Login" class="btn float-right login_btn">
			</div>
  		</form>
  	</c:otherwise>
  </c:choose>
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <p class="copyright text-muted">Copyright &copy; Your Website 2019</p>
        </div>
      </div>
    </div>
  </footer>
</body>
</html>