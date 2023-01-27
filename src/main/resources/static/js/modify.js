
function boardmodify(){

    const $mainboardBno = $('#mainboardBno');
    const $mainboardTitle = $('#mainboardTitle');
    const $mainboardContent = $('#mainboardContent');
    const $mainboardWriter = $('#mainboardWriter');

    $.ajax({
        type: 'post',
        url: '/main/modify',
        data: {
            mainboardBno: $mainboardBno.val(),
            mainboardTitle: $mainboardTitle.val(),
            mainboardContent: $mainboardContent.val(),
            mainboardWriter: $mainboardWriter.val(),
        },
        success: function(data){
            alert('글수정에 성공하였습니다!');
            window.location.href='/main/mainboard';
        },
        error: function(error){

            alert('글수정에 실패하였습니다!');

        }

    })


}