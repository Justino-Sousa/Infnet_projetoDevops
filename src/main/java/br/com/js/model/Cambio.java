package br.com.js.model;

import lombok.Data;

@Data
public class Cambio {

	private NestedClass nestedClass;

	@Data
	public class NestedClass {

		private String code;
		private String codein;
		private String name;
		private String high;
		private String low;
		private String varBid;
		private String pctChange;
		private String bid;
		private String ask;
		private String timestamp;
		private String create_date;
	}

}
