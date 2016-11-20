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
											'http://localhost:8181/pt-ws/rest/api/services')
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
							$scope.mostrarTablaCaracteristicas = true;
							$scope.id = undefined;
							$scope.nombre = undefined;
							$scope.descripcion = undefined;
							$scope.rutaImagen = undefined;
							$scope.mensaje=undefined;
							if (servicio === null) {
								$scope.mostrarTablaCaracteristicas = false;
							} else {
								$scope.id = servicio.id;
								$scope.nombre = servicio.nombre;
								$scope.descripcion = servicio.descripcion;
								$scope.rutaImagen = servicio.rutaImagen;
							}

							$scope.irListarServicios = function() {
								$state.go('listarServicios');
							};
							$scope.modificarServicio = function() {
								var data = {
									id : $scope.id,
									nombre : $scope.nombre,
									descripcion : $scope.descripcion,
									rutaImagen : $scope.rutaImagen
								};
								$http
										.post(
												'http://localhost:8181/pt-ws/rest/api/services',
												data)
										.success(
												function(data, status, headers,
														config) {
													if(data.ejecucion){
														$scope.mensaje=data.descripcion;
													}
												})
										.error(
												function(data, status, header,
														config) {
													
												});
							};

						} ]);