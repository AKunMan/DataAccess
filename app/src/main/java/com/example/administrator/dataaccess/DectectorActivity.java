package com.example.administrator.dataaccess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class DectectorActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dectector);

        gestureDetector = new GestureDetector(this,this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        toastMessage("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        toastMessage("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        toastMessage("onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        toastMessage("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        toastMessage("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        toastMessage("onFling");
        return false;
    }
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
