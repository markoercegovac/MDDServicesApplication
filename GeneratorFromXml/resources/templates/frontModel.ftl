export class ${class.name} {
	<#list properties as property>
		<#if property.name == "id">
			${property.name} : number;
		<#elseif property.type == "String">
			${property.name} : string;
		<#elseif property.type == "double">
			${property.name} : number;
		<#elseif property.type == "Integer">
			${property.name} : number;
		</#if>
	</#list>
	
	constructor(
		<#list properties as property>
			<#if property.name == "id">
				${property.name} : number,
			<#elseif property.type == "String">
				${property.name} : string,
			<#elseif property.type == "double">
				${property.name} : number,
			<#elseif property.type == "Integer">
				${property.name} : number,
			</#if>
		</#list>
	)
	{
		<#list properties as property>
			<#if property.name == "id">
				this.${property.name} = ${property.name};
			<#elseif property.type == "String">
				this.${property.name} = ${property.name};
			<#elseif property.type == "double">
				this.${property.name} = ${property.name};
			<#elseif property.type == "Integer">
				this.${property.name} = ${property.name};
			</#if>
		</#list>
	}
	
}