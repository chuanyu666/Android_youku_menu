package com.example.youku_menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener {

	private ImageView iv_home;
	private ImageView iv_menu;

	private RelativeLayout ll_level1;
	private RelativeLayout ll_level2;
	private RelativeLayout ll_level3;
	private boolean isLevel3Show = true;
	private boolean isLevel2Show = true;
	private boolean isLevel1Show = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		iv_home = (ImageView) findViewById(R.id.iv_home);
		iv_menu = (ImageView) findViewById(R.id.iv_menu);
		ll_level1 = (RelativeLayout) findViewById(R.id.ll_level1);
		ll_level2 = (RelativeLayout) findViewById(R.id.ll_level2);
		ll_level3 = (RelativeLayout) findViewById(R.id.ll_level3);

		iv_home.setOnClickListener(this);
		iv_menu.setOnClickListener(this);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_MENU){
			if(isLevel1Show ){
				AnimationUtils.startAnimOut(ll_level1);
				isLevel1Show = false;
				if(isLevel2Show ){
					AnimationUtils.startAnimOut(ll_level2,200);
					isLevel2Show = false;
					if(isLevel3Show){
						AnimationUtils.startAnimOut(ll_level3,400);
						isLevel3Show = false;
					}
				}
			}else{
				AnimationUtils.startAnimIn(ll_level1);
				isLevel1Show = true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_home:
			if(isLevel2Show ){
				AnimationUtils.startAnimOut(ll_level2);
				isLevel2Show = false;
				if(isLevel3Show){
					AnimationUtils.startAnimOut(ll_level3,200);
					isLevel3Show = false;
				}
			}else{
				AnimationUtils.startAnimIn(ll_level2);
				isLevel2Show = true;
			}
			break;
		case R.id.iv_menu:
			if(isLevel3Show ){
				AnimationUtils.startAnimOut(ll_level3);
			}else{
				AnimationUtils.startAnimIn(ll_level3);
			}
			isLevel3Show = !isLevel3Show;
			break;
		}
	}

}
