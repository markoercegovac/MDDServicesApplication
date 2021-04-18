package myplugin.generator.fmmodel;


public class FMProperty extends FMElement  {
	//Property type
	private String type;
	// Property visibility (public, private, protected, package)
	private String visibility;
	//Multiplicity (lower value)
	private Integer lower;
	//Multiplicity (upper value) 
	private Integer upper;
	
	/** @ToDo: Add length, precision, unique... whatever is needed for ejb class generation
	 * Also, provide these meta-attributes or tags in the modeling languange metaclass or 
	 * stereotype */
	private FMPerisistentProperty perisistentProperty;
	private FMReferencedProperty referencedProperty;
	private FMFieldProperty fieldProperty;
	
	
	
	public FMProperty(String name, String type, String visibility, Integer lower, Integer upper,
			FMPerisistentProperty perisistentProperty, FMReferencedProperty referencedProperty,
			FMFieldProperty fieldProperty) {
		super(name);
		this.type = type;
		this.visibility = visibility;
		this.lower = lower;
		this.upper = upper;
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
	public FMFieldProperty getFieldProperty() {
		return fieldProperty;
	}
	public void setFieldProperty(FMFieldProperty fieldProperty) {
		this.fieldProperty = fieldProperty;
	}
	
	
	
	
}
