$(document).ready(function () {

    const getusername = RegExp(/^[가-힣]+$/);
    const getuserid = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z\-]+\.[A-Za-z0-9\-]+/);
    const getphone = /\d{2,3}-\d{3,4}-\d{4}/;
    const checkbtn = [false, false, false, false, false, false, false];
    //입력값 검증
    const $userId = $('#userId');
    const $btn = $('#btn');
    const $userPw = $('#userPw');
    const $userTel = $('#userTel');
    const $userName = $('#userName');
    const $userPwcheck = $('#userpwconcheck');
    
    //console.log('버튼:', $btn);
    //console.log('아이디 값:', $userid.value);

    // 버튼 클릭시 일어나는 요청
    $btn.on('click', e => {

        console.log('아이디찾기 진행여부:'+ checkbtn[0]);
        if ($userId.val() === '' || $userId.val() === null) {
            alert('아이디는 필수사항입니다.');
            // checkbtn[0] = false;
            return;

        }

        if (!getuserid.test($userId.val())) {
            alert('10자리부터 20자리까지 이메일형식에 맞춰 입력해주세요.');
            return;

        }

        //console.log('순서확인!');
        if(checkbtn[0] === false){
            $.ajax({
                type: 'post',
                url: '/membership/idcheck',
                data: {
                    userId: $userId.val(),
                },
                success:function(data){
                    alert('사용가능한아이디입니다.');
                    checkbtn[0] = true;
                    usercheck();
                },
    
                error:function(xhr, status, e){
                    console.log('error:', e);
                    alert('중복된아이디입니다.');
                }
            });
        }else if(checkbtn[0] ===true){
            usercheck();
        }

            // checkbtn[0] = true;
       // console.log('값확인함:', checkbtn[0]);

        // for(let i=0; i<checkbtn.length; i++){
        //     if(checkbtn[i])
        // }
    });

    function usercheck(){
        if ($userPw.val() === '' || $userPw.val() === null) {
            alert('비밀번호를 입력하세요.');
            return;
        }

        if($userPwcheck.val() ===''||$userPwcheck.val()===null ){
            alert('비밀번호확인란을 확인해주세요.');
            return;
        }
        
        if ($userPwcheck.val() !== $userPw.val()) {
            alert('비밀번호가 일치하지 않습니다.');
            return;
        }

        if ($('#userName').val() === "" || $('#userName').val() === null) {
            alert('이름을 입력하세요.');
            return;
        }

        if (!getusername.test($('#userName').val())) {
            alert('이름형식에 맞게 입력하세요.');
            return;

        }

        if ($userTel.val() === "" || $userTel.val() === null) {
            alert('핸드폰번호를 입력 하세요.');
            return;
        }

        if (!getphone.test($('#userTel').val())) {
            alert('핸드폰번호 형식에 맞게 작성하세요.');
            return;    
        }

        $.ajax({
            type: 'post',
            url: '/membership/sing_up',
            data: {
                userId: $userId.val(),
                userPw: $userPw.val(),
                userName: $userName.val(),
                userTel: $userTel.val(),

            },
            success:function(data){
                alert('회원가입에 성공하였습니다.');
                location.href = '/login';

            },
            error:function(data){
                alert(data);
            }
        })
    }

});