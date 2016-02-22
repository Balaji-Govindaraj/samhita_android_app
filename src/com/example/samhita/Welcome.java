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

public class Welcome extends Activity{
	String username;
	TextView login_username;
	ListView out;
//	loading l;
	@Override 
	protected void onCreate(Bundle savedInstanceState) 
	{ 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_welcome);

		ActionBar ab = getActionBar(); 
        ab.setDisplayHomeAsUpEnabled(true);

		out=(ListView)findViewById(R.id.out);
		ListView listView = (ListView) findViewById(R.id.out);
    	if(isNetworkAvailable())
    	{
    	//	l=new loading(this,listView);
    		try
    		{
    	//		String success=new Async_data_set(this,listView).execute("http://balaji001.netne.net/android/select.php").get();
    			new Async_data_set(this,listView).execute("http://balaji001.netne.net/android/android/select.php");
    		
    		}
    		catch(Exception e){}
    	}
    	else
    	{
    		Toast.makeText(getApplicationContext(),"Please Connect to Internet",Toast.LENGTH_LONG).show();
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
}
/*
 class loading extends AsyncTask<String,Void,String>
 
{
	private Context context;
	private ListView listView;
	private ProgressDialog p;
	public loading(Context context,ListView listView)
	{
		this.context=context;
		this.listView=listView;
		
	}
	@Override
	protected void onPreExecute()
	{
		p=new ProgressDialog(context);
		p.setMessage("Checking Login");
		p.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		p.show();
	}
	@Override
	protected String doInBackground(String... params) {
		try
		{
			String success=new Async_data_set(context,listView).execute("http://balaji001.netne.net/android/select.php").get();
		}
		catch(Exception e){}
		return "success";
	}
	@Override
	protected void onPostExecute(String result)
	{
		if(result.equals("success"))
		{
			p.cancel();
		}
	}
}
*/