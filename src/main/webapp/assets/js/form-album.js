let modelEl = new ModelElement();

function submitAlbum(){
    let albumId = modelEl.getElById("album_id").value;
    let albumName = modelEl.getElById("album_name").value;
    let albumUserId = modelEl.getElById("album_user_id").value;

    if(albumId === "" || albumName === "" || albumUserId === ""
    || albumId === undefined || albumName === undefined || albumUserId === undefined){
        alert("form still empty");
        return false;
    }else{
        return true;
    }

}