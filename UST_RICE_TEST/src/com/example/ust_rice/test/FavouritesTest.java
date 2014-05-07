package com.example.ust_rice.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;

import com.example.ust_rice.Favourites;

public class FavouritesTest extends ActivityInstrumentationTestCase2<Favourites> {

	private Favourites mActivity;
	
	public FavouritesTest() {
		super(Favourites.class);		
	}
	
	@Override
	protected void setUp() throws Exception {
		// this method is called every time before any test execution
		super.setUp();

		mActivity = (Favourites) getActivity(); // get current activity

		// link the objects with the activity objects

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
}
