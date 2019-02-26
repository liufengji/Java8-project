package com.yinggu.demo05;


import org.junit.Test;

import com.yinggu.domain.Book;

/**
 * 
 * 创建Book类，里面有书名、作者、价格属性，并对其进行合理封装 定义测试类，提供测试方法（要求用上Lambda表达式）
 * 测试方法一：比较两本书大小，先判断价格，价格相等，判断书名 
 * 
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 **/

interface MyCompare<T> {
	int compare(T t1, T t2);
}

public class TestLambda1 {

	@Test
	public void test1() {
		Book b1 = new Book("红楼梦", "曹雪芹", 100);
		Book b2 = new Book("西游记", "吴承恩", 23);
		compareBook(b1, b2, (o1, o2) -> {
			if (o1.getPrice() > o2.getPrice())
				return 1;
			else if (o1.getPrice() < o2.getPrice())
				return -1;
			else
				return o1.getName().compareTo(o2.getName());
		});

	}

	public void compareBook(Book b1, Book b2, MyCompare<Book> com) {
		System.out.println(com.compare(b1, b2));
	}

}

