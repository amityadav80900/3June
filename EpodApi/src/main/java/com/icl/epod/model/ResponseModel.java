package com.icl.epod.model;

/**
 * @author Vijendra.y
 *
 */
public class ResponseModel {
	
	private String success;
	private String failure;
	private Integer recordNumber;
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	
	public String getFailure() {
		return failure;
	}
	public void setFailure(String failure) {
		this.failure = failure;
	}
	public Integer getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(Integer recordNumber) {
		this.recordNumber = recordNumber;
	}
}
