package game.engine;

import java.awt.Point;

public class Food {

	private Point coordinate;
	private boolean exist;

	public Food() {
		coordinate = new Point((int) (Math.random() * MapUtils.MAP_WIDTH), (int) (Math.random() * MapUtils.MAP_HEIGHT));
		exist = true;
	}

	public Point getCoordinate() {
		return coordinate;
	}
	
	public boolean isExist() {
		return exist;
	}
	
	public void setExist(boolean exist) {
		this.exist = exist;
	}
}
