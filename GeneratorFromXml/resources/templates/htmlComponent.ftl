<html>
<head>
<meta charset="utf-8">

	<title>${fmForm.title}</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> 
</head>
<body>
<div class="control-group">
<table>
	<#list listFields as field>
		<tr>
			<td>${field.label}:</td>
		</tr>
	</#list>

</html>