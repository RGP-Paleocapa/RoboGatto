package main.components;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	JButton runButton;
	JButton clearButton;

	public ButtonPanel(JButton runButton, JButton clearButton) {
		this.runButton = runButton;
		this.clearButton = clearButton;

		this.add(runButton);
		this.add(clearButton);
	}
}
