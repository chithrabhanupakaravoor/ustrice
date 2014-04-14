package com.example.ust_rice.test;

import com.example.ust_rice.MainActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mActivity;
	ImageButton mbFood, mbRecommend, mbRanking, mbFavourites, mbAccount;
	
	public MainActivityTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();

		mActivity = (MainActivity) getActivity();

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
