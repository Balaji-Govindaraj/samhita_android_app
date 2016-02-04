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
 
 
public class General_List_Main extends Activity{
	
	ListView list;
	String[] itemname ={
			"Gaming",
			"Treature Hunt",
			"General Quiz",
			"Math-O-Mania",
			"B-Plan",
			"Paper Presentation",
			"How Stuff Works",
			"IPL Auctions",
			"Master Manager"
		};
	String[] sub_itemname ={
			"Oragnizer:R.Vignesh\nPhoneno:8124922676\nMail ID:vgcena2@gmail.com\n",
			"Oragnizer:M.kalaivanan\nPhoneno:9787648702\nMail ID:mitvanan@gmail.com\n",
			"Oragnizer:M.Mithila\nPhoneno:9962619848\nMail ID:mithilam28@gmail.com\n",
			"Oragnizer:S.Subashini\nPhoneno:9445512370\nMail ID:subashinimit12@gmail.com\n",
			"Oragnizer:S.Malathi\nPhoneno:7708298089\nMail ID:\n",
			"Oragnizer:\nPhoneno:\nMail ID:\n",
			"Oragnizer:\nPhoneno:\nMail ID:\n",
			"Oragnizer:\nPhoneno:\nMail ID:\n",
			"Oragnizer:\nPhoneno:\nMail ID:\n"
			};
	Integer[] imgid={
			R.drawable.gaming,
			R.drawable.hunt,
			R.drawable.quiz,
			R.drawable.maths,
			R.drawable.b_plan,
			R.drawable.paper_presentation,
			R.drawable.stuff,
			R.drawable.ipl_auction,
			R.drawable.master
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