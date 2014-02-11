package com.geos.baches;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class Mapa extends Fragment {
	
	private RelativeLayout rl;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		rl = (RelativeLayout)inflater.inflate(R.layout.fragment_mapa, container, false);
		
		return rl;
	}
}
