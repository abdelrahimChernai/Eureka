package com.usthb.vues;

import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.usthb.controler.AppControler;

public class ThemeSelectionPage extends JPanel {
	private AppControler manger = new AppControler(); 
	private JLabel username;
	private LinkedList<JButton> themesButtons;
	
	public ThemeSelectionPage(LinkedList<String> themes
			, String username
			, Font font) {
		
		super(null, true);
		
		this.themesButtons = new LinkedList<JButton>();
		
		this.username = new JLabel(username);
		this.username.setFont(font);
		this.username.setForeground(Color.decode("#BB86FC"));
		this.username.setBounds(682, 93, 50, 20);
		this.username.addMouseListener(new AppControler());
		
		for (String theme : themes) {
			JButton themeButton = new JButton(theme);
			themeButton.setFont(font);
			themeButton.setBorderPainted(false);
			themeButton.setFocusPainted(false);
			themeButton.setSize(100, 100);
			themeButton.setBackground(Color.decode("#BB86FC"));
			themeButton.setForeground(Color.decode("#FFFFFF"));
			themeButton.addActionListener(manger);
			
			themesButtons.add(themeButton);
		}
		
		setupButtonsLocation();
		
		this.setBackground(Color.decode("#1A1919"));
		this.add(this.username);
		
		for (JButton button : themesButtons) {
			this.add(button);
		}
	}
	
	private void setupButtonsLocation() {
		final int SPACING = 45;
		final int MIN_WIDTH = (
				810
				- themesButtons.size() * 100
				+ (themesButtons.size() - 1) * SPACING
			) / 2;
		
		for (int i = 0; i < themesButtons.size(); i++) {
			themesButtons.get(i).setLocation(MIN_WIDTH + i * (100 + SPACING)
					, 291);
		}
	}
	
}
