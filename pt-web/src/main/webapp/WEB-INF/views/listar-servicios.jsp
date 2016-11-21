<a class="btn btn-primary" href ng-click="agregarServicio()">Agregar</a>
<table class="table table-striped table-hover">
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
			<td>
				<div class="btn-group">
					<a class="btn btn-primary" href ng-click="editarServicio(servicio)">Editar</a><a
						class="btn btn-primary" href ng-click="eliminarServicio(servicio)">Eliminar</a>
				</div>





			</td>
		</tr>
	</tbody>
</table>
<div class="mensaje" ng-show="mensaje!=undefined">{{mensaje}}</div>