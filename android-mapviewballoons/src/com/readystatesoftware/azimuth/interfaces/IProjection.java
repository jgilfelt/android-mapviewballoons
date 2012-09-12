package com.readystatesoftware.azimuth.interfaces;

public interface IProjection {
	android.graphics.Point toPixels(IGeoPoint arg0, android.graphics.Point arg1);
	IGeoPoint fromPixels(int arg0, int arg1);
	float metersToEquatorPixels(float arg0);
}
