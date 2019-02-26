package com.yinggu.demo02;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 * 
 * 此类用于演示类型推断
 * 类型推断： 编译器根据上下文推断出对应的类型，开发人员不用手动的写上类型 
 */
public class TestTypeAna {
	
	@Test
	public void test1() {
		@SuppressWarnings("unused")
		List<String> list = new ArrayList<>();
	}

	@Test
	public void test2() {
		print(new HashMap<>());
	}

	public void print(Map<String, Integer> map) {

	}

}

