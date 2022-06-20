package com.micropos.carts.model;

import lombok.Data;

@Data
public class Joke {
	private String icon_url;
	private String id;
	private String url;
	private String value;


	public String getValue() {
		return value;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
