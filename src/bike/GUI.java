package bike;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {

	
	GUI() {
		JPanel panel = new JPanel();
		setTitle("Bike Gearing");
		setSize(500,500);
		setLayout(new BorderLayout());
		panel = buttons();
		add(panel, BorderLayout.NORTH);
		panel = textBoxes();
		add(panel, BorderLayout.SOUTH);
	}
	
	public JPanel buttons() {
		JPanel panel = new JPanel();
		
		JButton shiftUp = new JButton();
		shiftUp.setText("Shift Up");
		JButton shiftDown = new JButton();
		shiftDown.setText("Shift Down");
		panel.add(shiftUp);
		panel.add(shiftDown);
		
		return panel;	
	}
	
	public JPanel textBoxes() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		JTextField front = new JTextField(5);
		front.setText("53");
		JTextField rear = new JTextField(5);
		rear.setText("12");
		JLabel frontLabel = new JLabel();
		frontLabel.setText("Front Gear");
		JLabel rearLabel = new JLabel();
		rearLabel.setText("Rear Gear");
		panel.add(frontLabel);
		panel.add(rearLabel);
		panel.add(front);
		panel.add(rear);
		
		
		return panel;
	}
	
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		LoadBike bike = new LoadBike();
		bike.loadConfigFiles();
		gui.setVisible(true);
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
