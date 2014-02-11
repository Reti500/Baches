package com.geos.baches;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.util.Log;

public class BachesTabListener implements ActionBar.TabListener {

	private Fragment fragment;
	
	public BachesTabListener(Fragment fg){
		this.fragment = fg;
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Log.i("ActionBar", tab.getText() + " reseleccionada.");
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Log.i("ActionBar", tab.getText() + " seleccionada");
		ft.replace(R.id.contenedor, fragment);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Log.i("ActionBar", tab.getText() + " deseleccionada.");
		ft.remove(fragment);
	}

}
