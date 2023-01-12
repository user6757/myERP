<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>membership</title>

        <!-- Custom fonts for this template-->

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <jsp:include page="../../tiles/layouts/include.jsp" />
    </head>

    <body class="bg-gradient-primary">

        <div class="container">

            <!--Outet row-->
            <div class="row justify-content-center">
                <!--membership page-->
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-800 mb-4">회원가입</h1>
                                    </div>
                                    <form class="userfrm" name="userfrm" action="/membership/sing_up" method="post">
                                        <div class="form-group row">

                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="email" class="form-control form-control-user" name="userId"
                                                    id="userId" placeholder="아이디:">
                                            </div>

                                            <div class="col-sm-6">
                                                <input type="password" class="form-control form-control-user"
                                                    name="userPw" id="userPw" placeholder="비밀번호:">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="password" class="form-control form-control-user"
                                                    name="userpwconcheck" id="userpwconcheck" placeholder="비밀번호 확인:">
                                            </div>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control form-control-user" id="userName"
                                                    name="userName" placeholder="이름:">
                                            </div>
                                        </div>

                                        <div class="form-group row">

                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" name="userTel"
                                                    id="userTel" placeholder="핸드폰번호:">
                                            </div>

                                        </div>
                                        
                                        <button type="button" id="btn" class="btn btn-primary btn-block">회원가입</button>
                                        <a href="/" class="btn btn-primary btn-block">뒤로</a>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--/membership-->
            </div>


        </div>
        <script src="js/sing_up.js"></script>
    </body>