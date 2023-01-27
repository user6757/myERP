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
            window.location.href='/main/mainboard';
        },
        error:function(result){
            alert(result);
        }
    })

}