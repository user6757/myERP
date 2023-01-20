function boardDelete(path, name){

    $mainboardBno = $('#mainboardBno');


    $.ajax({
        type:'post',
        url: '/main/delete',
        data: {
            mainboardBno: $mainboardBno.val()
        },
        success:function(data){
            alert(data);
            $('#mainContent').children().remove();
            $('#mainContent').load('/'+path+'/'+name);
        },
        error:function(result){
            alert(result);
        }
    })

}