 function flipPanel(evt) {
    var myEl = document.querySelector("#flapContainer");
    if(myEl.style.transform ==="none")
        myEl.style.transform = "rotateY(180deg)";
    else 
        myEl.style.transform = "none";
}

	 
var buttonEl=document.querySelector("#myButton"); 
	buttonEl.addEventListener("click", flipPanel);