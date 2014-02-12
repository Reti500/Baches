package com.geos.baches;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class OrdenesTrabajo extends Fragment {
	
	private Button hola;
	private RelativeLayout rl;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		//View v = inflater.inflate(R.layout.fragment_trabajo, container, false);
		
		hola = new Button(container.getContext());
		hola.setText("Hola");
		
		rl = (RelativeLayout)inflater.inflate(R.layout.fragment_trabajo, container, false);
		rl.addView(hola);
		
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
