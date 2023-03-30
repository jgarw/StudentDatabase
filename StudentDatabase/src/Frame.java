import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class Frame implements ActionListener {

JFrame frame;
JPanel panel;
JTextField nameText, heightText, ageText, courseText;
JLabel nameLabel, heightLabel, ageLabel, courseLabel;
JLabel studentsLabel;
JButton submitButton, clrButton, viewButton;
DefaultListModel<String> listModel;
JList<String> myList;
Student[] arrayStudents = new Student[10];
static int stuIndex = 0;

	Frame(){
		//creating frame
		frame = new JFrame();
		frame.setSize(500, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(false);
		frame.setVisible(true);
		frame.setResizable(false);
		
		//creating and adding panel
		panel = new JPanel();
		//panel.setBackground(Color.BLACK);
		panel.setFocusable(false);
		panel.setSize(500,420);
		panel.setLayout(null);
		frame.add(panel);
		
		//creating and adding buttons
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		clrButton = new JButton("Clear");
		viewButton = new JButton("View");
		submitButton.setBounds(20, 300, 75, 30);
		clrButton.setBounds(400, 300, 75, 30);
		viewButton.setBounds(300, 300, 75, 30);
		submitButton.setFocusable(false);
		clrButton.setFocusable(false);
		viewButton.setFocusable(false);
		panel.add(viewButton);
		panel.add(submitButton);
		panel.add(clrButton);
		panel.repaint();
		
		//creating and adding textFields
		nameText = new JTextField();
		heightText = new JTextField();
		ageText = new JTextField();
		courseText = new JTextField();
		nameText.setBounds(70, 50,150, 30);
		heightText.setBounds(70, 100,150, 30);
		ageText.setBounds(70, 150,150, 30);
		courseText.setBounds(70, 200,150, 30);
		
		//creating and adding labels
		nameLabel = new JLabel("Name: ");
		heightLabel = new JLabel("Height:");
		ageLabel = new JLabel("Age: ");
		courseLabel = new JLabel("Course:");
		nameLabel.setBounds(10, 50,50, 30);
		heightLabel.setBounds(10, 100,50, 30);
		ageLabel.setBounds(10, 150,50, 30);
		courseLabel.setBounds(10, 200,50, 30);
		studentsLabel = new JLabel("Students:");
		studentsLabel.setBounds(360, 25,200, 30);
		
		panel.add(nameText);
		panel.add(heightText);
		panel.add(ageText);
		panel.add(courseText);
		panel.add(nameLabel);
		panel.add(heightLabel);
		panel.add(ageLabel);
		panel.add(courseLabel);
		panel.add(studentsLabel);
		
		//trying to get JList to work. LEAVE AND COME BACK TO
		listModel = new DefaultListModel<String>();
		myList = new JList<String>();
		myList.setModel(listModel);
		myList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		myList.setLayoutOrientation(JList.VERTICAL);
		myList.setBounds(275, 50, 200, 200);
		panel.add(myList);
		panel.repaint();
		myList.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==submitButton) {
			
			arrayStudents[stuIndex]=new Student(nameText.getText(), heightText.getText(), ageText.getText(), courseText.getText());
			listModel.addElement(Student.name);
			System.out.println(Student.name);
			stuIndex++;
			
			
			//Clear textfields after hitting submit
			nameText.setText("");
			heightText.setText("");
			ageText.setText("");
			courseText.setText("");
			
			if(stuIndex == 50) {
				submitButton.setEnabled(false);
			}
		}
	}
}
