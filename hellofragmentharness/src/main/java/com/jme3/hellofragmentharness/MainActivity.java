package com.jme3.hellofragmentharness;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

/**
 * <b>NB: Please Open this example <u>root module</u> using Android Studio; because android build scripts are different from java builds.</b>
 * <br/>
 * An Android Example that demonstrates : How to use a simple game#{@link MyGame}
 * on #{@link com.jme3.app.AndroidHarnessFragment} inside an #{@link androidx.appcompat.app.AppCompatActivity} using the #{@link FragmentManager} of the Activity context.
 *
 * @author pavl_g
 */
public final class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*get the fragment support manager of this activity context*/
        final FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        /*replace the previous fragment w/ the new one & commit the change*/
        fragmentTransaction.replace(R.id.jmeContainer, new FullscreenFragment()).commit();
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