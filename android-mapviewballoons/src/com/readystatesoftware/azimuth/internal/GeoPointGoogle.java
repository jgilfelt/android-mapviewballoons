package com.readystatesoftware.azimuth.internal;

import com.readystatesoftware.azimuth.interfaces.IGeoPoint;

public class GeoPointGoogle implements IGeoPoint {

	private final com.google.android.maps.GeoPoint mGeoPoint;

	public GeoPointGoogle(final com.google.android.maps.GeoPoint pGeoPoint) {
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
