package myplugin.generator.fmmodel;

import java.util.ArrayList;
import java.util.List;

public class FMPerisistentProperty extends FMProperty {
	private String columnName;
	private Integer length;
	private Integer precision;
	private List<FMEnumeration> enumerationList = new ArrayList<FMEnumeration>();

	public FMPerisistentProperty(String name, String type, String visibility, Integer lower, Integer upper,
			FMPerisistentProperty perisistentProperty, FMReferencedProperty referencedProperty, String columnName,
			Integer length, Integer precision, List<FMEnumeration> enumerationList) {
		super(name, type, visibility, lower, upper, perisistentProperty, referencedProperty);
		this.columnName = columnName;
		this.length = length;
		this.precision = precision;
		this.enumerationList = enumerationList;
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

	public List<FMEnumeration> getEnumerationList() {
		return enumerationList;
	}

	public void setEnumerationList(List<FMEnumeration> enumerationList) {
		this.enumerationList = enumerationList;
	}
}
