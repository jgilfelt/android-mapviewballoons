package com.readystatesoftware.azimuth.interfaces;

public interface IMapView {
	IMapController getController();
	IProjection getProjection();
	int getZoomLevel();
	int getMaxZoomLevel();
	int getLatitudeSpan();
	int getLongitudeSpan();
	IGeoPoint getMapCenter();
}
