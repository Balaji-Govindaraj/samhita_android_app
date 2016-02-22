package com.example.samhita;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
 
 
public class Online_List_Main extends Activity{
	
	ListView list;
	String[] itemname ={
			"OLPC",
			"Google Trotter",	
			"Shutters",
			"PS I LOVE U",
			"Capture the Flag"
		};
	String[] sub_itemname ={
			"Oragnizer:R.kaushik\nPhoneno:8681027488\nMail ID:kaushikmit94@gmail.com\n",
			"Organizer:Poornima\nPhoneno:8681027488\nMail ID:poornimamoorthy05@gmail.com\n",
			"Organizer:P.Lavanya\nPhoneno:9043404680\nMail ID:lavanyaprasath2595@gmail.com\n",
			"Organizer:R.Saranya\nPhoneno:7845488439\nMail ID:2012506041b2@gmail.com\n",
			"Organizer:R.Kaushik\nPhoneno:8681027488\nMail ID:kaushikmit94@gmail.com\n"
		};
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
		setContentView(R.layout.onsite_main);
		
		Onsite_List adapter=new Onsite_List(this, itemname, imgid,sub_itemname);
		list=(ListView)findViewById(R.id.list);
		list.setAdapter(adapter);
	
		ActionBar ab = getActionBar(); 
        ab.setDisplayHomeAsUpEnabled(true);
		
		list.setOnItemClickListener(new OnItemClickListener() {
 
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String Slecteditem= itemname[+position];
				if(position==0)
				{
					Intent intent=new Intent(Online_List_Main.this,Events_Template.class);
					intent.putExtra("EVENT_NAME","olpc");
					intent.putExtra("EVENT_TITLE","OLPC");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","DESCRIPTION:\nLife can be very cruel, a missing semicolon could make the stock market tumble overnight. Put on your brains and dive into the world of codin with olpc!\nROUND DETAILS:\n1.Online Contest @ Hackerrank \n2. Questions on Dynamic Programming,Graph Search and Heuristics will be given Priority ! Special Points will be given to Pythonists !");
					intent.putExtra("CALL","8681027488");
					startActivity(intent);
				}
				else if(position==1)
				{
					Intent intent=new Intent(Online_List_Main.this,Events_Template.class);
					intent.putExtra("EVENT_NAME","googletrotter");
					intent.putExtra("EVENT_TITLE","Google Trotter");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","DESCRIPTION:\nRoam the world of internet to find keys to unlock the answers to our challenges in Google trotter...PS: Bing this time!\nROUND DETAILS:\n1. Online Round - Find answers to image puzzles with the help of your favorite search engine !");
					intent.putExtra("CALL","8681027488");
					startActivity(intent);
				}
				else if(position==2)
				{
					Intent intent=new Intent(Online_List_Main.this,Events_Template.class);
					intent.putExtra("EVENT_NAME","shutters");
					intent.putExtra("EVENT_TITLE","Shutters");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","DESCRIPTION:\nPhotography is the only language that can be understood anywhere in the world -bruno barbey.Peek a boo nature waves at you!sun rise lightens you!street lights throw a spark at you!explore the childish moments!traverse the unexpected candids!take your camera and capture your best moments\nROUND DETAILS:\n1.Participants are expected to capture photos relevant to each category.\n2.Get Maximum Likes/Shares");
					intent.putExtra("CALL","9043404680");
					startActivity(intent);
				}
				else if(position==3)
				{
					Intent intent=new Intent(Online_List_Main.this,Events_Template.class);
					intent.putExtra("EVENT_NAME","psiloveu");
					intent.putExtra("EVENT_TITLE","PS I Love U");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","DESCRIPTION:\nReality leaves a lot to the imagination” - John lennon Are you a PS fanatic? Are you good with colors and designs? Well, here’s the best platform you can ever get to showcase your “creative skills”. Pour out every ounce of the creative “you” in your posters and your well on your way to glory. Mail your designs to us and throw us off guard with your Spielberg ideas. Who knows? We might actually end up discovering a new Spielberg in the making.\nROUND DETAILS:\n1.Participants are expected to submit their photos to the Facebook page. Winner will be decided based on the number of likes and decision of organisers. \n2. Facebook link will be provided shortly !");
					intent.putExtra("CALL","7845488439");
					startActivity(intent);
				}
				else if(position==4)
				{
					Intent intent=new Intent(Online_List_Main.this,Events_Template.class);
					intent.putExtra("EVENT_NAME","capturetheflag");
					intent.putExtra("EVENT_TITLE","Capture The Flag");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","DESCRIPTION:\nCapture the Flag (CTF) is a special kind of information security competitions. There are three common types of CTFs: Jeopardy, Attack-Defence and mixed. This will be a Jeopardy Style Competition. Jeopardy-style CTFs has a couple of questions (tasks) in range of categories. For example, Web, Forensic, Crypto, Binary or something else. Team can gain some points for every solved task. More points for more complicated tasks usually. The next task in chain can be opened only after some team solve previous task. Then the game time is over sum of points shows you a CTF winner.\nROUND DETAILS:\n1.Basic ethical hacking challenges on OWASP Web Vulnerabilities, Reverse Engineering, Cryptography.");
					intent.putExtra("CALL","8681027488");
					startActivity(intent);	
				}
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