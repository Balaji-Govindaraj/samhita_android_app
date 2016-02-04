package com.example.samhita;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.view.*;
public class Async extends AsyncTask<String,Void,String> {
private ProgressDialog p;
Context context;
String content;
String image;
EditText username;
EditText mail;
EditText phoneno;
EditText password;
int flag;
TextView response;
//public Async(Context context,String image,EditText username,EditText mail,EditText phoneno,EditText password,TextView response,int flag)
public Async(Context context,String image,TextView response,int flag)

{
	this.context=context;
	this.image=image;
	/*this.username=username;
	this.mail=mail;
	this.phoneno=phoneno;
	this.password=password;*/
	this.flag=flag;
	this.response=response;
	
}
@Override
protected void onPreExecute()
{
	p=new ProgressDialog(context);
	p.setMessage("Checking Login");
	p.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	p.show();
}
@Override
	protected String doInBackground(String... arg0) {
	StringBuilder sb = new StringBuilder();	
	String dataa=null;
			try
	        {
	        	String link=(String)arg0[0];
	        	String username_data="amuthan";
	        	String password_data="amuthan";
	        	String phone_data="7777788888";
	        	String mail_data="amuthanparthu@gmail.com";
	        	/*String username_data=username.getText().toString();
	        	String password_data=password.getText().toString();
	        	String mail_data=mail.getText().toString();
	        	String phone_data=phoneno.getText().toString();*/
	        	
	        	String data=
	            		URLEncoder.encode("uname", "UTF-8")+"="+URLEncoder.encode(username_data,"UTF-8");
	            	data+="&"+URLEncoder.encode("pass", "UTF-8")+"="+URLEncoder.encode(password_data,"UTF-8");  
	            	data+="&"+URLEncoder.encode("image","UTF-8")+"="+URLEncoder.encode(image,"UTF-8");
	            	data+="&"+URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone_data,"UTF-8");
	            	data+="&"+URLEncoder.encode("mail","UTF-8")+"="+URLEncoder.encode(mail_data,"UTF-8");
	            	
	        	URL url = new URL(link); 
	        	URLConnection conn = url.openConnection(); 
	        	conn.setDoOutput(true);
	            OutputStreamWriter osw=new OutputStreamWriter(conn.getOutputStream());
	            osw.write(data);
	            osw.flush();	        	     	
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
		
	return "success";
	}
@Override
protected void onPostExecute(String rec_data)
{
	p.cancel();
	response.setText("");
	
}
}
