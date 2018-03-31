package game.engine;

import java.awt.Point;

public class Map {

	private Snake snake;
	private Food food;
	private Player player;

	public Map() {
		this.food = new Food();
		this.snake = new Snake(new Point(5, 5));
		this.player = new Player(this, Level.LEVEL0);
	}

	public Food getFood() {
		return this.food;
	}

	public Snake getSnake() {
		return this.snake;
	}

	public void update() {
		this.snake.update(food);
		if (!this.food.isExist()) {
			this.food = new Food();
		}
		player.update();
	}
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
	
	public Player getPlayer() {
		return this.player;
	}
}
