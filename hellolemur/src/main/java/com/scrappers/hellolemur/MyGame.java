package com.scrappers.hellolemur;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetKey;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;
import com.simsilica.lemur.Button;
import com.simsilica.lemur.Container;
import com.simsilica.lemur.GuiGlobals;
import com.simsilica.lemur.Insets3f;
import com.simsilica.lemur.Label;
import com.simsilica.lemur.component.QuadBackgroundComponent;
import com.simsilica.lemur.component.TbtQuadBackgroundComponent;
import com.simsilica.lemur.style.Attributes;
import com.simsilica.lemur.style.Styles;

/**
 * Shows a lemur example on android.
 *
 * @author pavl_g
 */
public final class MyGame extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        flyCam.setEnabled(false);
        final Sphere mySphere = new Sphere(10, 50, 50);
        final Geometry geometry = new Geometry("ball", mySphere);
        geometry.setLocalScale(0.05f);
        final Material material = new Material(assetManager.loadAsset(new AssetKey<>("Common/MatDefs/Misc/Unshaded.j3md")));
        material.setColor("Color", ColorRGBA.randomColor().mult(2f));
        geometry.setMaterial(material);
        rootNode.attachChild(geometry);

        GuiGlobals.initialize(this);

        // Create a simple container for our elements
        final Container myWindow = new Container();
        // Put it somewhere that we will see it.
        // Note: Lemur GUI elements grow down from the upper left corner.
        myWindow.setLocalTranslation(300, 300, 0);
        myWindow.setLocalScale(5,5,5);

        guiNode.attachChild(myWindow);

        // Add some elements
        myWindow.addChild(new Label("Hello, World."));

        final Button clickMe = myWindow.addChild(new Button("Click Me"));
        clickMe.addClickCommands(source -> ((Label)myWindow.getChild(0)).setText("Hey"));

        final Styles styles = GuiGlobals.getInstance().getStyles();
        final QuadBackgroundComponent bg = new QuadBackgroundComponent(ColorRGBA.randomColor());

        final float guiScale = 10.0f;
        final TbtQuadBackgroundComponent gradient = TbtQuadBackgroundComponent.create(
                "/com/simsilica/lemur/icons/bordered-gradient.png",
                // "Textures/Gui/radial-gradient.png",
                1, 1, 1, 126, 126,
                1f,false);
        final Attributes attrs = styles.getSelector("button", "glass");
        // button
        attrs.set("color", new ColorRGBA(0.8f, 0.9f, 1.0f, 0.85f));
        attrs.set("background", gradient.clone());
        ((TbtQuadBackgroundComponent)attrs.get("background")).setColor(new ColorRGBA(0.0f, 0.75f, 0.75f, 0.5f));
        attrs.set("insets", new Insets3f(2 * guiScale,2 * guiScale,2 * guiScale,2 * guiScale));

        myWindow.setBackground(bg);
    }
}
