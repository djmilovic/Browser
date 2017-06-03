package com.browsEr;

import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class BrowserSimple extends JFrame {

	//text field for URL
	private TextField field = new TextField();
	//place where we can view/read HTML files
	//constructor is empty
	private JEditorPane display = new JEditorPane();
	//scrolling through JEditorPane 
	//crate a new scroll bar on JEditorPane object
	private JScrollPane pane1 = new JScrollPane(display);
	
	public static void main(String args[]) {
		//creating a brand new instance of the class
		BrowserSimple file = new BrowserSimple();
		//
		file.frameHandler();
	}
	//start of the program
	//inits the program == the frame our browser is gonna be in 

	public void frameHandler() {
		setTitle("Browser");
		//fixed size, the user can't change it 
		setSize(1280, 880);
		//when we click on Exit, it's gonna quit the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		//it's weird
		setLayout(null);
		//create the frame in the middle, instead of top left corner
		setLocationRelativeTo(null);
		addComponentsToFrame(getContentPane());	
	}

	public void addComponentsToFrame(Container pane) {
		
		//locations of the edges of the frame
		Insets insets = getInsets();
		
		pane.add(field);
		pane.add(pane1);
		//
		Font font = new Font("Menlo", Font.PLAIN, 12);
		
		field.setFont(font);
		//he determined
		field.setBounds(8-insets.left, 30-insets.top, 1268, 20);
		pane1.setBounds(8-insets.left, 52-insets.top, 1268, 830);
		
		actionListenerCalls();
	
	}
	//what happens when we type something out, and then hit enter
	private void actionListenerCalls() {
		
		field.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				loadData("http://" + e.getActionCommand());
			}
		});
		
		display.addHyperlinkListener(new HyperlinkListener() {
			
			public void hyperlinkUpdate(HyperlinkEvent e) {
				
				if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					loadData(e.getURL().toString());
				}
			}
		});	
		
	}
	private void loadData(String text){
		
		try {
			display.setPage(text);
		}
		catch(Exception e) {
			System.out.println("nononoooo");
		}
		
	}
}