package myplugin.generator.fmmodel;


public class FMProperty {
	//Property type
	private String type;
	// Property visibility (public, private, protected, package)
	private String visibility;
	//Multiplicity (lower value)
	private Integer lower;
	//Multiplicity (upper value) 
	private Integer upper;
	
	private String name;
	private String classPackage;
	
	private String columnName;
	private Integer length;
	private Integer precision;
	private Strategy strategy;
	
	private String propertyType;
	private String joinTable;
	private String joinType;
	private CascadeType cascadeType;
	private FetchType fetchType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassPackage() {
		return classPackage;
	}
	public void setClassPackage(String classPackage) {
		this.classPackage = classPackage;
	}
	public String getTypePackage() {
		return typePackage;
	}
	public void setTypePackage(String typePackage) {
		this.typePackage = typePackage;
	}

	private String typePackage;
	
	/** @ToDo: Add length, precision, unique... whatever is needed for ejb class generation
	 * Also, provide these meta-attributes or tags in the modeling languange metaclass or 
	 * stereotype */
	private FMPerisistentProperty perisistentProperty;
	private FMReferencedProperty referencedProperty;
	private FMFieldProperty fieldProperty;
	
	public FMProperty() {
		super();
	}
	
	public FMFieldProperty getFieldProperty() {
		return fieldProperty;
	}
	public void setFieldProperty(FMFieldProperty fieldProperty) {
		this.fieldProperty = fieldProperty;
	}
	public FMProperty(String type, String visibility, Integer lower, Integer upper, String name, String classPackage,
			String typePackage, FMPerisistentProperty perisistentProperty, FMReferencedProperty referencedProperty,
			FMFieldProperty fieldProperty) {
		super();
		this.type = type;
		this.visibility = visibility;
		this.lower = lower;
		this.upper = upper;
		this.name = name;
		this.classPackage = classPackage;
		this.typePackage = typePackage;
		this.perisistentProperty = perisistentProperty;
		this.referencedProperty = referencedProperty;
		this.fieldProperty = fieldProperty;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	public Integer getLower() {
		return lower;
	}

	public void setLower(Integer lower) {
		this.lower = lower;
	}

	public Integer getUpper() {
		return upper;
	}

	public void setUpper(Integer upper) {
		this.upper = upper;
	}

	public FMPerisistentProperty getPerisistentProperty() {
		return perisistentProperty;
	}

	public void setPerisistentProperty(FMPerisistentProperty perisistentProperty) {
		this.perisistentProperty = perisistentProperty;
	}

	public FMReferencedProperty getReferencedProperty() {
		return referencedProperty;
	}

	public void setReferencedProperty(FMReferencedProperty referencedProperty) {
		this.referencedProperty = referencedProperty;
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
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
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
