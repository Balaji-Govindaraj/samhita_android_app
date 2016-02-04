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
 
 
public class Onsite_List_Main extends Activity{
	
	ListView list;
	String[] itemname ={
			"Web Designing",
			"Dexterity Unbounded",
			"Coffee With Java",
			"Reverse Coding",
			"Debugging",
			"Linux Mate",
			"NetWiz",
			"Sequel Scholars",
			"Street Coding",
			"Hackathon",
			"OSPC",
			"DUMB C",
			"Code Obfuscation",
			"Pursuit of Prodigies"
		};
	String[] sub_itemname ={
			"Oragnizer:P.M.Suganya\nPhoneno:9952187622\nMail ID:suganyapm2111@gmail.com\n",
			"Organizer:V.Chandrasekar\nPhoneno:8124830060\nMail ID:chandru12309@gmail.com\n",
			"Organizer:R.venkatasubramaniam\nPhoneno:9444229874\nMail ID:goldenday44@yahoo.com\n",
			"Organizer:L.Nikita Christie\nPhoneno:9003056280\nMail ID:2012506029b8@gmail.com\n",
			"Organizer:S.Rani\nPhoneno:9094140127\nMail ID:ranisomasundaram95@gmail.com\n",
			"Organizer:E.Manjushree\nPhoneno:7401635012\nMail ID:emanjushree371995@gmail.com\n",
			"Organizer:C.Shenbaga\nPhoneno:9488215317\nMail ID:chenbaga@gmail.com\n",
			"Organizer:T.N.Thamarai Selvi\nPhoneno:9445649354\nMail ID:thamnataraj@gmail.com\n",
			"Organizer:R.Ram prasath\nPhoneno:9597774039\nMail ID:ramprasath2812@gmail.com\n",
			"Organizer:\nPhoneno:\nMail ID:\n",
			"Organizer:G.Rajeswari\nPhoneno:9600157620\nMail ID:2012rajeshwari@gmail.com\n",
			"Organizer:R.Deepika\nPhoneno:9790555005\nMail ID:deeps6reshu@gmail.com\n",
			"Organizer:\nPhoneno:\nMail ID:\n",
			"Organizer:Y.Gayatri\nPhoneno:8940540513\nMail ID:ygayatri.26@gmail.com\n"
		};
	Integer[] imgid={
			R.drawable.web_design,
			R.drawable.x,
			R.drawable.java,
			R.drawable.reverse_coding,
			R.drawable.debugging,
			R.drawable.linux,
			R.drawable.netwiz,
			R.drawable.sequel_scholars,
			R.drawable.street_coding,
			R.drawable.hackathon,
			R.drawable.ospc,
			R.drawable.dumb_c,
			R.drawable.code,	
			R.drawable.prodigy
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