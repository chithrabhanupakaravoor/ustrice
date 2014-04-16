package com.example.ust_rice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class FoodMenuSearch extends Activity {
	TextView textView1, textView2, textView3, textView4, textView5;


	String[] name = new String[10];
	String[] canteen = new String[10];
	int[] price = new int[10];
	String[] a = new String[5];
	JSONParser jsonParser = new JSONParser();

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_menu_search);
		
		StrictMode.enableDefaults();
		
		textView1 = (TextView) findViewById(R.id.textView1);

		Intent intent = getIntent();

		a[0] = intent.getStringExtra("sCanteen");
		a[1] = intent.getStringExtra("sTime");
		a[2] = intent.getStringExtra("sCuisine");
		a[3] = intent.getStringExtra("sPrice");
		a[4] = intent.getStringExtra("sSortby");

		getData();
		
		ListAdapter adapter = new ListAdapter(this, name, canteen, price);
		ListView list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
            	Intent i = new Intent(FoodMenuSearch.this, FoodItem.class);
        		startActivity(i);

            }
        });

	}

	public void getData() {

		try {

			List<NameValuePair> params = new ArrayList<NameValuePair>();
//			params.add(new BasicNameValuePair("canteen", a[0]));
//			params.add(new BasicNameValuePair("offering", a[1]));
//			params.add(new BasicNameValuePair("cuisine", a[2]));
//			params.add(new BasicNameValuePair("priceFrom", "0"));
//			params.add(new BasicNameValuePair("priceTo", a[3]));
			params.add(new BasicNameValuePair("sortBy", "rating"));
			JSONArray jArray = jsonParser.makeHttpRequest(jsonParser.URL + "rank.php",
					params);

			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json = jArray.getJSONObject(i);

				name[i] = json.getString("food_name");
				canteen[i] = json.getString("canteen");
				price[i] = json.getInt("price");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}

	// private void setListView() {
	// String[] x = {"sCanteen", "sCanteen", "sCanteen", "sCanteen"};
	// ArrayAdapter<String> adapter = new ArrayAdapter<String>( this,
	// R.layout.list_item, x);
	// ListView list = (ListView) findViewById(R.id.listView1);
	// list.setAdapter(adapter);
	// }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.food_menu_search, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
