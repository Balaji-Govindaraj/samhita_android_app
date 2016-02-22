package com.example.samhita;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.View;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button; 
import android.view.View.*;
public class General_List_Main extends Activity  {
	
	ListView list;
	String[] itemname ={
			"Gaming",
			"Treasure Hunt",
			"General Quiz",
			"Math-O-Mania",
			"B-Plan",
			"Paper Presentation",
			"How Stuff Works",
			"IPL Auctions",
			"Onsite Photography"
		};
	String[] sub_itemname ={
			"Oragnizer:R.Vignesh\nPhoneno:8124922676\nMail ID:vgcena2@gmail.com\n",
			"Oragnizer:M.kalaivanan\nPhoneno:9787648702\nMail ID:mitvanan@gmail.com\n",
			"Oragnizer:M.Mithila\nPhoneno:9962619848\nMail ID:mithilam28@gmail.com\n",
			"Oragnizer:S.Subashini\nPhoneno:9445512370\nMail ID:subashinimit12@gmail.com\n",
			"Oragnizer:K.Abinaya\nPhoneno:9578290215\nMail ID:abinaya14895@gmail.com\n",
			"Oragnizer:Vaishnavi\nPhoneno:9790809728\nMail ID:vaish.sweety0408@gmail.com\n",
			"Oragnizer:Swathi\nPhoneno:8883036600\nMail ID:swathimohi555@gmail.com\n",
			"Oragnizer:Soundhar Raj\nPhoneno:8015986459\nMail ID:soundharraj.v@gmail.com\n",
			"Oragnizer:Vino Balan\nPhoneno:7299047710\nMail ID:vinobalan10@gmail.com\n"
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
		
		ActionBar ab = getActionBar(); 
        ab.setDisplayHomeAsUpEnabled(true);

		
		Onsite_List adapter=new Onsite_List(this, itemname, imgid,sub_itemname);
		list=(ListView)findViewById(R.id.list);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {
 
			@Override
			public void onItemClick(AdapterView<?> parent, View view,final int position, long id) 
			{
				// TODO Auto-generated method stub
				String Slecteditem= itemname[+position];
				if(position==0)
				{
					Intent intent=new Intent(General_List_Main.this,Events_Template_General.class);
					intent.putExtra("EVENT_NAME","gaming");
					intent.putExtra("EVENT_TITLE","Gaming");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","It’s time for you to prove yourself as THE BEST. Kill the opponent as a Warrior,chase your enemy as a Racer. Live your dream as a gamer and show how much you love it, to be a conqueror!\nROUND DETAILS:\n1.Choose Your Mode - NFS,CS,AOE,Clash Of Clans \n2.Connect as Teams through our network !");
					intent.putExtra("CALL","8124922676");
					startActivity(intent);
				}
				else if(position==1)
				{
					Intent intent=new Intent(General_List_Main.this,Events_Template_General.class);
					intent.putExtra("EVENT_NAME","treasurehunt");
					intent.putExtra("EVENT_TITLE","Treasure Hunt");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Do you love treasures?? Do you have the enthusiasm and the ebullience to go on a never ending search for the most elusive trophies? Join the plunder with your friends, go on a clue – finding mission and unravel the mysteries hidden in plain sight. Get ready to be mystified and battle an army of clues to reach the most coveted prize of the event!\nROUND DETAILS:\n1.Solve the given set of Ambiguous Puzzles.\n2.Find treasure using our Wi-FI Hotspots !");
					intent.putExtra("CALL","9787648702");
					startActivity(intent);
				}
				else if(position==2)
				{
					Intent intent=new Intent(General_List_Main.this,Events_Template_General.class);
					intent.putExtra("EVENT_NAME","generalquiz");
					intent.putExtra("EVENT_TITLE","General Quiz");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","It’s not a silly question if you can’t answer it!” -Jostein Gaarder Sharpen your brains. Time is of the essence. For each second lost, you’re an answer away from glory. Join us with your friends in the most thrilling and the most intellectual event of Samhita 16. Be ready to dodge the ammos of questions fired at you and you may emerge the conqueror of brains!\nROUND DETAILS:\n1.Quiz questions on Science,Sports,Cinema,Politics,Geography. \n2.Picture and AV questions.");
					intent.putExtra("CALL","9962619848");
					startActivity(intent);
				}

				else if(position==3)
				{
					Intent intent=new Intent(General_List_Main.this,Events_Template_General.class);
					intent.putExtra("EVENT_NAME","math-o-mania");
					intent.putExtra("EVENT_TITLE","Math-O-Mania");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Nothing is impossible.. IMPOSSIBLE itself says I AM POSSIBLE!! And mathematics is a strong disciple of this notion..Its not about how hard you work for a solution rather a smart answer counts more..so get your pens swinging..the smarter you solve, the closer you be to become the unrivalled king of the great maths kingdom!! Keep it simple chums!!\nROUND DETAILS:\n1.Similar to Math musketeers. \n2.Complex mathematical problems.");
					intent.putExtra("CALL","9445512370");
					startActivity(intent);
				}
				else if(position==4)
				{
					Intent intent=new Intent(General_List_Main.this,Events_Template_General.class);
					intent.putExtra("EVENT_NAME","b-plan");
					intent.putExtra("EVENT_TITLE","B-Plan");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","We aim to move towards a greener and cleaner future. Polluting the country is a strict NO. You will have to adhere to the guidelines of the amount of Carbon Emissions that an Industry can produce. Carbon credits are hard to gain. So, grab this opportunity to show how you can weave your way towards a successful business empire in a cleaner and greener India.\nROUND DETAILS:\n1.Basic questions on management strategies,case study,TQM,etc");
					intent.putExtra("CALL","9578290215");
					startActivity(intent);
				}
				else if(position==5)
				{
					Intent intent=new Intent(General_List_Main.this,Events_Template_General.class);
					intent.putExtra("EVENT_NAME","paperpresentation");
					intent.putExtra("EVENT_TITLE","Paper Presentation");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Ready to innovate? Bring out the innovator in you, by publishing your ideas !\nROUND DETAILS:\n1.Topics: Big data analytics,Artificial Intelligence,Cloud and grid computing,Algorithms,Wireless Sensor Networks,SOA and Web Service,Data Mining,Human Computer Interaction,Green Computing,E-Governance,Cryptography and Network Security,Image Processing Send your abstracts to samhita2k16@gmail.com");
					intent.putExtra("CALL","9790809728");
					startActivity(intent);
				}
				else if(position==6)
				{
					Intent intent=new Intent(General_List_Main.this,Events_Template_General.class);
					intent.putExtra("EVENT_NAME","howstuffworks");
					intent.putExtra("EVENT_TITLE","How Stuff Works");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","The most important thing is not to stop questioning. Curiosity has its own reason for existing! -Albert Einstein Do you marvel at how the most complex phenomenon in our Universe is driven by simple laws of Science? Watching Discovery channel is finally going to pay off. Can you uncover the hidden logic behind what makes a bulb glow to how the Universe was created? This event is meant especially to bring out the Archimedes in you. Logical reasoning will take you to great heights and this is just the right place for you to squeeze the juice out of your cerebrum.\nROUND DETAILS:\n1. Questions on Technology, Aviation, Agriculture, Science. \n2.Analysis on current trends and optimization strategies with effective ideas.");
					intent.putExtra("CALL","9790809728");
					startActivity(intent);
				}
				else if(position==7)
				{
					Intent intent=new Intent(General_List_Main.this,Events_Template_General.class);
					intent.putExtra("EVENT_NAME","iplauctions");
					intent.putExtra("EVENT_TITLE","IPL Auctions");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","IPL AUCTIONS is a combination of cricketing knowledge and managerial skills.The prelims will be a cricket quiz with a combination of easy ,medium and hard level questions.With the hard questions given some extra weightage in marks calculation.The top 8 teams will be selected for the finals.Finals will be conducted in a similar way to the actual IPL auctions. The 8 teams will be provided a fixed budget and a list of players who will be put up for auction. As the auction proceeds teams can bid for any player of their choice and try to buy him. At the end of the auction the teams picked by the contestants will be evaluated based on the common criteria used to judge teams in cricket. (squad balance, individual player contributions, team chemistry) etc and a winner will be picked. Any queries, grievances, disputes etc shall be brought to the notice of the organizers who will take necessary action.\nROUND DETAILS:\n1.Questions on Cricket.\n2.Mock IPL Auction focussing on application of management tricks to maximise profit and minimise expenditure.");
					intent.putExtra("CALL","8015986459");
					startActivity(intent);
				}
				else if(position==8)
				{
					Intent intent=new Intent(General_List_Main.this,Events_Template_General.class);
					intent.putExtra("EVENT_NAME","onsitephotography");
					intent.putExtra("EVENT_TITLE","Onsite Photography");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Roam around, Click your favorite pics and Impress our Judges !\nROUND DETAILS:\n1.MIT Shoot - You are free to take pics of anything in our campus.\n2.Capture the essence of the concept and then replicate !");
					intent.putExtra("CALL","7299047710");
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