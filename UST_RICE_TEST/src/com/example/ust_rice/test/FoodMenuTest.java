package com.example.ust_rice.test;

import com.example.ust_rice.FoodMenu;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class FoodMenuTest extends
		ActivityInstrumentationTestCase2<FoodMenu> {

	private FoodMenu mActivity;
	ImageButton mbFood, mbRecommend, mbRanking, mbFavourites, mbAccount;
	
	RadioButton rbBreakfast, rbLunch, rbTea, rbDinner;
	RadioButton rbChinese, rbWestern, rbOthers;
	RadioButton rbSortby2, rbSortby3, rbSortby4;
	RadioButton rbCanteenA, rbCanteenB;
	RadioButton rbPrice25, rbPrice30;
	
	RadioButton rbMainTime, rbMainCuisine, rbMainSort;
	Button search;
	
	public FoodMenuTest() {
		super(FoodMenu.class);
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();

		mActivity = (FoodMenu) getActivity();

		search = (Button) mActivity
				.findViewById(com.example.ust_rice.R.id.bSearch);
		
		rbBreakfast = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbBreakfast);
		rbLunch = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbLunch);
		rbTea = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbTea);
		rbDinner = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbDinner);
		
		rbChinese = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbChinese);
		rbWestern = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbWestern);
		rbOthers = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbOthers);
		
		
		rbSortby2 = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbSortby2);
		rbSortby3 = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbSortby3);
		rbSortby4 = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbSortby4);
		
		
		rbCanteenA = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbCanteenA);
		rbCanteenB = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbCanteenB);
		
		rbPrice25 = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbPrice25);
		rbPrice30 = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbPrice30);
		
		
		mbFood = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbFood);
		mbRecommend = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbRecommend);
		mbRanking = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbRanking);
		mbFavourites = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbFavourites);
		mbAccount = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbAccount);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@SmallTest
	public void testView() {
		assertNotNull(getActivity());
	}
	
	@SmallTest
	public void testDefault() {
		TouchUtils.clickView(this, search);
	}
	
	@SmallTest
	public void testSearch() {
		TouchUtils.clickView(this, rbBreakfast);
		TouchUtils.clickView(this, rbWestern);
		TouchUtils.clickView(this, rbSortby2);
		TouchUtils.clickView(this, rbCanteenA);
		TouchUtils.clickView(this, rbPrice25);
		
		TouchUtils.clickView(this, search);
	}
	
	@SmallTest
	public void testFoodButton() {
		TouchUtils.clickView(this, mbFood);
	}
	
	@SmallTest
	public void testRecommendButton() {
		TouchUtils.clickView(this, mbRecommend);
	}
	
	@SmallTest
	public void testRankingButton() {
		TouchUtils.clickView(this, mbRanking);
	}
	
	@SmallTest
	public void testFavouritesButton() {
		TouchUtils.clickView(this, mbFavourites);
	}
	
	@SmallTest
	public void testAccountButton() {
		TouchUtils.clickView(this, mbAccount);
	}
}
