package com.readystatesoftware.azimuth.interfaces;

public interface IOverlayItem {
    //public static final int ITEM_STATE_PRESSED_MASK = 1;
	//public static final int ITEM_STATE_SELECTED_MASK = 2;
	//public static final int ITEM_STATE_FOCUSED_MASK = 4;
	void setMarker(android.graphics.drawable.Drawable arg0);
	android.graphics.drawable.Drawable getMarker(int arg0);
	//static void setState(android.graphics.drawable.Drawable arg0, int arg1);
	java.lang.String getTitle();
	java.lang.String getSnippet();
	IGeoPoint getPoint();
	java.lang.String routableAddress();
}
