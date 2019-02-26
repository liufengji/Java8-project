package com.yinggu.demo01;

import org.junit.Test;

/**
 * 此类用于演示Lambda表达式的语法 ★
 * (o1,o2)->o2.compareTo(o1)
 * (e) -> e.getAge() > 30
 * 一、语法
 * (参数名1,...)->{方法主体}
 * 注意：
 * 1、当只有一个参数时，可以省略小括号，如果有多个参数，需要加上小括号
 * 2、方法体的语句需要用大括号包起来，但如果只有一句话，则可以省略大括号
 * 如果仅有的一句话还是return语句，则return 也可以省略
 * 
 * 二、概念
 * Lambda表达式相当于匿名内部类，赋值给一个接口
 * Runnable run = (参数名1,...)->{方法主体}
 * 
 * 三、分类
 * 函数式接口中的方法分类：
 * （1）无返回-无参
 * （2）无返回-有参数
 * （3）有返回-有参数
 */
/**
 * @FunctionalInterface 判断是否是函数式接口
 */

// 无返回有1个参数
@FunctionalInterface
interface I1 {
	void play(String str);
}

//判断是否是函数式接口
//@FunctionalInterface
//interface I4 {
//	void start();
//	void stop();
//}

// 无返回有2个参数
interface I2 {
	void play(String str1, String str2);
}

// 有返回有2个参数
interface I3<T, R> {
	R cale(T t1, T t2);
}

public class TestLambda3 {

	// 1、无返回无参
	@Test
	public void test1() {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("1 阿甘跑啊跑啊！！！");
				System.out.println("2 阿甘跑啊跑啊！！！");
				System.out.println("3 阿甘跑啊跑啊！！！");
			}
		};
		r.run();
		System.out.println("------------------------");
		// 返回肯定是Runnable类型，所以 new Runnable()代码冗余了
		// 类似于 枚举的 public static 使用了enum 关键字 直接省略了，都是一个优化的过程
		Runnable r1 = () -> {
			System.out.println("1 阿甘跑啊跑啊！！！");
			System.out.println("2 阿甘跑啊跑啊！！！");
			System.out.println("3 阿甘跑啊跑啊！！！");
		};
		r1.run();
	}

	// 2、无返回有参,一个参数
	@Test
	public void test2() {
		I1 i = new I1() {
			@Override
			public void play(String str1) {
				System.out.println("我喜欢玩" + str1);
			}
		};
		i.play("足球");
		System.out.println("-------------------------");
		I1 i1 = (str1) -> System.out.println("我喜欢玩" + str1);
		// I1 i1 = str1 -> System.out.println("我喜欢玩" + str1);
		i1.play("足球");
	}

	// 3、无返回有参,两个参数
	@Test
	public void test3() {
		I2 i = new I2() {
			@Override
			public void play(String str1, String str2) {
				System.out.println("我喜欢玩" + str1 + "和" + str2);
			}
		};
		i.play("足球", "篮球");
		System.out.println("-------------------------");
		I2 i1 = (str1, str2) -> System.out.println("我喜欢玩" + str1 + "和" + str2);
		i1.play("足球", "篮球");
	}

	// 4、有返回有参
	@Test
	public void test4() {
		I3<Double, Integer> i = new I3<Double, Integer>() {
			@Override
			public Integer cale(Double t1, Double t2) {
				return (int) (t1 + t2);
			}
		};
		System.out.println(i.cale(1.5, 2.6));
		System.out.println("------------------------");
		I3<Double, Integer> i2 = (Double t1, Double t2) -> (int) (t1 + t2);
		System.out.println(i2.cale(2.2, 3.3));
	}

}
