package com.example.samhita;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Async_data_set extends AsyncTask<String,Void,String>{
	private ProgressDialog p;
	Context context;
	String content;
	ListView lid;
	int flag;
	//String[] images;
	String[] mt;
	String[] st;
	String[] tel;
	public Async_data_set(Context context,ListView lid)
	{
		this.context=context;
		this.lid=lid;
		p=new ProgressDialog(context);
	}
	@Override
	protected void onPreExecute()
	{
		p=new ProgressDialog(context);
		p.setMessage("Loading.please Wait");
		p.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		p.setIndeterminate(true);
		p.setCancelable(false);
		p.setInverseBackgroundForced(false);
		p.show();
	}
/*	 @Override 
	 public void onProgressUpdate(Integer... prog) {
	        if (prog == null)
	            return;
	        p.setProgress(prog[0]);
	    }
	*/@Override
		protected String doInBackground(String... arg0) {
			 try
		        {
		        	String link=(String)arg0[0];
		        	URL url = new URL(link); 
		        	URLConnection conn = url.openConnection(); 
		        	BufferedReader reader = new BufferedReader (new InputStreamReader(conn.getInputStream())); 
		        	StringBuilder sb = new StringBuilder(); 
		        	String line = null; 
		        	while((line = reader.readLine()) != null) 
		        	{ 
		        		sb.append(line); 
		        		break; 
		        	}
		        	content=sb.toString();
		        	 return "success";
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }
			 return "success";
		}
	
	  @Override	 
	protected void onPostExecute(String result)
	{
		p.cancel();
		
			 ArrayList<com.example.samhita.ListItem> listData = getListData(result);

		        final ListView listView =lid;
		        listView.setAdapter(new CustomListAdapter(context, listData));
		        listView.setOnItemClickListener(new OnItemClickListener() {

		            @Override
		            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
		                com.example.samhita.ListItem newsData = (com.example.samhita.ListItem) listView.getItemAtPosition(position);
		                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+newsData.gettel().toString()));
						context.startActivity(intent);
		               // Toast.makeText(context,newsData.gettel().toString(), Toast.LENGTH_LONG).show();
		            }
		        });
	}
	 private ArrayList<com.example.samhita.ListItem> getListData(String result) {
	        ArrayList<com.example.samhita.ListItem> listMockData = new ArrayList<com.example.samhita.ListItem>();
	        converttoLISTVIEW(result);
			for (int i = 0; i < mt.length; i++) {
	        		com.example.samhita.ListItem newsData = new com.example.samhita.ListItem();
	      //      	newsData.setUrl(images[i]);
	            	newsData.setmt(mt[i]);
	            	newsData.setst(st[i]);
	            	newsData.settel(tel[i]);
	            	listMockData.add(newsData);
	        	}   
			 return listMockData;
	    }
	public void converttoLISTVIEW(String response)
	{
		try
		{
		JSONObject jsonRootObject=new JSONObject(content);
		JSONArray jsonArray=jsonRootObject.optJSONArray("results");
		//images=new String[jsonArray.length()];
		mt=new String[jsonArray.length()];
		st=new String[jsonArray.length()];
		tel=new String[jsonArray.length()];
		
			for(int i=0;i<jsonArray.length();i++)
			{
				JSONObject jsonObject=jsonArray.getJSONObject(i);
				int ii=jsonObject.optInt("id");
				ii+=11000;
				mt[i]=jsonObject.optString("username").toString();
				st[i]="S_ID:S#"+ii+"\nPhone Number:"+jsonObject.optString("phoneno").toString()+"\nYear:"+jsonObject.optString("year").toString()+"\nDepartment:"+
						jsonObject.optString("department").toString()+"\nCollege:"+jsonObject.optString("college").toString()+"\nMail ID:"+jsonObject.optString("mail").toString()+"\n";
				tel[i]=jsonObject.optString("phoneno").toString();
				//	images[i]="http://balaji001.netne.net/android/i.php?username="+mt[i];
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	}
