$('#mainContent').load('/main/maindashboard');

function mainboard(path, name){
    $('#mainContent').children().remove();
    $('#mainContent').load('/'+path+'/'+name);
}

function mainboardpath(path, name){

    const mainboardWriter = $('#mainboardWriter');

    $('#mainContent').children().remove();
    $('#mainContent').load('/'+path+'/'+name+'?boardname='+mainboardWriter.val());

}