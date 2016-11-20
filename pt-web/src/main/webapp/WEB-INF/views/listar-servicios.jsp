<a href ng-click="agregarServicio()">Agregar</a>
<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Foto</th>
			<th>Acciones</th>
		</tr>
	</thead>
	<tbody>
		<tr ng-repeat="servicio in servicios">
			<td>{{servicio.id}}</td>
			<td>{{servicio.nombre}}</td>
			<td>{{servicio.descripcion}}</td>
			<td>{{servicio.rutaImagen}}</td>
			<td><a href ng-click="editarServicio(servicio)">Editar</a><a>Eliminar</a></td>
		</tr>
	</tbody>
</table>