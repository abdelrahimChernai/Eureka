package com.usthb.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.usthb.ErrorCode;
import com.usthb.MainApp;
import com.usthb.vues.EurekaFrame;

public class AppControler implements ActionListener{
	private static MainApp eurekaRuner;
	private static EurekaFrame gameFrame;
	
	public static void start() {
		eurekaRuner = new  MainApp();
		eurekaRuner.initialization();
		gameFrame = new EurekaFrame();
		gameFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String triger = e.getActionCommand(); 
		
		if (triger.contentEquals("")) {
			System.exit(0);
		} else if (triger.contentEquals("Continue")) {
			switchPanel(
						gameFrame.getHomePage()
						, gameFrame.getConnectionPage()
					);
		} else if (triger.contentEquals("Confirm")) {
			ErrorCode error = eurekaRuner.connection();
			
			if (error == ErrorCode.WRONG_USERNAME) {
				gameFrame.getConnectionPage().setUsernameError(
						error.getErrorMessage());
			} else if (error == ErrorCode.WRONG_PASSWORD) {
				gameFrame.getConnectionPage().setPasswordError(
						error.getErrorMessage());
			} else {
				System.out.println(eurekaRuner.getCurrnetPlayer());
			}
		}
	}
	
	private void switchPanel(JPanel oldPanel, JPanel newPanel) {
		gameFrame.remove(oldPanel);
		gameFrame.add(newPanel);
		gameFrame.repaint();
	}
	
	public static String getConnectionUsername() {
		return gameFrame.getConnectionPage().getUsernameInput().getText();
	}
	
	public static String getConnectionPassword() {
		return gameFrame.getConnectionPage().getPasswordInput().getText();
	}
	

}
