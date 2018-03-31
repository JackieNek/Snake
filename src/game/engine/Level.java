package game.engine;

public enum Level {

	LEVEL0("( Level 0)", 750, 1, 1, 30) {
		@Override
		public Level nextLevel() {
			return Level.LEVEL1;
		}
	},
	LEVEL1("( Level 1)", 700, 30, 2, 90) {
		@Override
		public Level nextLevel() {
			return Level.LEVEL2;
		}
	},
	LEVEL2("( Level 2)", 650, 90, 4, 210) {
		@Override
		public Level nextLevel() {
			return Level.LEVEL3;
		}
	},
	LEVEL3("( Level 3)", 600, 210, 6, 390) {
		@Override
		public Level nextLevel() {
			return Level.LEVEL4;
		}
	},
	LEVEL4("( Level 4)", 550, 390, 8, 630) {
		@Override
		public Level nextLevel() {
			return Level.LEVEL5;
		}
	},
	LEVEL5("( Level 5)", 500, 630, 10, 930) {
		@Override
		public Level nextLevel() {
			return Level.LEVEL6;
		}
	},
	LEVEL6("( Level 6)", 450, 930, 15, 1380) {
		@Override
		public Level nextLevel() {
			return Level.LEVEL7;
		}
	},
	LEVEL7("( Level 7)", 400, 1380, 20, 1980) {
		@Override
		public Level nextLevel() {
			return Level.LEVEL8;
		}
	},
	LEVEL8("( Level 8)", 300, 1980, 30, 2880) {
		@Override
		public Level nextLevel() {
			return Level.LEVEL9;
		}
	},
	LEVEL9("( Level 9)", 200, 2880, 40, 4080) {
		@Override
		public Level nextLevel() {
			return Level.LEVELMAX;
		}
	},
	LEVELMAX("( Level max)", 100, 4080, 50, Integer.MAX_VALUE) {
		@Override
		public Level nextLevel() {
			return Level.LEVELMAX;
		}
	};

	private String name;
	private long timeDelay;
	private int baseScore;
	private int multiScore;
	private int maxScore;

	private Level(String name, long timeDelay, int baseScore, int multiScore, int maxScore) {
		this.name = name;
		this.timeDelay = timeDelay;
		this.baseScore = baseScore;
		this.multiScore = multiScore;
		this.maxScore = maxScore;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public int getBaseScore() {
		return this.baseScore;
	}

	public int getMultiScore() {
		return this.multiScore;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public long getTimeDelay() {
		return this.timeDelay;
	}

	public abstract Level nextLevel();
}
