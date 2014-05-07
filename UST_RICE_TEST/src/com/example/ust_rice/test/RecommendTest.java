package com.example.ust_rice.test;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.ImageButton;

import com.example.ust_rice.Account;
import com.example.ust_rice.Favourites;
import com.example.ust_rice.FoodMenu;
import com.example.ust_rice.Ranking;
import com.example.ust_rice.ReNutrition;
import com.example.ust_rice.RePreference;
import com.example.ust_rice.ReRanking;
import com.example.ust_rice.Recommend;

public class RecommendTest extends ActivityInstrumentationTestCase2<Recommend> {

	private Recommend mActivity;

	ImageButton bReRanking, bNutrition, bDiet, bFood, bFavourites, bRanking,
			bAccount;

	public RecommendTest() {
		super(Recommend.class);
	}

	@Override
	protected void setUp() throws Exception {
		// this method is called every time before any test execution
		super.setUp();

		mActivity = (Recommend) getActivity(); // get current activity

		bReRanking = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.reRank);
		bNutrition = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.reNutrition);
		bDiet = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.rePreference);
		bFood = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbFood);
		bFavourites = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbFavourites);
		bRanking = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbRanking);
		bAccount = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbAccount);
	}

	@Override
	protected void tearDown() throws Exception {
		// this method is called every time after any test execution
		// we want to clean the texts
		super.tearDown();
	}

	@SmallTest
	// SmallTest: this test doesn't interact with any file system or network.
	public void testView() { // checks if the activity is created
		assertNotNull(getActivity());
	}

	@SmallTest
	public void testReRankingButton() {

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				ReRanking.class.getName(), null, false);
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.

				bReRanking.performClick();
			}
		});

		ReRanking nextActivity = (ReRanking) getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitor, 5000);

		nextActivity.finish();
	}

	public void testNutButton() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				ReNutrition.class.getName(), null, false);
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.

				bNutrition.performClick();
			}
		});

		ReNutrition nextActivity = (ReNutrition) getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitor, 5000);

		nextActivity.finish();
	}

	public void testPrefButton() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				RePreference.class.getName(), null, false);
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.

				bDiet.performClick();
			}
		});

		RePreference nextActivity = (RePreference) getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitor, 5000);

		nextActivity.finish();
	}

	public void testFoodButton() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				FoodMenu.class.getName(), null, false);
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.

				bFood.performClick();
			}
		});

		FoodMenu nextActivity = (FoodMenu) getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitor, 5000);

		nextActivity.finish();
	}
	
	public void testRankingButton() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				Ranking.class.getName(), null, false);
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.

				bRanking.performClick();
			}
		});

		Ranking nextActivity = (Ranking) getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitor, 5000);

		nextActivity.finish();
	}
	
	public void testFavouritesButton() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				Favourites.class.getName(), null, false);
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.

				bFavourites.performClick();
			}
		});

		Favourites nextActivity = (Favourites) getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitor, 5000);

		nextActivity.finish();
	}
	
	public void testAccountButton() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				Account.class.getName(), null, false);
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.

				bAccount.performClick();
			}
		});

		Account nextActivity = (Account) getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitor, 5000);

		nextActivity.finish();
	}
}
