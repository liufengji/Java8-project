package com.yinggu.demo15;
/*
 * @author 黑猴子的家 
 * http://www.121ugrow.com/
 */
public class Man {

	private Girl girl;

	@Override
	public String toString() {
		return "Man 心里住了一个 ：[girl=" + girl + "]";
	}

	public Girl getGirl() {
		return girl;
	}

	public void setGirl(Girl girl) {
		this.girl = girl;
	}

	public Man(Girl girl) {
		super();
		this.girl = girl;
	}

	public Man() {
		super();
	}

}
