package myplugin.generator.fmmodel;

public class FMFormClass {

	private String title;
	private String name;
	private boolean modal;
	private boolean getAll;
	private boolean input;
	private boolean edit;
	private String redirectLink;
	private String successMessage;
	private String errorMessage;
	private String componentName;
	private String componentPath;
	
	public FMFormClass(String title, String name, boolean modal, boolean getAll, boolean input, boolean edit,
			String redirectLink, String successMessage, String errorMessage, String componentName,
			String componentPath) {
		super();
		this.title = title;
		this.name = name;
		this.modal = modal;
		this.getAll = getAll;
		this.input = input;
		this.edit = edit;
		this.redirectLink = redirectLink;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
		this.componentName = componentName;
		this.componentPath = componentPath;
	}

	public FMFormClass() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isModal() {
		return modal;
	}

	public void setModal(boolean modal) {
		this.modal = modal;
	}

	public boolean isGetAll() {
		return getAll;
	}

	public void setGetAll(boolean getAll) {
		this.getAll = getAll;
	}

	public boolean isInput() {
		return input;
	}

	public void setInput(boolean input) {
		this.input = input;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getRedirectLink() {
		return redirectLink;
	}

	public void setRedirectLink(String redirectLink) {
		this.redirectLink = redirectLink;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentPath() {
		return componentPath;
	}

	public void setComponentPath(String componentPath) {
		this.componentPath = componentPath;
	}
	
	

}
