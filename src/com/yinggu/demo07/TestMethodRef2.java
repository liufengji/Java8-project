package com.yinggu.demo07;


import org.junit.Test;

/**
 * 
 * @author 黑猴子的家 
 * http://www.121ugrow.com/
 */
public class TestMethodRef2 {

	@Test
	public void testA() {
		// 使用匿名内部类
		A a = new A() {
			@Override
			public void method1() {
				new MyClass().run();
			}
		};
		a.method1();
		// 方法引用
		A a2 = new MyClass()::run;
	}
	
	@Test
	public void testB() {
		// 使用匿名内部类
		B<Integer> b = new B<Integer>() {
			@Override
			public void method2(Integer t1, Integer t2) {
				MyClass.cale(t1, t2);
			}
		};
		// 使用方法引用
		B<Integer> b2 = MyClass::cale;
	}
	
	@Test
	public void testC() {
		// 测试一
		// 使用匿名内部类
		C<Double, Double> c = new C<Double, Double>() {
			@Override
			public Double method3(Double t1, Double t2, Double t3) {
				return MyClass.sum(t1, t2, t3);
			}
		};
		// 使用方法引用
		C<Double, Double> c2 = MyClass::sum;
		// 测试二
		// 使用匿名内部类
		C<Double, String> c3 = new C<Double, String>() {
			@Override
			public String method3(Double t1, Double t2, Double t3) {
				return new MyClass().concat(t1, t2, t3);
			}
		};
		// 使用方法引用
		C<Double, String> c4 = new MyClass()::concat;
	}
	
	@Test
	public void testD() {
		// 使用匿名内部类
		D<Integer, String> d = new D<Integer, String>() {
			@Override
			public String method4(Integer... ts) {
				return new MyClass().max(ts);
			}
		};
		// 方法引用
		D<Integer, String> d2 = new MyClass()::max;
	}
}

class MyClass {
	
	public void run() {
		System.out.println("跑啊跑啊");
	}

	public static void cale(int a, int b) {
		System.out.println(a + b);
	}

	public static double sum(double d1, double d2, double d3) {
		return d1 + d2 + d3;
	}

	public String concat(double d1, double d2, double d3) {
		return "hi:" + d1 + d2 + d3;
	}

	public String max(Integer... is) {
		int max = is[0];
		for (int i = 0; i < is.length; i++) {
			if (max < is[i])
				max = is[i];
		}
		return "最大值：" + max;
	}
}

//没有参数-无返回
interface A {
	void method1();
}

//两个参数-无返回
interface B<T> {
	void method2(T t1, T t2);
}

//三个参数-有返回
interface C<T, R> {
	R method3(T t1, T t2, T t3);
}

//可变参数-有返回
interface D<T, R> {
	R method4(@SuppressWarnings("unchecked") T... ts);
}
