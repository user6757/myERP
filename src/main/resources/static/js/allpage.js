$('#mainContent').load('/main/maindashboard');

function mainboard(path, name){
    $('#mainContent').children().remove();
    $('#mainContent').load('/'+path+'/'+name);
}

function mainboardpath(path, name){

    $('#mainContent').children().remove();
    $('#mainContent').load('/'+path+'/'+name);

}