package com.whitesky.home.model;

import java.sql.Timestamp;
import com.whitesky.home.common.model.DeviceType;
import com.whitesky.home.common.model.ModelBase;

public class Device extends ModelBase {
	private static final long serialVersionUID = -988652006673730197L;

	private String id;
	private String name;
	private String note;
	private DeviceType type;
	private Timestamp createTime;

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public DeviceType getType() {
		return type;
	}

	public void setType(DeviceType type) {
		this.type = type;
	}

}
