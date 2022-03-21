package window.webcam;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;

class FrameWindow extends JFrame{
	JLabel labelImage;

	private BufferedImage mat2BufferedImage(Mat matrix) {
		
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if(matrix.channels() > 1) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		
		int bufferSize = matrix.channels() * matrix.cols() * matrix.rows();
		byte[] buffer = new byte[bufferSize];
		matrix.get(0, 0, buffer);
		BufferedImage image = new BufferedImage(matrix.cols(), matrix.rows(), type);
		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
		return image;
	}
	
	public FrameWindow(String title) {
		super(title);
		labelImage = new JLabel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(labelImage);
		setVisible(true);
	}
	
	public void setImage(Mat matImage) {
		Image image = mat2BufferedImage(matImage);
		ImageIcon imgIcon = new ImageIcon(image);
		setSize(matImage.cols(), matImage.rows());
		labelImage.setIcon(imgIcon);
		labelImage.repaint();
	}
}

public class WindowWebCam {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		FrameWindow fw = new FrameWindow("Webcam Capture");
		
		VideoCapture capture = new VideoCapture(0); // if you have only one camera use ZERO, increase if you have multiple
		if(capture.isOpened() == false) {
			System.out.println("Unable to Open Camera");
			capture.release();
			System.exit(0);
		}
		Mat frame = new Mat();
		
		while(true) {
			if(capture.read(frame)) {
				fw.setImage(frame);
			};
		}
		
	}

}
