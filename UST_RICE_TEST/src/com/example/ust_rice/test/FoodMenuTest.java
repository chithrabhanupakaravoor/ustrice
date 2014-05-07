package com.example.ust_rice.test;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.ust_rice.Account;
import com.example.ust_rice.Favourites;
import com.example.ust_rice.FoodMenu;
import com.example.ust_rice.FoodMenuSearch;
import com.example.ust_rice.Ranking;
import com.example.ust_rice.Recommend;

public class FoodMenuTest extends ActivityInstrumentationTestCase2<FoodMenu> {

	private FoodMenu mActivity;

	ImageButton bFood, bRecommend, bRanking, bFavourites, bAccount;

	Button search;


	public FoodMenuTest() {
		super(FoodMenu.class);
	}

	@Override
	protected void setUp() throws Exception {
		// this method is called every time before any test execution
		super.setUp();

		mActivity = (FoodMenu) getActivity(); // get current activity
		
		bRecommend = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbRecommend);
		bRanking = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbRanking);
		bFavourites = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbFavourites);
		bAccount = (ImageButton) mActivity
				.findViewById(com.example.ust_rice.R.id.mbAccount);
		search = (Button) mActivity
				.findViewById(com.example.ust_rice.R.id.bSearch);
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

	public void testRecommendButton() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				Recommend.class.getName(), null, false);
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.

				bRecommend.performClick();
			}
		});

		Recommend nextActivity = (Recommend) getInstrumentation()
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

	public void testSearchItem() {

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				FoodMenuSearch.class.getName(), null, false);
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.

				search.performClick();
			}
		});

		FoodMenuSearch nextActivity = (FoodMenuSearch) getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitor, 5000);

		nextActivity.finish();
	}
}
