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

import android.graphics.drawable.Drawable;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

/**
 * An extend of OverlayItem to add an image into the image balloon
 */
public class ImageOverlayItem extends OverlayItem {

	private Drawable image ;
	
	public ImageOverlayItem(GeoPoint point, String title, String snippet, Drawable image) {
		super(point, title, snippet);
		this.image = image;
	
	}

	public void setBitmap(Drawable image) {
		this.image = image;
	}

	public Drawable getBitmap() {
		return image;
	}

}
