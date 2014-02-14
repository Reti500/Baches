package com.geos.baches;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class OrdenesTrabajo extends Fragment {
	
	private Button hola;
	private RelativeLayout rl;
	private ListView listOrdenes;
	private ArrayAdapter<String> listAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		//View v = inflater.inflate(R.layout.fragment_trabajo, container, false);
		
		hola = new Button(container.getContext());
		hola.setText("Hola");
		
		rl = (RelativeLayout)inflater.inflate(R.layout.fragment_trabajo, container, false);
//		rl.addView(hola);
		
		listOrdenes = (ListView)rl.findViewById(R.id.listOrdenesTrabajo);
		
//		String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",  
//                "Jupiter", "Saturn", "Uranus", "Neptune"};
		String[] planets = new String[] {};
		ArrayList<String> planetList = new ArrayList<String>();
		planetList.addAll(Arrays.asList(planets));
		
		listAdapter = new ArrayAdapter<String>(container.getContext(), R.layout.adapter_list_ordenes, planetList);
		listOrdenes.setAdapter(listAdapter);
		
		listAdapter.add("Hola");
		listAdapter.add("Estas son");
		listAdapter.add("Las ordenes");
		listAdapter.add("De trabajo");
		listAdapter.add(":)");
		
		new Datos().execute("");
		return rl;
	}
	
	private class Datos extends AsyncTask<String, Void, String> {

		
		@Override
		protected String doInBackground(String... params) {
			//cargar = ProgressDialog.show(getActivity().getApplicationContext(), null, "Cargando ...", true);
			return null;
		}
	
		 @Override
        protected void onPostExecute(String result) {
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
	}
}
