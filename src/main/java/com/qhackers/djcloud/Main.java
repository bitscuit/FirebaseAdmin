package com.qhackers.djcloud;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.google.firebase.auth.FirebaseAuth;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("hello world");
		FirebaseAuthUtil auth = new FirebaseAuthUtil();
		FirebaseUtility f = new FirebaseUtility();
		f.readDataOnce("PartyList", (data) -> {
			System.out.println(data);
		});
		f.readDataOnce("admin", Main::myPrint);
		f.listenForValueChanges("admin", Main::myPrint);
		System.out.println("end");
		boolean test = ("added, changed, removed, added".contains("removed")) ? true : false;
		System.out.println(test);
		// FirebaseAuthUtil auth2 = new FirebaseAuthUtil();
		new CountDownLatch(1).await(5L, TimeUnit.SECONDS);
	}

	public static void myPrint(String s) {
		System.out.println("my printing method");
		System.out.println(s);
	}

}