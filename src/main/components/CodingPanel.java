package main.components;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

public class CodingPanel extends JPanel {
	public RSyntaxTextArea codeTextArea;

	public CodingPanel() {
		this.setLayout(new BorderLayout());
		codeTextArea = new RSyntaxTextArea();
		codeTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		codeTextArea.setCodeFoldingEnabled(true);
		codeTextArea.setAntiAliasingEnabled(true);
		codeTextArea.setAutoscrolls(true);
		codeTextArea.setText("class Test {\n\n" +
				"   public static void main(String[] args) {\n" +
				"      System.out.println(\"Hello, world!\");\n" +
				"   }\n\n" +
				"}\n");
		JScrollPane codeScrollPane = new JScrollPane(codeTextArea);
		this.add(codeScrollPane, BorderLayout.CENTER);
		JButton runButton = new JButton("Run code");
		JButton clearButton = new JButton("Clear");
		runButton.addActionListener(e -> {
		});
		clearButton.addActionListener(e -> codeTextArea.setText(""));
		this.add(new ButtonPanel(runButton, clearButton), BorderLayout.SOUTH);
	}
}
