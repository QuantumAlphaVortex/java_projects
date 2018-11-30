//Adding event handler directly to property of 
//  window object
window.onload = loadDocument;

//global properties to remember where things were drawn.
window.previousX= 0;
window.previousY= 0;
window.isDrawing = true;


function loadDocument(evt) {
    var canvas = document.getElementById("myCanvas");
    begin(evt);
    canvas.addEventListener("mousedown",onMousePress);    
    canvas.addEventListener("mousemove",onMouseDrag);
}


/**
*  begin Function runs when page is loaded.
*     it creates instructions and first sun.
*/
function begin(evt) {
    //initialize variables
    let canvas = document.getElementById("myCanvas");
    let pen = canvas.getContext("2d");
    
    //reset strokes and paths pen has saved
    pen.beginPath();    
   
}

/**
*  onMousePress function runs every time canvas is clicked on
*     it should move sun up and hide instructions
*/
function onMousePress(evt) {

    let mouseX = evt.offsetX;
    let mouseY = evt.offsetY;
    let canvas = evt.currentTarget;
    let pen = canvas.getContext("2d");
    
    //TODO save offsetX and offsetY to previousX and previous Y
     previousX = evt.offsetX;
	 previousY = evt.offsetY;
}

function onMouseDrag(evt) {
    let canvas = document.getElementById("myCanvas");
    let pen = canvas.getContext("2d");
    
    //Reset path for drawing
    pen.beginPath();
    //make sure we are drawing AND we have left mouse button pressed
    if(isDrawing && evt.which ==1) {
        //get color from HTML of pen to draw
        let color = document.querySelector('input[name="color"]:checked').value;
    
        //set fillStyle of pen with that color
        pen.strokeStyle = color;
		if(color == "white")
			pen.lineWidth = 25;
		else if(color !== "white")
			pen.lineWidth = 1;
        //TODO move the pen to previousX and previousY
		pen.moveTo(previousX,previousY);
		 previousX = evt.offsetX;
		 previousY = evt.offsetY;
        //TODO create a line to current X and Y (evt.offsetX and evt.offsetY)
		
		pen.lineTo(evt.offsetX,evt.offsetY);
        //draw the line (stroke)
        pen.stroke();
    } 
}