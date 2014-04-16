package com.example.ust_rice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Recommend extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommend);

	}
	Button bRanking, bPreferenceb,Nutrition ;
	ImageButton mbFood, mbRanking, mbFavourites, mbAccount;

	public void goRank(View view) {
		Intent i = new Intent(this, ReRanking.class);
		bRanking = (Button) findViewById(R.id.re_ranking);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
	}
	public void goPref(View view) {
		Intent i = new Intent(this, RePreference.class);
		bRanking = (Button) findViewById(R.id.re_preference);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
	}
	public void goNut(View view) {
		Intent i = new Intent(this, ReNutrition.class);
		bRanking = (Button) findViewById(R.id.re_nutrition);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
	}
	
	public void goFood(View view) {
		Intent i = new Intent(this, FoodMenu.class);
		mbFood = (ImageButton) findViewById(R.id.mbFood);
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
	}

	public void goRanking(View view) {
		Intent i = new Intent(this, Ranking.class);
		mbRanking = (ImageButton) findViewById(R.id.mbRanking);
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
		getMenuInflater().inflate(R.menu.recommend, menu);
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