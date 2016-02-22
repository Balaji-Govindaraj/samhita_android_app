package com.example.samhita;

public class ListItem {

	private String url;
	private String mt;
	private String st;
	private String tel;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getmt() {
		return mt;
	}

	public void setmt(String mt) {
		this.mt = mt;
	}

	public String gettel() {
		return tel;
	}
	public void settel(String tel) {
		this.tel = tel;
	}
	
	public String getst() {
		return st;
	}

	public void setst(String st) {
		this.st = st;
	}

	@Override
	public String toString() {
		return st+":"+mt;
	}
}
