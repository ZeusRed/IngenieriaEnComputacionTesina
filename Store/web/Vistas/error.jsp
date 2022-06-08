 
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>  

<mt:dashboard title="Dashboard">
    <jsp:attribute name="content">
        <style type="text/css">
        

           
            .return a:hover {
                border-bottom-color: #fff;
            }
            footer{
                display:none;
                
            }
        </style>
        <div class="isrow">
            <div class="error-container">
                <h3>No se encontraron elementos.</h3>
                <p class="return">Regresar a <a href="${pageContext.request.contextPath}/Inicio">Electronic Shop &copy;</a></p>
            </div>
        </div>
    </jsp:attribute>
</mt:dashboard>
 
