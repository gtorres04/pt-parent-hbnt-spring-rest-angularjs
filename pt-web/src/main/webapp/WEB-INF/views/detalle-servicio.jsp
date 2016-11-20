<div class="mensaje" ng-show="mensaje!=undefined">{{mensaje}}</div>
<table>
	<tr>
		<td>ID</td>
		<td><input ng-model="id"></td>
	</tr>
	<tr>
		<td>Nombre</td>
		<td><input ng-model="nombre"></td>
	</tr>
	<tr>
		<td>Descripcion</td>
		<td><input ng-model="descripcion"></td>
	</tr>
	<tr>
		<td>Cargar Imagen</td>
		<td><input ng-model="rutaImagen"></td>
	</tr>
</table>
<hr>
<table ng-show="mostrarTablaCaracteristicas">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>valor</th>
			<th>Acciones</th>
		</tr>
	</thead>
	<tbody>
		<tr ng-repeat="servicio in servicios">
			<td>ca</td>
			<td>ca</td>
			<td>ca</td>
			<td><a>Editar</a><a>Eliminar</a></td>
		</tr>
	</tbody>
</table>
<a href ng-click="modificarServicio()">Guardar</a><a href ng-click="irListarServicios()">Cancelar</a>