function modify(path, name){

    const $mainboardBno = $('#mainboardBno');
    const $mainboardTitle = $('#mainboardTitle');
    const $mainboardContent = $('#mainboardContent');
    const $mainboardWriter = $('#mainboardWriter');

    $.ajax({
        type: 'post',
        url: document.modifyfrm.action,
        data: {
            mainboardBno: $mainboardBno.val(),
            mainboardTitle: $mainboardTitle.val(),
            mainboardContent: $mainboardContent.val()
        },
        success: function(data){
            alert('글수정에 성공하였습니다!');
            $('#mainContent').children().remove();
            $('#mainContent').load('/'+path+'/'+name+'?mainboardWriter='+$mainboardWriter.val());
        },
        error: function(error){
            alert('글수정에 실패하였습니다!');
        }

    })


}