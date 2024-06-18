<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*, persistencia.Conexion"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pantalla Cines</title>
</head>
<body class="cuerpo">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="CinesJSP.jsp">Cines</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						href="PeliculasJSP.jsp">Peliculas</a></li>
					<li class="nav-item"><a class="nav-link" href="SalasJSP.jsp">Salas</a></li>
				</ul>
				<form class="d-flex">
					<button type="button" class="btn btn-secondary"
						data-bs-toggle="modal" data-bs-target="#exampleModal">Insertar
						Pelicula</button>
				</form>
			</div>
		</div>
	</nav>

	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Insertar
						Pelicula</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<form method="post" action="insertPeli">
					<div class="modal-body">
						<div class="form-group">
							<label for="nombrePeli">Nombre de la Pelicula</label> <input
								type="text" class="form-control" name="nombrePeli"
								id="nombrePeli">
						</div>
						<div class="form-group">
							<label for="duracion">Duracion Pelicula</label> <input
								type="text" class="form-control" name="duracion" id="duracion">
						</div>
						<div class="form-group">
							<label for="genero">Genero</label> <input type="text"
								class="form-control" name="genero" id="genero">
						</div>
						<div class="form-group">
							<label for="director">Director</label> <input type="text"
								class="form-control" name="director" id="director">
						</div>
						<div class="form-group">
							<label for="pegi">PEGI</label> <input type="text"
								class="form-control" name="pegi" id="pegi">
						</div>
						<div class="form-group">
							<label for="precio">Precio</label> <input type="text"
								class="form-control" name="precio" id="precio">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Insertar</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="contenedor">
		<div class="contenido">
			<div id="ListaPeliculas" class="lista">
				<table class="table table-striped">
					<tr>
						<th style="text-align: left;">ID</th>
						<th style="text-align: left;">Nombre</th>
						<th style="text-align: left;">Duración</th>
						<th style="text-align: left;">Genero</th>
						<th style="text-align: left;">Director</th>
						<th style="text-align: left;">PEGI</th>
						<th style="text-align: left;">Precio</th>
						<th style="text-align: center;">Acciones</th>
					</tr>
					<%
					Conexion con = new Conexion();
					try {
						List<String> pelis = con.leerPeliculas(con.getConexion());
						if (pelis.isEmpty()) {
							out.println("<tr><td colspan='8'>No hay Peliculas disponibles</td></tr>");
						} else {
							for (String datosPelis : pelis) {
						String[] columnas = datosPelis.split(",");
					%>
					<tr class="justify-content-center">
						<td style="text-align: left;"><%=columnas[0]%></td>
						<td style="text-align: left;"><%=columnas[1]%></td>
						<td style="text-align: left;"><%=columnas[2]%></td>
						<td style="text-align: left;"><%=columnas[3]%></td>
						<td style="text-align: left;"><%=columnas[4]%></td>
						<td style="text-align: left;"><%=columnas[5]%></td>
						<td style="text-align: left;"><%=columnas[6]%></td>
						<td>
							<form method="post" action="ModificarPeliculas"
								style="display: inline;">
								<input type="hidden" name="pelisID" value="<%=columnas[0]%>" />
								<button type="button" class="btn btn-primary"
									data-bs-toggle="modal"
									data-bs-target="#exampleModalLong-<%=columnas[0]%>">
									Modificar</button>
							</form>
							<form method="post" action="BorrarPeliculas"
								style="display: inline;">
								<input type="hidden" name="peliID" value="<%=columnas[0]%>" />
								<button class="btn btn-danger" type="submit" name="Borrar">Borrar</button>
							</form>
						</td>
					</tr>
					<div class="modal fade" id="exampleModalLong-<%=columnas[0]%>"
						tabindex="-1" aria-labelledby="exampleModalLongTitle"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modificarPeliculas" id="modificarPeliculas">Modificar
										Pelicula</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form method="post" action="ModificarPeliculas">
										<div class="form-group">
											<label for="nuevoNombrePeli">Nuevo nombre Pelicula</label> <input
												type="text" class="form-control" name="nuevoNombrePeli"
												id="nuevoNombrePeli" value="<%=columnas[1]%>">
										</div>
										<input type="hidden" name="peliId" value="<%=columnas[0]%>" />
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Close</button>
											<button class="btn btn-primary" type="submit">Realizar
												cambios</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					<%
					}
					}
					} catch (SQLException e) {
					out.println("<tr><td colspan='8'>Error al obtener la lista de cines</td></tr>");
					e.printStackTrace();
					}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
