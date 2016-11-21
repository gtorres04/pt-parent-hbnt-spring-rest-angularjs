<div class="alert alert-success" ng-show="mensaje!=undefined">{{mensaje}}</div>
<table class="table table-striped table-hover" >
	<tr>
		<td>ID</td>
		<td><input readonly="readonly" ng-model="servicioDetalle.id"></td>
	</tr>
	<tr>
		<td>Nombre</td>
		<td><input ng-model="servicioDetalle.nombre"></td>
	</tr>
	<tr>
		<td>Descripcion</td>
		<td><input ng-model="servicioDetalle.descripcion"></td>
	</tr>
	<tr>
		<td>Cargar Imagen</td>
		<td><input ng-model="servicioDetalle.rutaImagen"></td>
	</tr>
</table>
<a class="btn btn-primary" href ng-click="modificarServicio()">Guardar</a>
<a  class="btn btn-primary" href ng-click="irListarServicios()">Cancelar</a>
<hr>


<div ng-show="mostrarTablaCaracteristicas" style="width: 100%">
<a class="btn btn-primary" href ng-click="agregarCasillaCaracteristica()">Agregar Caracteristica</a>
<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>valor</th>
			<th>Acciones</th>
		</tr>
	</thead>
	<tbody>
		<tr ng-repeat="caracteristica in servicioDetalle.caracteristicas">
			<td><span>{{caracteristica.id}}</span></td>
			<td><span ng-show="!caracteristica.seEstaEditando">{{caracteristica.nombre}}</span><input ng-show="caracteristica.seEstaEditando" ng-model="caracteristica.nombre" ></td>
			<td><span ng-show="!caracteristica.seEstaEditando">{{caracteristica.valor}}</span><input ng-show="caracteristica.seEstaEditando" ng-model="caracteristica.valor" ></td>
			<td>
			<div class="btn-group">
			<a class="btn btn-primary" ng-show="!caracteristica.seEstaEditando" href
				ng-click="habilitarCamposModificacion(caracteristica)">Editar</a> 
				<a class="btn btn-primary" ng-show="caracteristica.seEstaEditando" href
				ng-click="modificarCaracteristica(caracteristica, servicioDetalle)">Actualizar</a> 
				<a class="btn btn-primary" href ng-click="eliminarCaracteristica(caracteristica, servicioDetalle)">Eliminar</a>
				</div>
			</td>
		</tr>
		<tr ng-show="seEstaAgregando">
			<td><input readonly="readonly" ng-model="idCaracteristicaAgregar" ></td>
			<td><input ng-model="nombreCaracteristicaAgregar" ></td>
			<td><input ng-model="valorCaracteristicaAgregar" ></td>
			<td>
			<div class="btn-group"><a class="btn btn-primary" href
				ng-click="agregarCaracteristica(servicioDetalle)">Guardar</a> 
				<a class="btn btn-primary" href ng-click="resetCaracteristica()">Cancelar</a>
				</div>
			</td>
		</tr>
	</tbody>
</table>

</div>
