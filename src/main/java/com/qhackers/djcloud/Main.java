package com.qhackers.djcloud;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("hello world");
		FirebaseUtility f = new FirebaseUtility();
		f.readDataOnce("admin", (data) -> {
			System.out.println(data);
		});
		System.out.println("end");
		new CountDownLatch(1).await(5L, TimeUnit.SECONDS);
	}

}