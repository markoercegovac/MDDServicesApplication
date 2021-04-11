package myplugin.generator.fmmodel;

import java.util.ArrayList;
import java.util.List;

public class FMPerisistentProperty {
	private String columnName;
	private Integer length;
	private Integer precision;
	private Strategy strategy;

	public FMPerisistentProperty() {
		super();
	}

	public FMPerisistentProperty(String columnName, Integer length, Integer precision, Strategy strategy) {
		super();
		this.columnName = columnName;
		this.length = length;
		this.precision = precision;
		this.strategy = strategy;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getPrecision() {
		return precision;
	}

	public void setPrecision(Integer precision) {
		this.precision = precision;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

}
