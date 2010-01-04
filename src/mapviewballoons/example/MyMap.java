/***
 * Copyright (c) 2010 readyState Software Ltd
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

package mapviewballoons.example;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MyMap extends MapActivity {

	MapView mapView;
	List<Overlay> mapOverlays;
	Drawable drawable;
	MyItemizedOverlay itemizedOverlay;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		
		mapOverlays = mapView.getOverlays();
		drawable = getResources().getDrawable(R.drawable.marker);
		itemizedOverlay = new MyItemizedOverlay(drawable, mapView);
		
		GeoPoint point = new GeoPoint((int)(51.5174723*1E6),(int)(-0.0899537*1E6));
		OverlayItem overlayItem = new OverlayItem(point, "Tomorrow Never Dies (1997)", 
				"(M gives Bond his mission in Daimler car)");
		itemizedOverlay.addOverlay(overlayItem);
		
		GeoPoint point2 = new GeoPoint((int)(51.515259*1E6),(int)(-0.086623*1E6));
		OverlayItem overlayItem2 = new OverlayItem(point2, "GoldenEye (1995)", 
				"(Interiors Russian defence ministry council chambers in St Petersburg)");		
		itemizedOverlay.addOverlay(overlayItem2);
		
		GeoPoint point3 = new GeoPoint((int)(51.51738*1E6),(int)(-0.08186*1E6));
		OverlayItem overlayItem3 = new OverlayItem(point3, "Mission: Impossible (1996)", 
				"(Ethan & Jim cafe meeting)");		
		itemizedOverlay.addOverlay(overlayItem3);
		
		mapOverlays.add(itemizedOverlay);
		
		final MapController mc = mapView.getController();
		mc.animateTo(point2);
		mc.setZoom(16);
		
    }
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
