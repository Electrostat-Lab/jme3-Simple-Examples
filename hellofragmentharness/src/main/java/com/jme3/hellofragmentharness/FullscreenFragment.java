package com.jme3.hellofragmentharness;

import android.app.Fragment;
import android.app.FragmentTransaction;
import com.jme3.app.AndroidHarnessFragment;
import java.util.Objects;

/**
 * An Example class of #{@link AndroidHarnessFragment} to render a jme game #{@link MyGame} using a #{@link android.app.Fragment}
 * <br>
 * Steps :
 * <ol>
 * <li>Create a constructor of our class #{@link FullscreenFragment}</li>
 * <li>Specify the #{@link AndroidHarnessFragment#appClass} class directory using #{@link Class#getName()}</li>
 * <li>Feed an instance of #{@link FullscreenFragment} inside a #{@link android.app.FragmentTransaction#replace(int, Fragment)} with the id of the container view</li>
 * <li>Call #{@link FragmentTransaction#commit()} to commit the updates</li>
 * </ol>
 *
 * @author pavl_g
 */
public class FullscreenFragment extends AndroidHarnessFragment {
    public FullscreenFragment(){
        /*get the jme class dir*/
        appClass = Objects.requireNonNull(MyGame.class).getName();
    }
}