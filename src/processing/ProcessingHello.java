package processing;

import processing.core.PApplet;

public class ProcessingHello extends PApplet{
	
	
	public void settings() {
		size(800,600);
	}
	
	public void draw() {
	  if (mousePressed) {
		    fill(0, 255, 0);
		  } else {
		    fill(0, 0, 255);
		  }
	  ellipse(mouseX, mouseY, 10, 10);
	  //rect(mouseX, mouseY, 100, 100, 360, 45, 360, 50);
	}
	
	public static void main(String[] args) {
		PApplet.main(ProcessingHello.class.getName());

	}

}
