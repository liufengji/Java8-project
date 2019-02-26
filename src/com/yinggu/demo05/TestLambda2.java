package com.yinggu.demo05;


import java.util.function.BiPredicate;

import org.junit.Test;

import com.yinggu.domain.Book;

/**
 * 
 * 测试方法二：书名、作者、价格一样，则为两本书相等
 
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 **/
public class TestLambda2 {
	@SuppressWarnings("unused")
	@Test
	public void test2() {
		Book b1 = new Book("红楼梦", "曹雪芹", 100);
		// Book b2 = new Book("西游记","吴承恩",23);
		Book b2 = new Book("红楼梦", "曹雪芹", 100);
		
		BiPredicate<Book, Book> pre = new BiPredicate<Book, Book>() {
			@Override
			public boolean test(Book t, Book u) {
				return t.getAuthor().equals(u.getAuthor()) && t.getName().equals(u.getName())
						&& t.getPrice() == u.getPrice();
			}
		};
		System.out.println("--------------------------------------------------");
		BiPredicate<Book, Book> pre1 = (t, u) -> t.getAuthor().equals(u.getAuthor()) && t.getName().equals(u.getName())
				&& t.getPrice() == u.getPrice();

		System.out.println(pre1.test(b1, b2));

	}
}