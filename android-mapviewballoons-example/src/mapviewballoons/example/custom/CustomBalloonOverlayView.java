/***
 * Copyright (c) 2011 readyState Software Ltd
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

package mapviewballoons.example.custom;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.maps.OverlayItem;
import com.readystatesoftware.mapviewballoons.BalloonOverlayView;
import com.readystatesoftware.mapviewballoons.R;

public class CustomBalloonOverlayView<Item extends OverlayItem> extends BalloonOverlayView<CustomOverlayItem> {

	private TextView title;
	private TextView snippet;
	private ImageView image;
	
	public CustomBalloonOverlayView(Context context, int balloonBottomOffset) {
		super(context, balloonBottomOffset);
	}
	
	@Override
	protected void setupView(Context context, final ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.custom_balloon_overlay, parent);
		
		title = (TextView) v.findViewById(R.id.balloon_item_title);
		snippet = (TextView) v.findViewById(R.id.balloon_item_snippet);
		image = (ImageView) v.findViewById(R.id.balloon_item_image);

		ImageView close = (ImageView) v.findViewById(R.id.balloon_close);
		close.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				parent.setVisibility(GONE);
			}
		});
		
	}

	@Override
	protected void setBalloonData(CustomOverlayItem item, ViewGroup parent) {
		
		title.setText(item.getTitle());
		snippet.setText(item.getSnippet());
				
		image.setImageResource(R.drawable.icon);
		new FetchImageTask() { 
	        protected void onPostExecute(Bitmap result) {
	            if (result != null) {
	            	image.setImageBitmap(result);
	            }
	        }
	    }.execute(item.getImageURL());
		
	}

	private class FetchImageTask extends AsyncTask<String, Integer, Bitmap> {
	    @Override
	    protected Bitmap doInBackground(String... arg0) {
	    	Bitmap b = null;
	    	try {
				 b = BitmapFactory.decodeStream((InputStream) new URL(arg0[0]).getContent());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
	        return b;
	    }	
	}
	
}
