package com.readystatesoftware.azimuth.internal;

import android.graphics.Point;

import com.readystatesoftware.azimuth.interfaces.IGeoPoint;
import com.readystatesoftware.azimuth.interfaces.IProjection;

public class ProjectionGoogle implements IProjection {

	private final com.google.android.maps.Projection mProjection;

	public ProjectionGoogle(final com.google.android.maps.Projection pProjection) {
		mProjection = pProjection;
	}

	@Override
	public Point toPixels(final IGeoPoint in, final Point out) {
		final com.google.android.maps.GeoPoint iGeoPoint =
				new com.google.android.maps.GeoPoint(in.getLatitudeE6(), in.getLongitudeE6());
		return mProjection.toPixels(iGeoPoint, out);
	}

	@Override
	public IGeoPoint fromPixels(final int x, final int y) {
		final com.google.android.maps.GeoPoint iGeoPoint = mProjection.fromPixels(x, y);
		return new GeoPointGoogle(iGeoPoint);
	}

	@Override
	public float metersToEquatorPixels(final float meters) {
		return mProjection.metersToEquatorPixels(meters);
	}

}
