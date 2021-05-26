package com.care.root.board.dto;

import java.sql.Timestamp;

public class BoardRepDTO {
	private String id;
	private String title;
	private String content;
	private int write_group;
	private Timestamp wrtie_data;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getWrite_group() {
		return write_group;
	}
	public void setWrite_group(int write_group) {
		this.write_group = write_group;
	}
	public Timestamp getWrtie_data() {
		return wrtie_data;
	}
	public void setWrtie_data(Timestamp wrtie_data) {
		this.wrtie_data = wrtie_data;
	}
}
