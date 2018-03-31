package game.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import game.engine.Food;
import game.engine.Map;
import game.engine.MapUtils;
import game.engine.Snake;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {

	private static final Dimension DIMENSION_GAMEPANEL = new Dimension(500, 500);
	private static final Point LOCATION_GAMEPANEL = new Point(0, 0);
	private int width;
	private int height;
	private Map map;
	private Frame frame;

	public GamePanel(Frame frame) {

		this.frame = frame;
		inits();
		addControls();
	}

	private void addControls() {
		this.map = new Map();
		Thread gameThread = new Thread(this);
		gameThread.start();
	}

	private void inits() {
		setSize(DIMENSION_GAMEPANEL);
		setLocation(LOCATION_GAMEPANEL);
		setFocusable(true);
		setLayout(null);
		this.width = (int) (DIMENSION_GAMEPANEL.getWidth() / MapUtils.MAP_WIDTH);
		this.height = (int) (DIMENSION_GAMEPANEL.getHeight() / MapUtils.MAP_HEIGHT);
	}

	private void drawMap(Graphics g) {
		g.setColor(Color.black);
		for (int i = 0; i < MapUtils.MAP_WIDTH; i++) {
			for (int j = 0; j < MapUtils.MAP_HEIGHT; j++) {
				g.fillRect(i * this.width, j * this.height, this.width - 2, this.height - 2);
			}
		}
		drawFood(g, this.map.getFood());
		drawSnake(g, this.map.getSnake());
	}

	private void drawFood(Graphics g, Food food) {
		g.setColor(Color.red);
		g.fillRect((int) food.getCoordinate().getX() * this.width, (int) food.getCoordinate().getY() * this.height,
				this.width - 2, this.height - 2);
	}

	private void drawSnake(Graphics g, Snake snake) {
		g.setColor(Color.green);
		for (final Point point : snake.getSnake()) {
			g.fillRect((int) point.getX() * this.width, (int) point.getY() * this.height, this.width - 2,
					this.height - 2);
		}
	}

	private void update() {
		this.map.update();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawMap(g);
	}

	@Override
	public void run() {
		while (true) {
			if (!GamePanel.this.map.getSnake().isDie())
				try {
					update();
					this.frame.getMenuPanel().getTxtScore().setText(String.valueOf(this.map.getPlayer().getScore()));
					repaint();
					Thread.sleep(GamePanel.this.map.getPlayer().getLevel().getTimeDelay());
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	public Map getMap() {
		return this.map;
	}

}
