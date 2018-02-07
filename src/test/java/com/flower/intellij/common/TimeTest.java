package com.flower.intellij.common;

import org.junit.Test;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

/**
 * @author wanli zhou
 * @created 2018-02-04 11:17 PM.
 */
public class TimeTest {

	@Test
	public void timeTst(){
		SimpleDateFormat sdf =  new SimpleDateFormat("HH:mm:ss" );
		System.out.println(sdf.parse("12:31:39", new ParsePosition(0)));
	}
}
