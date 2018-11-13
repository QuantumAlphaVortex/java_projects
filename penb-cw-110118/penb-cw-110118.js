var x = 0;
var y = 0;
var z = 0;

window.onload = function() {
	var moveDiv = document.getElementById("move");
	var enterDiv = document.getElementById("enter");
	var overDiv = document.getElementById("over");
	var clickDiv = document.getElementById("click");
	
	moveDiv.onmousemove = myMoveFunction;
	enterDiv.onmouseenter = myEnterFunction;
	overDiv.onmouseover = myOverFunction;
	clickDiv.onclick = myClickoverFunction;
}
function myMoveFunction() {
	document.getElementById("demo").innerHTML = z+=1;
}

function myEnterFunction() {
	document.getElementById("demo2").innerHTML = x+=1;
}

function myOverFunction() {
	document.getElementById("demo3").innerHTML = y+=1;
}

function myClickoverFunction(e) {
	document.getElementById("demo4").innerHTML = "Button clicked is: "+ e.button + '<br>';
	document.getElementById("demo4").innerHTML += "OffsetX is "+ e.offsetX+ '<br>';
	document.getElementById("demo4").innerHTML += "OffsetY is "+ e.offsetY+ '<br>';
	document.getElementById("demo4").innerHTML += "Shift key is pressed" + e.getModifierState('Shift')+ '<br>';
	
} 