package game.graphics;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private static final Dimension DIMENSION_FRAME = new Dimension(830, 530);
	private static Frame INSTANCE = new Frame();
	private GamePanel gamePanel;
	private MenuPanel menuPanel;

	private Frame() {
		
		this.menuPanel = new MenuPanel(this);
		this.gamePanel = new GamePanel(this);
		
		inits();
		addComponents();
		addEvents();
	}

	private void addEvents() {
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				Frame.this.gamePanel.getMap().getPlayer().action(e);
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});		
	}

	public static Frame install() {
		return INSTANCE;
	}

	private void addComponents() {
		add(this.gamePanel);
		add(this.menuPanel);	
	}

	private void inits() {
		setSize(DIMENSION_FRAME);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setFocusableWindowState(true);
		setFocusable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public GamePanel getGamePanel() {
		return this.gamePanel;
	}
	
	public MenuPanel getMenuPanel() {
		return this.menuPanel;
	}
	
}
