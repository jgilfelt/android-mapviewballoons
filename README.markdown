Android MapView Balloons
========================

This project provides an easy way to annotate map overlay items with a simple information balloon when using the Android Maps external library (`com.google.android.maps`). It consists of `BalloonOverlayView`, a view representing the balloon that is displayed over your `MapView` and `BalloonItemizedOverlay`, an abstract extension of `ItemizedOverlay`.

![Balloon](http://jeffgilfelt.com/mapviewballoons/device-balloon1.png "Balloon")
![Balloon Pressed](http://jeffgilfelt.com/mapviewballoons/device-balloon2.png "Balloon Pressed")
![hdpi](http://jeffgilfelt.com/mapviewballoons/device-balloon-hdpi.png "hdpi")

The presentation of the balloons was mostly reverse engineered from Google's Places Directory application. 

Usage
-----

Create a subclass of `BalloonItemizedOverlay` in the same way you would do for the base `ItemizedOverlay` class. Rather than overriding `onTap()` (which is already implemented and final in the subclass to invoke the balloon view display for each item tap), you override `onBalloonTap()` to handle a screen tap event on the balloon itself.

The data displayed in each balloon is mapped to the title and snippet arguments you provide to the constructor of each `OverlayItem`.

The repository contains a working sample application project which fully demonstrates its usage.

Implementation
--------------

As of version 1.1, android-mapviewballoons is an Android Library project. Refer to 'Referencing a library project from an application' in [this document](http://developer.android.com/guide/developing/eclipse-adt.html#libraryProject) for instructions on how to include it in your own Android project. Ensure you have the latest Android SDK, tools and Eclipse plugin installed.

Whats Missing?
--------------

* Custom balloon layouts and data mappings
* Long press support
* Trackball support (not tested)
* Focus events (not tested)

<br />

The code in this project is licensed under the Apache Software License 2.0.
<br />
Copyright (c) 2010 readyState Software Ltd.
