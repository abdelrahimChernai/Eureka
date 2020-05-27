package com.usthb.vues;

import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.usthb.controler.AppControler;

public class ThemeSelectionPage extends JPanel {
	private AppControler manager = new AppControler(); 
	private JLabel back;
	private JLabel username;
	private JLabel lvl;
	private JLabel selectTheme;
	private LinkedList<JButton> themesButtons;
	
	public ThemeSelectionPage(LinkedList<String> themes
			, String playerUsername
			, int playerLvl
			, Font font) {
		
		super(null, true);
		
		this.themesButtons = new LinkedList<JButton>();
		
		back = new JLabel("Back");
		back.setFont(font);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setForeground(Color.decode("#BB86FC"));
		back.setBounds(60, 90, 32, 20);
		back.addMouseListener(manager);
		
		username = new JLabel(playerUsername);
		username.setFont(font);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setForeground(Color.decode("#BB86FC"));
		username.setBounds(682, 80, 48, 20);
		username.addMouseListener(manager);
		
		lvl = new JLabel("Level " + playerLvl);
		Font temp = font.deriveFont(12f);
		lvl.setFont(temp);
		lvl.setHorizontalAlignment(SwingConstants.CENTER);
		lvl.setForeground(Color.decode("#BB86FC"));
		lvl.setBounds(682, 97, 48, 20);
		lvl.addMouseListener(manager);
		
		selectTheme = new JLabel("Select a theme");
		temp = font.deriveFont(16f);
		selectTheme.setFont(temp);
		selectTheme.setHorizontalAlignment(SwingConstants.CENTER);
		selectTheme.setForeground(Color.decode("#FFFFFF"));
		selectTheme.setBounds((EurekaFrame.WIDTH - 140) / 2, 209, 140, 20);
		
		for (String theme : themes) {
			JButton themeButton = new JButton(theme);
			themeButton.setFont(font);
			themeButton.setHorizontalAlignment(SwingConstants.CENTER);
			themeButton.setBorderPainted(false);
			themeButton.setFocusPainted(false);
			themeButton.setSize(100, 100);
			themeButton.setBackground(Color.decode("#BB86FC"));
			themeButton.setForeground(Color.decode("#FFFFFF"));
			themeButton.addActionListener(manager);
			
			themesButtons.add(themeButton);
		}
		
		setupButtonsLocation();
		
		this.setBackground(Color.decode("#1A1919"));
		this.add(back);
		this.add(this.username);
		this.add(lvl);
		this.add(selectTheme);
		
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
