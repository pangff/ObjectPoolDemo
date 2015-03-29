package com.pangff.objectpooldemo;

import android.support.v4.util.Pools.SynchronizedPool;

public class User {

	public String id;
	public String name;

	private static final SynchronizedPool<User> sPool = new SynchronizedPool<User>(
			10);

	public static User obtain() {
		User instance = sPool.acquire();
		return (instance != null) ? instance : new User();
	}

	public void recycle() {
		sPool.release(this);
	}
}
