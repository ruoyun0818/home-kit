package com.whitesky.home.controller.common;

import java.io.Serializable;

public class GlobalResult implements Serializable {
	private boolean correct;
	private String result;
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @param correct
	 * @param result
	 */
	public GlobalResult(boolean correct, String result) {
		this.correct = correct;
		this.result = result;
	}
	
}
