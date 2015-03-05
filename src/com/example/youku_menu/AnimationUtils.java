package com.example.youku_menu;

import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class AnimationUtils {

	public static void startAnimOut(RelativeLayout view) {
		/**
		 * 默认圆心为view的左上角
		 * 水平向右为0度
		 * 		360
		 * 180         0
		 * 		90
		 */
		
		RotateAnimation ra = new RotateAnimation(0, 180, view.getWidth()/2, view.getHeight());
		ra.setDuration(500);
		ra.setFillAfter(true);
		view.startAnimation(ra);
	}

	public static void startAnimIn(RelativeLayout view) {
		RotateAnimation ra = new RotateAnimation(180, 360, view.getWidth()/2, view.getHeight());
		ra.setDuration(500);
		ra.setFillAfter(true);
		view.startAnimation(ra);
	}

	public static void startAnimOut(RelativeLayout view, int offset) {
		RotateAnimation ra = new RotateAnimation(0, 180, view.getWidth()/2, view.getHeight());
		ra.setDuration(500);
		ra.setFillAfter(true);  //动画执行完成以后，保持最后状态
		ra.setStartOffset(offset);// 延时执行
		view.startAnimation(ra);		
	}

}
