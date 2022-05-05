package com.jme3.helloandroidharness;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;

import androidx.annotation.Nullable;

import com.jme3.app.AndroidHarness;

import java.util.Objects;

/**
 * <b>NB: Please Open this example <u>root module</u> using Android Studio; because android build scripts are different from java builds.</b>
 * <br>
 * An Example Class that demonstrates the usage of #{@link AndroidHarness} to render a jme game inside android.
 * <br>
 * Steps :
 * <ol>
 * <li>Create a class extending #{@link AndroidHarness} as your #{@link android.app.Activity} class that holds the #{@link android.opengl.GLSurfaceView}
 * with its #{@link android.opengl.GLSurfaceView.Renderer} to render a jme game</li>
 * <li>Specify the directory of your game class package inside #{@link AndroidHarness#appClass} using #{@link Class#getName()}</li>
 * <li>That's it, and magic comes into play :-)</li>
 * </ol>
 *
 * @author pavl_g
 */
public final class MainActivity extends AndroidHarness {
    public MainActivity() {
        /*get the jme class dir*/
        appClass = Objects.requireNonNull(MyGame.class.getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.err.println("OnDestroy invoked");
    }
}