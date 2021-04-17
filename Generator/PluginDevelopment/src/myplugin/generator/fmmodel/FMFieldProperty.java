package myplugin.generator.fmmodel;

public class FMFieldProperty {

	private String label;
	private FieldType type;
	private boolean multiple;
	private boolean required;
	
	public FMFieldProperty() {
		// TODO Auto-generated constructor stub
	}

	public FMFieldProperty(String label, FieldType type, boolean multiple, boolean required) {
		super();
		this.label = label;
		this.type = type;
		this.multiple = multiple;
		this.required = required;
	}
	
	

}
