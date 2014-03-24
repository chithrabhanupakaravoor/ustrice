package com.example.ust_rice;

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

	RadioGroup rgRanking1;
	RadioButton rbMostOrdered, rbMostRated;

	TableLayout tlRanking;
	TableRow trRanking;
	TextView tvRank, tvFood, tvPrice, tvRating, tvVariable;

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
							createMostOrdered();
							tvVariable.setText("Rating");
							tvVariable.setTextColor(0xFFFF3B30);
						} 
						else if (checkedId == rbMostRated.getId()) {
							createMostRated();
							tvVariable.setText("Order");
							tvVariable.setTextColor(0xFFFF3B30);
						}
					}
				});


	}

	public void createMostOrdered() {
		if (tlRanking.getChildCount() > 1) {
			tlRanking.removeViews(1, 10);
		}

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
			tvRank.setText("1.");
			tvRank.setTextSize(15);
			trRanking.addView(tvRank);

			tvFood = new TextView(this);
			tvFood.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, 7));
			tvFood.setBackgroundColor(0xFFFFFFFF);
			tvFood.setGravity(0x03 | 0x11);
			tvFood.setText(Integer.toString(tlRanking.getChildCount()));
			tvFood.setTextSize(15);
			trRanking.addView(tvFood);

			tvPrice = new TextView(this);
			tvPrice.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, 1));
			tvPrice.setBackgroundColor(0xFFFFFFFF);
			tvPrice.setGravity(0x11);
			tvPrice.setText("$25.0");
			tvPrice.setTextSize(15);
			trRanking.addView(tvPrice);

			tvRating = new TextView(this);
			tvRating.setLayoutParams(new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));
			tvRating.setBackgroundColor(0xFFFFFFFF);
			tvRating.setGravity(0x11);
			tvRating.setText("10");
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
			tvRank.setText("2.");
			tvRank.setTextSize(15);
			trRanking.addView(tvRank);

			tvFood = new TextView(this);
			tvFood.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, 7));
			tvFood.setBackgroundColor(0xFFFFFFFF);
			tvFood.setGravity(0x03 | 0x11);
			tvFood.setText("3");
			tvFood.setTextSize(15);
			trRanking.addView(tvFood);

			tvPrice = new TextView(this);
			tvPrice.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, 1));
			tvPrice.setBackgroundColor(0xFFFFFFFF);
			tvPrice.setGravity(0x11);
			tvPrice.setText("$99.0");
			tvPrice.setTextSize(15);
			trRanking.addView(tvPrice);

			tvRating = new TextView(this);
			tvRating.setLayoutParams(new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));
			tvRating.setBackgroundColor(0xFFFFFFFF);
			tvRating.setGravity(0x11);
			tvRating.setText("85");
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
