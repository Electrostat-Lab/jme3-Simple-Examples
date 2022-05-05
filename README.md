# jme3-Simple-Examples
Module based jMonkeyEngine Android Simple Gradle Examples.

## In this repository, you will find 5 modules : 

```gradle
include ':helloandroidui'
include ':hellofragmentharness'
include ':helloandroidharness'
include ':hellojmesurfaceview'
include ':hellokotlin'
```
| helloandroidharness | hellofragmentharness | hellojmesrufaceview | helloandroidui | hellokotlin |
|-------|------|-------|-------|-------|
| Tests jme game on an android activity `AndroidHarness` | Tests jme game on an android fragment `AndroidFragmentHarness` | Tests jme game on a custom android view `JmeSurfaceView` | Tests jme game on a surface view with some android ui usages showing best practice | Tests jme game using kotlin android plugin |

## Quick start guide using android studio IDE : 
1) Clone the repository.
2) Open android studio (any version would be fine) and `Get from version control` : 
![image](https://user-images.githubusercontent.com/60224159/163730625-997ee9fa-f398-49f4-a78a-1f90d7feb97e.png)
3) To test on physical device : connect your physical device and use the developer options to enable adb via usb debugging, you can refer to use 
guide for more on devdloper options : https://developer.android.com/studio/debug/dev-options#debugging
4) To test on an emulator, android launches the selected emulator directly when you run an app module.
5) When opening android studio, you will find these modules, select a module and run : 
![image](https://user-images.githubusercontent.com/60224159/163730853-42410b2d-939b-45d3-8a6b-3632d90bc54e.png)
6) Congrats ! Now you can play around with android and jMonkeyEngine apis !

## Quick start guide using command line gradle and adb : 
1) Download the repository on your local disk.
2) Navigate to the root directory.
3) To start building an example use the following command : 
> For windows 
```bash
gradlew :helloandroidharness
```
> For linux/mac
```bash
./gradlew :helloandroidharness
```
4) To start dexing and build a debug apk for an example, use the following command : 
> For windows 
```bash
gradlew :hellofragmentharness:assemble
```
> For linux/mac
```bash
./gradlew :hellofragmentharness:assemble
```
5) To run directly on connected devices : 
> For windows 
```bash 
gradlew :hellofragmentharness:installDebug
```
> For linux/mac
```bash
./gradlew :hellofragmentharness:installDebug
```
6) To dex a signed apk for google play, check this tutorial : 
https://developer.android.com/studio/publish/app-signing

## For more about testing your application : 
https://developer.android.com/studio/test

## The anatomy of jMonkeyEngine game android application : 
| `SimpleApplication` | `Rendering Component` | `Android Activity` | `AppStates and Controls` |
|-------|------|-------|-------|
| Initializes and updates a jme game | Renders a `SimpleApplication` using a surface view (gl component) and passes it to android activity | The entry point and life cycle manager of android application, it holds the surface view |Game logic is distributed among these components and can be registered inside `SimpleApplication` class to be updated inside game loop |
