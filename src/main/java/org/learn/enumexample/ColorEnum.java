package org.learn.enumexample;

public enum ColorEnum {
	green("绿色") {
		@Override
		String getName() {
			return this.name;
		}
	},
	red("红色") {
		@Override
		String getName() {
			return this.name;
		}
	},
	blue("蓝色") {
		@Override
		String getName() {
			return this.name;
		}
	},
	white("白色") {
		@Override
		String getName() {
			return this.name;
		}
	};

	protected String name;

	private ColorEnum(String value) {
		this.name = value;
	}

	abstract String getName();
}
