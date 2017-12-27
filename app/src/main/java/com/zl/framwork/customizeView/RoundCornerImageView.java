package com.zl.framwork.customizeView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.zl.framwork.BaseApplication;
import com.zl.framwork.R;
import com.zl.framwork.utils.Util;

/**
 * 带圆角的用户头像图片
 */
public class RoundCornerImageView extends AbsShapeImageView{

	private int DEF_RADIUS = Util.dip2px(BaseApplication.myApplication, 10);
	private float mRadius = DEF_RADIUS;
	private float[] radiis;

	public RoundCornerImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}

	public RoundCornerImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}

	private void init(AttributeSet attrs) {
		TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.CornerRadiusStyle);
		mRadius = ta.getDimension(R.styleable.CornerRadiusStyle_corner_radius, DEF_RADIUS);
		ta.recycle();
		radiis = new float[]{mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius};
	}

	public void setRadius(float radius){
		mRadius = radius;
	}

	public float getRadius(){
		return mRadius;
	}

	public void setFullRadius(float[] radiis){
		this.radiis = radiis.clone();
	}

	@Override
	protected void drawCustomShape(Canvas canvas, RectF rectF, Paint paint) {
		Path path = new Path();
		path.addRoundRect(rectF, radiis, Path.Direction.CCW);
		canvas.drawPath(path, paint);
	}

	@Override
	protected void drawCustomBorder(Canvas canvas, RectF borderRectF,
									float borderWidth, Paint borderPaint) {
		Path path = new Path();
		path.addRoundRect(borderRectF, radiis, Path.Direction.CCW);
		canvas.drawPath(path, borderPaint);
	}
}
