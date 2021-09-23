import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

PImage img;
Bacteria [] dots;
Trump hunter;

public void setup(){
	size(600,600);
	background(0);
	img = loadImage("donaldtramp.PNG");
	dots = new Bacteria[200];
	for(int i = 0; i < dots.length;i++)
	{

	  dots[i] = new Bacteria();
	}
	hunter = new Trump();
}
public void draw(){

	fill(0);
	rect(-50,-50, 650,650);
	hunter.show();
	for(int i = 0; i < dots.length; i++)
	{
		dots[i].move();
		dots[i].show();
	}
}

public void mousePressed()
{
	setup();
}

class Bacteria
{
	int x, y;
	boolean alive;
	Bacteria()
	{
		x = (int)(Math.random()*600);
		y = (int)(Math.random()*600);
		alive = true;
	}
	public void move()
	{
		x = x + (int)(Math.random()*3)-1;
		y = y + (int)(Math.random()*3)-1;
	}
	public void show()
	{
		noStroke();
		fill(255,200,0);

		// image(img, x, y);
		if(get(x,y) != color(255,200,0) && get(x,y)!=color(0)  )
			alive = false;
		if(alive == true)
			ellipse(x,y,15,15);
	}
}

class Trump
{
	int x, y;
	Trump()
	{
		x = mouseX;
		y = mouseY;
	}
	public void show()
	{	
		fill(255);
		image(img, mouseX-img.width/2, mouseY-img.height/2);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
