<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*, persistencia.Conexion"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pantalla Cines</title>
</head>
<body class="cuerpo">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="CinesJSP.jsp">Cines</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="PeliculasJSP.jsp">Peliculas</a></li>
                <li class="nav-item"><a class="nav-link" href="SalasJSP.jsp">Salas</a></li>
            </ul>
            <form class="d-flex">
                <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal">Insertar Salas</button>
            </form>
        </div>
    </div>
</nav>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Insertar Sala</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form method="post" action="insertSalas">
                    <div class="form-group">
                        <label for="capacidad">Capacidad</label>
                        <input type="text" class="form-control" name="capacidad" id="capacidad">
                    </div>
                    <div class="form-group">
                        <label for="metrosCuadrados">Metros Cuadrados</label>
                        <input type="text" class="form-control" name="metrosCuadrados" id="metrosCuadrados">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Insertar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="contenedor">
    <div class="contenido">
        <div id="ListaCines" class="lista">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th style="text-align: left;">ID</th>
                        <th style="text-align: left;">Capacidad</th>
                        <th style="text-align: left;">Metros cuadrados</th>
                        <th style="text-align: center;">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    Conexion con = new Conexion();
                    List<String> salas = new ArrayList<>();
                    try {
                        salas = con.leerSalas(con.getConexion());
                        if (salas.isEmpty()) {
                            out.println("<tr><td colspan='4'>No hay salas disponibles</td></tr>");
                        } else {
                            for (String datosSalas : salas) {
                                String[] columnas = datosSalas.split(",");
                    %>
                    <tr class="justify-content-center">
                        <td style="text-align: left;"><%= columnas[0] %></td>
                        <td style="text-align: left;"><%= columnas[1] %></td>
                        <td style="text-align: left;"><%= columnas[2] %></td>
                        <td>
                            <form method="post" action="ModificarSalas" style="display: inline;">
                                <input type="hidden" name="salasID" value="<%= columnas[0] %>" />
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModalLong-<%= columnas[0] %>">Modificar</button>
                            </form>
                            <form method="post" action="GestorSalas" style="display: inline;">
                                <input type="hidden" name="salaId" value="<%= columnas[0] %>" />
                                <button class="btn btn-danger" type="submit" name="Borrar">Borrar</button>
                            </form>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    } catch (SQLException e) {
                        out.println("<tr><td colspan='4'>Error al obtener la lista de salas</td></tr>");
                        e.printStackTrace();
                    }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%
for (String datosSalas : salas) {
    String[] columnas = datosSalas.split(",");
%>
<div class="modal fade" id="exampleModalLong-<%= columnas[0] %>" tabindex="-1" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Modificar Sala</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form method="post" action="ModificarSalas">
                    <div class="form-group">
                        <label for="capacidadNueva">Capacidad Mod</label>
                        <input type="text" class="form-control" name="capacidadNueva" id="capacidadNueva" value="<%= columnas[1] %>">
                    </div>
                    <div class="form-group">
                        <label for="nuevosMetros">Metros Cuadrados Mod</label>
                        <input type="text" class="form-control" name="nuevosMetros" id="nuevosMetros" value="<%= columnas[2] %>">
                    </div>
                    <input type="hidden" name="salasID" value="<%= columnas[0] %>" />
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button class="btn btn-primary" type="submit">Realizar cambios</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%
}
%>

</body>
</html>
