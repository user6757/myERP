function login(){

    const $userId = $('#userId');
    const $userPw = $('#userPw');
    
    if($userId.val() == null || $userId.val() ==''){
        alert('아이디를 입력하세요.');
        return;
    }

    if($userPw.val() == null || $userPw.val() == ''){
        alert('비밀번호를 입력하세요.');
        return;
    }

    document.userfrm.submit();

}