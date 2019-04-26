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
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/clean-blog.min.css" rel="stylesheet">

</head>

<body>

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
            <a class="nav-link" href="MyWordBook.jsp">나의 단어장</a>
          </li>
          <li class="nav-item">
			<a class="nav-link" href="study.jsp">학습하기</a>
          </li>
          <li class="nav-item">

            <a class="nav-link a" href="search.jsp">단어검색</a>
          </li>
          <c:choose>
          	<c:when test="${login_user == null }">
	          <li class="nav-item">
	            <a class="nav-link" href="#" data-toggle="modal" data-target="#myModal">Login</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="#" data-toggle="modal" data-target="#myModal2">Sign-up</a>
	          </li>          	
          	</c:when>
          	<c:otherwise>
          		<li class="nav-item">
	            <a class="nav-link" href="#" data-toggle="modal" data-target="#myModal">My Page</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="#" data-toggle="modal" data-target="#myModal2">Logout</a>
	          </li>
          	</c:otherwise>
          </c:choose>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Header -->
  <header style="background-color:black; height:60px">
    <div class="overlay"></div>
  </header>

  <!-- Post Content -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="carousel slide" id="carousel-6835">
					<div class="carousel-inner"">
						<div class="carousel-item active">
							<img class="d-block w-100" src="https://www.layoutit.com/img/sports-q-c-1600-500-1.jpg" />
							<div class="carousel-caption" style="top: 0; bottom: auto;">
								<div class="text-right">
									<a class="fas fa-star" href="#"></a>
								</div>
								<h4>
									단어명
								</h4>
								<p class="text-left">
									단어 뜻은 여기에 로드
								</p>
							</div>
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" src="https://www.layoutit.com/img/sports-q-c-1600-500-2.jpg" />
							<div class="carousel-caption" style="top: 0; bottom: auto;">
								<div class="text-right">
									<a class="fas fa-star" href="#"></a>
								</div>
								<h4>
									단어명
								</h4>
								<p class="text-left">
									단어 뜻은 여기에 로드
								</p>
							</div>
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" src="https://www.layoutit.com/img/sports-q-c-1600-500-3.jpg" />
							<div class="carousel-caption" style="top: 0; bottom: auto;">
								<div class="text-right">
									<a class="fas fa-star" href="#"></a>
								</div>
								<h4>
									단어명
								</h4>
								<p class="text-left">
									단어 뜻은 여기에 로드
								</p>
							</div>
						</div>
					</div> <a class="carousel-control-prev" href="#carousel-6835" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-6835" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
				</div>
			</div>
		</div>
	</div>

  <hr>

  <!-- Footer -->
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <ul class="list-inline text-center">
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
          </ul>
          <p class="copyright text-muted">Copyright &copy; Your Website 2019</p>
        </div>
      </div>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/clean-blog.min.js"></script>

</body>

</html>
