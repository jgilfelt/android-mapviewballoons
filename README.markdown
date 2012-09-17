Android MapView Balloons
========================

This project provides an easy way to annotate map overlay items with a simple information balloon when using the Android Maps external library (`com.google.android.maps`). It consists of `BalloonOverlayView`, a view representing the balloon that is displayed over your `MapView` and `BalloonItemizedOverlay`, an abstract extension of `ItemizedOverlay`.

![Balloon](http://jeffgilfelt.com/mapviewballoons/mvb-1a.png "Balloon")&nbsp;
![Balloon Pressed](http://jeffgilfelt.com/mapviewballoons/mvb-2a.png "Balloon Pressed")&nbsp;
![Balloon2](http://jeffgilfelt.com/mapviewballoons/mvb-3a.png "Balloon Disclose")

Basic Usage
-----------

Create a subclass of `BalloonItemizedOverlay` in the same way you would do for the base `ItemizedOverlay` class. Rather than overriding `onTap()` (which is already implemented and final in the subclass to invoke the balloon view display for each item tap), you override `onBalloonTap()` to handle a screen tap event on the balloon itself.

The data displayed in each balloon is mapped to the title and snippet arguments you provide to the constructor of each `OverlayItem`.

The repository contains a working sample application project which fully demonstrates its usage.

Custom Layouts
--------------

![custom](http://jeffgilfelt.com/mapviewballoons/mvb-4a.png "custom")

You can create your own balloon look & feel and custom data mapping by creating a subclass of `BalloonOverlayView` with a generic type that extends `OverlayItem`. Override the `setupView(Context context, final ViewGroup parent)` method and inflate your own XML layout using `parent` as the root of its view hierarchy.

One caveat with custom layouts is that you MUST include a layout container that represents the clickable action area of your balloon whose id property is `android:id="@id/balloon_inner_layout"`.

An example custom layout and data mapping which downloads an image from the internet and displays it in an ImageView is included in the sample application project.

TapControlledMapView
--------------------

This library also includes `TapControlledMapView` - an optional custom `MapView` implementation which can be used to more closely mimic behaviour of Google Maps for Android and the iOS MapKit component, such as double-tap to zoom and single-tap to dismiss a balloon.

Refer to the example Activity included in the sample application project.

Amazon Maps API & Kindle Fire
-----------------------------

![kindle](http://jeffgilfelt.com/mapviewballoons/kindle.png "kindle")

This library supports the alternative Amazon Maps API found on devices such as the 2nd generation Kindle Fire and Kindle Fire HD.

To enable Amazon Maps API support you should follow the Google Maps API migration instructions found at [developer.amazon.com](http://developer.amazon.com). Switch to the `amazon-maps-api-support` branch in this repository for an example. The library must be modified to use the `com.amazon.geo.maps` imports. You can use the [mapimports.sh](https://gist.github.com/3715056) script to toggle between Google and Amazon APIs. This project does not currently provide a way to support both APIs in a single build.

Implementation
--------------

This project is implemented as an Android Library project. Refer to **Referencing a library project** in [this document](http://developer.android.com/guide/developing/projects/projects-eclipse.html#ReferencingLibraryProject) for instructions on how to include it in your own Android project. Ensure you have the latest Android SDK, tools and Eclipse plugin installed.

To install the library and sample project in Eclipse:

- Select **File, Import, Existing projects into workspace...**
- Select the root folder where you cloned/downloaded the repository to import both projects.
- Use **Project - Clean** if there are any errors.

Credits
-------

Author: Jeff Gilfelt

The code in this project is licensed under the Apache Software License 2.0.
<br />
Copyright &copy; 2012 readyState Software Ltd.
