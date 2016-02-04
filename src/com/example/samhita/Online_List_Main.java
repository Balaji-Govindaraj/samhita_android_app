package com.example.samhita;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
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
			"Math Musketeers",
			"Shutters",
			"PS I LOVE U",
			"Google Geek"
		};
	String[] sub_itemname ={
			"Oragnizer:M.Akila\nPhoneno:7402323265\nMail ID:akila16111995@gmail.com\n",
			"Organizer:\nPhoneno:\nMail ID:\n",
			"Organizer:\nPhoneno:\nMail ID:\n",
			"Organizer:P.Lavanya\nPhoneno:9043404680\nMail ID:lavanyaprasath2595@gmail.com\n",
			"Organizer:R.Saranya\nPhoneno:7845488439\nMail ID:2012506041b2@gmail.com\n",
			"Organizer:\nPhoneno:\nMail ID:\n"
		};
	Integer[] imgid={
			R.drawable.olpc,
			R.drawable.google_trotter,
			R.drawable.math_musketeers,
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
		
		list.setOnItemClickListener(new OnItemClickListener() {
 
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String Slecteditem= itemname[+position];
				Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
				
			}
		});
	}
}