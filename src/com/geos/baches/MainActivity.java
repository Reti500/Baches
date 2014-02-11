package com.geos.baches;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	
	private ViewPager viewPager;
	private TabsPagerAdapter tabsAdapter;
	private ActionBar bar;
	
	private String[] tabs = {"Trabajo", "Reporte", "Mapa"};
	
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
		
		viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
			
			private static final float MIN_SCALE = 0.85f;
		    private static final float MIN_ALPHA = 0.5f;
		    
			@Override
			public void transformPage(View view, float position) {
				int pageWidth = view.getWidth();
		        int pageHeight = view.getHeight();

		        if (position < -1) { // [-Infinity,-1)
		            // This page is way off-screen to the left.
		            view.setAlpha(0);

		        } else if (position <= 1) { // [-1,1]
		            // Modify the default slide transition to shrink the page as well
		            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
		            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
		            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
		            if (position < 0) {
		                view.setTranslationX(horzMargin - vertMargin / 2);
		            } else {
		                view.setTranslationX(-horzMargin + vertMargin / 2);
		            }

		            // Scale the page down (between MIN_SCALE and 1)
		            view.setScaleX(scaleFactor);
		            view.setScaleY(scaleFactor);

		            // Fade the page relative to its size.
		            view.setAlpha(MIN_ALPHA +
		                    (scaleFactor - MIN_SCALE) /
		                    (1 - MIN_SCALE) * (1 - MIN_ALPHA));

		        } else { // (1,+Infinity]
		            // This page is way off-screen to the right.
		            view.setAlpha(0);
		        }
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
