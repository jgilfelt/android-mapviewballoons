package com.readystatesoftware.azimuth.internal;

import android.content.Context;
import android.util.AttributeSet;

import com.readystatesoftware.azimuth.interfaces.IGeoPoint;
import com.readystatesoftware.azimuth.interfaces.IMapController;
import com.readystatesoftware.azimuth.interfaces.IMapView;
import com.readystatesoftware.azimuth.interfaces.IProjection;

public class MapViewGoogle implements IMapView {

	private final com.google.android.maps.MapView mMapView;

	public MapViewGoogle(final com.google.android.maps.MapView pMapView) {
		mMapView = pMapView;
	}

	public MapViewGoogle(final Context pContext, final AttributeSet pAttrs, final int pDefStyle) {
		this(new com.google.android.maps.MapView(pContext, pAttrs, pDefStyle));
	}

	public MapViewGoogle(final Context pContext, final AttributeSet pAttrs) {
		this(new com.google.android.maps.MapView(pContext, pAttrs));
	}

	public MapViewGoogle(final Context pContext, final String pApiKey) {
		this(new com.google.android.maps.MapView(pContext, pApiKey));
	}

	@Override
	public IMapController getController() {
		return new MapControllerGoogle(mMapView.getController());
	}

	@Override
	public IProjection getProjection() {
		return new ProjectionGoogle(mMapView.getProjection());
	}

	@Override
	public int getZoomLevel() {
		return mMapView.getZoomLevel();
	}

	@Override
	public int getLatitudeSpan() {
		return mMapView.getLatitudeSpan();
	}

	@Override
	public int getLongitudeSpan() {
		return mMapView.getLongitudeSpan();
	}

	@Override
	public IGeoPoint getMapCenter() {
		return new GeoPointGoogle(mMapView.getMapCenter());
	}

	@Override
	public int getMaxZoomLevel() {
		return mMapView.getMaxZoomLevel();
	}

}
