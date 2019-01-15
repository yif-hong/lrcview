package me.wcy.lrcviewsample;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class AnimationDemoView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "text size : ";
    float textSize = dpToSp(24);
    Animator animator = ObjectAnimator.ofFloat(this, "textSize", dpToSp(24), dpToSp(48), dpToSp
            (24));


    public AnimationDemoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        animator.setInterpolator(new DecelerateInterpolator());
        postDelayed(() -> animator.setDuration(5000).start(), 2000);
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
        invalidate();
    }

    private float dpToSp(int dp) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return dp * displayMetrics.density;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setTextSize(textSize);
        paint.setColor(Color.BLACK);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text + (int) textSize, getWidth() / 2, getHeight() / 2, paint);
    }
}
