package com.readystatesoftware.azimuth.internal;

import android.graphics.Point;

import com.readystatesoftware.azimuth.interfaces.IGeoPoint;
import com.readystatesoftware.azimuth.interfaces.IProjection;

public class ProjectionAmazon implements IProjection {

	private final com.amazon.geo.maps.Projection mProjection;

	public ProjectionAmazon(final com.amazon.geo.maps.Projection pProjection) {
		mProjection = pProjection;
	}

	@Override
	public Point toPixels(final IGeoPoint in, final Point out) {
		final com.amazon.geo.maps.GeoPoint iGeoPoint =
				new com.amazon.geo.maps.GeoPoint(in.getLatitudeE6(), in.getLongitudeE6());
		return mProjection.toPixels(iGeoPoint, out);
	}

	@Override
	public IGeoPoint fromPixels(final int x, final int y) {
		final com.amazon.geo.maps.GeoPoint iGeoPoint = mProjection.fromPixels(x, y);
		return new GeoPointAmazon(iGeoPoint);
	}

	@Override
	public float metersToEquatorPixels(final float meters) {
		return mProjection.metersToEquatorPixels(meters);
	}

}
