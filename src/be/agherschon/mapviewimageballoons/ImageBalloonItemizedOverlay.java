/***
 * Copyright (c) 2010 Alexandre Gherschon
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package be.agherschon.mapviewimageballoons;

import java.lang.reflect.Method;
import java.util.List;

import mapviewballoons.example.R;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.readystatesoftware.mapviewballoons.BalloonItemizedOverlay;

/**
 * An abstract extension of ItemizedOverlay for displaying an information image balloon
 * upon screen-tap of each marker overlay.
 * 
 * @author Alexandre Gherschon
 */
public abstract class ImageBalloonItemizedOverlay<Item> extends ItemizedOverlay<ImageOverlayItem> {

	private MapView mapView;
	private ImageBalloonOverlayView imageBalloonView;
	private View clickRegion;
	private int viewOffset;
	final MapController mc;
	
	/**
	 * Create a new MyImageBalloonItemizedOverlay
	 * 
	 * @param defaultMarker - A bounded Drawable to be drawn on the map for each item in the overlay.
	 * @param mapView - The view upon which the overlay items are to be drawn.
	 */
	public ImageBalloonItemizedOverlay(Drawable defaultMarker, MapView mapView) {
		super(defaultMarker);
		this.mapView = mapView;
		viewOffset = 0;
		mc = mapView.getController();
	}
	
	/**
	 * Set the horizontal distance between the marker and the bottom of the information
	 * balloon. The default is 0 which works well for center bounded markers. If your
	 * marker is center-bottom bounded, call this before adding overlay items to ensure
	 * the balloon hovers exactly above the marker. 
	 * 
	 * @param pixels - The padding between the center point and the bottom of the
	 * information balloon.
	 */
	public void setBalloonBottomOffset(int pixels) {
		viewOffset = pixels;
	}
	
	/**
	 * Override this method to handle a "tap" on a balloon. By default, does nothing 
	 * and returns false.
	 * 
	 * @param index - The index of the item whose balloon is tapped.
	 * @return true if you handled the tap, otherwise false.
	 */
	protected boolean onBalloonTap(int index) {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.google.android.maps.ItemizedOverlay#onTap(int)
	 */
	@Override
	protected final boolean onTap(int index) {
		
		boolean isRecycled;
		final int thisIndex;
		GeoPoint point;
		
		thisIndex = index;
		point = createItem(index).getPoint();
		
		if (imageBalloonView == null) {
			imageBalloonView = new ImageBalloonOverlayView(mapView.getContext(), viewOffset);
			clickRegion = (View) imageBalloonView.findViewById(R.id.image_balloon_inner_layout);
			isRecycled = false;
		} else {
			isRecycled = true;
		}
	
		imageBalloonView.setVisibility(View.GONE);
		
		List<Overlay> mapOverlays = mapView.getOverlays();
		if (mapOverlays.size() > 1) {
			hideOtherBalloons(mapOverlays);
		}
		
		imageBalloonView.setData(createItem(index));
		
		MapView.LayoutParams params = new MapView.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, point,
				MapView.LayoutParams.BOTTOM_CENTER);
		params.mode = MapView.LayoutParams.MODE_MAP;
		
		setBalloonTouchListener(thisIndex);
		
		imageBalloonView.setVisibility(View.VISIBLE);

		if (isRecycled) {
			imageBalloonView.setLayoutParams(params);
		} else {
			mapView.addView(imageBalloonView, params);
		}
		
		// from this geopoint, creates another geopoint to be able to see the whole pop-up
		//GeoPoint virtualPoint = new GeoPoint(point.getLatitudeE6() + 2500 , point.getLongitudeE6());
		
		mc.animateTo(point);

		
		return true;
	}
	
	/**
	 * Sets the visibility of this overlay's balloon view to GONE. 
	 */
	public void hideBalloon() {
		if (imageBalloonView != null) {
			imageBalloonView.setVisibility(View.GONE);
		}
	}
	
	/**
	 * Hides the balloon view for any other MyImageBalloonItemizedOverlay instances
	 * that might be present on the MapView.
	 * 
	 * @param overlays - list of overlays (including this) on the MapView.
	 */
	private void hideOtherBalloons(List<Overlay> overlays) {
		
		for (Overlay overlay : overlays) {
			if (overlay instanceof ImageBalloonItemizedOverlay<?> && overlay != this) {
				((ImageBalloonItemizedOverlay<?>) overlay).hideBalloon();
			}
			if (overlay instanceof BalloonItemizedOverlay<?>) {
				((BalloonItemizedOverlay<?>) overlay).hideBalloon();
			}
		}
		
		
	}
	
	/**
	 * Sets the onTouchListener for the balloon being displayed, calling the
	 * overridden onBalloonTap if implemented.
	 * 
	 * @param thisIndex - The index of the item whose balloon is tapped.
	 */
	private void setBalloonTouchListener(final int thisIndex) {
		
		try {
			@SuppressWarnings("unused")
			Method m = this.getClass().getDeclaredMethod("onBalloonTap", int.class);
			
			clickRegion.setOnTouchListener(new OnTouchListener() {
				public boolean onTouch(View v, MotionEvent event) {
					
					View l =  ((View) v.getParent()).findViewById(R.id.image_balloon_main_layout);
					Drawable d = l.getBackground();
					
					if (event.getAction() == MotionEvent.ACTION_DOWN) {
						int[] states = {android.R.attr.state_pressed};
						if (d.setState(states)) {
							d.invalidateSelf();
						}
						return true;
					} else if (event.getAction() == MotionEvent.ACTION_UP) {
						int newStates[] = {};
						if (d.setState(newStates)) {
							d.invalidateSelf();
						}
						// call overridden method
						onBalloonTap(thisIndex);
						return true;
					} else {
						return false;
					}
					
				}
			});
			
		} catch (SecurityException e) {
			Log.e("MyImageBalloonItemizedOverlay", "setBalloonTouchListener reflection SecurityException");
			return;
		} catch (NoSuchMethodException e) {
			// method not overridden - do nothing
			return;
		}

	}
	
}
