package com.yinggu.demo06;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;

import org.junit.Test;

import com.yinggu.domain.MyDate;

/**
 * 一、创建日期MyDate类，里面有年、月、日属性，并对其进行合理封装 定义测试类，提供测试方法（要求用上Lambda表达式） 
 * 测试方法一：比较两个日期大小
 * 测试方法二：比较两个日期是否相等 
 * 测试方法三根据传入的日期，返回有效的格式xx年xx月xx日
 * 
 * @author 黑猴子的家 
 * http://www.121ugrow.com/
 */
public class TestMyDate1 {

	// 测试方法一
	@Test
	public void test1() {
		Comparator<MyDate> com1 = new Comparator<MyDate>() {
			@Override
			public int compare(MyDate o1, MyDate o2) {
				if (o1.getYear() > o2.getYear())
					return 1;
				else if (o1.getYear() < o2.getYear())
					return -1;
				else if (o1.getMonth() > o2.getMonth())
					return 1;
				else if (o1.getMonth() < o2.getMonth())
					return -1;
				else
					return Integer.compare(o1.getDay(), o2.getDay());

			}
		};
		System.out.println(com1.compare(new MyDate(2012, 1, 1), new MyDate(2013, 5, 1)));
		
		System.out.println("-------------------------------------------------------------");

		Comparator<MyDate> com = (o1, o2) -> {
			if (o1.getYear() > o2.getYear())
				return 1;
			else if (o1.getYear() < o2.getYear())
				return -1;
			else if (o1.getMonth() > o2.getMonth())
				return 1;
			else if (o1.getMonth() < o2.getMonth())
				return -1;
			else
				return Integer.compare(o1.getDay(), o2.getDay());

		};
		System.out.println(com.compare(new MyDate(2012, 1, 1), new MyDate(2013, 5, 1)));

	}

	// 测试方法二
	@Test
	public void test2() {
		BiPredicate<MyDate, MyDate> bp = (o1, o2) -> o1.equals(o2);
		System.out.println(bp.test(new MyDate(2012, 1, 1), new MyDate(2012, 1, 1)));
	}

	// 测试方法三
	@Test
	public void test3() {
		Function<MyDate, String> fun = d -> d.getYear() + "年" + d.getMonth() + "月" + d.getDay() + "日";
		System.out.println(fun.apply(new MyDate(2017, 9, 1)));
	}
}
