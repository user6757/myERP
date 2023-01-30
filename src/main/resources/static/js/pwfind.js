function pwfindcheck(){

    $userId = $('#userId');

    if($userId.val() == ''){
        alert('아이디를 입력하여주세요!');
        return;
    }

    $.ajax({
        type: 'post',
        url: '/login/login_checkpwfind',
        data:{
            userId: $userId.val()
        },
        success:function(data){
            document.passwordfrm.method='post';
            document.passwordfrm.action='/login/login_okpwfind';
            document.passwordfrm.submit();
        },
        error:function(data){
            alert('해당아이디는 존재하지않는 정보입니다.');
        }

    })

}