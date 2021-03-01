<#-- @ftlvariable name="" type="com.nataliele.connect4.GridView" -->
<html>
    <h1>Turn: Player ${currentPlayer}</h1>
    <h3>${message}</h3>
    <#assign rows = grid.representation>
    <#list rows as row>
      <h2>${row}
    </#list>
</html>