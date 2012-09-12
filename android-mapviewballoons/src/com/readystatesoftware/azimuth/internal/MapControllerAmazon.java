package com.readystatesoftware.azimuth.internal;

import android.os.Message;
import android.view.KeyEvent;
import android.view.View;

import com.readystatesoftware.azimuth.interfaces.IGeoPoint;
import com.readystatesoftware.azimuth.interfaces.IMapController;

public class MapControllerAmazon implements IMapController {

	private final com.amazon.geo.maps.MapController mController;
	
	public MapControllerAmazon(final com.amazon.geo.maps.MapController pMapController) {
		mController = pMapController;
	}
	
	@Override
	public void animateTo(IGeoPoint arg0) {
		mController.animateTo(new com.amazon.geo.maps.GeoPoint(arg0.getLatitudeE6(), arg0.getLongitudeE6()));
	}

	@Override
	public void animateTo(IGeoPoint arg0, Message arg1) {
		mController.animateTo(new com.amazon.geo.maps.GeoPoint(arg0.getLatitudeE6(), arg0.getLongitudeE6()), arg1);
	}

	@Override
	public void animateTo(IGeoPoint arg0, Runnable arg1) {
		mController.animateTo(new com.amazon.geo.maps.GeoPoint(arg0.getLatitudeE6(), arg0.getLongitudeE6()), arg1);
	}

	@Override
	public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
		return mController.onKey(arg0, arg1, arg2);
	}

	@Override
	public void scrollBy(int arg0, int arg1) {
		mController.scrollBy(arg0, arg1);

	}

	@Override
	public void setCenter(IGeoPoint arg0) {
		mController.setCenter(new com.amazon.geo.maps.GeoPoint(arg0.getLatitudeE6(), arg0.getLongitudeE6()));
	}

	@Override
	public int setZoom(int arg0) {
		return mController.setZoom(arg0);
	}

	@Override
	public void stopAnimation(boolean arg0) {
		mController.stopAnimation(arg0);
	}

	@Override
	public void stopPanning() {
		mController.stopPanning();
	}

	@Override
	public boolean zoomIn() {
		return mController.zoomIn();
	}

	@Override
	public boolean zoomInFixing(int arg0, int arg1) {
		return mController.zoomInFixing(arg0, arg1);
	}

	@Override
	public boolean zoomOut() {
		return mController.zoomOut();
	}

	@Override
	public boolean zoomOutFixing(int arg0, int arg1) {
		return mController.zoomOutFixing(arg0, arg1);
	}

	@Override
	public void zoomToSpan(int arg0, int arg1) {
		mController.zoomToSpan(arg0, arg1);
	}

}
