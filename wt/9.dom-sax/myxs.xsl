<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<body>
<h2> Motor Bike</h2>
<table border="1">
<tr bgcolor="orange">
<th>COMPANY</th>
<th>MODEL</th>
<th>COLOR</th>
<th>YEAR</th>
<th>PRICE</th>
<th>ENGINE</th>
<th>MILEAGE</th>
</tr>
<xsl:for-each select="BIKEMODEL/CD">
<tr bgcolor="yellow">
<td><xsl:value-of select="COMPANY"/></td>
<td><xsl:value-of select="MODEL"/></td>
<td><xsl:value-of select="COLOR"/></td>
<td><xsl:value-of select="YEAR"/></td>
<td><xsl:value-of select="PRICE"/></td>
<td><xsl:value-of select="ENGINE"/></td>
<td><xsl:value-of select="MILEAGE"/></td>
</tr>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>

