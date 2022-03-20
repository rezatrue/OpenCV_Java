package displaytest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class WebcamTest2 {

	public static void main(String[] args) {
		System.out.println("Webcam Test 2");
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		VideoCapture capture = new VideoCapture(0);
		
		capture.set(Videoio.CAP_PROP_FRAME_HEIGHT, 640);
		capture.set(Videoio.CAP_PROP_FRAME_WIDTH, 480);
		
		if(capture.isOpened()== false) {
			System.out.println("Unable to open Camera");
			capture.release();
			System.exit(0);
		}
		
		
		
		HighGui.namedWindow("Webcam Video");
		Mat frame = new Mat();
		
		while(true) {
			
			capture.read(frame);
			if(frame.empty()) {
				System.out.println("empty frame");
				break;
			}
			HighGui.imshow("Webcam Video", frame);
			if(HighGui.waitKey(10) == 27) {
				break;
			}
		
		}
		
		HighGui.destroyAllWindows();
		capture.release();
		System.exit(0);

	}

}
