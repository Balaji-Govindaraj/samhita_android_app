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
 
 
public class Onsite_List_Main extends Activity{
	
	ListView list;
	String[] itemname ={
			"Web Designing",
			"Dexterity Unbounded",
			"Coffee With Java",
			"Reverse Coding",
			"Debugging",
			"Linux Mate",
			"Pixels",
			"Sequel Scholars",
			"Street Coding",
			//"Hackathon",
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
			"Organizer:R.Kaushik\nPhoneno:8681027488\nMail ID:kaushikmit94@gmail.com\n",
			"Organizer:T.N.Thamarai Selvi\nPhoneno:9445649354\nMail ID:thamnataraj@gmail.com\n",
			"Organizer:R.Ram prasath\nPhoneno:9597774039\nMail ID:ramprasath2812@gmail.com\n",
			//"Organizer:G.Rajeswari\nPhoneno:9600157620\nMail ID:2012rajeshwari@gmail.com\n",
			"Organizer:G.Rajeswari\nPhoneno:9600157620\nMail ID:2012rajeshwari@gmail.com\n",
			"Organizer:R.Deepika\nPhoneno:9790555005\nMail ID:deeps6reshu@gmail.com\n",
			"Organizer:M.Akila\nPhoneno:7402323265\nMail ID:akila16111995@gmail.com\n",
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
			//R.drawable.hackathon,
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
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","webdesigning");
					intent.putExtra("EVENT_TITLE","Web Designing");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","An irresistible event where creativity holds the upper hand. Show us what you can do with anything from the basic HTML to the fascinating JQueries. What are you waiting for? Join the event to compete with the most creative designers from around the nation. Amaze us with your designs and be crowned the victor.\nROUND DETAILS:\n1.Questions on Client and Server side scripting languages,threads,databases(Paper and Pen).\n2.Design a Web application (Usage of frameworks like MVC will be preferred) with proper control logic,UI and user experience.");
					intent.putExtra("CALL","9952187622");
					startActivity(intent);
				}
				else if(position==1)
				{
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","dexterityunbounded");
					intent.putExtra("EVENT_TITLE","Dexterity Unbounded");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Reason, Think, Introspect, Concentrate and Believe.! And that's Dexterity Unbounded. You can expect anything and everything out of geeky stuffs totally driving you to ponder and scrutinize from the given nothing to speculate into everything. Come and enjoy yourself with a team, to get through the amusing rounds leading you to ultimate fun.\nROUND DETAILS:\n1.Puzzles and aptitude questions(Paper and Pen). \n2.Connexions(Connect the pictures to get clues).\n3.Shipwreck(Assumption of a personality and justifying the provision of life boat) or DumbShalaks(Guessing the clues based on actions alone).");
					intent.putExtra("CALL","8124830060");
					startActivity(intent);
				}
				else if(position==2)
				{
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","coffeewithjava");
					intent.putExtra("EVENT_TITLE","Coffee With Java");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Coffee with java is all set ready to quench the thirst of java freaks !! Get ready to drown inside out in Gosling's baby creation. This exclusive event is all set to test your expertise in JAVA be it applets, swings, AWT and everything that makes JAVA so tantalizing. Drop by and have your share of caffeine. Get stimulated with hypnotic java.\nROUND DETAILS:\n1.Basic programming questions on OOPS,Applet,Swing,Servlets,etc (Paper and Pen). \n2.Development of a Real-time applications using native JAVA APIS available.");
					intent.putExtra("CALL","9444229874");
					startActivity(intent);
				}
				else if(position==3)
				{
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","reversecoding");
					intent.putExtra("EVENT_TITLE","Reverse Coding");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Why fit in,when you are born to stand out ! how about doing things in reverse for a change.The event will test your basic logic skills along with pattern analysis and recognition as you play with the code, identify the patterns and decipher it. Get ready for the endless excitement awaiting to embrace you !\nROUND DETAILS:\n1. Test set with Expected Output conditions will be provided. Participants should guess the logic behind them.\n2. You will be asked to rewrite the source-code from the binaries provided !");
					intent.putExtra("CALL","9003056280");
					startActivity(intent);					
				}
				else if(position==4)
				{
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","debugging");
					intent.putExtra("EVENT_TITLE","Debugging");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free.' -Steve Mc Connell The art of programming lies not just in typing lines and lines of code. Debugging is in itself a challenge that lets you identify your difference of opinion with the compiler. The most effective debugging tool is still careful thought, coupled with judiciously placed print statements. Get ready to sort out things with the compiler – Identify all the errors and your relationship becomes successful! You really don't want a conflict with your compiler do you??\nROUND DETAILS:\n1.Compile time(Coding) and runtime errors (SIGSEGV,TL:E,Exception Handling)- Paper and Pen.\n2.Testing the binaries with Cout, Breakpoint, Walkthrough and any other conventional debugging strategies.");
					intent.putExtra("CALL","9094140127");
					startActivity(intent);					
				}
				else if(position==5)
				{
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","linuxmate");
					intent.putExtra("EVENT_TITLE","Linux Mate");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Fascinated to boot Linux? Here is the opportunity to exhibit your tricks on linux. Show us your expertise on Torvalds’ creation. Bring out the Linux Lunatic in you and you might walk out wearing the 'Red Hat'!\nROUND DETAILS:\n1.General questions about the file structure,architecture,open source and shell commands.\n2.Challenges based on shell commands,Scripting,File manipulation,etc.");
					intent.putExtra("CALL","7401635012");
					startActivity(intent);					
				}
				else if(position==6)
				{
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","pixels");
					intent.putExtra("EVENT_TITLE","Pixels");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Show us your Image Processing Skills. Pixels is a 3 hour event, where you will have to solve problems on Image/Video processing, Augmented Reality and Computer Vision.\nROUND DETAILS:\n1.Simple questions on Image Processing(Online). Problem Statement to be Released Soon ! \n2.Real time applications using Opencv or MATLAB(Onsite)");
					intent.putExtra("CALL","8681027488");
					startActivity(intent);					
				}
				else if(position==7)
				{
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","sequelscholars");
					intent.putExtra("EVENT_TITLE","Sequel Scholars");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Is there something inside you thriving to manipulate the most precious entity that drives the entire world . Yes, we are talking about data and databases. Try your hand in manipulating some delightful data. Get ready to trigger the gray cells in your mind, avoid being deadlocked and complete the query quest.\nROUND DETAILS:\n1.Basic questions on SQL Queries,ACID,Transactions,Triggers,PL/SQL(Paper and Pen).\n2.Optimizing SQL Queries and display the result set with appropriate UI.");
					intent.putExtra("CALL","9445649354");
					startActivity(intent);					
				}
				else if(position==8)
				{
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","streetcoding");
					intent.putExtra("EVENT_TITLE","Street Coding");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Ever coded in the street?? Get enrolled to get a chance to code in the street of our Green Campus\nROUND DETAILS:\n1.Basic programming questions on Algorithms(Paper and Pen). \n2.Application Development using C,C++,Java or Python with Real-Time Distractions !");
					intent.putExtra("CALL","9597774039");
					startActivity(intent);					
				}
				else if(position==9)
				{
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","ospc");
					intent.putExtra("EVENT_TITLE","OSPC");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","If you think your thoughts are a blend of new idea and logical thinking,then there is yet another programming contest to test the programmer in you. Show us that you've got all that it takes to solve the problems with speed and precision. join the race, glory is yours !\nROUND DETAILS:\n1.Basic Questions on Algorithms,C,C++.\n2.Online Contest @ Hackerrank.");
					intent.putExtra("CALL","9600157620");
					startActivity(intent);				
				}
				else if(position==10)
				{
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","dumbc");
					intent.putExtra("EVENT_TITLE","Dumb C");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","A fun event for all the C maniacs out there. Train yourself to play with C tokens and keywords.It's time to seal your mouth and enjoy your own way of acting.Act out the words given to you and guess them. The more right ones you strike, the merrier! We techies know how to have fun in our own way, don't we??\nROUND DETAILS:\n1.Keywords and terms used in C to be enacted.\n2.Complete Technical Drama");
					intent.putExtra("CALL","9790555005");
					startActivity(intent);					
				}
				else if(position==11)
				{
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","codeobfuscation");
					intent.putExtra("EVENT_TITLE","Code Obfuscation");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Obfuscated Code is a source or machine code that has been made difficult to understand for humans. After participating in this contest you might get the idea that every language feature makes code unsustainable - not so, this can happen only if properly ‘misused’. Then probably you become a good coder.\nROUND DETAILS:\n1.Obfuscate simple logic(Paper and Pen)\n2.Obfuscate as Teams, preventing other teams deciphering your logic !");
					intent.putExtra("CALL","7402323265");
					startActivity(intent);					
				}
				else if(position==12)
				{
					Intent intent=new Intent(Onsite_List_Main.this,Events_Template_Onsite.class);
					intent.putExtra("EVENT_NAME","pursuitofprodigies");
					intent.putExtra("EVENT_TITLE","Pursuit Of Prodigies");
					intent.putExtra("EVENT_IMAGE",position);
					intent.putExtra("DESCRIPTION","Follow your passion in Algorithms, Databases and Web Technology.\nROUND DETAILS:\n1.Basic questions on Core CS concepts like OS,DBMS,Algorithms,TOC,Web Development(Paper and Pen).\n2.Machine coding of a real-time application with QOS constraints.\n3.Technical Interview.");
					intent.putExtra("CALL","8940540513");
					startActivity(intent);					
					intent.putExtra("EVENT_NAME","pursuitofprodigies");
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