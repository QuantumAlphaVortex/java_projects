
//In javascript we create a class only by creating a constructor
//That constructor must create all properties AND methods using the 
//this keyword and returning that object
function BouncingBall(x,y,canvas) {
    this.x = x;
    this.y = y;
    this.Y_STEP = -4;
    this.radius = 10;
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
        var d = 2*this.radius+10;
        ctx.clearRect(this.x-this.radius-5,this.y-this.radius-5,d,d);
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
		ctx.lineWidth = 10;
        ctx.stroke();
    }
    this.run = ()=> {
        this.move(0,this.Y_STEP);
        if(this.y <= 0) {
            this.stop();
        }
    }
    
    this.start = ()=>{
        this.thread= window.setInterval(this.run,this.delay);        
    } 
    
    this.stop = ()=> {
        clearInterval(this.thread);
    }
    
}

//once you have a constructor, you simply create a new object using the syntax
// myObject = new BouncingBall(value1,value2,value3);
