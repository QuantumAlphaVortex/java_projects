//reference https://medium.com/tech-tajawal/javascript-this-4-rules-7354abdb274c

window.onload = function() {
    var c = document.getElementById("myCanvas");
    c.onmousedown = onMouseDown;
    begin(c);
} 

function begin(myCanvas) {
	var myTarget = new BouncingTarget(0, 0,myCanvas);
    myTarget.start(); 
}

function onMouseDown(evt) {
    var myBall = new BouncingBall(evt.offsetX,evt.offsetY,this);
    myBall.start();    
}


//In javascript we create a class only by creating a constructor
//That constructor must create all properties AND methods using the 
//this keyword and returning that object
function BouncingTarget(x,y,canvas) {
    this.X_STEP_RIGHT = 5;
	this.X_STEP_LEFT = -5;
	this.direction = this.X_STEP_RIGHT;
    this.radius = 50;
	this.x = x + this.radius;
    this.y = y + this.radius;
	this.canvas = canvas;
    this.thread = 0;
    this.delay = 33;
    
    this.move = (dx,dy) =>{
        this.erase();
        this.x += dx;
        this.y += dy;
        this.draw();
    };
    
    this.moveTo = (x,y) =>{
        this.erase();
        this.x = x;
        this.y = y;
        this.draw();        
    };
    
    this.erase = ()=> {
        var ctx = this.canvas.getContext("2d");
        var d = 2*this.radius+2;
        ctx.clearRect(this.x-this.radius-1,this.y-this.radius-1,d,d);
        /*ctx.beginPath();
        ctx.strokeStyle = "white";        
        ctx.arc(this.x,this.y,this.radius,0,2*Math.PI);
        ctx.stroke();    
        /**/
    };
    
    this.draw = ()=> {
        var ctx = this.canvas.getContext("2d");
        ctx.beginPath();
        ctx.strokeStyle = "black";        
        ctx.arc(this.x,this.y,this.radius,0,2*Math.PI);
		ctx.lineWidth = 2;
        ctx.stroke();
    }
    this.run = ()=> {
		
        this.move(this.direction,0);
		
		if(this.x + this.radius >= this.canvas.width && this.direction == this.X_STEP_RIGHT) {
			this.direction = this.X_STEP_LEFT;
		}
		if(this.x - this.radius <= 0 && this.direction == this.X_STEP_LEFT) {
			this.direction = this.X_STEP_RIGHT;
		}
    }
    
    this.start = ()=>{
        this.thread= window.setInterval(this.run,this.delay);        
    } 
    
    this.stop = ()=> {
        window.clearInterval(this.thread);
    }
    
}

//once you have a constructor, you simply create a new object using the syntax
// myObject = new BouncingBall(value1,value2,value3);
