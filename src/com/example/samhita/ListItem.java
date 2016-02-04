package com.example.samhita;

public class ListItem {

	private String url;
	private String mt;
	private String st;

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
