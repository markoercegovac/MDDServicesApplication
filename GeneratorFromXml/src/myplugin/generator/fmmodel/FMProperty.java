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
	private String typePackage;
	
	/** @ToDo: Add length, precision, unique... whatever is needed for ejb class generation
	 * Also, provide these meta-attributes or tags in the modeling languange metaclass or 
	 * stereotype */
	private FMPerisistentProperty perisistentProperty;
	private FMReferencedProperty referencedProperty;
	
	
	public FMProperty() {
		super();
	}
	public FMProperty(String type, String visibility, Integer lower, Integer upper, String name, String classPackage,
			String typePackage, FMPerisistentProperty perisistentProperty, FMReferencedProperty referencedProperty) {
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
	
	
	
	
}