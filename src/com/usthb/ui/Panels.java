package com.usthb.ui;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Component;
import java.util.LinkedList;
import java.util.Arrays;


public enum Panels {
	HOME_PAGE (new Panel(
					new Rectangle(0, 32, 810, 608)
					, Color.decode("#1A1919")
					, new LinkedList<Component>(Arrays.asList(Elements.CONNECTION.getComponent(), Elements.INSCRIPTION.getComponent()))
				)
			),
	LOGIN_PAGE (new Panel(
					new Rectangle(0, 32, 810, 608)
					, Color.decode("#1A1919")
					, new LinkedList<Component>(Arrays.asList(Elements.INPUT_FIELD1.getComponent(), Elements.INPUT_FIELD2.getComponent(), Elements.VALIDATE.getComponent()))
				)
			);
	
	private Panel panel;
	
	private Panels(Panel panel) {
		this.panel = panel;
	}
	
	public Panel getPanel() {
		return this.panel;
	}
}



