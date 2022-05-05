package com.scrappers.hellokotlin

import com.jme3.app.SimpleApplication
import com.jme3.asset.AssetKey
import com.jme3.material.Material
import com.jme3.math.ColorRGBA
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Sphere

/**
 * **Your Actual Jme Game class.**
 * <br></br>
 * To use it inside Android :
 *
 *  1. Create an instance of it inside the #[MainActivity]
 *  1. Set that instance using #[com.jme3.app.jmeSurfaceView.JmeSurfaceView.setLegacyApplication]
 *  1. Start the game using #[com.jme3.app.jmeSurfaceView.JmeSurfaceView.startRenderer]
 *
 *
 * @author pavl_g
 */
class MyGame : SimpleApplication() {
    override fun simpleInitApp() {
        flyByCamera.isDragToRotate = false
        val mySphere = Sphere(10, 50, 50F)
        val geometry = Geometry("ball", mySphere)
        geometry.setLocalScale(0.05f)
        val material =
            Material(assetManager.loadAsset(AssetKey("Common/MatDefs/Misc/Unshaded.j3md")))
        material.setColor("Color", ColorRGBA.randomColor().mult(2f))
        geometry.material = material
        rootNode.attachChild(geometry)
    }
}