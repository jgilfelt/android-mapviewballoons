package com.readystatesoftware.azimuth.internal;

import android.content.Context;
import android.util.AttributeSet;

import com.readystatesoftware.azimuth.interfaces.IGeoPoint;
import com.readystatesoftware.azimuth.interfaces.IMapController;
import com.readystatesoftware.azimuth.interfaces.IMapView;
import com.readystatesoftware.azimuth.interfaces.IProjection;

public class MapViewAmazon implements IMapView {

	private final com.amazon.geo.maps.MapView mMapView;

	public MapViewAmazon(final com.amazon.geo.maps.MapView pMapView) {
		mMapView = pMapView;
	}

	public MapViewAmazon(final Context pContext, final AttributeSet pAttrs, final int pDefStyle) {
		this(new com.amazon.geo.maps.MapView(pContext, pAttrs, pDefStyle));
	}

	public MapViewAmazon(final Context pContext, final AttributeSet pAttrs) {
		this(new com.amazon.geo.maps.MapView(pContext, pAttrs));
	}

	public MapViewAmazon(final Context pContext, final String pApiKey) {
		this(new com.amazon.geo.maps.MapView(pContext, pApiKey));
	}

	@Override
	public IMapController getController() {
		return new MapControllerAmazon(mMapView.getController());
	}

	@Override
	public IProjection getProjection() {
		return new ProjectionAmazon(mMapView.getProjection());
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
		return new GeoPointAmazon(mMapView.getMapCenter());
	}

	@Override
	public int getMaxZoomLevel() {
		return mMapView.getMaxZoomLevel();
	}

}
