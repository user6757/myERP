<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

        <div class="col-lg-12 col-md-6" align="center">

            <h1>FAQ 글 상세 목록</h1>
            <form action="/main/modify" name="modifyfrm" method="post">
                <input type="hidden" id="mainboardBno" name="mainboardBno" value="${main.mainboardBno}">
                <input type="hidden" id="mainboardWriter" name="mainboardWriter" value="${main.mainboardWriter}">
                <table>
                    <tr>
                        <td>제목</td>
                        <td><input type="text" id="mainboardTitle" name="mainboardTitle" value="${main.mainboardTitle}"></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td><textarea id="mainboardContent" name="mainboardContent">${main.mainboardContent}</textarea></td>
                    </tr>
                    <tr>
                        <td>등록일</td>
                        <td>${main.strRegdate}</td>
                    </tr>
                    <tr>
                        <td>조회수</td>
                        <td>${main.mainboardViewcnt}</td>
                    </tr>
                </table>
            </form>

                        <tr>
                            <td colspan="2"><input type="button" href="#" class="btn btn-primary" onclick="modify('main', 'mainboard')" value="글수정"/></td>
                        </tr>
                <a href="#" class="btn btn-primary" onclick="changeContentCusdelete('main', 'faq')">글삭제</a>
            &nbsp;&nbsp;&nbsp;
            <button id="to-list" type="button" class="btn btn-primary" onclick="mainboard('main', 'mainboard')">목록</button>
        </div>