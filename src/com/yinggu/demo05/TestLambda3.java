package com.yinggu.demo05;

import java.util.function.Function;

import org.junit.Test;

import com.yinggu.domain.Book;

/**
 * 测试方法三：根据传入的Book对象，打印有效的格式 这本书叫x，作者是xx，价格为xx.
 * 
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 **/
public class TestLambda3 {

	@Test
	public void test3() {
		Function<Book, String> fun = b -> "这本书：" + b.getName() + ",作者是：" + b.getAuthor() + ",价格为：" + b.getPrice();
		Book b1 = new Book("红楼梦", "曹雪芹", 100);
		System.out.println(fun.apply(b1));
	}
}


