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
                <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#insertModal">Insertar Cines</button>
            </form>
        </div>
    </div>
</nav>

<div class="modal fade" data-backdrop="false" id="insertModal" tabindex="-1" aria-labelledby="insertModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="insertModalLabel">Insertar Cine</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form method="post" action="insertCine">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nuevoNombreCineInsert">Nombre del Cine</label>
                        <input type="text" class="form-control" name="nuevoNombreCineInsert" id="nuevoNombreCineInsert">
                    </div>
                    <div class="form-group">
                        <label for="nuevaDireccionCine">Dirección del Cine</label>
                        <input type="text" class="form-control" name="nuevaDireccionCine" id="nuevaDireccionCine">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Insertar</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="contenedor">
    <div class="contenido">
        <div id="ListaCines" class="lista">
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Acciones</th>
                </tr>
                <%
                Conexion con = new Conexion();
                List<String> cines = new ArrayList<>();
                try {
                    cines = con.leerCines(con.getConexion());
                    if (cines.isEmpty()) {
                        out.println("<tr><td colspan='4'>No hay cines disponibles</td></tr>");
                    } else {
                        for (String datosCine : cines) {
                            String[] columnas = datosCine.split(",");
                %>
                <tr>
                    <td><%= columnas[0] %></td>
                    <td><%= columnas[1] %></td>
                    <td><%= columnas[2] %></td>
                    <td>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#updateModal-<%= columnas[0] %>">Modificar</button>
                        <form method="post" action="borrarCines" style="display: inline;">
                            <input type="hidden" name="cineId" value="<%= columnas[0] %>">
                            <button class="btn btn-danger" type="submit" name="Borrar">Borrar</button>
                        </form>
                    </td>
                </tr>
                <% } } } catch (SQLException e) { %>
                <tr><td colspan='4'>Error al obtener la lista de cines</td></tr>
                <% e.printStackTrace(); } %>
            </table>
        </div>
    </div>
</div>

<%
    for (String datosCine : cines) {
        String[] columnas = datosCine.split(",");
%>
<div class="modal fade" data-backdrop="false" id="updateModal-<%= columnas[0] %>" tabindex="-1" aria-labelledby="updateModalLabel-<%= columnas[0] %>" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updateModalLabel-<%= columnas[0] %>">Modificar Cine</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form method="post" action="ModificarCines">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="updateNombreCine-<%= columnas[0] %>">Nombre del Cine</label>
                        <input type="text" class="form-control" name="nuevoNombreCine" id="updateNombreCine">
                    </div>
                    <div class="form-group">
                        <label for="updateDireccionCine-<%= columnas[0] %>">Dirección del Cine</label>
                        <input type="text" class="form-control" name="nuevaDireccionCine" id="updateDireccionCine">
                    </div>
                    <input type="hidden" name="cineId" value="<%= columnas[0] %>">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button class="btn btn-primary" type="submit">Realizar cambios</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%
    }
%>

</body>
</html>





