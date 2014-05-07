package com.example.ust_rice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FoodOrderListItem extends Activity {

	TextView tvItemFoodName, tvItemCanteen, tvItemTime, tvItemCuisine,
			tvItemPrice, tvItemRating;

	String name;
	int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_order_list_item);

		Intent intent = getIntent();

		tvItemFoodName = (TextView) findViewById(R.id.tvItemFoodName);
		tvItemCanteen = (TextView) findViewById(R.id.tvItemCanteen2);
		tvItemTime = (TextView) findViewById(R.id.tvItemTime2);
		tvItemCuisine = (TextView) findViewById(R.id.tvItemCuisine2);
		tvItemPrice = (TextView) findViewById(R.id.tvItemPrice2);
		tvItemRating = (TextView) findViewById(R.id.tvItemRating2);

		tvItemFoodName.setText(intent.getStringExtra("itemName"));
		tvItemCanteen.setText(intent.getStringExtra("itemCanteen"));
		tvItemTime.setText(intent.getStringExtra("itemTime"));
		tvItemCuisine.setText(intent.getStringExtra("itemCuisine"));
		tvItemPrice.setText("$" + intent.getStringExtra("itemPrice"));
		tvItemRating.setText(intent.getStringExtra("itemRating"));

		name = intent.getStringExtra("itemName");
		position = intent.getIntExtra("itemPosition", 0);
	}

	public void deleteOrderListItem(View view) {
		((UserData) this.getApplication()).deleteItem(position);
		finish();
	}

	public void cancel(View view) {
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
