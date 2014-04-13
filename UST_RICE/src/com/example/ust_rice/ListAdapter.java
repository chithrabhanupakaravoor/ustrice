package com.example.ust_rice;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String> {
	private final Activity context;
	private final String[] name;
	private final String[] canteen;
	private final int[] price;

	// private final Integer[] imageId;

	public ListAdapter(Activity context, String[] name, String[] canteen,
			int[] price) {
		super(context, R.layout.list_item, name);
		this.context = context;
		this.name = name;
		this.canteen = canteen;
		this.price = price;
		// this.imageId = imageId;

	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.list_item, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.textView1);
		TextView txtTitle2 = (TextView) rowView.findViewById(R.id.textView2);
		TextView txtTitle3 = (TextView) rowView.findViewById(R.id.textView3);
		txtTitle.setText(name[position]);
		txtTitle2.setText(canteen[position]);
		txtTitle3.setText("$" + Integer.toString(price[position]));
		return rowView;
	}

}
