package com.xsis.batch197.model;

import javax.validation.Valid;

public class FormBiodataModel {
	
	@Valid
	private XBiodataModel biodata;
	@Valid
	private XAddressModel address;
	
	public XBiodataModel getBiodata() {
		return biodata;
	}
	public void setBiodata(XBiodataModel biodata) {
		this.biodata = biodata;
	}
	public XAddressModel getAddress() {
		return address;
	}
	public void setAddress(XAddressModel address) {
		this.address = address;
	}
	
	
}
