package com.example.ust_rice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	ImageButton mbFood, mbRecommend, mbRanking, mbFavourites, mbAccount;

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


