package bike;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	
	private LoadBike bike;

	
	GUI() {
		bike = new LoadBike();
		bike.loadConfigFiles();
		JPanel panel = new JPanel();
		setTitle("Bike Gearing");
		setSize(500,500);
		setLayout(new BorderLayout());
		panel = shift();
		add(panel, BorderLayout.NORTH);
		panel = gear();
		add(panel, BorderLayout.SOUTH);
		panel = bike();
		add(panel, BorderLayout.WEST);
		
		
	}
	
	public JPanel shift() {
		JPanel panel = new JPanel();
		
		JButton shiftUp = new JButton();
		shiftUp.setText("Shift Up");
		JButton shiftDown = new JButton();
		shiftDown.setText("Shift Down");
		panel.add(shiftUp);
		panel.add(shiftDown);
		
		return panel;	
	}
	
	public JPanel gear() {
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
	
	public JPanel bike() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel chooseBike = new JLabel();
		chooseBike.setText("Choose a bike: ");
		JComboBox bikes = new JComboBox();
		for(int i = 0; i < bike.getName().size(); i++) {
			bikes.addItem(bike.getName().get(i));
		}
		panel.add(chooseBike);
		panel.add(bikes);
		
		return panel;
	}
	
	
	public static void main(String[] args) {
		GUI gui = new GUI();

		gui.setVisible(true);
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
