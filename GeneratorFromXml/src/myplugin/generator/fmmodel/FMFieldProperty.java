package myplugin.generator.fmmodel;

public class FMFieldProperty {

	private String label;
	private FieldType type;
	private boolean multiple;
	private boolean required;
	private String stereotype;
	
	public FMFieldProperty() {
		// TODO Auto-generated constructor stub
	}

	public FMFieldProperty(String label, FieldType type, boolean multiple, boolean required, String stereotype) {
		super();
		this.label = label;
		this.type = type;
		this.multiple = multiple;
		this.required = required;
		this.stereotype = stereotype;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public FieldType getType() {
		return type;
	}

	public void setType(FieldType type) {
		this.type = type;
	}

	public boolean isMultiple() {
		return multiple;
	}

	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getStereotype() {
		return stereotype;
	}

	public void setStereotype(String stereotype) {
		this.stereotype = stereotype;
	}

	

}
