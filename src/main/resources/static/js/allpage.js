$('#mainContent').load('/main/maindashboard');

function mainboard(path, name){
    $('#mainContent').children().remove();
    $('#mainContent').load('/'+path+'/'+name);
}

function mainboardform(path, name){

    const mainboardWriter = $('#userName');
    console.log('이름:', mainboardWriter.val());

    $('#mainContent').children().remove();
    $('#mainContent').load('/'+path+'/'+name+'?boardname='+mainboardWriter.val());
}