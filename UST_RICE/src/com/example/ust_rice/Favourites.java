package com.example.ust_rice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

public class Favourites extends Activity {

	ArrayList<String> foodID = new ArrayList<String>();
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> canteen = new ArrayList<String>();
	ArrayList<String> time = new ArrayList<String>();
	ArrayList<String> cuisine = new ArrayList<String>();
	ArrayList<String> price = new ArrayList<String>();
	ArrayList<String> rating = new ArrayList<String>();
	ArrayList<String> nut = new ArrayList<String>();

	String userID;
	String[] a = new String[10];
	String itemFoodID, itemName, itemCanteen, itemTime, itemCuisine, itemPrice,
			itemRating, itemNut;

	JSONParser jsonParser = new JSONParser();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favourites);
		StrictMode.enableDefaults();
		
		
		userID = ((UserData) this.getApplication()).getUserID();
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

				Intent i = new Intent(Favourites.this, FavouritesItem.class);
				i.putExtra("itemFoodID", itemFoodID);
				i.putExtra("itemName", itemName);
				i.putExtra("itemCanteen", itemCanteen);
				i.putExtra("itemTime", itemTime);
				i.putExtra("itemCuisine", itemCuisine);
				i.putExtra("itemPrice", itemPrice);
				i.putExtra("itemRating", itemRating);
				i.putExtra("itemNut", itemNut);
				startActivityForResult(i, 0);
			}
		});
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		finish();
		overridePendingTransition(0, 0);
		Intent i = new Intent(this, Favourites.class);
		startActivity(i);
	}

	public void getData() {

		try {

			List<NameValuePair> params = new ArrayList<NameValuePair>();

			params.add(new BasicNameValuePair("userID", userID));

			JSONArray jArray = jsonParser.makeHttpRequest(jsonParser.URL
					+ "showFavour.php", params);

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

	ImageButton mbFood, mbRecommend, mbRanking, mbAccount;

	public void goFood(View view) {
		Intent i = new Intent(this, FoodMenu.class);
		mbFood = (ImageButton) findViewById(R.id.mbFood);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
		finish();
		overridePendingTransition(0, 0);
	}

	public void goRecommend(View view) {
		Intent i = new Intent(this, Recommend.class);
		mbRecommend = (ImageButton) findViewById(R.id.mbRecommend);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
		finish();
		overridePendingTransition(0, 0);
	}

	public void goRanking(View view) {
		Intent i = new Intent(this, Ranking.class);
		mbRanking = (ImageButton) findViewById(R.id.mbRanking);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
		finish();
		overridePendingTransition(0, 0);
	}

	public void goAccount(View view) {
		Intent i = new Intent(this, Account.class);
		mbAccount = (ImageButton) findViewById(R.id.mbAccount);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
		finish();
		overridePendingTransition(0, 0);
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
