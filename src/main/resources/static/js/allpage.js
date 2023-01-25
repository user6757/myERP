$('#mainContent').load('/main/maindashboard');

function mainboard(){
    
    location.href='/main/mainboard';

}

function mainboardselect(path, name){

    $mainboardtype = $('#mainboardtype');
    $mainboardkeyword = $('#mainboardkeyword');

    console.log('타입:', $mainboardtype.val(), '키워드:', $mainboardkeyword.val());

    $('#mainContent').children().remove();
    $('#mainContent').load('/'+path+'/'+name+'?mainboardtype='+$mainboardtype.val()+'&mainboardkeyword='+$mainboardkeyword.val());

}