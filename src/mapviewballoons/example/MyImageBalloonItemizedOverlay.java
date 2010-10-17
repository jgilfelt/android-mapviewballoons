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

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import be.agherschon.mapviewimageballoons.ImageBalloonItemizedOverlay;
import be.agherschon.mapviewimageballoons.ImageOverlayItem;

import com.google.android.maps.MapView;

public class MyImageBalloonItemizedOverlay extends ImageBalloonItemizedOverlay<ImageOverlayItem> {

	private ArrayList<ImageOverlayItem> m_overlays = new ArrayList<ImageOverlayItem>();
	private Context c;
	
	public MyImageBalloonItemizedOverlay(Drawable defaultMarker, MapView mapView) {
		super(boundCenter(defaultMarker), mapView);
		c = mapView.getContext();
	}

	public void addOverlay(ImageOverlayItem overlay) {
	    m_overlays.add(overlay);
	    populate();
	}

	@Override
	protected ImageOverlayItem createItem(int i) {
		return m_overlays.get(i);
	}

	@Override
	public int size() {
		return m_overlays.size();
	}

	@Override
	protected boolean onBalloonTap(int index) {
		Toast.makeText(c, "onBalloonTap for overlay index " + index,
				Toast.LENGTH_LONG).show();
		return true;
	}
	
}
