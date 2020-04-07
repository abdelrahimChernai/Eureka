package com.usthb.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.usthb.MainApp;

class EventManager implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		String triger = e.getActionCommand();
		
		if (triger.contentEquals("Connection")) {
			JPanel parent = (JPanel)((JButton)e.getSource()).getParent();
			JPanel frame = (JPanel)parent.getParent();

			frame.remove(parent);
			frame.add(Panels.LOGIN_PAGE.getPanel());
			frame.repaint();
		} else if(triger.contentEquals("Validate")) {
			MainApp.player =  MainApp.connection();
		} else if (triger.contentEquals("Inscription")) {
			
			MainApp.inscription();
		} else if (triger.contentEquals("")) {
			System.exit(0);
		}
	}
}
