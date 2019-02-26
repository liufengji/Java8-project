package com.yinggu.demo04;

import org.junit.Test;

/**
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 *
 * (1) 声明函数式接口，接口中声明抽象方法：public String getValue(String str);
 * (2) 声明类LambdaTest，类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为方法的返回值。
 * (3) 再将一个字符串的第2个到第4个索引位置进行截取子串。    
 **/

@FunctionalInterface
interface ValueInterface {
	String getValue(String str);
}

public class TestLambda2 {
	
	@Test
	public void test2() {
		// 将一个字符串转换成大写，并作为方法的返回值。
		method("hello", str -> str.toUpperCase());
		// 一个字符串的第2个到第4个索引位置进行截取子串。
		method("我爱你北京", str -> str.substring(1, 4)); 
	}
	
	public void method(String str, ValueInterface vi) {
		System.out.println(vi.getValue(str));
	}
}
