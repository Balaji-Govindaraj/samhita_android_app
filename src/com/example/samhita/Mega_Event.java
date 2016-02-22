package com.example.samhita;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
 
 
public class Mega_Event extends Activity{
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mega_event);
		
		ActionBar ab = getActionBar(); 
        ab.setDisplayHomeAsUpEnabled(true);
        
        b=(Button)findViewById(R.id.buttonUpload);
        b.setText("\nTechnical Discussions and Interviews with Winners and Runners of Individual Events.\nOrganizer:Rahul Malik\nPhone Number:9445898428\nMail ID:mallikuniqkmails@gmail.com\n");
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