package com.example.ust_rice;

import java.util.ArrayList;

import android.app.Application;

public class UserData extends Application {
	private ArrayList<String> foodID = new ArrayList<String>();
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<String> canteen = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	private ArrayList<String> cuisine = new ArrayList<String>();
	private ArrayList<String> price = new ArrayList<String>();
	private ArrayList<String> rating = new ArrayList<String>();
	private ArrayList<String> nut = new ArrayList<String>();

	public void addList(String iFoodID, String iName, String iCanteen,
			String iOfferingTime, String iCuisine, String iPrice,
			String iRating, String iNut) {
		foodID.add(iFoodID);
		name.add(iName);
		canteen.add(iCanteen);
		time.add(iOfferingTime);
		cuisine.add(iCuisine);
		price.add(iPrice);
		rating.add(iRating);
		nut.add(iNut);

	}

	public void deleteItem(int i) {
		foodID.remove(i);
		name.remove(i);
		canteen.remove(i);
		time.remove(i);
		cuisine.remove(i);
		price.remove(i);
		rating.remove(i);
		nut.remove(i);
	}

	public void clearList() {
		foodID.clear();
		name.clear();
		canteen.clear();
		time.clear();
		cuisine.clear();
		price.clear();
		rating.clear();
		nut.clear();
	}

	public ArrayList<String> getFoodIDList() {
		return foodID;
	}

	public ArrayList<String> getNameList() {
		return name;
	}

	public ArrayList<String> getCanteenList() {
		return canteen;
	}

	public ArrayList<String> getTimeList() {
		return time;
	}

	public ArrayList<String> getCuisineList() {
		return cuisine;
	}

	public ArrayList<String> getPriceList() {
		return price;
	}

	public ArrayList<String> getRatingList() {
		return rating;
	}

	public ArrayList<String> getNutList() {
		return nut;
	}
}
