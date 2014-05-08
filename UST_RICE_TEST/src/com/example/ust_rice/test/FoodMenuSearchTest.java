package com.example.ust_rice.test;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.ListView;

import com.example.ust_rice.FoodItem;
import com.example.ust_rice.FoodMenuSearch;

public class FoodMenuSearchTest extends
		ActivityInstrumentationTestCase2<FoodMenuSearch> {

	private FoodMenuSearch mActivity;

	ListView itemList;

	public FoodMenuSearchTest() {
		super(FoodMenuSearch.class);
	}

	@Override
	protected void setUp() throws Exception {
		// this method is called every time before any test execution
		super.setUp();

		mActivity = (FoodMenuSearch) getActivity(); // get current activity
		itemList = (ListView) mActivity
				.findViewById(com.example.ust_rice.R.id.listView1);
		
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
	public void testItemList() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				FoodItem.class.getName(), null, false);
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.

				itemList.performItemClick(itemList, 1, itemList.getItemIdAtPosition(1));
			}
		});

		FoodItem nextActivity = (FoodItem) getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitor, 5000);

		nextActivity.finish();
	}


}
