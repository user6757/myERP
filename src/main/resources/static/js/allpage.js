$('#mainContent').load('/main/maindashboard');

function mainboard(path, name){
    alert('확인!');
    $('#mainContent').children().remove();
    $('#mainContent').load('/'+path+'/'+name);
}