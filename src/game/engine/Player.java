package game.engine;

import java.awt.event.KeyEvent;

public class Player {

	private Map map;
	private Level level;
	private int score;

	public Player(Map map, Level level) {
		this.map = map;
		this.level = level;
		this.score = 0;
	}

	public void update() {
		this.score = this.level.getBaseScore() + this.map.getSnake().getSnake().size() * this.level.getMultiScore();
		if (this.score > level.getMaxScore()) {
			this.level = this.level.nextLevel();
			Snake snake = this.map.getSnake();
			this.map.setSnake(new Snake(snake.getSnake().get(0)));
		}
	}

	public int getScore() {
		return this.score;
	}

	public Level getLevel() {
		return this.level;
	}

	public void action(KeyEvent e) {
		Snake snake = this.map.getSnake();
		if (snake.isMoveNext()) {
			snake.setMoveNext(false);
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (!snake.getDirection().isDown())
					snake.setDirection(Direction.TOP);
				return;
			case KeyEvent.VK_DOWN:
				if (!snake.getDirection().isTop())
					snake.setDirection(Direction.DOWN);
				return;
			case KeyEvent.VK_LEFT:
				if (!snake.getDirection().isRight())
					snake.setDirection(Direction.LEFT);
				return;
			case KeyEvent.VK_RIGHT:
				if (!snake.getDirection().isLeft())
					snake.setDirection(Direction.RIGHT);
				return;
			default:
				return;
			}
		}
	}
}
