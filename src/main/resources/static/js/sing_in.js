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
    
    $.ajax({
        url: '/login/sing_in',
        type: 'post',
        data: {
            userId: $userId.val(),
            userPw: $userPw.val(),
        },
        success: function(data){
            if(data == true){
                alert('로그인에 성공하였습니다.');
                location.href='/main';
            }else{
                alert('정보를 다시 확인해주세요.');
            }
            
        }

    })

}