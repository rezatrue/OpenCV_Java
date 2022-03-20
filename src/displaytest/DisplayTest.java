package displaytest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class DisplayTest {

	public static void main(String[] args) {
		System.out.println("DisplayTest");
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		String filePath = "src/displaytest/cat.jpg";
		
		Mat originalImage = Imgcodecs.imread(filePath);
		if(originalImage.dataAddr()==0) {
			System.out.println("Couldn't open file "+ filePath);
		}else {
			HighGui.namedWindow("original image");
			HighGui.imshow("original image", originalImage);
			HighGui.waitKey();
		}
		

	}

}
