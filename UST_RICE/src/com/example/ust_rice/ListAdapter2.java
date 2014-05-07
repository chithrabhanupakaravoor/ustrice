package com.example.ust_rice;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter2 extends ArrayAdapter<String> {
	private final Activity context;
	private final ArrayList<String> name;
	private final ArrayList<String> canteen;
	private final ArrayList<String> price;
	private final ArrayList<String> orderTime;
	
//	private final String[] name;
//	private final String[] canteen;
//	private final int[] price;

	// private final Integer[] imageId;

	public ListAdapter2(Activity context, ArrayList<String> name, ArrayList<String> canteen,
			ArrayList<String> price, ArrayList<String> orderTime) {
		super(context, R.layout.record_list_item, name);
		this.context = context;
		this.name = name;
		this.canteen = canteen;
		this.price = price;
		this.orderTime = orderTime;
		// this.imageId = imageId;

	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.record_list_item, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.textView1);
		TextView txtTitle2 = (TextView) rowView.findViewById(R.id.textView2);
		TextView txtTitle3 = (TextView) rowView.findViewById(R.id.textView3);
		TextView txtTitle4 = (TextView) rowView.findViewById(R.id.textView4);
		txtTitle.setText(name.get(position));
		txtTitle2.setText(canteen.get(position));
		txtTitle3.setText("$" + price.get(position));
		txtTitle4.setText(orderTime.get(position));
		return rowView;
	}

}
