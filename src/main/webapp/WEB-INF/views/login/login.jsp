<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>erp</title>
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <jsp:include page="../../tiles/layouts/include.jsp" />

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-6 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">로그인</h1>
                                    </div>
                                    <form class="user" name="userfrm" id="userfrm">
                                        <div class="form-group">
                                            <input type="email" name="userId" class="form-control form-control-user"id="userId" aria-describedby="emailHelp"
                                                placeholder="아이디를 입력하세요:">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="userPw" class="form-control form-control-user"
                                                id="userPw" placeholder="비밀번호를 입력하세요:">
                                        </div>
                                        <a class="btn btn-primary btn-user btn-block" id="loginbtn" onclick="login();">
                                            로그인
                                        </a>
                                        <hr>
                                        <a href="/membership" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> 회원가입
                                        </a>
                                        <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                            <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                        </a>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.html">Forgot Password?</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="register.html">Create an Account!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
   <script src="js/sing_in.js"></script>


</body>

</html>