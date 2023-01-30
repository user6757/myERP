function idfind(){

    $userName = $('#userName');
    $userTel = $('#userTel');

    if($userName.val() == ''){
        alert('이름을 입력하세요!');
        return;
    }

    if($userTel.val() == ''){
        alert('휴대폰번호를 입력하세요!');
        return;
    }

    $.ajax({
        type: 'post',
        url: '/login/accountfind',
        data: {
            userName: $userName.val(),
            userTel: $userTel.val()
        },
        success:function(result){
            document.userfrm.method='post';
            document.userfrm.action='/login/getaccount';
            document.userfrm.submit();
        },
        error:function(e){
            alert('해당정보의 회원이 존재하지않습니다.');
        }

    })

}