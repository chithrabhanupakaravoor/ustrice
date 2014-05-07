package com.example.ust_rice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ReRanking extends Activity {

	ArrayList<String> foodID = new ArrayList<String>();
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> canteen = new ArrayList<String>();
	ArrayList<String> time = new ArrayList<String>();
	ArrayList<String> cuisine = new ArrayList<String>();
	ArrayList<String> price = new ArrayList<String>();
	ArrayList<String> rating = new ArrayList<String>();
	ArrayList<String> nut = new ArrayList<String>();

	String offering;
	String itemFoodID, itemName, itemCanteen, itemTime, itemCuisine, itemPrice,
			itemRating, itemNut;

	JSONParser jsonParser = new JSONParser();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_re_ranking);

		StrictMode.enableDefaults();

		offering = checkOfferingTime();
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

				Intent i = new Intent(ReRanking.this, FoodItem.class);
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

	@SuppressLint("SimpleDateFormat")
	public String checkOfferingTime() {
		SimpleDateFormat hour = new SimpleDateFormat("HH");

		Date currentTime = new Date();

		if (Integer.parseInt(hour.format(currentTime)) >= 8
				&& Integer.parseInt(hour.format(currentTime)) < 11)
			return "Breakfast";
		else if (Integer.parseInt(hour.format(currentTime)) >= 11
				&& Integer.parseInt(hour.format(currentTime)) < 14)
			return "Lunch";
		else if (Integer.parseInt(hour.format(currentTime)) >= 14
				&& Integer.parseInt(hour.format(currentTime)) < 18)
			return "Tea";
		else if (Integer.parseInt(hour.format(currentTime)) >= 18
				&& Integer.parseInt(hour.format(currentTime)) < 21)
			return "Dinner";
		else
			return "allDay";
	}

	public void getData() {

		try {

			List<NameValuePair> params = new ArrayList<NameValuePair>();

			params.add(new BasicNameValuePair("offering", offering));
			JSONArray jArray = jsonParser.makeHttpRequest(jsonParser.URL
					+ "recommendByRank.php", params);

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
