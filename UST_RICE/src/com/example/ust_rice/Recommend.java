package com.example.ust_rice;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Recommend extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommend);
		checkOfferingTime();
	}

	@SuppressLint("SimpleDateFormat")
	public boolean checkOfferingTime() {
		SimpleDateFormat hour = new SimpleDateFormat("HH");

		Date currentTime = new Date();

		if (Integer.parseInt(hour.format(currentTime)) <= 8
				|| Integer.parseInt(hour.format(currentTime)) >= 21) {
			Toast.makeText(this, "Canteen is closed!", Toast.LENGTH_SHORT)
					.show();
			return false;
		} else
			return true;

	}

	ImageButton bRanking, bPreference, bNutrition, mbFood, mbRanking,
			mbFavourites, mbAccount;

	public void goRank(View view) {
		if (checkOfferingTime()) {
			Intent i = new Intent(this, ReRanking.class);
			bRanking = (ImageButton) findViewById(R.id.reRank);
			startActivity(i);
		}
	}

	public void goPref(View view) {
		if (checkOfferingTime()) {
			Intent i = new Intent(this, RePreference.class);
			bPreference = (ImageButton) findViewById(R.id.rePreference);
			startActivity(i);
		}
	}

	public void goNut(View view) {
		if (checkOfferingTime()) {
			Intent i = new Intent(this, ReNutrition.class);
			bNutrition = (ImageButton) findViewById(R.id.reNutrition);
			startActivity(i);
		}
	}

	public void goFood(View view) {
		Intent i = new Intent(this, FoodMenu.class);
		mbFood = (ImageButton) findViewById(R.id.mbFood);
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

	public void goFavourites(View view) {
		Intent i = new Intent(this, Favourites.class);
		mbFavourites = (ImageButton) findViewById(R.id.mbFavourites);
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
		getMenuInflater().inflate(R.menu.recommend, menu);
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
