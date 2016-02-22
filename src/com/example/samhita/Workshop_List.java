package com.example.samhita;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class Workshop_List extends ArrayAdapter<String> {


	private final Activity context;
	private final String[] itemname;
	private final Integer[] imgid;
	private final String[] sub_itemname;
	ImageConverter ic;
	public Workshop_List(Activity context, String[] itemname, Integer[] imgid,String[] sub_itemname) {
		super(context, R.layout.mylist_contact, itemname);
		// TODO Auto-generated constructor stub
		
		this.context=context;
		this.itemname=itemname;
		this.sub_itemname=sub_itemname;
		this.imgid=imgid;
	}
	
	public View getView(int position,View view,ViewGroup parent) {
		LayoutInflater inflater=context.getLayoutInflater();
		View rowView=inflater.inflate(R.layout.mylist_contact, null,true);
		
		TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
		ic=new ImageConverter();
		txtTitle.setText(itemname[position]);
		imageView.setImageResource(imgid[position]);
		extratxt.setText(sub_itemname[position]);
		
		return rowView;
		
	};
}
