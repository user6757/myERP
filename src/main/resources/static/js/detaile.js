function detailepath(path, name){

    $('#mainContent').children().remove();
    $('#mainContent').load('/'+path+'/'+name);

}