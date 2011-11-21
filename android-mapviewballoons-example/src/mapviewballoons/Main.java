package mapviewballoons;

import mapviewballoons.example.MyMap;
import mapviewballoons.example.custom.CustomMap;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class Main extends ListActivity implements OnItemClickListener {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mStrings));
        getListView().setOnItemClickListener(this);
    }

    private String[] mStrings = {"Simple", "Custom"};

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = null;
		switch (position) {
		case 0:
			intent = new Intent(this, MyMap.class);
			startActivity(intent);
			break;
		case 1:
			intent = new Intent(this, CustomMap.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}
	
}
