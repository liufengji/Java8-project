package com.yinggu.demo09;

import java.util.function.Function;

import org.junit.Test;

/**
 * @author 黑猴子的家 
 * http://www.121ugrow.com/
 * 
 * 此类用于演示数组引用
 * 特点：
 * 		代替一部分具有特殊 要求的Lambda 表达式
 * 要求：
 * 		1.方法的实现中仅仅只有一个return语句
 * 		2.return 的只能是 一个数组对象
 * 		3.函数式接口的抽象方法的参数列表=数组参数类型+数组类型
 * 
 * 语法：
 * 		数组类型[]::new
 */
public class TestArrayRef {
	
	@Test 
	public void test1() {
		
		//Lambda
		Function<Integer,Integer[]> fun = (i) -> new Integer[i];
		
		//数组引用
		Function<Integer,Integer[]> fun2 = Integer[]::new;
		
		
		//Lambda
		Function<Integer,String[]> fun3 = (i) -> new String[i];
		
		//数组引用
		Function<Integer,String[]> fun4 = String[]::new;

	}

}
