package myplugin.generator.fmmodel;

import java.util.ArrayList;
import java.util.List;

public class FMReferencedProperty extends FMProperty {
	private String columnName;
	private String joinTable;
	private String joinType;
	private List<FMEnumeration> enumerationList = new ArrayList<FMEnumeration>();

	public FMReferencedProperty(String name, String type, String visibility, Integer lower, Integer upper,
			FMPerisistentProperty perisistentProperty, FMReferencedProperty referencedProperty, String columnName,
			String joinTable, String joinType, List<FMEnumeration> enumerationList) {
		super(name, type, visibility, lower, upper, perisistentProperty, referencedProperty);
		this.columnName = columnName;
		this.joinTable = joinTable;
		this.joinType = joinType;
		this.enumerationList = enumerationList;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getJoinTable() {
		return joinTable;
	}

	public void setJoinTable(String joinTable) {
		this.joinTable = joinTable;
	}

	public List<FMEnumeration> getEnumerationList() {
		return enumerationList;
	}

	public void setEnumerationList(List<FMEnumeration> enumerationList) {
		this.enumerationList = enumerationList;
	}

	public String getJoinType() {
		return joinType;
	}

	public void setJoinType(String joinType) {
		this.joinType = joinType;
	}
}
