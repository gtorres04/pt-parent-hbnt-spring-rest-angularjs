'use strict';

angular
		.module('serviciosComponent')
		.controller(
				'listarServiciosController',
				[
						"$scope",
						"$log",
						"$http",
						"$state",
						"$rootScope",
						"$stateParams",
						function($scope, $log, $http, $state, $rootScope,
								$stateParams) {
							$log.info('Probando Log');
							$http
									.get(
											window.location.origin
											+ webAppConfig.contextPathWs
											+ 'rest/api/services')
									.then(
											function(response) {
												$scope.servicios = response.data.servicios;
											});

							// Example table
							var vm = this;

							$scope.agregarServicio = function() {
								$state.go('detalleServicios');
							};

							$scope.editarServicio = function(servicio) {
								$state.go('detalleServicios', {
									servicio : servicio
								});
							};
							$scope.mensaje = undefined;
							$scope.eliminarServicio = function(servicio) {
								$log.info('Eliminando Servicio '
										+ servicio.nombre);
								var data = {
									id : servicio.id,
									nombre : servicio.nombre,
									descripcion : servicio.descripcion,
									rutaImagen : servicio.rutaImagen,
									metodoHttp : 'delete'
								};
								$http
										.post(
												window.location.origin
												+ webAppConfig.contextPathWs
												+ 'rest/api/services',
												data)
										.success(
												function(data, status, headers,
														config) {
													if (data.ejecucion) {
														$scope.mensaje = data.descripcion;
													}
												}).error(
												function(data, status, header,
														config) {

												});
							};

						} ])
		.controller(
				'detalleServiciosController',
				[
						"$scope",
						"$log",
						"$http",
						"$state",
						"$rootScope",
						"$stateParams",
						function($scope, $log, $http, $state, $rootScope,
								$stateParams) {
							$log.info('detalle Servicio');
							var servicio = $stateParams.servicio;
							$scope.mostrarTablaCaracteristicas = true
							$scope.mensaje = undefined;
							$scope.servicioDetalle = undefined;
							if (servicio === null) {
								$scope.mostrarTablaCaracteristicas = false;
							} else {
								$scope.servicioDetalle = servicio;
							}

							$scope.irListarServicios = function() {
								$state.go('listarServicios');
							};
							$scope.modificarServicio = function() {
								var data = {
									id : $scope.servicioDetalle.id,
									nombre : $scope.servicioDetalle.nombre,
									descripcion : $scope.servicioDetalle.descripcion,
									rutaImagen : $scope.servicioDetalle.rutaImagen
								};
								$http
										.post(
												window.location.origin
												+ webAppConfig.contextPathWs
												+ 'rest/api/services',
												data)
										.success(
												function(data, status, headers,
														config) {
													if (data.ejecucion) {
														$scope.mensaje = data.descripcion;
														$scope.servicioDetalle.id=data.id;
													}
												}).error(
												function(data, status, header,
														config) {

												});
							};
							$scope.eliminarCaracteristica = function(
									caracteristica, servicioRelacionado) {
								$log.info('eliminando Caracteristica');
								var data = {
									id : caracteristica.id,
									nombre : caracteristica.nombre,
									valor : caracteristica.valor,
									metodoHttp : 'delete',
									idServicio : servicioRelacionado.id
								};
								var response = peticionPost(
										window.location.origin
												+ webAppConfig.contextPathWs
												+ 'rest/apic/services/specs',
										data);
							};
							$scope.modificarCaracteristica = function(
									caracteristica, servicioRelacionado) {
								$log.info('modificando Caracteristica');
								var data = {
									id : caracteristica.id,
									nombre : caracteristica.nombre,
									valor : caracteristica.valor,
									idServicio : servicioRelacionado.id
								};
								peticionPost(window.location.origin
										+ webAppConfig.contextPathWs
										+ 'rest/apic/services/specs', data);
								caracteristica.seEstaEditando = false;
							};

							var peticionPost = function(url, data) {
								var response = {
									data : undefined,
									status : undefined,
									headers : undefined,
									config : undefined
								};
								$http
										.post(url, data)
										.success(
												function(data, status, headers,
														config) {
													response.data = data;
													response.status = status;
													response.headers = headers;
													response.config = config;

													$scope.mensaje = data.descripcion;

												}).error(
												function(data, status, header,
														config) {
													response.data = data;
													response.status = status;
													response.headers = headers;
													response.config = config;
												});
								return response;
							};
							$scope.idCaracteristicaEditar = undefined;
							$scope.nombreCaracteristicaEditar = undefined;
							$scope.valorCaracteristicaEditar = undefined;
							$scope.habilitarCamposModificacion = function(
									caracteristica) {
								$scope.idCaracteristicaEditar = caracteristica.id;
								$scope.nombreCaracteristicaEditar = caracteristica.nombre;
								$scope.valorCaracteristicaEditar = caracteristica.valor;
								caracteristica.seEstaEditando = true;
							};
							$scope.seEstaAgregando = false;
							$scope.idCaracteristicaAgregar = undefined;
							$scope.nombreCaracteristicaAgregar = undefined;
							$scope.valorCaracteristicaAgregar = undefined;
							$scope.agregarCasillaCaracteristica = function() {
								$scope.seEstaAgregando = true;
							}
							$scope.agregarCaracteristica = function(
									servicioDetalle) {
								$log.info('modificando Caracteristica');
								var data = {
									id : $scope.idCaracteristicaAgregar,
									nombre : $scope.nombreCaracteristicaAgregar,
									valor : $scope.valorCaracteristicaAgregar,
									idServicio : servicioDetalle.id
								};
								
								$http
								.post(window.location.origin
										+ webAppConfig.contextPathWs
										+ 'rest/apic/services/specs', data)
								.success(
										function(data, status, headers,
												config) {
											
											if(data.ejecucion){
												$scope.seEstaAgregando = false;
												servicioDetalle.caracteristicas.push(data);
												$scope.idCaracteristicaAgregar = undefined;
												$scope.nombreCaracteristicaAgregar = undefined;
												$scope.valorCaracteristicaAgregar = undefined;
											}
											$scope.mensaje = data.descripcion;

										}).error(
										function(data, status, header,
												config) {
											response.data = data;
											response.status = status;
											response.headers = headers;
											response.config = config;
										});
								

							};
							$scope.resetCaracteristica = function(
									servicioDetalle) {
								$scope.seEstaAgregando = false;
								$scope.idCaracteristicaAgregar = undefined;
								$scope.nombreCaracteristicaAgregar = undefined;
								$scope.valorCaracteristicaAgregar = undefined;
							};
						} ]);