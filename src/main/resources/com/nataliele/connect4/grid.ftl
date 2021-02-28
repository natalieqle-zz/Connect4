<#-- @ftlvariable name="" type="com.nataliele.connect4.GridView" -->
<html>
    <#assign rows = grid.representation>
    <#list rows as row>
      <p>${row}
    </#list>
</html>