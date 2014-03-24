package com.example.ust_rice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class Ranking extends ActionBarActivity {

	final String severIp = "http://223.19.68.90/ust_rice/";

	RadioGroup rgRanking1;
	RadioButton rbMostOrdered, rbMostRated;

	TableLayout tlRanking;
	TableRow trRanking;
	TextView tvRank, tvFood, tvPrice, tvRating, tvVariable;

	String ranking_switch;
	String name[] = new String[10];
	int numOfOrder[] = new int[10];
	int price[] = new int[10];
	int rating[] = new int[10];

	JSONParser jsonParser = new JSONParser();

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranking);

		StrictMode.enableDefaults();

		rgRanking1 = (RadioGroup) findViewById(R.id.rgRanking1);
		rbMostOrdered = (RadioButton) findViewById(R.id.rbMostOrdered);
		rbMostRated = (RadioButton) findViewById(R.id.rbMostRated);
		tvVariable = (TextView) findViewById(R.id.tvRate);
		tlRanking = (TableLayout) findViewById(R.id.tlRanking);

		rgRanking1
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == rbMostOrdered.getId()) {
							ranking_switch = "rating";
							createMostOrdered();
							tvVariable.setText("Rating");
							tvVariable.setTextColor(0xFFFF3B30);
						} else if (checkedId == rbMostRated.getId()) {
							ranking_switch = "numOfOrder";
							createMostRated();
							tvVariable.setText("Order");
							tvVariable.setTextColor(0xFFFF3B30);
						}
					}
				});

	}

	public void getData() {

		try {

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("sortBy", ranking_switch));
			JSONArray jArray = jsonParser.makeHttpRequest(severIp + "rank.php",
					params);

			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json = jArray.getJSONObject(i);

				name[i] = json.getString("food_name");
				numOfOrder[i] = json.getInt("numOfOrder");
				price[i] = json.getInt("price");
				rating[i] = json.getInt("rating");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}

	public void createMostOrdered() {
		if (tlRanking.getChildCount() > 1) {
			tlRanking.removeViews(1, 10);
		}
		getData();
		for (int i = 0; i < 10; i++) {
			// Create a TableRow dynamically
			trRanking = new TableRow(this);
			trRanking.setBackgroundColor(0xFF929292);
			trRanking.setPadding(0, 0, 0, 1);
			trRanking.setWeightSum(10);

			// Creating a TextView to add to the row
			tvRank = new TextView(this);
			tvRank.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, 1));
			tvRank.setBackgroundColor(0xFFFFFFFF);
			tvRank.setGravity(0x11);
			tvRank.setText(i + 1 + ".");
			tvRank.setTextSize(15);
			trRanking.addView(tvRank);

			tvFood = new TextView(this);
			tvFood.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, 7));
			tvFood.setBackgroundColor(0xFFFFFFFF);
			tvFood.setGravity(0x03 | 0x11);
			tvFood.setText(name[i]);
			tvFood.setTextSize(15);
			trRanking.addView(tvFood);

			tvPrice = new TextView(this);
			tvPrice.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, 1));
			tvPrice.setBackgroundColor(0xFFFFFFFF);
			tvPrice.setGravity(0x11);
			tvPrice.setText("$" + price[i]);
			tvPrice.setTextSize(15);
			trRanking.addView(tvPrice);

			tvRating = new TextView(this);
			tvRating.setLayoutParams(new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));
			tvRating.setBackgroundColor(0xFFFFFFFF);
			tvRating.setGravity(0x11);
			tvRating.setText(Integer.toString(rating[i]));
			tvRating.setTextSize(15);
			trRanking.addView(tvRating);

			// Add the TableRow to the TableLayout
			tlRanking.addView(trRanking, new TableLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));
		}
	}

	public void createMostRated() {
		if (tlRanking.getChildCount() > 1) {
			tlRanking.removeViews(1, 10);
		}
		getData();
		for (int i = 0; i < 10; i++) {
			// Create a TableRow dynamically
			trRanking = new TableRow(this);
			trRanking.setBackgroundColor(0xFF929292);
			trRanking.setPadding(0, 0, 0, 1);
			trRanking.setWeightSum(10);

			// Creating a TextView to add to the row
			tvRank = new TextView(this);
			tvRank.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, 1));
			tvRank.setBackgroundColor(0xFFFFFFFF);
			tvRank.setGravity(0x11);
			tvRank.setText(i + 1 + ".");
			tvRank.setTextSize(15);
			trRanking.addView(tvRank);

			tvFood = new TextView(this);
			tvFood.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, 7));
			tvFood.setBackgroundColor(0xFFFFFFFF);
			tvFood.setGravity(0x03 | 0x11);
			tvFood.setText(name[i]);
			tvFood.setTextSize(15);
			trRanking.addView(tvFood);

			tvPrice = new TextView(this);
			tvPrice.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, 1));
			tvPrice.setBackgroundColor(0xFFFFFFFF);
			tvPrice.setGravity(0x11);
			tvPrice.setText("$" + price[i]);
			tvPrice.setTextSize(15);
			trRanking.addView(tvPrice);

			tvRating = new TextView(this);
			tvRating.setLayoutParams(new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));
			tvRating.setBackgroundColor(0xFFFFFFFF);
			tvRating.setGravity(0x11);
			tvRating.setText(Integer.toString(numOfOrder[i]));
			tvRating.setTextSize(15);
			trRanking.addView(tvRating);

			// Add the TableRow to the TableLayout
			tlRanking.addView(trRanking, new TableLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));
		}
	}

	ImageButton mbFood, mbRecommend, mbFavourites, mbAccount;

	public void goFood(View view) {
		Intent i = new Intent(this, FoodMenu.class);
		mbFood = (ImageButton) findViewById(R.id.mbFood);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
	}

	public void goRecommend(View view) {
		Intent i = new Intent(this, Recommend.class);
		mbRecommend = (ImageButton) findViewById(R.id.mbRecommend);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
	}

	public void goFavourites(View view) {
		Intent i = new Intent(this, Favourites.class);
		mbFavourites = (ImageButton) findViewById(R.id.mbFavourites);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
	}

	public void goAccount(View view) {
		Intent i = new Intent(this, Account.class);
		mbAccount = (ImageButton) findViewById(R.id.mbAccount);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
