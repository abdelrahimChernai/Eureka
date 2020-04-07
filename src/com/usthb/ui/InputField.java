package com.usthb.ui;

import java.awt.Color;
import java.awt.Rectangle;

import  javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class InputField extends JTextField{
	public InputField(Rectangle bounds, Color color) {
		
		this.setBounds(bounds);
		this.setBackground(color);
		this.setForeground(Color.decode("#FFFFFF"));
		this.setBorder(new LineBorder(Color.decode("#FFFFFF"), 1, true));
	}
}
