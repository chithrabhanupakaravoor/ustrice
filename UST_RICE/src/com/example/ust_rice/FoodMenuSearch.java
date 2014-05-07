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
import android.widget.Toast;

public class FoodMenuSearch extends Activity {

	public ArrayList<String> foodID = new ArrayList<String>();
	public ArrayList<String> name = new ArrayList<String>();
	public ArrayList<String> canteen = new ArrayList<String>();
	public ArrayList<String> time = new ArrayList<String>();
	public ArrayList<String> cuisine = new ArrayList<String>();
	public ArrayList<String> price = new ArrayList<String>();
	public ArrayList<String> rating = new ArrayList<String>();
	public ArrayList<String> nut = new ArrayList<String>();

	public String[] a = {"canteenA", "canteenB", "allDay", "chinese",  "western", "others", "99","canteen"};

	public String itemFoodID, itemName, itemCanteen, itemTime, itemCuisine,
			itemPrice, itemRating, itemNut;

	JSONParser jsonParser = new JSONParser();

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_menu_search);

		StrictMode.enableDefaults();

		Intent intent = getIntent();
		try {
			if (intent.getStringExtra("sCanteen").equals("canteenAll")) {
				a[0] = "canteenA";
				a[1] = "canteenB";
			} else {
				a[0] = intent.getStringExtra("sCanteen");
				a[1] = "";
			}

			a[2] = intent.getStringExtra("sTime");

			if (intent.getStringExtra("sCuisine").equals("cuisineAll")) {
				a[3] = "chinese";
				a[4] = "western";
				a[5] = "others";
			} else {
				a[3] = intent.getStringExtra("sCuisine");
				a[4] = "";
				a[5] = "";
			}

			a[6] = intent.getStringExtra("sPrice");
			a[7] = intent.getStringExtra("sSortby");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

		getData();

		ListAdapter adapter = new ListAdapter(this, name, canteen, price);
		ListView list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				itemFoodID = foodID.get(position);
				itemName = name.get(position);
				itemCanteen = canteen.get(position);
				itemTime = time.get(position);
				itemCuisine = cuisine.get(position);
				itemPrice = price.get(position);
				itemRating = rating.get(position);

				Intent i = new Intent(FoodMenuSearch.this, FoodItem.class);
				i.putExtra("itemFoodID", itemFoodID);
				i.putExtra("itemName", itemName);
				i.putExtra("itemCanteen", itemCanteen);
				i.putExtra("itemTime", itemTime);
				i.putExtra("itemCuisine", itemCuisine);
				i.putExtra("itemPrice", itemPrice);
				i.putExtra("itemRating", itemRating);
				i.putExtra("itemNut", itemNut);
				startActivity(i);
			}
		});

	}

	public void getData() {

		try {

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("canteen1", a[0]));
			params.add(new BasicNameValuePair("canteen2", a[1]));
			params.add(new BasicNameValuePair("offering", a[2]));
			params.add(new BasicNameValuePair("cuisine1", a[3]));
			params.add(new BasicNameValuePair("cuisine2", a[4]));
			params.add(new BasicNameValuePair("cuisine3", a[5]));
			params.add(new BasicNameValuePair("priceFrom", "0"));
			params.add(new BasicNameValuePair("priceTo", a[6]));
			params.add(new BasicNameValuePair("sortBy", a[7]));
			JSONArray jArray = jsonParser.makeHttpRequest(jsonParser.URL
					+ "search.php", params);

			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json = jArray.getJSONObject(i);
				foodID.add(json.getString("food_id"));
				name.add(json.getString("food_name"));
				canteen.add(json.getString("canteen"));
				time.add(json.getString("offering"));
				cuisine.add(json.getString("cuisine"));
				price.add(json.getString("price"));
				rating.add(json.getString("rating"));

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
		getMenuInflater().inflate(R.menu.ranking, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_order_list) {
			Intent i = new Intent(this, FoodOrderList.class);
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
