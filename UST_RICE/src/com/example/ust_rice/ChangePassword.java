package com.example.ust_rice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends Activity {

	String userID, a, b;
	JSONParser jsonParser = new JSONParser();
	EditText newPass, enterAgain;
	Button changePass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_password);

		StrictMode.enableDefaults();

		userID = ((UserData) this.getApplication()).getUserID();
		newPass = (EditText) findViewById(R.id.et1);
		enterAgain = (EditText) findViewById(R.id.et2);

	}

	public void Submit(View v) {
		if (sameInput()) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("userID", userID));
			params.add(new BasicNameValuePair("password", newPass.getText()
					.toString()));
			jsonParser.makeHttpRequest(jsonParser.URL + "changePassword.php",
					params);

			finish();
			Toast.makeText(this, "Password changed!", Toast.LENGTH_SHORT)
					.show();
		} else
			Toast.makeText(this, "Password incorrect!", Toast.LENGTH_SHORT)
					.show();
	}

	boolean sameInput() {
		if (newPass.getText().toString()
				.equals(enterAgain.getText().toString()))
			return true;
		else
			return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.change_password, menu);
		return true;
	}

}
