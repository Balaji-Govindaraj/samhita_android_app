package com.example.samhita;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
 
public class Create_Account extends Activity implements View.OnClickListener {
 
    public static final String UPLOAD_URL = "http://balaji001.netne.net/android/ii.php";
    public static final String UPLOAD_KEY = "image";
    public static final String UPLOAD_USERNAME = "username";
    public static final String UPLOAD_MAIL="mail";
    public static final String UPLOAD_PHONE="phone";
    public static final String UPLOAD_PASSWORD="password";
    
    public static final String TAG = "MY MESSAGE";
 
    private int PICK_IMAGE_REQUEST = 1;
 
    private Button buttonChoose;
    private Button buttonUpload;
    private Button buttonView;
 
    public EditText username;
    public EditText mail;
    public EditText phone;
    public EditText password;
    
    private ImageView imageView;
 
    private Bitmap bitmap;
 
    private Uri filePath;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open);
 
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        mail=(EditText)findViewById(R.id.mail);
        phone=(EditText)findViewById(R.id.phone);
        
        
       // buttonChoose = (Button) findViewById(R.id.buttonChoose);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        buttonView = (Button) findViewById(R.id.buttonViewImage);
 
        imageView = (ImageView) findViewById(R.id.imageView);
 
       // buttonChoose.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }
 
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
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
    public void call(View view)
    {
    	showFileChooser();
    }
    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        //String encodedImage=new String(imageBytes);
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }
 
    private void uploadImage(){
        class UploadImage extends AsyncTask<Bitmap,Void,String>{
 
            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();
            String uploadImage="";
            String u="";
            String p="";
            String ph="";
            String m="";
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Create_Account.this, "Uploading...", null,true,true);
            }
 
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
            }
 
            @Override
            protected String doInBackground(Bitmap... params) {
                Bitmap bitmap = params[0];
                if(bitmap!=null)
                	uploadImage = getStringImage(bitmap);
                
                u=username.getText().toString();
                p=password.getText().toString();
                ph=phone.getText().toString();
                m=mail.getText().toString();
                
                HashMap<String,String> data = new HashMap<String,String>();
                data.put(UPLOAD_KEY, uploadImage);
                data.put(UPLOAD_USERNAME,u);
                data.put(UPLOAD_MAIL,m);
                data.put(UPLOAD_PHONE,ph);
                data.put(UPLOAD_PASSWORD,p);
                
                String result = rh.sendPostRequest(UPLOAD_URL,data);
 
                return result;
            }
        }
 
        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }
 
    @Override
    public void onClick(View v) {
       // if (v == buttonChoose) {
       //     showFileChooser();
       // }
        if(v == buttonUpload){
            uploadImage();
        }
        if(v == buttonView){
            viewImage();
        }
    }
 
    private void viewImage() {
        startActivity(new Intent(this, Welcome.class));
    }
}