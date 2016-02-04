package com.example.samhita;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
 
 
public class Contact_List_Main extends Activity{
	
	ListView list;
	String[] itemname ={
			"ITA Chairman",
			"ITA Secretary",
			"Accomodation Incharge",
			"Pradeep",
			"Workshop Incharge"
		};
	String[] sub_itemname ={
			"Name:Sasi Dharan\nPhoneno:8870068020\nMail ID:sasidharan@gmail.com",
			"Name:Vimal Kumar\nPhoneno:8122107944\nMail ID:vimal.m94@gmail.com",
			"Name:Sample3\nPhoneno:9888888888\nMail ID:sasidharan@gmail.com",
			"Phoneno:984243313\nMail ID:compprad@gmail.com",
			"Name:Sample5\nPhoneno:9888888888\nMail ID:sasidharan@gmail.com"
	};
	Integer[] imgid={
			R.drawable.phone,
			R.drawable.phone,
			R.drawable.phone,
			R.drawable.phone,
			R.drawable.phone,
		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_main);
		
		Onsite_List adapter=new Onsite_List(this, itemname, imgid,sub_itemname);
		list=(ListView)findViewById(R.id.list);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {
 
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String Selecteditem= itemname[+position];
				if(Selecteditem.equals("ITA Chairman"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8870068020"));
					startActivity(intent);
				}
				else if(Selecteditem.equals("ITA Secretary"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8122107944"));
					startActivity(intent);
				}
				else if(Selecteditem.equals("Accomodation Incharge"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8122107944"));
					startActivity(intent);
				}
				else if(Selecteditem.equals("Pradeep"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:984243313"));
					startActivity(intent);
				}
				else if(Selecteditem.equals("Workshop Incharge"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:88122107944"));
					startActivity(intent);
				}
				
				//Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();
				
			}
		});
	}
}