package com.usthb.vues;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.usthb.controler.AppControler;

public class Leaderboard extends JPanel {
	private int shownPlayers;
	
	private AppControler manager = new AppControler();
	
	private JLabel back;
	private JLabel title;
	private JPanel leaderboard;
	private JScrollPane scrollPane;
	

	public Leaderboard(Font font) {
		super(null, true);
		
		back = new JLabel("Back");
		back.setFont(font);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setForeground(Color.decode("#BB86FC"));
		back.setBounds(60, 74, 32, 20);
		back.addMouseListener(manager);
		
		title = new JLabel("Leaderboard");
		Font temp = font.deriveFont(30f);
		title.setFont(temp);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.decode("#FFFFFF"));
		title.setBounds(284, 90, 242, 55);
		
		
		leaderboard = new JPanel(new GridLayout(8, 1, 0, 20));
		leaderboard.setBackground(Color.decode("#1A1919"));
		leaderboard.setBounds(105, 173, 415, 600);
		
		shownPlayers = 0;
		
		scrollPane = new JScrollPane(leaderboard);
		
		scrollPane.setBounds(105, 173, 600, 415);
		scrollPane.setBackground(new Color(0.f, 0.f, 0.f, 0.f));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setAutoscrolls(true);
		
		this.setBackground(Color.decode("#1A1919"));
		this.add(back);
		this.add(scrollPane);
		this.add(title);
	}

	public void addPlayerToLeaderboard(String playerInfo, Font font) {
		shownPlayers++;
		
		JLabel player = new JLabel(playerInfo);
		player.setSize(600, 20);
		player.setBorder(BorderFactory.createMatteBorder(
				0,
				0,
				1,
				0,
				Color.WHITE)
			);
		Font temp = font.deriveFont(20f);
		player.setFont(temp);
		player.setForeground(Color.decode("#FFFFFF"));
		player.setHorizontalAlignment(SwingConstants.CENTER);
		
		if (shownPlayers > 8) {
			((GridLayout) leaderboard.getLayout()).setRows(shownPlayers);
		}
		leaderboard.add(player);
		this.repaint();
	}
}
