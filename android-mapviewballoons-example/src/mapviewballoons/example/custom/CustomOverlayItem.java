package mapviewballoons.example.custom;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

public class CustomOverlayItem extends OverlayItem {

	protected String mImageURL;
	
	public CustomOverlayItem(GeoPoint point, String title, String snippet, String imageURL) {
		super(point, title, snippet);
		mImageURL = imageURL;
	}

	public String getImageURL() {
		return mImageURL;
	}

	public void setImageURL(String imageURL) {
		this.mImageURL = imageURL;
	}
	
}
