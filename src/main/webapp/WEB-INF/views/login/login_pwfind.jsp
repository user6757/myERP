<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>아이디 찾기</title>

        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="../css/sb-admin-2.min.css" rel="stylesheet">
        <jsp:include page="../../tiles/layouts/include.jsp" />
    </head>

    <body class="bg-gradient-primary">

        <div class="container">

            <c:if test="${pass == null}">
            <!--Outet row-->
            <div class="row justify-content-center">
                <!--idfind-->
                <div class="col-xl-6 col-lg-12 col-md-9">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-4">비밀번호 찾기</h1>
                                        </div>
                                        <form name="passwordfrm">
                                            <div class="form-group">
                                                <input type="text" class="form-control form-control-user" name="userId" id="userId" aria-describedby="emailHelp" placeholder="아이디 입력:">
                                            </div>
                                            <button type="button" onclick="pwfindcheck();" class="btn btn-primary btn-block">비밀번호 찾기</button>
                                            <a href="/login/login_login" class="btn btn-primary btn-block">로그인</a>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:if>

            <c:if test="${pass != null}">
            <!--Outet row-->
            <div class="row justify-content-center">
                <!--idfind-->
                <div class="col-xl-6 col-lg-12 col-md-9">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h4 class="h4 text-gray-900 mb-4">
                                                ${userId}님의 임시비밀번호는 ${pass}입니다.
                                            </h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:if>

        </div>

        <script src="../js/pwfind.js"></script>

    </body>
