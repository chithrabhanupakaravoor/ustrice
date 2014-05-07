package com.example.ust_rice.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;

import com.example.ust_rice.LoginActivity;

public class LoginActivityTest extends
		ActivityInstrumentationTestCase2<LoginActivity> {

	private LoginActivity mActivity;
	Button submit;
	EditText textUsername, textPassword;
	
	public LoginActivityTest() {
		super(LoginActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		// this method is called every time before any test execution
		super.setUp();

		mActivity = (LoginActivity) getActivity(); // get current activity

		// link the objects with the activity objects
		submit = (Button) mActivity
				.findViewById(com.example.ust_rice.R.id.submit);
		textUsername = (EditText) mActivity
				.findViewById(com.example.ust_rice.R.id.etUsername);
		textPassword = (EditText) mActivity
				.findViewById(com.example.ust_rice.R.id.etPassword);
	}

	@Override
	protected void tearDown() throws Exception {
		// this method is called every time after any test execution
		// we want to clean the texts
		textUsername.clearComposingText();
		textPassword.clearComposingText();
		super.tearDown();
	}

	@SmallTest
	// SmallTest: this test doesn't interact with any file system or network.
	public void testView() { // checks if the activity is created
		assertNotNull(getActivity());
	}
	
	@SmallTest
	public void testWrongUsername() {

		/* INTERACTIONS */
		TouchUtils.tapView(this, textUsername); // tap the EditText textKilos
		sendKeys("x"); // sent x
		TouchUtils.tapView(this, textPassword);
		sendKeys("1234");
		TouchUtils.clickView(this, submit); // click the button
	}
	
	@SmallTest
	public void testWrongPassword() {
		
		TouchUtils.tapView(this, textUsername);
		sendKeys("Kelvin"); 
		TouchUtils.tapView(this, textPassword);
		sendKeys("x");
		TouchUtils.clickView(this, submit);
	}
	
	@SmallTest
	public void testSuccessfulLogin() {

		TouchUtils.tapView(this, textUsername);
		sendKeys("Kelvin"); 
		TouchUtils.tapView(this, textPassword);
		sendKeys("1234");
		TouchUtils.clickView(this, submit);
	}
}
