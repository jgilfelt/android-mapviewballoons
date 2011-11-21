package mapviewballoons.example.custom;

import android.content.Context;
import android.view.ViewGroup;

import com.google.android.maps.OverlayItem;
import com.readystatesoftware.mapviewballoons.BalloonOverlayView;

public class CustomBalloonOverlayView<Item extends OverlayItem> extends BalloonOverlayView<CustomOverlayItem> {

	public CustomBalloonOverlayView(Context context, int balloonBottomOffset) {
		super(context, balloonBottomOffset);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	protected void setupView(Context context, ViewGroup parent) {
		// TODO Auto-generated method stub
		super.setupView(context, parent);
	}



	@Override
	public void setData(CustomOverlayItem item) {
		// TODO Auto-generated method stub
		super.setData(item);
	}

	
	

}
