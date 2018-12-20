package com.zxjaihhl.yds.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.zxjaihhl.yds.R;
import com.zxjaihhl.yds.utils.SharedUtils;

/**
 * Created by Administrator on 2017/9/18.
 * 描述：
 */

public class BatteryView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private Paint paintS, paintF;
    private int bwidth;
    private int bheight;
    int varyInnerWidth;
    private int bColor, cColor, backgroundColor;
    private float bRadius;
    private RectF SrectF, FrectF;
    private Thread thread;
    private SurfaceHolder surfaceHolder;
    private Canvas canvas;
    private boolean isThreadRunning = true;
    private int distance;
    private int centerX, centerY;
    private int battery, full = 100;

    public BatteryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public BatteryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BatteryView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        SrectF = new RectF();
        FrectF = new RectF();
        distance = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getContext().getResources().getDisplayMetrics());
        TypedArray attrArray = getContext().obtainStyledAttributes(attrs, R.styleable.BatteryLoadingView);
        if (attrArray != null) {
            bwidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70, getContext().getResources().getDisplayMetrics());
            bheight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getContext().getResources().getDisplayMetrics());
            bwidth = attrArray.getDimensionPixelSize(R.styleable.BatteryLoadingView_outBWidth, bwidth);
            bheight = attrArray.getDimensionPixelSize(R.styleable.BatteryLoadingView_outBHeight, bheight);
            bColor = attrArray.getColor(R.styleable.BatteryLoadingView_bColor, Color.BLACK);
            cColor = attrArray.getColor(R.styleable.BatteryLoadingView_cColor, Color.GREEN);
            backgroundColor = attrArray.getColor(R.styleable.BatteryLoadingView_backgroundColor, Color.WHITE);
            bRadius = attrArray.getFloat(R.styleable.BatteryLoadingView_bRadius, 9f);
            attrArray.recycle();
        }
        initPaint();


    }

    private void initPaint() {
        paintS = new Paint();
        paintF = new Paint();
        paintS.setColor(bColor);
        paintF.setColor(cColor);
        paintS.setStyle(Paint.Style.FILL);
        paintF.setStyle(Paint.Style.FILL);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new Thread(this);
        thread.start();
        isThreadRunning = true;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        varyInnerWidth = 0;

        centerX = getMeasuredWidth() / 2;
        centerY = getMeasuredHeight();


        SrectF.left = centerX - bwidth / 2;
        SrectF.top = centerY - bheight;
        SrectF.right = centerX + bwidth / 2;
        SrectF.bottom = centerY;

        FrectF.left = SrectF.left;
        FrectF.right = SrectF.right;
        FrectF.bottom = SrectF.bottom;


    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isThreadRunning = false;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        if (modeWidth == MeasureSpec.AT_MOST || modeWidth == MeasureSpec.UNSPECIFIED) {
            sizeWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bwidth, getContext().getResources().getDisplayMetrics());
            sizeWidth += getPaddingLeft() + getPaddingRight();
        }
        if (modeHeight == MeasureSpec.AT_MOST || modeHeight == MeasureSpec.UNSPECIFIED) {
            sizeHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bheight, getContext().getResources().getDisplayMetrics());
            sizeHeight += getPaddingBottom() + getPaddingTop();
        }

        setMeasuredDimension(sizeWidth, sizeHeight);

    }


    private void drawView(Canvas canvas) {

        canvas.drawColor(backgroundColor);

        canvas.drawRoundRect(SrectF, 10, 10, paintS);

        canvas.drawRect(centerX - bwidth / 2 + 50, centerY - bheight, centerX + bwidth / 2 - 50, centerY - bheight - 10, paintS);

//        FrectF.right =  FrectF.left+varyInnerWidth;
        //满电量
//       FrectF.right =centerX+bwidth/2-distance*I2  ;
        //空电量
//         FrectF.right = centerX - bwidth / 2;
        battery = SharedUtils.getInt(getContext(), "battery_pc", full);

        FrectF.top = centerY - (bheight / 100) * battery;
        canvas.drawRoundRect(FrectF, 10, 10, paintF);


//        if (SrectF.left + varyInnerWidth > centerX + bwidth / 2 - distance * 2) {
//            varyInnerWidth = centerX + bwidth / 2 - distance * 2;
//        } else if (SrectF.left + varyInnerWidth == centerX + bwidth / 2 - distance * 2) {
//            varyInnerWidth = 0;
//        } else {
//            varyInnerWidth += 2;
//        }


    }


    @Override
    public void run() {
        while (isThreadRunning) {
            canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                drawView(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
            try {
                Thread.sleep(40); // 相当于帧频了，数值越小画面就越流畅
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
