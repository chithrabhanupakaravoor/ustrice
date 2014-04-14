package com.example.ust_rice.test;


import com.example.ust_rice.Ranking;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RankingTest extends
		ActivityInstrumentationTestCase2<Ranking> {

	//RadioGroup rgRanking1;
	RadioButton rbMostOrdered, rbMostRated;
	private Ranking mActivity;
	ImageButton mbFood, mbRecommend, mbRanking, mbFavourites, mbAccount;
	
	public RankingTest() {
		super(Ranking.class);
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();

		mActivity = (Ranking) getActivity();

//		rgRanking1 = (RadioGroup) mActivity
//				.findViewById(com.example.ust_rice.R.id.rgRanking1);
		
		rbMostOrdered = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbMostOrdered);
		rbMostRated = (RadioButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rbMostRated);
		
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
	public void testMostOrdered() {
		TouchUtils.clickView(this, rbMostOrdered);
	}
	
	@SmallTest
	public void testMostRated() {
		TouchUtils.clickView(this, rbMostRated);
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
