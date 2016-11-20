'use strict';

angular
	.module('serviciosComponent')
	.config(
		["$stateProvider", "$urlRouterProvider",function($stateProvider, $urlRouterProvider) {
			$urlRouterProvider.otherwise('/');
			$stateProvider.state('listarServicios', {
				url : "/",
				templateUrl : window.location.origin 
						+ webAppConfig.contextPath
						+ "listar-servicios",
				controller : "listarServiciosController as listService"
			})
			.state('detalleServicios', {
				url : "/detalleServicio/",
				params:{servicio:null},
				templateUrl : window.location.origin 
						+ webAppConfig.contextPath
						+ "detalle-servicio",
				controller : "detalleServiciosController as detailService"
			});
		}]);