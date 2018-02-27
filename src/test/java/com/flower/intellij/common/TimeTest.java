package com.flower.intellij.common;

import org.junit.Test;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author wanli zhou
 * @created 2018-02-04 11:17 PM.
 */
public class TimeTest {

	@Test
	public void timeTst() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.parse("12:31:39", new ParsePosition(0)));
	}

	@Test
	public void timerTest() {
		Timer timer = new Timer();//实例化Timer类
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("退出1" + System.currentTimeMillis());
				this.cancel();
			}
		}, 500);//五百毫秒
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("退出2" + System.currentTimeMillis());
				this.cancel();
			}
		}, 1000);//五百毫秒
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("退出3" + System.currentTimeMillis());
				this.cancel();
			}
		}, 1500);//五百毫秒
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("退出4" + System.currentTimeMillis());
				this.cancel();
			}
		}, 2500);//五百毫秒

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
