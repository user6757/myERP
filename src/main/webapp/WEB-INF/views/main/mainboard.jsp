<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ERP main</title>

    <jsp:include page="../../tiles/layouts/include.jsp"/>

</head>
<body id="page-top">
    <div id="wrapper">
      <!-- side -->
      <!-- Sidebar -->
      <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
    
        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#" onClick="changeContent('dashboard');">
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
            <img class="img-profile rounded-circle" src="../img/undraw_profile.svg" style="width: 64px;height: 64px;">&nbsp;&nbsp;
            <span>${user.userName}</span>&nbsp;
            <c:if test="${user.userFlag eq '관리자'}">
                <span class="badge badge-danger">Admin</span>
            </c:if>
            <br>
            <br>
            <a class="btn btn-primary" style="width: 186px;" href="http://localhost:8097/logout">로그아웃</a>
          </a>
    
        </li>
    
        <!-- Divider -->
        <hr class="sidebar-divider">
    
        <!-- Heading -->
        <div class="sidebar-heading">MyArea</div>
    
        <li class="nav-item">
          <a class="nav-link collapsed" href="#" onclick="window.open('/main/editinfo', 'PopupWin', 'width=710,height=810');" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span>내 정보 수정</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link collapsed" href="#" onclick="window.open('/main/mywrite', 'PopupWin', 'width=710,height=810');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fa-solid fa-pen"></i>
            <span>내가 쓴 글</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link collapsed" href="#" onClick="changeContent('todo');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
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
          <a class="nav-link collapsed" href="/" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fa-solid fa-bell"></i>
            <span>공지사항</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link collapsed" onclick="mainboard('main', 'mainboard')">
            <i class="fa-solid fa-clipboard"></i>
            <span>자유 게시판</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link collapsed" href="#" onClick="changeContent('mrmain');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fa-solid fa-handshake"></i>
            <span>회의실 예약</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link collapsed" href="#" onClick="changeContent('sharedata');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fa-solid fa-share"></i>
            <span>자료 공유</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link collapsed" href="#" onClick="changeContent('cocalender');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fa-solid fa-calendar-days"></i>
            <span>사내 일정</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link collapsed" href="#" onClick="changeContent('qna');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fa-solid fa-question"></i>
            <span>Q&A</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link collapsed" href="#" onClick="changeContent('faq');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fa-solid fa-list"></i>
            <span>FAQ</span>
          </a>
        </li>
    
        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">
    
        <!-- 관리자 영역 -->
    
        <!-- 관리자 영역 끝 -->
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
    
              <!-- 채팅 아이콘 -->
              <li class="nav-item dropdown no-arrow mx-1">
                <a class="nav-link dropdown-toggle" href="#" onclick="window.open('/popup.html', 'PopupWin', 'width=710,height=810');" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="fas fa-comments fa-2x"></i>
                  <!-- Counter - Alerts -->
                  <span class="badge badge-danger badge-counter">3+</span>
                </a>
              </li>
    
              <!-- 메일 아이콘 -->
              <li class="nav-item dropdown no-arrow mx-1">
                <a class="nav-link dropdown-toggle" href="#" onclick="window.open('/mail/receive', 'PopupWin', 'width=710,height=810');" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="fas fa-envelope fa-2x"></i>
                  <!-- Counter - Messages -->
                  <span class="badge badge-danger badge-counter">7</span>
                </a>
              </li>
            </ul>
    
          </nav>
          <!-- End of Topbar -->
          <div id="mainContent" class="container-fluid">
            <h2 align="center">자유 게시판</h2>
            <hr>
            <div class="input-group mb-4">
    
                <form method="get" action="/main/mainboard">
                    <select class="form-select" name="mainboardtype" id="mainboardtype">
                        <option value="maintitle">제목</option>
                        <option value="maincontent">내용</option>
                    </select><br>
                    <div class="input-group" style="margin-left: auto;">
                        <input type="text" class="form-control" id="mainboardkeyword" placeholder="입력:" name="mainboardkeyword" required>
                        <input type="submit" class="btn btn-success" value="검색">
                    </div>
                </form>
            </div>
    
            <table class="boardDTO table">
                <thead>
                    <tr>
                        <th id="board_num" scope="col">게시물 번호</th>
                        <th scope="col">제목</th>
                        <th id="read_board_count" scope="col">조회수</th>
                        <th scope="col">작성일</th>
                        <c:if test="${modify == true}">
                            <th scope="col">수정일</th>
                        </c:if>
                    </tr>
                </thead>
    
                <tbody>
                    <c:forEach var="list" items="${main}">
                        <tr>
                            <th scope="row">${list.mainboardBno}</th>
                            <td><a href="/main/detaile?mainboardBno=${list.mainboardBno}">${list.mainboardTitle}</a>
                            </td>
                            <td>${list.mainboardViewcnt}</td>
                            <td>${list.strRegdate}</td>
                            <c:if test="${list.strRegdate ne list.strModifiyRegdate}">
                                <td>${list.strModifiyRegdate}</td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
    
            </table>
    
            <!-- 글 추가 -->
    
            <!-- 게시글 목록 하단 영역 -->
            <div class="bottom-section">
    
                <div class="create writing" align="left">
                  <form name="writerfrm">
                  <input type="hidden" name="mainboardWriter" id="mainboardWriter" value="${boardname}">
                    <button type="button" class="btn btn-success" onclick="writerform()">글쓰기</button>
                  </form>  
                </div>
                <!-- 페이지 버튼 영역 -->
    
            </div>
    
            <div id="search box" align="right">
                <a href="javascript:openfrm('/faq/Precautions');">주의사항</a>
            </div>
            <div class="input-group mb-4" align="center">
                <a href="#" onclick="changeContentCus('main', 'path')">화면이동</a>
            </div>
          </div>

        </div>
        <!-- footer -->
        <jsp:include page="../../tiles/layouts/footer.jsp"/>
      </div>
      <!-- End of Content Wrapper -->
    </div>
    <script src="../js/writer.js"></script>
    <script src="../js/detaile.js"></script>

    </body>
</html>
