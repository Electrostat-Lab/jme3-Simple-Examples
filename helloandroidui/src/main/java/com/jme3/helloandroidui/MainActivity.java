package com.jme3.helloandroidui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jme3.app.LegacyApplication;
import com.jme3.app.jmeSurfaceView.JmeSurfaceView;
import com.jme3.app.jmeSurfaceView.OnExceptionThrown;
import com.jme3.app.jmeSurfaceView.OnRendererCompleted;
import com.jme3.system.AppSettings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import static android.widget.Toast.LENGTH_LONG;

/**
 * <b>NB: Please Open this example <u>root module</u> using Android Studio; because android build scripts are different from java builds.</b>
 * <br/>
 * An Android Example that demonstrates :
 * <ul>
 * <li>How to use a simple game#{@link MyGame}
 * on #{@link JmeSurfaceView} inside an #{@link AppCompatActivity} with a SplashScreen #{@link CardView}</li>
 * <li>Use Android UI (Android Concrete classes of the #{@link View} hierarchy) with a Jme Game</li>
 * </ul>
 *
 * @author pavl_g
 */
public final class MainActivity extends AppCompatActivity implements OnRendererCompleted, OnExceptionThrown {

    private JmeSurfaceView jmeSurfaceView;
    private CardView splashScreen;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*define the android view with it's id from xml*/
        jmeSurfaceView = findViewById(R.id.jmeSurfaceView);
        /*display a splash screen*/
        splashScreen = new CardView(MainActivity.this);
        splashScreen.setLayoutParams(new RelativeLayout.LayoutParams(jmeSurfaceView.getLayoutParams().width, jmeSurfaceView.getLayoutParams().height));
        splashScreen.setBackground(ContextCompat.getDrawable(this, R.drawable.power2));
        jmeSurfaceView.addView(splashScreen);
        /*set the jme game*/
        jmeSurfaceView.setLegacyApplication(new MyGame());
        jmeSurfaceView.setOnExceptionThrown(this);
        jmeSurfaceView.setOnRendererCompleted(this);
        /*start the game, with delay for the splashScreen*/
        jmeSurfaceView.startRenderer(300);

        /*Handle other UI-Components parts*/
        final WebView webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(true);
        webView.loadUrl("https://jmonkeyengine.org/");
        /*an image and clickListener for demonstration*/
        findViewById(R.id.image).setOnClickListener((view) -> MainActivity.this.runOnUiThread(() -> Toast.makeText(MainActivity.this, "Hi Jme From UI !", LENGTH_LONG).show()));
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
        /*animate and remove the splashScreen UI Component*/
        splashScreen.animate().scaleY(0).scaleX(0).setDuration(500).withEndAction(() -> {
            /*set the other android views to be visible*/
            findViewById(R.id.webView).setVisibility(View.VISIBLE);
            findViewById(R.id.image).setVisibility(View.VISIBLE);
            /*dismiss the splash screen at the send of the animation*/
            jmeSurfaceView.removeView(splashScreen);
        }).start();
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
        /*hide navigation bar, apply fullscreen, hide status bar, immersive sticky to disable the system bars(nav and status) from showing up when user wipes the screen*/
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}