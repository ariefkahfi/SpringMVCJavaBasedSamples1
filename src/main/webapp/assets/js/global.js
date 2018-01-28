function ModelElement(){
    this.createEl = function (elName){
        document.createElement(elName);
    }

    this.getElById = function(elId) {
        return document.getElementById(elId);
    }
    this.emptyInnerHTML = function(elementsId){
        elementsId.forEach((val)=>{
            this.getElById(val).innerHTML ="";
        });
    }
    this.appendChildrenToParent = function (parElementId,listOfElementToAppends){
        listOfElementToAppends.forEach((val)=>{
            this.getElById(parElementId).append(val);
        });
    }
}