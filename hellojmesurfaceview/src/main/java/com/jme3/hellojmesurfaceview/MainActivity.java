package com.jme3.hellojmesurfaceview;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jme3.app.LegacyApplication;
import com.jme3.app.jmeSurfaceView.JmeSurfaceView;
import com.jme3.app.jmeSurfaceView.OnExceptionThrown;
import com.jme3.app.jmeSurfaceView.OnRendererCompleted;
import com.jme3.system.AppSettings;

import androidx.appcompat.app.AppCompatActivity;

/**
 * <b>NB: Please Open this example <u>root module</u> using Android Studio; because android build scripts are different from java builds.</b>
 * <br/>
 * An Android Example that demonstrates : How to use a simple game#{@link MyGame}
 * on #{@link com.jme3.app.jmeSurfaceView.JmeSurfaceView} inside an #{@link androidx.appcompat.app.AppCompatActivity}.
 * <br>
 * <b>Note : use #{@link AppCompatActivity#setRequestedOrientation(int)} & #{@link ActivityInfo#SCREEN_ORIENTATION_LANDSCAPE} for LandScape mode or specify that under the <activity> activity tag xml.</b>
 *
 * @author pavl_g
 */
public final class MainActivity extends AppCompatActivity implements OnRendererCompleted, OnExceptionThrown {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        /*define the android view with it's id from xml*/
        final JmeSurfaceView jmeSurfaceView = findViewById(R.id.jmeSurfaceView);
        /*set the jme game*/
        jmeSurfaceView.setLegacyApplication(new MyGame());
        jmeSurfaceView.setOnExceptionThrown(this);
        jmeSurfaceView.setOnRendererCompleted(this);
        /*start the game*/
        jmeSurfaceView.startRenderer(JmeSurfaceView.NO_DELAY);
    }

    /**
     * Fired when exception/error/(concretes of #{@link Throwable} class) is thrown.
     *
     * @param e the thrown error or exception
     */
    @Override
    public void onExceptionThrown(Throwable e) {
        Toast.makeText(MainActivity.this, "User's Delay Finished w/ exception : " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    /**
     * Fired when the user delay in ms is up #{@link JmeSurfaceView#startRenderer(int)}.
     *
     * @param application the current jme game instance
     * @param appSettings the current game settings
     */
    @Override
    public void onRenderCompletion(LegacyApplication application, AppSettings appSettings) {
        Toast.makeText(MainActivity.this, "User's Delay Finished w/o errors !" + application.getContext() + " " + appSettings.getFrameRate(), Toast.LENGTH_SHORT).show();
    }

    /**
     * Fired when the screen has/hasNo touch/mouse focus.
     *
     * @param hasFocus specify whether the current screen has focus or not
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        /*get the view from the current activity*/
        final View decorView = MainActivity.this.getWindow().getDecorView();
        /*hide navigation bar, apply fullscreen, hide status bar, immersive sticky to disable the system bars(nav & status) from showing up when user wipes the screen*/
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}