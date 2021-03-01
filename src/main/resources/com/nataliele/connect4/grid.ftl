<#-- @ftlvariable name="" type="com.nataliele.connect4.GridView" -->
<html>
    <h1>Turn: Player ${currentPlayer}</h1>
    <h2>${message}</h2>
    <#assign rows = grid.representation>
    <#list rows as row>
      <p>${row}
    </#list>
</html>