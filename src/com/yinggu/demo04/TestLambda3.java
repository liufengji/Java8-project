package com.yinggu.demo04;

import org.junit.Test;


/**
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 * 
 * (1) 声明一个带两个泛型的函数式接口，泛型类型为<T,R> : T 为参数，R 为返回值。
 * (2) 接口中声明对应抽象方法
 * (3) 在LambdaTest类中声明方法，使用接口作为参数，计算两个long型参数的和。
 * (4) 再计算两个long型参数的乘积    
 **/

@FunctionalInterface
interface CaleInterface<T, R> {
	R cale(T t1, T t2);
}

public class TestLambda3 {

	@Test
	public void test3() {
		// 1.计算两个long型参数的和。
		method(10L, 20L, (l1, l2) -> (double) (l1 + l2));
		// 2.计算两个long型参数的乘积
		method(10L, 20L, (l1, l2) -> (double) (l1 * l2));

	}
	
	public void method(Long l1, Long l2, CaleInterface<Long, Double> ci) {
		System.out.println(ci.cale(l1, l2));
	}
}
