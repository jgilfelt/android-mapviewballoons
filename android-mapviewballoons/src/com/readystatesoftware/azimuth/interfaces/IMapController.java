package com.readystatesoftware.azimuth.interfaces;

public interface IMapController {
	void animateTo(IGeoPoint arg0);
	void animateTo(IGeoPoint arg0, android.os.Message arg1);
	void animateTo(IGeoPoint arg0, java.lang.Runnable arg1);
	boolean onKey(android.view.View arg0, int arg1, android.view.KeyEvent arg2);
	void scrollBy(int arg0, int arg1);
	void setCenter(IGeoPoint arg0);
	int setZoom(int arg0);
	void stopAnimation(boolean arg0);
	void stopPanning();
	boolean zoomIn();
	boolean zoomInFixing(int arg0, int arg1);
	boolean zoomOut();
	boolean zoomOutFixing(int arg0, int arg1);
	void zoomToSpan(int arg0, int arg1);
}
