let modelEl = new ModelElement();


function submitForm(){

    let userId = modelEl.getElById("user_id").value;
    let userName = modelEl.getElById("user_name").value;

    if(userId === "" || userId === undefined
    || userName === "" || userName === undefined){
        alert("form still empty");
        return false;
    }else{
        return true;
    }

};