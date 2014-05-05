package com.example.ust_rice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FoodMenu extends Activity {

	RadioGroup rgCanteen, rgTime, rgCuisine, rgPrice, rgSortby;
	String sCanteen = "canteenAll";
	String sTime = "allDay";
	String sCuisine = "cuisineAll";
	String sPrice = "99";
	String sSortby = "canteen";
	TextView fmCanteen, fmTime, fmCuisine, fmPrice;
	RadioButton rbMainTime, rbMainCuisine, rbMainSort;
	Button search;
	ImageButton mbRecommend, mbRanking, mbFavourites, mbAccount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_menu);

		rgCanteen = (RadioGroup) findViewById(R.id.rgCanteen);
		rgTime = (RadioGroup) findViewById(R.id.rgTime);
		rgCuisine = (RadioGroup) findViewById(R.id.rgCuisine);
		rgPrice = (RadioGroup) findViewById(R.id.rgPrice);
		rgSortby = (RadioGroup) findViewById(R.id.rgSortby);
		fmCanteen = (TextView) findViewById(R.id.fmCanteen);
		fmTime = (TextView) findViewById(R.id.fmTime);
		fmCuisine = (TextView) findViewById(R.id.fmCuisine);
		fmPrice = (TextView) findViewById(R.id.fmPrice);
		search = (Button) findViewById(R.id.bSearch);

		rbMainTime = (RadioButton) findViewById(R.id.rbAllday);
		rbMainSort = (RadioButton) findViewById(R.id.rbSortby1);
		rbMainCuisine = (RadioButton) findViewById(R.id.rbCuisineAll);

		getSearch();
		search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(FoodMenu.this, FoodMenuSearch.class);

				i.putExtra("sCanteen", sCanteen);
				i.putExtra("sTime", sTime);
				i.putExtra("sCuisine", sCuisine);
				i.putExtra("sPrice", sPrice);
				i.putExtra("sSortby", sSortby);

				startActivity(i);
			}

		});
	}

	public void mainTime(View v) {
		if (rbMainTime != null) {
			rbMainTime.setChecked(false);
		}
		((RadioButton) v).setChecked(true);
		rbMainTime = (RadioButton) v;
		if (rbMainTime.getId() == R.id.rbAllday) {
			sTime = "allday";

		} else if (rbMainTime.getId() == R.id.rbBreakfast) {
			sTime = "breakfast";

		} else if (rbMainTime.getId() == R.id.rbLunch) {
			sTime = "lunch";

		} else if (rbMainTime.getId() == R.id.rbTea) {
			sTime = "tea";

		} else if (rbMainTime.getId() == R.id.rbDinner) {
			sTime = "dinner";

		}
	}

	public void mainCuisine(View v) {
		if (rbMainCuisine != null) {
			rbMainCuisine.setChecked(false);
		}
		((RadioButton) v).setChecked(true);
		rbMainCuisine = (RadioButton) v;
		if (rbMainCuisine.getId() == R.id.rbCuisineAll) {
			sCuisine = "cuisineAll";

		} else if (rbMainCuisine.getId() == R.id.rbChinese) {
			sCuisine = "chinese";

		} else if (rbMainCuisine.getId() == R.id.rbWestern) {
			sCuisine = "western";

		} else if (rbMainCuisine.getId() == R.id.rbOthers) {
			sCuisine = "others";

		}
	}

	public void mainSort(View v) {
		if (rbMainSort != null) {
			rbMainSort.setChecked(false);
		}
		((RadioButton) v).setChecked(true);
		rbMainSort = (RadioButton) v;
		if (rbMainSort.getId() == R.id.rbSortby1) {
			sSortby = "canteen";

		} else if (rbMainSort.getId() == R.id.rbSortby2) {
			sSortby = "offering";

		} else if (rbMainSort.getId() == R.id.rbSortby3) {
			sSortby = "cuisine";

		} else if (rbMainSort.getId() == R.id.rbSortby4) {
			sSortby = "price";

		}
	}

	public void getSearch() {

		rgCanteen
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.rbCanteenAll) {
							sCanteen = "canteenAll";

						} else if (checkedId == R.id.rbCanteenA) {
							sCanteen = "canteenA";

						} else if (checkedId == R.id.rbCanteenB) {
							sCanteen = "canteenB";

						}
					}
				});

		rgPrice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.rbPriceAll) {
					sPrice = "99";

				} else if (checkedId == R.id.rbPrice25) {
					sPrice = "25";

				} else if (checkedId == R.id.rbPrice30) {
					sPrice = "30";

				}
			}
		});

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
