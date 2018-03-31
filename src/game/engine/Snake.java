package game.engine;

import java.awt.Point;
import java.util.ArrayList;

public class Snake {

	private ArrayList<Point> list;
	private Direction direction;
	private boolean die;
	private boolean moveNext;

	public Snake(Point point) {
		this.list = new ArrayList<Point>();
		this.list.add(point);
		this.direction = Direction.NULL;
		this.die = false;
		this.moveNext = true;
	}

	public boolean isDie() {
		return this.die;
	}

	public ArrayList<Point> getSnake() {
		return this.list;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	private Point makeCoodinate(Point head) {
		if (this.direction.isLeft()) {
			return new Point(MapUtils.catchCoordinate((int) (head.getX() - 1)), (int) head.getY());
		} else if (this.direction.isRight()) {
			return new Point(MapUtils.catchCoordinate((int) (head.getX() + 1)), (int) head.getY());
		} else if (this.direction.isTop()) {
			return new Point((int) (head.getX()), MapUtils.catchCoordinate((int) head.getY() - 1));
		} else if (this.direction.isDown()) {
			return new Point((int) (head.getX()), MapUtils.catchCoordinate((int) head.getY() + 1));
		} else {
			return null;
		}
	}

	private void eat(Food food) {
		this.list.add(0, food.getCoordinate());
		food.setExist(false);
	}

	private void move(Point coordinate) {
		for (final Point point : list) {
			if (coordinate.equals(point))
				this.die = true;
		}
		this.list.add(0, coordinate);
		this.list.remove(list.size() - 1);
		this.moveNext = true;
	}

	public void update(Food food) {
		if (this.direction.isNull())
			return;
		Point head = this.list.get(0);
		Point nextPoint = makeCoodinate(head);
		if (nextPoint.equals(food.getCoordinate())) {
			eat(food);
			head = nextPoint;
			move(makeCoodinate(head));
		} else
			move(nextPoint);
	}
	
	public void setMoveNext(boolean moveNext) {
		this.moveNext = moveNext;
	}
	
	public boolean isMoveNext() {
		return this.moveNext;
	}
}
