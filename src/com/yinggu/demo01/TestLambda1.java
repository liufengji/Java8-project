package com.yinggu.demo01;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 此类用于演示Lambda表达式的使用
 * 
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 */

public class TestLambda1 {

	// 没有使用Lambda表达式
	@Test
	public void test1() {
		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});

		ts.add("DD");
		ts.add("BB");
		ts.add("AA");
		ts.add("CC");

		System.out.println(ts);
	}

	// 使用Lambda表达式
	@Test
	public void test2() {

		TreeSet<String> ts = new TreeSet<>((o1, o2) -> o2.compareTo(o1));

		ts.add("DD");
		ts.add("BB");
		ts.add("AA");
		ts.add("CC");

		System.out.println(ts);
	}

}