package com.jme3.helloandroidharness;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetKey;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.debug.WireSphere;

/**
 * <b>Your JmeGame class</b>
 *
 * @author pavl_g
 */
public class MyGame extends SimpleApplication {
    @Override
    public void simpleInitApp() {
        WireSphere wireSphere=new WireSphere(50);
        Geometry geometry = new Geometry("wireSphere", wireSphere);
        geometry.setLocalScale(0.05f);
        Material material = new Material(assetManager.loadAsset(new AssetKey<>("Common/MatDefs/Misc/Unshaded.j3md")));
        material.setColor("Color", ColorRGBA.randomColor().mult(2f));
        geometry.setMaterial(material);
        rootNode.attachChild(geometry);
    }
}
