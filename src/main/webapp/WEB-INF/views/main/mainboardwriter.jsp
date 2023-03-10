<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ERP main</title>

        <jsp:include page="../../tiles/layouts/include.jsp" />

    </head>

    <body id="page-top">
        <div id="wrapper">
            <!-- side -->
            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#"
                    onClick="changeContent('dashboard');">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">ERP Project</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item active">
                    <a class="nav-link">
                        <img class="img-profile rounded-circle" src="../img/undraw_profile.svg"
                            style="width: 64px;height: 64px;">&nbsp;&nbsp;
                        <span>${mainboardWriter}</span>&nbsp;
                        <br>
                        <br>
                        <a class="btn btn-primary" href="http://localhost:8097/logout" style="width: 186px;">๋ก๊ทธ์์</a>
                    </a>

                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">MyArea</div>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#"
                        onclick="window.open('/main/editinfo', 'PopupWin', 'width=710,height=810');"
                        data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>๋ด ์?๋ณด ์์?</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#"
                        onclick="window.open('/main/mywrite', 'PopupWin', 'width=710,height=810');"
                        data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fa-solid fa-pen"></i>
                        <span>๋ด๊ฐ ์ด ๊ธ</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" onClick="changeContent('todo');"
                        data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fa-solid fa-list"></i>
                        <span>To-Do</span>
                    </a>
                </li>


                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Common
                </div>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="/" data-target="#collapseUtilities" aria-expanded="true"
                        aria-controls="collapseUtilities">
                        <i class="fa-solid fa-bell"></i>
                        <span>๊ณต์ง์ฌํญ</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" onclick="mainboard()">
                        <i class="fa-solid fa-clipboard"></i>
                        <span>์์? ๊ฒ์ํ</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" onClick="changeContent('mrmain');"
                        data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fa-solid fa-handshake"></i>
                        <span>ํ์์ค ์์ฝ</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" onClick="changeContent('sharedata');"
                        data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fa-solid fa-share"></i>
                        <span>์๋ฃ ๊ณต์?</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" onClick="changeContent('cocalender');"
                        data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fa-solid fa-calendar-days"></i>
                        <span>์ฌ๋ด ์ผ์?</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" onClick="changeContent('qna');"
                        data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fa-solid fa-question"></i>
                        <span>Q&A</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" onClick="changeContent('faq');"
                        data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fa-solid fa-list"></i>
                        <span>FAQ</span>
                    </a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- ๊ด๋ฆฌ์ ์์ญ -->

                <!-- ๊ด๋ฆฌ์ ์์ญ ๋ -->
            </ul>
            <!-- End of Sidebar -->
            <div id="content-wrapper" class="d-flex flex-column">
                <!-- Main Content -->
                <div id="content">
                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- ์ฑํ ์์ด์ฝ -->
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#"
                                    onclick="window.open('/popup.html', 'PopupWin', 'width=710,height=810');"
                                    id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false">
                                    <i class="fas fa-comments fa-2x"></i>
                                    <!-- Counter - Alerts -->
                                    <span class="badge badge-danger badge-counter">3+</span>
                                </a>
                            </li>

                            <!-- ๋ฉ์ผ ์์ด์ฝ -->
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#"
                                    onclick="window.open('/mail/receive', 'PopupWin', 'width=710,height=810');"
                                    id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false">
                                    <i class="fas fa-envelope fa-2x"></i>
                                    <!-- Counter - Messages -->
                                    <span class="badge badge-danger badge-counter">7</span>
                                </a>
                            </li>
                        </ul>

                    </nav>
                    <!-- End of Topbar -->
                    <div id="mainContent" class="container-fluid">
                        
                        <div class="boardDTO write">

                            <h2 align="center">์์?๊ฒ์ํ ๊ธ ์์ฑ</h2>
                            <form name="savefrm" action="/main/mainboardsave" method="post">

                                <input type="hidden" id="mainboardWriter" name="mainboardWriter"
                                    value="${mainboardWriter}">
                                <input type="hidden" id="mainboardUserId" name="mainboardUserId"
                                    value="${mainboardUserId}">

                                <div class="mainboard-3">
                                    <label for="write_title" class="form-label">๊ธ์?๋ชฉ</label>
                                    <input type="text" class="form-control" id="mainboardTitle" placeholder="์?๋ชฉ"
                                        name="mainboardTitle" placeholder="์?๋ชฉ์ ์๋?ฅํด ์ฃผ์ธ์." required>
                                </div>
                                <div class="mainboard-3">
                                    <label for="write_text" class="form-label">๋ด์ฉ</label>
                                    <input type="textarea" class="form-control" name="mainboardContent"
                                        id="mainboardContent" row="10" placeholder="๋ด์ฉ์ ์๋?ฅํด ์ฃผ์ธ์." required>
                                </div>
                        </div>

                        <div>
                            <button type="button" class="btn btn-primary"
                                onclick="writercheck('main', 'mainboard')">๋ฑ๋ก</button>
                            <button id="to-list" type="button" class="btn btn-primary"
                                onclick="mainboard('main', 'mainboard')">๋ชฉ๋ก</button>

                        </div>

                        </form>
                        <script src="js/writer.js"></script>
                    </div>

                </div>
                <!-- footer -->
                <jsp:include page="../../tiles/layouts/footer.jsp" />
            </div>
            <!-- End of Content Wrapper -->
        </div>
        <script src="../js/writer.js"></script>

    </body>

    </html>