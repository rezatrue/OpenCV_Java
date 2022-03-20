package swing.windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class FrameWindow extends JFrame{
	JLabel labelMessage;
	JTextField txtfieldInput;
	JButton btnClick;
	JPanel p1,p2,p3;
	public FrameWindow(String title) {
		super(title);
		setSize(320,240);
		setLayout(new GridLayout(3,1,5,5));
		labelMessage = new JLabel("Hello World");
		p1 = new JPanel();
		p1.add(labelMessage);
		
		txtfieldInput = new JTextField(20);
		p2 = new JPanel();
		p2.add(txtfieldInput);
		
		btnClick = new JButton("Click");
		p3 = new JPanel();
		p3.add(btnClick);
		
		add(p1);
		add(p2);
		add(p3);
		
		btnClick.addActionListener(new ButtonHandler());
	}
	
	class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnClick) {
				JOptionPane.showMessageDialog(null, "Hello " + txtfieldInput.getText());
				labelMessage.setText("Hello " + txtfieldInput.getText());
			}
		}
		
	}
}

public class SwingWindows {

	public static void main(String[] args) {
		FrameWindow fw = new FrameWindow("Hello");
		fw.setVisible(true);
	}
}
