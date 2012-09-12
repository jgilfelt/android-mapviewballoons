package com.amazon.geo.maps;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.readystatesoftware.azimuth.interfaces.IGeoPoint;
import com.readystatesoftware.azimuth.interfaces.IItemizedOverlay;
import com.readystatesoftware.azimuth.interfaces.IMapView;
import com.readystatesoftware.azimuth.interfaces.IOverlayItem;
import com.readystatesoftware.azimuth.internal.GeoPointAmazon;
import com.readystatesoftware.azimuth.internal.OverlayItemAmazon;

public abstract class _ItemizedOverlay implements IItemizedOverlay {

	private final com.amazon.geo.maps.ItemizedOverlay<com.amazon.geo.maps.OverlayItem> mItemizedOverlay;
	
	public _ItemizedOverlay(final com.amazon.geo.maps.ItemizedOverlay<com.amazon.geo.maps.OverlayItem> pItemizedOverlay) {
		mItemizedOverlay = pItemizedOverlay;
	}
	
	@Override
	public void populate() {
		mItemizedOverlay.populate();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public abstract IOverlayItem createItem(int arg0);

	@Override
	public IOverlayItem getItem(int arg0) {
		return new OverlayItemAmazon(mItemizedOverlay.getItem(arg0));
	}

	@Override
	public IGeoPoint getCenter() {
		return new GeoPointAmazon(mItemizedOverlay.getCenter());
	}

	@Override
	public void setFocus(IOverlayItem arg0) {
		mItemizedOverlay.setFocus(new com.amazon.geo.maps.OverlayItem(
				new com.amazon.geo.maps.GeoPoint(arg0.getPoint().getLatitudeE6(), arg0.getPoint().getLongitudeE6()),
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
