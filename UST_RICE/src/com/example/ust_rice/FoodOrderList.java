package com.example.ust_rice;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class FoodOrderList extends Activity {

	ArrayList<String> foodID = new ArrayList<String>();
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> canteen = new ArrayList<String>();
	ArrayList<String> time = new ArrayList<String>();
	ArrayList<String> cuisine = new ArrayList<String>();
	ArrayList<String> price = new ArrayList<String>();
	ArrayList<String> rating = new ArrayList<String>();
	ArrayList<String> nut = new ArrayList<String>();

	String itemFoodID, itemName, itemCanteen, itemTime, itemCuisine, itemPrice,
			itemRating, itemNut;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_order_list);
		TextView totalPrice = (TextView) findViewById(R.id.totalPrice);

		foodID = ((UserData) this.getApplication()).getFoodIDList();
		name = ((UserData) this.getApplication()).getNameList();
		canteen = ((UserData) this.getApplication()).getCanteenList();
		time = ((UserData) this.getApplication()).getTimeList();
		cuisine = ((UserData) this.getApplication()).getCuisineList();
		price = ((UserData) this.getApplication()).getPriceList();
		rating = ((UserData) this.getApplication()).getRatingList();
		nut = ((UserData) this.getApplication()).getNutList();

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

				Intent i = new Intent(FoodOrderList.this,
						FoodOrderListItem.class);
				i.putExtra("itemFoodID", itemFoodID);
				i.putExtra("itemName", itemName);
				i.putExtra("itemCanteen", itemCanteen);
				i.putExtra("itemTime", itemTime);
				i.putExtra("itemCuisine", itemCuisine);
				i.putExtra("itemPrice", itemPrice);
				i.putExtra("itemRating", itemRating);
				i.putExtra("itemNut", itemNut);
				i.putExtra("itemPosition", position);
				startActivityForResult(i, 0);

			}
		});

		totalPrice.setText("$" + addPrice(price));
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		finish();
		Intent i = new Intent(FoodOrderList.this, FoodOrderList.class);
		startActivity(i);
	}

	public void clearList(View view) {
		((UserData) this.getApplication()).clearList();
		finish();
	}

	public String addPrice(ArrayList<String> price) {
		int total = 0;

		for (int i = 0; i < price.size(); i++) {
			total += Integer.parseInt(price.get(i));
		}
		return Integer.toString(total);

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
