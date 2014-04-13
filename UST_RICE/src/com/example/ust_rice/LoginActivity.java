package com.example.ust_rice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private JSONParser jsonParser = new JSONParser();
	private EditText username;
	private EditText password;
	private Button submit;
	private ProgressDialog dialog;
	private int success;
	private String message = new String();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		// StrictMode.enableDefaults();
		username = (EditText) findViewById(R.id.etUsername);
		password = (EditText) findViewById(R.id.etPassword);
		submit = (Button) findViewById(R.id.submit);
		submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new AttemptLogin().execute();
			}
		});

	}

	class AttemptLogin extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog = new ProgressDialog(LoginActivity.this);
			dialog.setMessage("Attempting login...");
			dialog.setIndeterminate(false);
			dialog.setCancelable(true);
			dialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {
			try {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("username", (username
						.getText().toString())));
				params.add(new BasicNameValuePair("password", (password
						.getText().toString())));
				JSONArray jArray = jsonParser.makeHttpRequest(jsonParser.URL
						+ "login.php", params);

				JSONObject json = jArray.getJSONObject(0);
				success = json.getInt("success");
				message = json.getString("message");

				if (success == 0) {
					return message;
				} else if (success == 1) {
					// To Do: Connect to home page

					Intent i = new Intent(LoginActivity.this,
							MainActivity.class);
					finish();
					startActivity(i);

					return message;
				}
			} catch (Exception e) {

			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			dialog.dismiss();
			if (result != null)
				Toast.makeText(LoginActivity.this, result, Toast.LENGTH_LONG)
						.show();
			else
				Toast.makeText(LoginActivity.this, "Connection Failed",
						Toast.LENGTH_SHORT).show();
		}
	}
}
