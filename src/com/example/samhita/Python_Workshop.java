package com.example.samhita;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.DialogInterface; 
import android.view.View.OnClickListener;
 
public class Python_Workshop extends Activity implements View.OnClickListener {
 
    public static final String UPLOAD_URL = "http://samhita.org.in/ii_workshop.php";
    public static final String UPLOAD_WORKSHOP = "workshop";
    public static final String UPLOAD_USERNAME = "username";
    public static final String UPLOAD_MAIL="mail";
    public static final String UPLOAD_PHONE="phone";
    public static final String UPLOAD_COLLEGE="college";
    public static final String UPLOAD_DEPARTMENT="department";
    public static final String UPLOAD_YEAR="year";
    
    public static final String TAG = "MY MESSAGE";
 
    private int PICK_IMAGE_REQUEST = 1;
 
    private Button buttonChoose;
    private Button buttonUpload;
  //  private Button buttonView;
 
    public EditText username;
    public EditText mail;
    public EditText phone;
    public EditText college;
    
    public Spinner year;
    public Spinner department;
    
    private ImageView imageView;
 
    private Bitmap bitmap;
 
    private Uri filePath;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open);
 
        username=(EditText)findViewById(R.id.username);
        college=(EditText)findViewById(R.id.college);
        mail=(EditText)findViewById(R.id.mail);
        phone=(EditText)findViewById(R.id.phone);
        year=(Spinner)findViewById(R.id.year);
        department=(Spinner)findViewById(R.id.department);
        
		ActionBar ab = getActionBar(); 
        ab.setDisplayHomeAsUpEnabled(true);
        
        List<String> list1 = new ArrayList<String>();
        list1.add("Aerospace Engineering");
        list1.add("Automobile Engineering");
        list1.add("Computer Science");
        list1.add("Electronics and Communication");
        list1.add("Information Technology");
        list1.add("Mechanical Engineering");
        list1.add("Production Technology");
        list1.add("other");
         
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        department.setAdapter(dataAdapter1);
        //addListenerOnSpinnerItemSelection1();
        
        
        List<String> list2 = new ArrayList<String>();
        list2.add("I Year");
        list2.add("II Year");
        list2.add("III Year");
        list2.add("IV Year");
         
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        year.setAdapter(dataAdapter2);
      //  addListenerOnSpinnerItemSelection2();
        
       // buttonChoose = (Button) findViewById(R.id.buttonChoose);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
      //  buttonView = (Button) findViewById(R.id.buttonViewImage);
 
 
       // buttonChoose.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);
       // buttonView.setOnClickListener(this);
    }
    public void addListenerOnSpinnerItemSelection1(){
        department.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    public void addListenerOnSpinnerItemSelection2(){
        year.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
 
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
 
            filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    private void uploadImage(){
        class UploadImage extends AsyncTask<Bitmap,Void,String>{
 
            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();
            String uploadImage="";
            String u="";
            String c="";
            String ph="";
            String m="";
            String ye="";
            String dep="";
           
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Python_Workshop.this, "Uploading...", null,true,true);
            }
 
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Python_Workshop.this);
                alertDialogBuilder.setTitle("NOTE DOWN THE ID FOR FURTHER PAYMENT");
                alertDialogBuilder.setMessage(s)
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						Uri uri = Uri.parse("https://www.payumoney.com/paybypayumoney/#/106037"); 
						Intent intent = new Intent(Intent.ACTION_VIEW, uri); 
						startActivity(intent);
						//Android_Workshop.this.finish();
					}
				  })
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						dialog.cancel();
					}
				});
                AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
        			
                //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }
 
            @Override
            protected String doInBackground(Bitmap... params) {
                
                
                u=username.getText().toString();
                c=college.getText().toString();
                ph=phone.getText().toString();
                m=mail.getText().toString();
                
                ye=String.valueOf(year.getSelectedItem());
                dep=String.valueOf(department.getSelectedItem());
                HashMap<String,String> data = new HashMap<String,String>();
                data.put(UPLOAD_USERNAME,u);
                data.put(UPLOAD_MAIL,m);
                data.put(UPLOAD_PHONE,ph);
                data.put(UPLOAD_COLLEGE,c);
                data.put(UPLOAD_DEPARTMENT,ye);
                data.put(UPLOAD_YEAR,dep);
                data.put(UPLOAD_WORKSHOP,"Python Workshop");
                
                String result = rh.sendPostRequest(UPLOAD_URL,data);
 
                return result;
            }
        }
 
        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }
    private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
    @Override
    public void onClick(View v) {
       // if (v == buttonChoose) {
       //     showFileChooser();
       // }
        if(v == buttonUpload){
        	if(isNetworkAvailable())
        	{
        		uploadImage();
        	}
        	else
        	{
        		Toast.makeText(getApplicationContext(),"Please Connect to Internet",Toast.LENGTH_LONG).show();
        	}
        }
        
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
    private void viewImage() {
        startActivity(new Intent(this, Welcome.class));
    }
}
