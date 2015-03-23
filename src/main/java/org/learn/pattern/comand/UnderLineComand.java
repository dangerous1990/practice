package org.learn.pattern.comand;

public class UnderLineComand implements IComand {
	private String preText;

	@Override
	public String execute(String text) {
		this.preText = text;
		return text + "加下划线";
	}

	@Override
	public String undo() {
		return preText;
	}

}
