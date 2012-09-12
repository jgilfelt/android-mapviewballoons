package com.readystatesoftware.azimuth.internal;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.readystatesoftware.azimuth.interfaces.IGeoPoint;
import com.readystatesoftware.azimuth.interfaces.IItemizedOverlay;
import com.readystatesoftware.azimuth.interfaces.IMapView;
import com.readystatesoftware.azimuth.interfaces.IOverlayItem;

public abstract class ItemizedOverlayGoogle implements IItemizedOverlay {

	private final com.google.android.maps.ItemizedOverlay<com.google.android.maps.OverlayItem> mItemizedOverlay;
	
	public ItemizedOverlayGoogle(final com.google.android.maps.ItemizedOverlay<com.google.android.maps.OverlayItem> pItemizedOverlay) {
		mItemizedOverlay = pItemizedOverlay;
	}
	
	@Override
	public void populate() {
//		mItemizedOverlay
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public abstract IOverlayItem createItem(int arg0);

	@Override
	public IOverlayItem getItem(int arg0) {
		return new OverlayItemGoogle(mItemizedOverlay.getItem(arg0));
	}

	@Override
	public IGeoPoint getCenter() {
		return new GeoPointGoogle(mItemizedOverlay.getCenter());
	}

	@Override
	public void setFocus(IOverlayItem arg0) {
		mItemizedOverlay.setFocus(new com.google.android.maps.OverlayItem(
				new com.google.android.maps.GeoPoint(arg0.getPoint().getLatitudeE6(), arg0.getPoint().getLongitudeE6()),
				arg0.getTitle(), arg0.getSnippet()));
	}

	@Override
	public IOverlayItem nextFocus(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOverlayItem getFocus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLastFocusedIndex(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLastFocusedIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Canvas arg0, IMapView arg1, boolean arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getIndexToDraw(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLatSpanE6() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLonSpanE6() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean onKeyUp(int arg0, KeyEvent arg1, IMapView arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onSnapToItem(int arg0, int arg1, Point arg2, IMapView arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTap(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTap(IGeoPoint arg0, IMapView arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0, IMapView arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hitTest(IOverlayItem arg0, Drawable arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTrackballEvent(MotionEvent arg0, IMapView arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDrawFocusedItem(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOnFocusChangeListener(IOnFocusChangeListener arg0) {
		// TODO Auto-generated method stub

	}

}
