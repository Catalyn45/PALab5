<html>
<head>
    <title>
        ${name}
    </title>
</head>

<body>
 <h1>${name}</h1>
 <#list items>
     <#items as item>
     <p>${item.toString()}</p>
     </#items>
 </#list>
</body>
</html>