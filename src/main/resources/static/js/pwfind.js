function pwfind(){

    $userId = $('#userId');

    if($userId.val() == ''){
        alert('아이디를 입력하여주세요!');
    }

    $.ajax({
        type: 'post',
        url: '/login/login_pwdinf',
        data:{
            userId: $userId.val()
        },
        success:function(data){
            alert('성공!');
            window.location.href='/login/login_login';
        },
        error:function(data){
            alert('해당아이디는 존재하지않는 정보입니다.');
        }

    })

}