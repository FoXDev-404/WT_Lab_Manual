<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Student Details</title>
                <style>
                    body { font-family: Arial, sans-serif; }
                    .student { margin: 10px 0; border: 1px solid #ccc; padding: 10px; background: #f9f9f9; }
                    .name { font-size: 18px; font-weight: bold; color: #007bff; }
                    .details { margin: 5px 0; font-size: 14px; color: #555; }
                </style>
            </head>
            <body>
                <h1>Student Information</h1>
                <xsl:for-each select="students/student">
                    <div class="student">
                        <div class="name"><xsl:value-of select="name"/></div>
                        <div class="details">Roll No: <xsl:value-of select="rollno"/></div>
                        <div class="details">Course: <xsl:value-of select="course"/></div>
                        <div class="details">Email: <xsl:value-of select="email"/></div>
                    </div>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
