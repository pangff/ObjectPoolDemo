package com.pangff.objectpooldemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	StringBuffer stringBuffer = new StringBuffer();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void initDataCommon(View view){
		for(int i=0;i<100;i++){
			User user = new User();
			user.name = stringBuffer.append("name:").append(i).toString();
			stringBuffer.setLength(0);
			user.id = stringBuffer.append("id:").append(i).toString();
			
			Log.d("objectPoolDemo", "user-hashcode:"+user.hashCode());
		}
	}
	
	public void initDataByPool(View view){
		for(int i=0;i<100;i++){
			//从对象池中获取，第一次对象池没有，会直接new一个,如果有会复用
			User user = User.obtain();
			user.name = stringBuffer.append("name:").append(i).toString();
			stringBuffer.setLength(0);
			user.id = stringBuffer.append("id:").append(i).toString();
			//TODO 进行user的使用
			Log.d("objectPoolDemo", "user-hashcode:"+user.hashCode());
			//使用完毕务必要将对象归还到对象池
			user.recycle();
		}
	}

}
