package com.rs.struts.form;

import org.apache.struts.action.ActionForm;

public class ExpenseReportForm extends ActionForm {
	private String Type;
	private String fromDate;
	private String toDate;

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
