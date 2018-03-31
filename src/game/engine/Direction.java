package game.engine;

public enum Direction {

	NULL("null"){
		@Override
		public boolean isNull() {
			return true;
		}
	},
	LEFT("Left"){
		@Override
		public boolean isLeft() {
			return true;
		}
	},
	RIGHT("Right"){
		@Override
		public boolean isRight() {
			return true;
		}
	}, TOP("Top"){
		@Override
		public boolean isTop() {
			return true;
		}
	}, DOWN("Down"){
		@Override
		public boolean isDown() {
			return true;
		}
	};

	private String name;

	private Direction(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	public boolean isNull(){
		return false;
	}
	
	public boolean isLeft() {
		return false;
	}
	
	public boolean isRight() {
		return false;
	}
	
	public boolean isTop() {
		return false;
	}
	
	public boolean isDown() {
		return false;
	}
}
