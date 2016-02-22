package com.example.samhita;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
 
public class Events_Template extends Activity{
	TextView title;
	ImageView img;
	Button b1;
	Button b2;
	Button b3;
	String EVENT_NAME;
	int EVENT_IMAGE;
	String EVENT_TITLE;
	String DESCRIPTION;
	String CALL;
	ImageConverter ic;

	Integer[] imgid={
			R.drawable.olpc,
			R.drawable.google_trotter,
			R.drawable.shutters,
			R.drawable.ps,
			R.drawable.google
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.events_template);

		   title=(TextView)findViewById(R.id.textView1);
	       img=(ImageView)findViewById(R.id.img);
	       b1=(Button)findViewById(R.id.description);
	       b2=(Button)findViewById(R.id.call);
	       b3=(Button)findViewById(R.id.results);
	        
		ActionBar ab = getActionBar(); 
        ab.setDisplayHomeAsUpEnabled(true);
        
        Bundle b=getIntent().getExtras();
		EVENT_NAME=b.getString("EVENT_NAME");
		EVENT_TITLE=b.getString("EVENT_TITLE");
		DESCRIPTION=b.getString("DESCRIPTION");
		EVENT_IMAGE=b.getInt("EVENT_IMAGE");
		CALL=b.getString("CALL");
	
     
        
        title.setText(EVENT_TITLE);
		ic=new ImageConverter();
		img.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),imgid[EVENT_IMAGE]));
		b1.setText("\n"+DESCRIPTION+"\n");
		b2.setText("CLICK TO CALL");
        b3.setText("CLICK FOR RESULTS");
        
        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent ii=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+CALL));
            	startActivity(ii);
			}
        });
        b3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent iii=new Intent(Events_Template.this,Event_Result.class);
				iii.putExtra("EVENT_NAME",EVENT_NAME);
				startActivity(iii);
			}
        });
        
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