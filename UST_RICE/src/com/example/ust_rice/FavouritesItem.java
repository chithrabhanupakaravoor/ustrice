package com.example.ust_rice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FavouritesItem extends Activity {

	TextView tvItemFoodName, tvItemCanteen, tvItemTime, tvItemCuisine,
			tvItemPrice, tvItemRating, tvItemNut;

	String userID;
	String foodID, name, canteen, offeringTime, cuisine, price, rating, nut;

	JSONParser jsonParser = new JSONParser();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favourites_item);
		StrictMode.enableDefaults();
		Intent intent = getIntent();

		tvItemFoodName = (TextView) findViewById(R.id.tvItemFoodName);
		tvItemCanteen = (TextView) findViewById(R.id.tvItemCanteen2);
		tvItemTime = (TextView) findViewById(R.id.tvItemTime2);
		tvItemCuisine = (TextView) findViewById(R.id.tvItemCuisine2);
		tvItemPrice = (TextView) findViewById(R.id.tvItemPrice2);
		tvItemRating = (TextView) findViewById(R.id.tvItemRating2);
		tvItemNut = (TextView) findViewById(R.id.tvItemNut2);

		userID = ((UserData) this.getApplication()).getUserID();
		foodID = intent.getStringExtra("itemFoodID");
		name = intent.getStringExtra("itemName");
		canteen = intent.getStringExtra("itemCanteen");
		offeringTime = intent.getStringExtra("itemTime");
		cuisine = intent.getStringExtra("itemCuisine");
		price = intent.getStringExtra("itemPrice");
		rating = intent.getStringExtra("itemRating");
		nut = intent.getStringExtra("itemNut");

		tvItemFoodName.setText(name);
		tvItemCanteen.setText(canteen);
		tvItemTime.setText(offeringTime);
		tvItemCuisine.setText(cuisine);
		tvItemPrice.setText("$" + price);
		tvItemRating.setText(rating);
		tvItemNut.setText(nut);

	}

	@SuppressLint("SimpleDateFormat")
	public boolean checkOfferingTime() {
		SimpleDateFormat hour = new SimpleDateFormat("HH");

		int offeringStart = 8, offeringEnd = 21;

		if (offeringTime.equals("Breakfast")) {
			offeringStart = 8;
			offeringEnd = 11;
		} else if (offeringTime.equals("Lunch")) {
			offeringStart = 11;
			offeringEnd = 14;
		} else if (offeringTime.equals("Tea")) {
			offeringStart = 14;
			offeringEnd = 18;
		} else if (offeringTime.equals("Dinner")) {
			offeringStart = 18;
			offeringEnd = 21;
		}
		Date currentTime = new Date();

		if (offeringStart <= Integer.parseInt(hour.format(currentTime))
				&& offeringEnd > Integer.parseInt(hour.format(currentTime))) {
			return true;
		} else
			return false;
	}

	public void itemOrder(View view) {
		if (checkOfferingTime()) {
			try {

				List<NameValuePair> params = new ArrayList<NameValuePair>();

				params.add(new BasicNameValuePair("userID", userID));
				params.add(new BasicNameValuePair("foodID", foodID));
				JSONArray jArray = jsonParser.makeHttpRequest(jsonParser.URL
						+ "order.php", params);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			Toast.makeText(this, name + " is ordered!", Toast.LENGTH_SHORT)
					.show();
		} else if (offeringTime.equals("allDay"))
			Toast.makeText(this, "Canteen is Closed!", Toast.LENGTH_SHORT)
					.show();
		else
			Toast.makeText(this, "Now it is not " + offeringTime + " time!",
					Toast.LENGTH_SHORT).show();
	}

	public void addToOderList(View view) {
		if (checkOfferingTime()) {
			((UserData) this.getApplication()).addList(foodID, name, canteen,
					offeringTime, cuisine, price, rating, nut);
			Toast.makeText(this, name + " is added to Order List!",
					Toast.LENGTH_SHORT).show();
		} else if (offeringTime.equals("allDay"))
			Toast.makeText(this, "Canteen is Closed!", Toast.LENGTH_SHORT)
					.show();
		else
			Toast.makeText(this, "Now it is not " + offeringTime + " time!",
					Toast.LENGTH_SHORT).show();

	}

	public void deleteFromFavour(View view) {
		try {

			List<NameValuePair> params = new ArrayList<NameValuePair>();

			params.add(new BasicNameValuePair("userID", "1"));
			params.add(new BasicNameValuePair("foodID", foodID));
			JSONArray jArray = jsonParser.makeHttpRequest(jsonParser.URL
					+ "deleteFromFavour.php", params);
			Toast.makeText(FavouritesItem.this,
					name + " is deleted from Favourite!", Toast.LENGTH_SHORT)
					.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		finish();
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
