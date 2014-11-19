package bike;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	
	private Bike bike;
	private JTextField rear;
	private JTextField front;
	private int gear;
	private int chainRing;
	
	GUI() {
		rear = new JTextField(5);
		front = new JTextField(5);
		gear = 0;
		chainRing = 0;
		
		bike = new Bike();
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
		panel.setLayout(new GridLayout(2,2));
		
		final JButton shiftUp = new JButton();
		shiftUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == shiftUp) {
					System.out.println("shift up pressed");
					gear++;
					if(gear < bike.getRearGears().size()) {
						bike.setCurrentCog(gear);
					}
					else {
						gear = 0;
						JOptionPane.showMessageDialog(null, "You dropped your chain!");
					}
					update();
				}
			}
			
		});
		shiftUp.setText("Shift Up");
		final JButton shiftDown = new JButton();
		shiftDown.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == shiftDown) {
					System.out.println("shift down pressed");
					gear--;
					if(gear >= 0) {
						bike.setCurrentCog(gear);
					}
					else {
						gear = 0;
						JOptionPane.showMessageDialog(null, "You dropped your chain!");
					}
					update();
				}
			}
			
		});
		shiftDown.setText("Shift Down");
		panel.add(shiftUp);
		panel.add(shiftDown);
		
		final JButton shiftFrontUp = new JButton();
		shiftFrontUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getSource() == shiftFrontUp) {
					System.out.println("shift chain ring up");
					chainRing++;
					if(chainRing < bike.getFrontChainRings().size()) {
						bike.setCurrentChainRing(chainRing);
					}
					else {
						chainRing = 0;
						JOptionPane.showMessageDialog(null, "You dropped your chain!");
					}
					update();
				}
			}
			
		});
		shiftFrontUp.setText("Shift Front Up");
		
		final JButton shiftFrontDown = new JButton();
		shiftFrontDown.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == shiftFrontDown) {
					System.out.println("shift chain ring down");
					chainRing--;
					if(chainRing >= 0) {
						bike.setCurrentChainRing(chainRing);
					}
					else {
						chainRing = 0;
						JOptionPane.showMessageDialog(null, "You dropped your chain!");
					}
					update();
				}
			}
			
		});
		shiftFrontDown.setText("Shift Front Down");
		
		panel.add(shiftFrontUp);
		panel.add(shiftFrontDown);
		
		return panel;	
	}
	
	public JPanel gear() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		front.setText(Integer.toString(bike.getFrontChainRings().get(chainRing)));
		rear.setText(Integer.toString(bike.getRearGears().get(gear)));
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
	
	
	
	
	public void setCurrentCog() {
		String rearText = Integer.toString(bike.getRearGears().get(gear));
		rear.setText(rearText);
	}
	
	public void setChainRing() {
		String frontText = Integer.toString(bike.getFrontChainRings().get(chainRing));
		front.setText(frontText);
	}
	
	public void update() {
		setCurrentCog();
		setChainRing();
	}
	
	
	
	public static void main(String[] args) {
		GUI gui = new GUI();

		gui.setVisible(true);
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
