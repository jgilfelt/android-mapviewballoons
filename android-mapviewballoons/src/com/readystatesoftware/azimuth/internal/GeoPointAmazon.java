package com.readystatesoftware.azimuth.internal;

import com.readystatesoftware.azimuth.interfaces.IGeoPoint;

public class GeoPointAmazon implements IGeoPoint {

	private final com.amazon.geo.maps.GeoPoint mGeoPoint;

	public GeoPointAmazon(final com.amazon.geo.maps.GeoPoint pGeoPoint) {
		mGeoPoint = pGeoPoint;
	}

	@Override
	public int getLatitudeE6() {
		return mGeoPoint.getLatitudeE6();
	}

	@Override
	public int getLongitudeE6() {
		return mGeoPoint.getLongitudeE6();
	}

}
