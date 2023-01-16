function writercheck(path, name){
    alert('클릭!');
    const $userid = $('#mainboardUserId').val();
    const $mainboardTitle = $('#mainboardTitle').val();
    const $mainboardContent = $('#mainboardContent').val();
    const $mainboardWriter = $('#mainboardWriter').val();

    console.log('받은아이디:', $userid, ', 받은 이름:', $mainboardWriter);

    if($mainboardTitle ===''){
        alert('제목은 필수사항입니다!');
        return;
    }
    if($mainboardContent ===''){
        alert('내용은 필수 사항입니다.');
        return;
    }

    $.ajax({
        type:'post',
        url:'/main/mainboardsave',
        data:{
            mainboardUserId: $userid,
            mainboardTitle: $mainboardTitle,
            mainboardContent: $mainboardContent,
            mainboardWriter: $mainboardWriter
        },
        success:function(data){
            alert('게시물 등록에 성공하였습니다.');
            $('#mainContent').children().remove();
            $('#mainContent').load('/'+path+'/'+name);
        },
        error:function(xhr, status){
            alert('게시물 등록에 실패하였습니다.');
        }
    })


}