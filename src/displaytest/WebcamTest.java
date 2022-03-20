package displaytest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class WebcamTest {

	public static void main(String[] args) {
		System.out.println("Webcam Test");
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		VideoCapture capture = new VideoCapture(0);
		
		HighGui.namedWindow("Webcam Video");
		Mat frame = new Mat();
		
		while(true) {
			
			capture.read(frame);
			HighGui.imshow("Webcam Video", frame);
			if(HighGui.waitKey(10) == 27) {
				break;
			}
		
		}
		System.exit(0);

	}

}
