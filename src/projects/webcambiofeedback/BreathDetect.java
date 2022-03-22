package projects.webcambiofeedback;

import org.opencv.core.Core;

import processing.core.PApplet;

public class BreathDetect extends PApplet{

	
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		PApplet.main(BreathDetect.class.getName());
	}

}
