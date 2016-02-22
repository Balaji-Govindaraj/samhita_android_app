package com.example.samhita;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
 
 
public class Workshop_List_Main extends Activity{
	
	ListView list;
	String[] itemname ={
			"Android Workshop",
			"Phython Workshop",
			"IOT Workshop",
			"Video Analysis for Machine Vision",
			"Network Workshop",
			"Ethical Hacking Workshop"
		};
	String[] sub_itemname ={
			"Description:Android is the latest Smartphone OS developed by Google taking the smart phone industry by storm. In nearly 2 years of it existence, it has over 40% of the Smartphone OS share. And still Android is not showing any sign of slowing down. Besides Android OS being Open Source, it is a real treat for programmers and developers to dwell into it. Get Exposed to the World of Android !"
					+"\n\nDuration:Full Day\n"
					+"\nDate:March 12\n"
					+"\nOrganized By:Innovation Technology\n"
					+"\nCost:850INR Per Person\n",
					"Description:Python is a versatile and widely-used programming language with many applications. This workshop explores Python's place in the scientific ecosystem, and how the language, with several readily-available open-source libraries, can serve as a powerful tool for data analysis."
							+"\n\nDuration:Half-a-Day\n"
							+"\nDate:March 12\n"
							+"\nOrganized By:Chandrasekhar Babu\n"
							+"\nCost:400INR Per Person\n",
							"Description:When we talk about an Internet of Thing, it’s not just putting RFID tags on some dumb thing is. It’s about embedding intelligence so things become smarter and do more than they were proposed to do. Can you imagine a computing concept where everyday objects have network connectivity? Is it possible for ordinary devices to communicate among themselves? Yes!! And the answer is ‘The Internet of Things’. The main objective of the workshop is to make the aspiring engineers acquainted with the conceptual as well as practical knowledge of IoT- Internet of Things. It is one of the Latest Technology which is going to change our lifestyle and the technology we use in coming years. It is an estimated that by 2020 approx 50 Billion electronics devices on this planet will be connected to internet."
									+"\n\nDuration:One Day\n"
									+"\nDate:March 11\n"
									+"\nOrganized By:Innovation Technologies\n"
									+"\nCost:1100INR Per Person\n",
									"Description:With the rapid growth of video surveillance applications and services, the amount of surveillance videos has become extremely 'big' which makes human monitoring difficult to handle. Therefore, there exists huge demand on smart surveillance techniques which can perform monitoring in an automatic or semi-automatic way. On one hand, with the huge amount of surveillance videos in the storage, video analysis techniques such as event detection, action recognition, and video summarization are of increasing importance in applications including events-of-interest retrieval and abnormality detection. On the other hand, with the rapid growth from the static centric-based processing to the dynamic collaborative computing and processing among distributed video processing nodes or cameras, new challenges such as multi-camera joint analysis, human re-identification, and distributed video processing are being issued in front of us. The requirement of these challenges is to extend the existing approaches or explore new suitable techniques. This workshop is intended to provide a forum for researchers and engineers to present their latest innovations and share their experiences on all aspects of design and implementation of new surveillance video analysis and parsing techniques."
											+"\n\nDuration:Half-a-Day\n"
											+"\nDate:March 11\n"
											+"\nOrganized By:Dr.Dhanajay Kumar\n"
											+"\nCost:400INR Per Person\n",
												"Description:We're here to connect the dots, show you how things ought to be taught. Come, join us. Together, we'll rediscover what people call 'Networking'. Networking is not as hard as it seems to be. A lot of folks out there consider networking an outlander's theory. And many of us fail to relish the joy in getting the code right. It is so much fun to work with routers, cables and computers. Just one among the many passionate people who like to show how great, networking can happen to be - if approached the right way - a group of people united by a common goal to see networking in a different perspective. We talk, share, learn and hack - Exactly the reason we're called the Network Geeks."
														+"\n\nDuration:Two Days\n"
														+"\nDate:March 11,12\n"
														+"\nOrganized By:Network Geek\n"
														+"\nCost:1200INR Per Person\n",
														"Description:Then this is the workshop YOU HAVE TO BE .Ever wished to see yourself as a JAMES BOND in REAL LIFE. Be Prepared for a JAW DROPPING , ENTERTAINING and EDUCATIVE learning experience.This is a great networking opportunity for the security enthusiasts and ethical hackers across the country with intense knowledge sharing sessions, LIVE demonstrations, hands on experience on the latest tools, Capture-the-Flag Competition and technologies that enables you to discover and contribute to make the world a SECURE place to live in. And Truth well said , 'The best part in ones life is DOING what people say you CANNOT DO' - Join us on a Magical Session of Computer Hacking."
																+"\n\nDuration:Full Day\n"
																+"\nDate:March 11\n"
																+"\nOrganized By:Infysec\n"
																+"\nCost:900INR Per Person\n",
	};
	Integer[] imgid={
			R.drawable.android,
			R.drawable.python,
			R.drawable.iot,
			R.drawable.machine,
			R.drawable.network,
			R.drawable.hacker
		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_main);
		
		ActionBar ab = getActionBar(); 
        ab.setDisplayHomeAsUpEnabled(true);

		Onsite_List adapter=new Onsite_List(this, itemname, imgid,sub_itemname);
		list=(ListView)findViewById(R.id.list);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {
 
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String Selecteditem= itemname[+position];
				if(Selecteditem.equals("Android Workshop"))
				{
					Intent intent = new Intent(Workshop_List_Main.this,Android_Workshop.class);
					startActivity(intent);
				}
				else if(Selecteditem.equals("Phython Workshop"))
				{
					Intent intent = new Intent(Workshop_List_Main.this,Python_Workshop.class);
					startActivity(intent);
				}
				else if(Selecteditem.equals("IOT Workshop"))
				{
					Intent intent = new Intent(Workshop_List_Main.this,IOT_Workshop.class);
					startActivity(intent);
				}
				else if(Selecteditem.equals("Video Analysis for Machine Vision"))
				{
					Intent intent = new Intent(Workshop_List_Main.this,Video_Workshop.class);
					startActivity(intent);
				}
				else if(Selecteditem.equals("Network Workshop"))
				{
					Intent intent = new Intent(Workshop_List_Main.this,Network_Workshop.class);
					startActivity(intent);
				}
				else if(Selecteditem.equals("Ethical Hacking Workshop"))
				{
					Intent intent = new Intent(Workshop_List_Main.this,Hacking_Workshop.class);
					startActivity(intent);
				}
				//Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();
				
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