package org.learn.enumexample;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.learn.jdk.lang.enu.ColorEnum;
import org.learn.jdk.lang.enu.WeekEnum;

/**
 * @author admin
 *
 */

public class EnumTest {
	@Test
	public void testEunm() {

		// switch
		switch (WeekEnum.WED) {
		// case WeekEnum.MON:
		case MON:
			System.out.println("星期一");
			break;
		case TUE:
			System.out.println("星期二");
			break;
		default:
			System.out.println("星期三");
			break;
		}
		System.out.println("-------------------------------------------------------------");
		// 遍历
		for (WeekEnum week : WeekEnum.values()) {
			System.out.println(week);
		}
		System.out.println("-------------------------------------------------------------");
		// compareTo(E o) 比较 orndinal
		switch (WeekEnum.TUE.compareTo(WeekEnum.MON)) {
		case -1:
			System.out.println("TUE 在 MON 之前");
			break;
		case 1:
			System.out.println("TUE 在 MON 之后");
			break;
		default:
			System.out.println("TUE 与 MON 在同一位置");
			break;
		}
		System.out.println("-------------------------------------------------------------");
		// getDeclaringClass() 获取声明的WeekEnum 而不是 Enum 父类
		System.out.println("getDeclaringClass(): "
				+ WeekEnum.MON.getDeclaringClass().getName());
		System.out.println("getClass(): "
				+ WeekEnum.MON.getClass().getName());
		System.out.println("-------------------------------------------------------------");
		// name() 和 toString() 返回的是name的值
		System.out.println("name(): " + WeekEnum.MON.name());
		System.out.println("toString(): " + WeekEnum.MON.toString());
		System.out.println("-------------------------------------------------------------");
		// ordinal()， 返回值是从 0 开始
		System.out.println("ordinal(): " + WeekEnum.MON.ordinal());
		System.out.println("-------------------------------------------------------------");
		//enum valueof 方法
		 WeekEnum mon= Enum.valueOf(WeekEnum.class , "MON");
		 System.out.println("---------------------Enum.valueOf()----------------------------------------");
		System.out.println(mon.name());

	}

	@Test
	public void testEnumSet() {
		// EnumSet的使用
		EnumSet<WeekEnum> weekSet = EnumSet.allOf(WeekEnum.class);//生成全部的WeekEnum类型的enumset
		EnumSet<WeekEnum>  weekSetNone= EnumSet.noneOf(WeekEnum.class);//创建一个空的WeekEnum对象的enumset
		EnumSet<WeekEnum> weekSet1 = EnumSet.of(WeekEnum.MON);//创建只有一个mon的enumset
		EnumSet<WeekEnum>  weekSetCopy= EnumSet.copyOf(weekSet1);//复制
		EnumSet<WeekEnum>  complement= EnumSet.complementOf(weekSet1);//不包含MON
		EnumSet<WeekEnum>  copy2 =EnumSet.copyOf(Arrays.asList(WeekEnum.MON));//从集合里面复制创建
		EnumSet<WeekEnum>  range = EnumSet.range(WeekEnum.MON, WeekEnum.FRI);//周一至周五
		for (WeekEnum day : weekSet) {
			System.out.println(day);
		}
		System.out.println("-------------------------生成全部的WeekEnum类型的enumset------------------------------------");
		for (WeekEnum day : weekSet) {
			System.out.println(day);
		}
		System.out.println("-----------------------创建一个空的WeekEnum对象的enumset--------------------------------------");
		System.out.println(weekSetNone.isEmpty());
		System.out.println("---------------------------创建只有一个mon的enumset----------------------------------");
		for (WeekEnum day : weekSet1) {
			System.out.println(day);
		}
		System.out.println("-------------------------------复制------------------------------");
		for (WeekEnum day : weekSetCopy) {
			System.out.println(day);
		}
		System.out.println("---------------------不包含MON----------------------------------------");
		for (WeekEnum day : complement) {//不包含MON
			System.out.println(day);
		}
		System.out.println("---------------------从集合里面复制创建----------------------------------------");
		for (WeekEnum day : copy2) {
			System.out.println(day);
		}
		System.out.println("---------------------range周一至周五----------------------------------------");
		for (WeekEnum day : range) {
			System.out.println(day);
		}
		//多线程下enumset
		System.out.println("-------------------------------------------------------------");
		Set<WeekEnum> s = Collections.synchronizedSet(EnumSet.noneOf(WeekEnum.class));

	}
	
	@Test
	public void testEnumMap() {
		System.out.println("-------------------------------------------------------------");
		// EnumMap的使用,enum作为key
		EnumMap<WeekEnum, String> weekMap = new EnumMap<WeekEnum, String>(
				WeekEnum.class);
		weekMap.put(WeekEnum.MON, "星期一");
		weekMap.put(WeekEnum.TUE, "星期二");
		for (Entry<WeekEnum, String> enumEntry : weekMap.entrySet()) {
			System.out.println(enumEntry.getKey());
			System.out.println(enumEntry.getValue());
		}
		//多线程下enummap
		System.out.println("-------------------------------------------------------------");
	     Map<WeekEnum, String> m= Collections.synchronizedMap(new EnumMap<WeekEnum, String>(WeekEnum.class));

	}
	@Test
	public void testColor(){
		//枚举实现接口，定义abstract方法
		System.out.println(ColorEnum.blue.getName());
	}
}
