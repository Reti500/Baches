package com.geos.baches;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	
	private ViewPager viewPager;
	private TabsPagerAdapter tabsAdapter;
	private ActionBar bar;
	
	private String[] tabs = {"Trabajo", "Reporte"};
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		viewPager = (ViewPager)findViewById(R.id.contenedor);
		bar = getActionBar();
		tabsAdapter = new TabsPagerAdapter(getSupportFragmentManager());
		
		viewPager.setAdapter(tabsAdapter);
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		for (String tab_name : tabs){
			bar.addTab(bar.newTab().setText(tab_name).setTabListener(this));
		}
		
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				bar.setSelectedNavigationItem(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

//	private ActionBar bar;
//	private ActionBar.Tab tab1;
//	private ActionBar.Tab tab2;
//	private Fragment tab1Frag;
//	private Fragment tab2Frag;
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		
//		bar = getActionBar();
//		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//		
//		bar.setDisplayShowTitleEnabled(false);
//		
//		tab1 = bar.newTab().setText("Trabajo");
//		tab2 = bar.newTab().setText("Reporte");
//		
//		tab1Frag = new OrdenesTrabajo();
//		tab2Frag = new NuevoReporte();
//		
//		tab1.setTabListener(new BachesTabListener(tab1Frag));
//		tab2.setTabListener(new BachesTabListener(tab2Frag));
//		
//		bar.addTab(tab1);
//		bar.addTab(tab2);
//	}
//
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
