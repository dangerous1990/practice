package org.learn.pattern.comand;

public class Client {
	public static void main(String[] args) {
		HistoryManager hm = new HistoryManager();
		String text = hm.exectute(new BoldComand(), "123456");
		System.out.println(text);// 加粗
		text = hm.exectute(new UnderLineComand(), text);
		System.out.println(text);// 加粗加下划线
		text = hm.exectute(new UnderLineComand(), text);
		System.out.println(text);// 加粗加下划线加下划线
		System.out.println(hm.undo());//
		text = hm.exectute(new UnderLineComand(), text);
		System.out.println(text);// 加粗加下划线加下划线加粗
		System.out.println(hm.undo());// 加粗加下划线加下划线
		System.out.println(hm.undo());// 加粗加下划线
		System.out.println(hm.undo());// 加粗
		System.out.println(hm.undo());// 123456
	}
}
