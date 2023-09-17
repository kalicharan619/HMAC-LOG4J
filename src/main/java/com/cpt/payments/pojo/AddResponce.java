package com.cpt.payments.pojo;

import lombok.Data;

@Data
public class AddResponce {

    private int resValue;

	public int getResValue() {
		return resValue;
	}

	public void setResValue(int resValue) {
		this.resValue = resValue;
	}

	@Override
	public String toString() {
		return "AddResponce [resValue=" + resValue + "]";
	}
  }
