package game.engine;

public class MapUtils {

	public static final int MAP_WIDTH = 40;
	public static final int MAP_HEIGHT = 40;
	public static final int MAP_LIMIT_MAX = 39;
	public static final int MAP_LIMIT_MIN = 0;

	public static int catchCoordinate(int number) {
		if (number < MAP_LIMIT_MIN)
			return MAP_LIMIT_MAX;
		else if (number > MAP_LIMIT_MAX)
			return MAP_LIMIT_MIN;
		else
			return number;
	}
}
