package com.readystatesoftware.azimuth.internal;

import android.graphics.drawable.Drawable;

import com.readystatesoftware.azimuth.interfaces.IGeoPoint;
import com.readystatesoftware.azimuth.interfaces.IOverlayItem;

public class OverlayItemAmazon implements IOverlayItem {

	public static final int ITEM_STATE_PRESSED_MASK = 1;
	public static final int ITEM_STATE_SELECTED_MASK = 2;
	public static final int ITEM_STATE_FOCUSED_MASK = 4;
	
	private final com.amazon.geo.maps.OverlayItem mOverlayItem;
	
	public OverlayItemAmazon(final com.amazon.geo.maps.OverlayItem pOverlayItem) {
		mOverlayItem = pOverlayItem;
	}
	
	@Override
	public void setMarker(Drawable arg0) {
		mOverlayItem.setMarker(arg0);
	}

	@Override
	public Drawable getMarker(int arg0) {
		return getMarker(arg0);
	}

	@Override
	public String getTitle() {
		return mOverlayItem.getTitle();
	}

	@Override
	public String getSnippet() {
		return mOverlayItem.getSnippet();
	}

	@Override
	public IGeoPoint getPoint() {
		return new GeoPointAmazon(mOverlayItem.getPoint());
	}

	@Override
	public String routableAddress() {
		return mOverlayItem.routableAddress();
	}
	
	public static void setState(android.graphics.drawable.Drawable arg0, int arg1) {
		com.amazon.geo.maps.OverlayItem.setState(arg0, arg1);
	}

}
