package com.scrappers.hellokotlin

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jme3.app.LegacyApplication
import com.jme3.system.AppSettings
import com.jme3.view.surfaceview.*

/**
 * Kotlin android example using jMonkeyEngine.
 *
 * @author pavl_g.
 */
class MainActivity : AppCompatActivity(), OnLayoutDrawn, OnRendererStarted, OnRendererCompleted,
    OnExceptionThrown {

    private lateinit var jmeSurfaceView: JmeSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        jmeSurfaceView = JmeSurfaceView(this)
        jmeSurfaceView.legacyApplication = MyGame()

        jmeSurfaceView.setOnRendererStarted(this)
        jmeSurfaceView.setOnLayoutDrawn(this)
        jmeSurfaceView.setOnRendererCompleted(this)
        jmeSurfaceView.setOnExceptionThrown(this)

        setContentView(jmeSurfaceView)

        jmeSurfaceView.startRenderer(400)

    }

    override fun onLayoutDrawn(legacyApplication: LegacyApplication?, layout: View?) {
    }

    override fun onRenderStart(application: LegacyApplication?, layout: View?) {
    }

    override fun onRenderCompletion(application: LegacyApplication?, appSettings: AppSettings?) {
    }

    override fun onExceptionThrown(e: Throwable?) {
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        /*get the view from the current activity*/
        val decorView = this@MainActivity.window.decorView
        /*hide navigation bar, apply fullscreen, hide status bar, immersive sticky to disable the system bars(nav and status) from showing up when user wipes the screen*/decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }
}