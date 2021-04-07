package myplugin.generator.fmmodel;

import java.util.ArrayList;
import java.util.List;

public class FMReferencedProperty  {
	private String columnName;
	private String joinTable;
	private String joinType;
	private CascadeType cascadeType;
	private FetchType fetchType;

	
	
	public FMReferencedProperty() {
		super();
	}

	public FMReferencedProperty(String columnName, String joinTable, String joinType, CascadeType cascadeType,
			FetchType fetchType) {
		super();
		this.columnName = columnName;
		this.joinTable = joinTable;
		this.joinType = joinType;
		this.cascadeType = cascadeType;
		this.fetchType = fetchType;
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

	public String getJoinType() {
		return joinType;
	}

	public void setJoinType(String joinType) {
		this.joinType = joinType;
	}

	public CascadeType getCascadeType() {
		return cascadeType;
	}

	public void setCascadeType(CascadeType cascadeType) {
		this.cascadeType = cascadeType;
	}

	public FetchType getFetchType() {
		return fetchType;
	}

	public void setFetchType(FetchType fetchType) {
		this.fetchType = fetchType;
	}
	
	
}
