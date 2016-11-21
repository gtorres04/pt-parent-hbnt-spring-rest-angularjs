<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Menu de Opciones</title>

<script type="text/javascript">
	var webAppConfig = {
		contextPath: '<c:url value="/"/>',
		contextPathWs: '/pt-ws/'
	};
</script>
</head>
<body>
	<div ng-app="serviciosComponent" id="gestion-app" style="margin: 10%">
		<div class="gestion-servicios" ui-view></div>
	</div>
	<script src="<c:url value="/frameworks/angular.min.js" />"></script>
	<script src="<c:url value="/frameworks/angular-resource.min.js" />"></script>
	<script src="<c:url value="/frameworks/angular-route.min.js" />"></script>
	<script src="<c:url value="/frameworks/angular-ui-router.min.js" />"></script>
	<script src="<c:url value="/modulo-ng-servicios/component.js" />"></script>
	<script src="<c:url value="/modulo-ng-servicios/controller.js" />"></script>
	<script src="<c:url value="/modulo-ng-servicios/router.js" />"></script>
	<link href="<c:url value="/frameworks-css/bootstrap.min.css" />" rel="stylesheet">
</body>
</html>