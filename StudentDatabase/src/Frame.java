import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class Frame implements ActionListener {

JFrame frame;
JFrame viewFrame;
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
		frame = new JFrame("Student Database");
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
		viewButton.addActionListener(this);
		submitButton.setFocusable(false);
		clrButton.setFocusable(false);
		clrButton.addActionListener(this);
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
		nameText.setBounds(90, 50,150, 30);
		heightText.setBounds(90, 100,150, 30);
		ageText.setBounds(90, 150,150, 30);
		courseText.setBounds(90, 200,150, 30);
		
		//creating and adding labels
		nameLabel = new JLabel("Name: ");
		heightLabel = new JLabel("Height: ");
		ageLabel = new JLabel("Age: ");
		courseLabel = new JLabel("Course:");
		nameLabel.setBounds(10, 50,50, 30);
		heightLabel.setBounds(10, 100,50, 30);
		ageLabel.setBounds(10, 150,50, 30);
		courseLabel.setBounds(10, 200,50, 30);
		studentsLabel = new JLabel("Students:");
		studentsLabel.setBounds(360, 25,200, 30);
		
		//adding a lot to the panel 
		panel.add(nameText);
		panel.add(heightText);
		panel.add(ageText);
		panel.add(courseText);
		panel.add(nameLabel);
		panel.add(heightLabel);
		panel.add(ageLabel);
		panel.add(courseLabel);
		panel.add(studentsLabel);
		
		//creating a JList to display student objects
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
		//when submit button is clicked, student object is added to array, then to list
		if (e.getSource()==submitButton) {
			arrayStudents[stuIndex]=new Student(nameText.getText(), heightText.getText(), ageText.getText(), courseText.getText());
			stuIndex++;
			listModel.addElement(Student.name);
			//System.out.println(Student.name);
			
			//Clear textfields after hitting submit
			nameText.setText("");
			heightText.setText("");
			ageText.setText("");
			courseText.setText("");
			
			if(stuIndex == 10) {
				submitButton.setEnabled(false);
			}
		}
		//when view button is clicked, new window is opened showing selected student info
		if(e.getSource()==viewButton) {
			new ViewWindow();
			ViewWindow.viewName.setText(Student.name);
			ViewWindow.viewHeight.setText(Student.height);
			ViewWindow.viewAge.setText(Student.age);
			ViewWindow.viewCourse.setText(Student.course);
			ViewWindow.viewPanel.repaint();
		}
		//when clr button is clicked, all fields including list are cleared
		if(e.getSource()==clrButton) {
			nameText.setText("");
			heightText.setText("");
			ageText.setText("");
			courseText.setText("");
			
			listModel.clear();
		}
	}
}
