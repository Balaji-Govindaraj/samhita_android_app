package com.example.samhita;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.samhita.SimpleGestureFilter.SimpleGestureListener;
import com.example.samhita.SimpleGestureFilter;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements SimpleGestureListener{
	/*private GestureDetectorCompat mDetector;
	Animation slide_in_left, slide_out_right;
	Animation slide_in_right, slide_out_left;
	ViewFlipper viewFlipper;*/
	 private SimpleGestureFilter detector;
	 private TextView textview1;
	int mPosition = -1;	
	String mTitle = "";
	
	// Array of strings storing country names
    String[] mCountries ;
    Animation animation;
    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] mFlags = new int[]{
                R.drawable.home,
                R.drawable.onsite,
                R.drawable.online,
                R.drawable.general,
                R.drawable.mega,
                R.drawable.workshop,
                R.drawable.mail,
    };

    // Array of strings to initial counts
    String[] mCount = new String[]{
        "", "", "", "", "", "",""};
	
	private DrawerLayout mDrawerLayout;	
	private ListView mDrawerList;	
	private ActionBarDrawerToggle mDrawerToggle;	
	private LinearLayout mDrawer ;	
	private List<HashMap<String,String>> mList ;	
	private SimpleAdapter mAdapter;	
	final private String COUNTRY = "country";	
	final private String FLAG = "flag";	
	final private String COUNT = "count";
	
	TextView textview2;
	private ViewFlipper viewFlipper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textview1=(TextView)findViewById(R.id.MarqueeText);
		textview2=(TextView)findViewById(R.id.MarqueeText1);
		if(isNetworkAvailable())
    	{
    		try
    		{
    			new Aync_data_set_event1(this,textview1).execute("http://balaji001.netne.net/android/android/notification1.php");
    			new Aync_data_set_event1(this,textview2).execute("http://balaji001.netne.net/android/android/notification2.php");
    		//	String text1=new Aync_data_set_event1(this,textview1).execute("http://balaji001.netne.net/android/android/notification1.php").get();
    		//	String text2=new Aync_data_set_event1(this,textview1).execute("http://balaji001.netne.net/android/android/notification2.php").get();    		
    		//	textview1.setText(text1);
    		//	textview2.setText(text2);
    			Toast.makeText(getApplicationContext(),"Use Double Tap to Move Next Page",Toast.LENGTH_SHORT).show();
    		}
    		catch(Exception e){}
    	}
    	else
    	{
    		textview1.setText("");
    		textview2.setText("");
    		Toast.makeText(getApplicationContext(),"Use Double Tap to Move Next Page.\nPlease Connect to Internet.",Toast.LENGTH_LONG).show();
    	}
		
		textview1.setSelected(true);
		textview2.setSelected(true);
		
		
		 
		 detector = new SimpleGestureFilter(this,this);
		 
		mCountries = getResources().getStringArray(R.array.countries);
		
		// Title of the activity
		mTitle="Samhita 2K16";
		//mTitle = (String)getTitle();
		
		// Getting a reference to the drawer listview
		mDrawerList = (ListView) findViewById(R.id.drawer_list);
		
		// Getting a reference to the sidebar drawer ( Title + ListView )
		mDrawer = ( LinearLayout) findViewById(R.id.drawer);
		
		// Each row in the list stores country name, count and flag
        mList = new ArrayList<HashMap<String,String>>();

        
        for(int i=0;i<7;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put(COUNTRY, mCountries[i]);
            hm.put(COUNT, mCount[i]);
            hm.put(FLAG, Integer.toString(mFlags[i]) );
            mList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { FLAG,COUNTRY,COUNT };

        // Ids of views in listview_layout
        int[] to = { R.id.flag , R.id.country , R.id.count};

        // Instantiating an adapter to store each items
        // R.layout.drawer_layout defines the layout of each item
        mAdapter = new SimpleAdapter(this, mList, R.layout.drawer_layout, from, to);
        
        // Getting reference to DrawerLayout
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);        
        
        // Creating a ToggleButton for NavigationDrawer with drawer event listener
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer , R.string.drawer_open,R.string.drawer_close){
        	
        	 /** Called when drawer is closed */
            public void onDrawerClosed(View view) {               
            	highlightSelectedCountry();            		
                supportInvalidateOptionsMenu();       
            }

            /** Called when a drawer is opened */
            public void onDrawerOpened(View drawerView) {            	
                getSupportActionBar().setTitle("Samhita 2K16");            	
            	supportInvalidateOptionsMenu();                
            }
        };
        
        // Setting event listener for the drawer
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        
        // ItemClick event handler for the drawer items
        mDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				
				// Increment hit count of the drawer list item
				incrementHitCount(position);			
				 if(position==0)
				 {
					 Intent intent1=new Intent(getApplicationContext(),Create_Account.class);
					 startActivity(intent1);
					 overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
						
				 }
				 else if(position==1)
				 {
					 Intent intent1=new Intent(getApplicationContext(),Onsite_List_Main.class);
					 startActivity(intent1);
					 overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
				 }
				 else if(position==2)
				 {
					 Intent intent1=new Intent(getApplicationContext(),Online_List_Main.class);
					 startActivity(intent1);
					 overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
						
				 }
				 else if(position==3)
				 {
					 Intent intent1=new Intent(getApplicationContext(),General_List_Main.class);
					 startActivity(intent1);
					 overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
				 }
				 else if(position==4)
				 {
					 Intent intent1=new Intent(getApplicationContext(),Mega_Event.class);
					 startActivity(intent1); 
					 overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
				 }
				 else if(position==5) 
				 { 
					 Intent intent1=new Intent(getApplicationContext(),Workshop_List_Main.class);
					 startActivity(intent1); 
					 overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
				 }
				 else if(position==6)
				 {
					 Intent intent1=new Intent(getApplicationContext(),Contact_List_Main.class);
					 startActivity(intent1); 
					 overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
				 }
				/* else{ // Show message box for countries : 5 to 9				
					Toast.makeText(getApplicationContext(), mCountries[position], Toast.LENGTH_LONG).show();
				}*/
				
				// Closing the drawer
				mDrawerLayout.closeDrawer(mDrawer);		
			}
		});
        
        
        // Enabling Up navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);     
        
        getSupportActionBar().setDisplayShowHomeEnabled(true);        

        // Setting the adapter to the listView
        mDrawerList.setAdapter(mAdapter);   
        
	}
	
	 @Override
	    public boolean dispatchTouchEvent(MotionEvent me){
	        // Call onTouchEvent of SimpleGestureFilter class
	         this.detector.onTouchEvent(me);
	       return super.dispatchTouchEvent(me);
	    }
	    @Override
	     public void onSwipe(int direction) {
	      String str = "";
	      
	      switch (direction) {
	      
	      case SimpleGestureFilter.SWIPE_RIGHT : 
	    	  
	    	  Intent iii1=new Intent(MainActivity.this,MainActivity1.class);
		  	  startActivity(iii1);
		  	overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
	          break;
	      case SimpleGestureFilter.SWIPE_LEFT :  
	    	  Intent iii2=new Intent(MainActivity.this,MainActivity1.class);
		  	  startActivity(iii2);
		  	overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
	    	  break;
	    	  
	      case SimpleGestureFilter.SWIPE_DOWN :  
	    	/*  Intent iii3=new Intent(MainActivity.this,MainActivity1.class);
		  	  startActivity(iii3);
		  	overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);*/
		  	  
		  	  break;
	      case SimpleGestureFilter.SWIPE_UP :    
	    	/*  Intent iii4=new Intent(MainActivity.this,MainActivity1.class);
		  	  startActivity(iii4);
		  	overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);*/
		  	  break;
	      }
	     }
	      
	     @Override
	     public void onDoubleTap() {
	    	  Intent iii5=new Intent(MainActivity.this,MainActivity1.class);
		  	  startActivity(iii5);
		  	overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
//	        Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
	     }
	          
	     
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
	          return true;
	    }
		return super.onOptionsItemSelected(item);
	}	
			
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void incrementHitCount(int position){
		HashMap<String, String> item = mList.get(position);
		String count = item.get(COUNT);
		item.remove(COUNT);
		if(count.equals("")){
			count = "";
		}else{
			//int cnt = Integer.parseInt(count.trim());
			//cnt ++;
			count = "";
		}				
		item.put(COUNT, count);				
		mAdapter.notifyDataSetChanged();
	}
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
	public void showFragment(int position){
		
		//Currently selected country
        mTitle = mCountries[position];	

        // Creating a fragment object
        CountryFragment cFragment = new CountryFragment();

        // Creating a Bundle object
        Bundle data = new Bundle();

        // Setting the index of the currently selected item of mDrawerList
        data.putInt("position", position);

        // Setting the position to the fragment
        cFragment.setArguments(data);

        // Getting reference to the FragmentManager
        FragmentManager fragmentManager  = getSupportFragmentManager();

        // Creating a fragment transaction
        FragmentTransaction ft = fragmentManager.beginTransaction();

        // Adding a fragment to the fragment transaction
        ft.replace(R.id.content_frame, cFragment);

        // Committing the transaction
        ft.commit();
	}
	
	// Highlight the selected country : 0 to 4
	public void highlightSelectedCountry(){
		int selectedItem = mDrawerList.getCheckedItemPosition();
    	
    	if(selectedItem > 7)
    		mDrawerList.setItemChecked(mPosition, true);
    	else
    		mPosition = selectedItem;
    	
    	if(mPosition!=-1)
    		getSupportActionBar().setTitle(mCountries[mPosition]);
	}
	
}