import javax.swing.*;

public class ViewWindow extends JFrame{

	static JFrame viewFrame = new JFrame("Student Info");
	static JPanel viewPanel = new JPanel();
	static JLabel viewName, viewHeight, viewAge, viewCourse;
	
	 ViewWindow(){
		
		
		viewFrame.setSize(300, 300);
		viewFrame.setResizable(false);
		viewFrame.setFocusable(false);
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.setVisible(true);
		
		viewPanel.setSize(300, 300);
		viewPanel.setLayout(null);
		viewPanel.setFocusable(false);
		viewFrame.add(viewPanel);
		viewPanel.setVisible(true);
		
		viewName = new JLabel();
		viewName.setBounds(130, 20, 200, 50);
		viewName.setFocusable(false);
		viewHeight = new JLabel();
		viewHeight.setBounds(130, 50, 200, 50);
		viewHeight.setFocusable(false);
		viewAge = new JLabel();
		viewAge.setBounds(130, 80, 200, 50);
		viewAge.setFocusable(false);
		viewCourse = new JLabel();
		viewCourse.setBounds(130, 110, 200, 50);
		viewCourse.setFocusable(false);
		
		viewPanel.add(viewName);
		viewPanel.add(viewHeight);
		viewPanel.add(viewAge);
		viewPanel.add(viewCourse);
		viewPanel.repaint();
		
	}
	 
	 
	
}
