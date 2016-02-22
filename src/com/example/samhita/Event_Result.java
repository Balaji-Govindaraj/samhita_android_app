package com.example.samhita;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity; 
import android.app.ProgressDialog;
import android.app.LauncherActivity.ListItem;
import android.content.Context; 
import android.content.Intent;
import android.content.SharedPreferences; 
import android.content.SharedPreferences.Editor; 
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle; 
import android.view.Menu; 
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.samhita.*;

import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;
import android.widget.AdapterView.OnItemClickListener;

public class Event_Result extends Activity{
	String username;
	TextView login_username;
	ListView out;
	String url;
//	loading l;
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) 
	{ 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_welcome);
        
		ActionBar ab = getActionBar(); 
        ab.setDisplayHomeAsUpEnabled(true);

        Bundle b=getIntent().getExtras();
		url=b.getString("EVENT_NAME");
		out=(ListView)findViewById(R.id.out);
		ListView listView = (ListView) findViewById(R.id.out);
    	if(isNetworkAvailable())
    	{
    		try
    		{
    			new Aync_data_set_event(this,listView).execute("http://samhita.org.in/event_select.php?event_name="+url);		
    		}
    		catch(Exception e){}
    	}
    	else
    	{
    		Toast.makeText(getApplicationContext(),"Please Connect to Internet",Toast.LENGTH_LONG).show();
    	}
		
	}
	 @Override
		public boolean onOptionsItemSelected(MenuItem item) { 
		    switch (item.getItemId()) {
		        case android.R.id.home:
		            this.finish();
		        	// app icon in action bar clicked; go home
		            return true;
		            default:
		            return super.onOptionsItemSelected(item); 
		    }
		}
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
	@Override 
	public boolean onCreateOptionsMenu(Menu menu) 
	{ 
		getMenuInflater().inflate(R.menu.main, menu); 
		return true; 
	} 
	
}
