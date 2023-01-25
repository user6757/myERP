<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <div class="boardDTO write">

                <h2 align="center">자유게시판 글 작성</h2>
                <form name="savefrm" action="/main/mainboardsave" method="post">

                <input type="hidden" id="mainboardWriter" name="mainboardWriter" value="${mainboardWriter}">
                <input type="hidden" id="mainboardUserId" name="mainboardUserId" value="${mainboardUserId}">

                    <div class="mainboard-3">
                        <label for="write_title" class="form-label">글제목</label>
                        <input type="text" class="form-control" id="mainboardTitle" placeholder="제목" name="mainboardTitle" placeholder="제목을 입력해 주세요." required>
                    </div>
                    <div class="mainboard-3">
                        <label for="write_text" class="form-label">내용</label>
                        <input type="textarea" class="form-control" name="mainboardContent" id="mainboardContent" row="10" placeholder="내용을 입력해 주세요." required>                     
                    </div>
            </div>

                <div>
                    <button type="button" class="btn btn-primary" onclick="writercheck('main', 'mainboard')">등록</button>
                    <button id="to-list" type="button" class="btn btn-primary" onclick="mainboard('main', 'mainboard')">목록</button>
                    
                </div>
            </form>