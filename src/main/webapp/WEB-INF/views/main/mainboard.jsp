<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .bottom-section {
        margin-top: 50px;
        margin-bottom: 30px;
        display: flex;
    }

    .bottom-section nav {
        flex: 9;
        display: flex;
        justify-content: center;
    }

    .bottom-section .btn-write {
        flex: 1;
    }
</style>

<h2 align="center">자유 게시판</h2>
<hr>
<div class="input-group mb-4">
    <form action="list" method="get">

        <select class="form-select" name="faqtype" id="search-type">
            <option value="faqtitle">제목</option>
            <option value="faqcontent">내용</option>
        </select><br>
        <div class="input-group" style="margin-left: auto;">
            <input type="text" style="margin-right: 10px;" class="form-control" id="faqkeyword"
                name="faqkeyword" placeholder="입력해주세요" />
            <a class="btn btn-primary" href="#" onclick="changeContentCusSearch('main', 'faq')">검색</a>
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
        </tr>
    </thead>

    <tbody>
        <c:forEach var="list" items="${main}">
            <tr>
                <th scope="row">${list.mainboardBno}</th>
                <td><a href="#" onclick="detailepath('main', 'detaile?mainboardBno=${list.mainboardBno}')">${list.mainboardTitle}</a></td>
                <td>${list.mainboardViewcnt}</td>
                <td>${list.strRegdate}</td>
            </tr>
        </c:forEach>
    </tbody>

</table>

<!-- 글 추가 -->

<!-- 게시글 목록 하단 영역 -->
<div class="bottom-section">

    <!-- 글쓰기 버튼 영역 -->
    <input type="hidden" id="boardname" value="${boardname}">

        <div class="create writing" align="left">
            <a class="btn btn-success" onclick="mainboardform('main', 'mainboardwriter')">글쓰기</a>
        </div>
    <!-- 페이지 버튼 영역 -->
    
</div>

<div id="search box" align="right">
    <a href="javascript:openfrm('/faq/Precautions');">주의사항</a>
</div>
<div class="input-group mb-4" align="center">
    <a href="#" onclick="changeContentCus('main', 'path')">화면이동</a>
</div>