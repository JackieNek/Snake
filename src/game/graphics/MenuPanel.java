package game.graphics;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.engine.Level;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {

	private static final Dimension DIMENSION_MENU = new Dimension(300,500);
	private static final Point LOCATION_MENU = new Point(500, 0);
	private Frame frame;
	
	private JButton btnNewGame,btnPauseAndContinueGame;
	private JTextField txtScore;
	private JComboBox<Level> cbLevel;

	public MenuPanel(Frame frame) {

		this.frame = frame;

		inits();
		addControl();
		addEvents();
	}

	private void addEvents() {
		
	}

	private void addControl() {
		add(btnNewGame);
		add(txtScore);
	}

	private void inits() {
		setSize(DIMENSION_MENU);
		setLocation(LOCATION_MENU);
		setFocusable(true);
		setLayout(null);
		
		txtScore= new JTextField();
		txtScore.setSize(120, 30);
		txtScore.setRequestFocusEnabled(false);
		txtScore.setLocation(new Point(10, 50));
		
		btnNewGame = new JButton("New game");
		btnNewGame.setSize(120, 30);
		btnNewGame.setLocation(new Point(10, 10));
	}

	public JTextField getTxtScore() {
		return txtScore;
	}
}
