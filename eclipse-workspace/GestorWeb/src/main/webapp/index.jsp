<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*, persistencia.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Gestor Cines</title>
</head>
<body class="cuerpo">

    <div class="contenedor">
        <div class="contenido">
            <h2>Lista de Cines</h2>
            <div id="ListaCines" class="lista">
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                    </tr>
                    <%
                    Conexion con = new Conexion();
                    try {
                        for (String datosCine : con.leerCines(con.getConexion())) {
                            String[] filas = datosCine.split(",");
                    %>
                    <tr>
                        <td><%=filas[0]%></td>
                        <td><%=filas[1]%></td>
                        <td><%=filas[2]%></td>
                    </tr>
                    <%
                    }
                    } catch (SQLException e) {
                        out.println("<tr><td colspan='3'>Error al obtener la lista de cines</td></tr>");
                        e.printStackTrace();
                    }
                    %>
                </table>
            </div>
            <div class="gestor">
            
                <h1>Gestión de Cines</h1>
                
                <h2>Crear Cine</h2>
                
                <form action="ServletCrearCine" id="crearCine" method="get">
                
                    <label for="nombreCine">Nombre del Cine:</label>
                    <input type="text" id="nombreCine" name="nombreCine" required>
                    
                    <label for="direccionCine">Dirección del Cine:</label>
                    <input type="text" id="direccionCine" name="direccionCine" required>
                    
                    <button type="submit" name ="botonCine" value="botonCrearCine" >Crear Cine</button>
                </form>
                
                <h2>Modificar Nombre del Cine</h2>
                
                <form action="ServletCrearCine" id="updateCinemaForm" method="get">
                
                    <label for="cineId">ID del Cine:</label>
                    <input type="text" id="cineId" name="cineId" required>
                    
                    <label for="nuevoNombreCine">Nuevo Nombre del Cine:</label>
                    <input type="text" id="nuevoNombreCine" name="nuevoNombre" required>
                    
                    <button type="submit" name="actualizarCine" value="actualizador">Modificar Cine</button>
                    
                </form>
                
                <h2>Que cine quieres eliminar</h2>
                                
                <form action="ServletCrearCine" id="eliminarCine" method="get">
                    <label>Id del Cine a eliminar</label>
                    <input type="number" id="pkCines" name="eliminarCineId" required>
                    
                    <button type="submit" name="botonEliminar" value="eliminarCine" >Eliminar Cine</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>

