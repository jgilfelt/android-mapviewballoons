package com.readystatesoftware.azimuth.interfaces;

public interface IItemizedOverlay {
	public interface IOnFocusChangeListener {
		void onFocusChanged(IItemizedOverlay arg0, IOverlayItem arg1);
	}
	void populate();
	int size();
	//abstract IOverlayItem createItem(int arg0);
	IOverlayItem getItem(int arg0);
	IGeoPoint getCenter();
	void setFocus(IOverlayItem arg0);
	IOverlayItem nextFocus(boolean arg0);
	IOverlayItem getFocus();
	void setLastFocusedIndex(int arg0);
	int getLastFocusedIndex();
	void draw(android.graphics.Canvas arg0, IMapView arg1, boolean arg2);
	int getIndexToDraw(int arg0);
	int getLatSpanE6();
	int getLonSpanE6();
	boolean onKeyUp(int arg0, android.view.KeyEvent arg1, IMapView arg2);
	boolean onSnapToItem(int arg0, int arg1, android.graphics.Point arg2, IMapView arg3);
	boolean onTap(int arg0);
	boolean onTap(IGeoPoint arg0, IMapView arg1);
	boolean onTouchEvent(android.view.MotionEvent arg0, IMapView arg1);
	boolean hitTest(IOverlayItem arg0, android.graphics.drawable.Drawable arg1, int arg2, int arg3);
	boolean onTrackballEvent(android.view.MotionEvent arg0, IMapView arg1);
	void setDrawFocusedItem(boolean arg0);
	void setOnFocusChangeListener(IItemizedOverlay.IOnFocusChangeListener arg0);
	//android.graphics.drawable.Drawable boundCenter(android.graphics.drawable.Drawable arg0);
	//android.graphics.drawable.Drawable boundCenterBottom(android.graphics.drawable.Drawable arg0);
}
