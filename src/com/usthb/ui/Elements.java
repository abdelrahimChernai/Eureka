package com.usthb.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;

public enum Elements {
	CONNECTION (new Button(new Rectangle(280, 295, 250, 45), Color.decode("#BB86FC"), "Connection")),
	INSCRIPTION (new Button(new Rectangle(280, 355, 250, 45), Color.decode("#BB86FC"), "Inscription")),
	VALIDATE (new Button(new Rectangle(280, 341, 250, 45), Color.decode("#4BBA87"), "Validate")),
	CLOSE (new Button(new Rectangle(Window.WIDTH - 46, 2, 45, 28), Color.decode("#E21526"), "")),
	INPUT_FIELD1 (new InputField(new Rectangle(280, 221, 250, 45), Color.decode("#1A1919"))),
	INPUT_FIELD2 (new InputField(new Rectangle(280, 281, 250, 45), Color.decode("#1A1919")));
	
	private Component component;
	
	private Elements(Component component) {
		this.component = component;
	}
	
	public Component getComponent() {
		return this.component;
	}
}
