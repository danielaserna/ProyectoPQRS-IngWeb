var LOGIN_WEB_SERVICE = 'http://localhost:8080/ProyectoPQRS/rest/Client/login?';
var ALL_SOLICITUDES_WEB_SERVICE = 'http://localhost:8080/ProyectoPQRS/rest/Solicitude/getAll?';
var REGISTER_CLIENT_WEB_SERVICE = 'http://localhost:8080/ProyectoPQRS/rest/Client/insert?';
var ALL_SUCURSALS_WEB_SERVICE = 'http://localhost:8080/ProyectoPQRS/rest/Sucursal/all?';
var ALL_PRODUCTS_WEB_SERVICE = 'http://localhost:8080/ProyectoPQRS/rest/Product/allProducts?';
var ALL_SOLICITUDE_TYPES_WEB_SERVICE = 'http://localhost:8080/ProyectoPQRS/rest/Solicitude/getSolicitudeType?';
var DO_SOLICITUDE_WEB_SERVICE = 'http://localhost:8080/ProyectoPQRS/rest/Solicitude/insert?';
var SOLICITUDE_RESPONSE_WEB_SERVICE = 'http://localhost:8080/ProyectoPQRS/rest/Solicitude/solicituderesponse?';

// / *** MODULES *** / //

var pqrsModule = angular.module('proyectoPQRS', [ 'ngRoute', 'ngCookies',
		'ui.bootstrap' ]);

// / *** FACTORIES *** / //

pqrsModule.factory('authentication', function($cookies, $location) {

	return ({
		login : function(email, idNumber, profile, fullName, lastName) {
			$cookies.email = email;
			$cookies.idNumber = idNumber;
			$cookies.profile = profile;
			$cookies.fullName = fullName;
			$cookies.lastName = lastName;
			$cookies.flag = false;

			if ($cookies.profile == 'cliente') {
				$location.url('/pages/requisition');
			} else if ($cookies.profile == 'admin') {
				$location.url('/pages/requisitionevaluation');
			}
		},

		logout : function() {
			$cookies.email = undefined;
			$cookies.idNumber = undefined;
			$cookies.profile = undefined;
			$cookies.fullName = undefined;
			$cookies.lastName = undefined;
			$location.url('/');
		},

		checkState : function() {
			if ($cookies.flag) {

				return;
			}

			if (typeof ($cookies.idNumber) == 'undefined'
					|| angular.equals($cookies.idNumber, 'undefined')) {
				$location.url('/');

				return;
			}

			if ((typeof ($cookies.idNumber) != 'undefined' || !angular.equals(
					$cookies.idNumber, 'undefined'))
					&& ($location.url() == '/')) {
				if ($cookies.profile == 'cliente') {
					$location.url('/pages/requisition');
				} else if ($cookies.profile == 'admin') {
					$location.url('/pages/requisitionevaluation');
				}
			}
		}
	});
});

// / *** CONFIGURATIONS *** / //
pqrsModule.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : './pages/login.html',
		controller : 'loginController'
	});

	$routeProvider.when('/pages/requisition', {
		templateUrl : './pages/requisition.html',
		controller : 'requisitionController'
	});

	$routeProvider.when('/pages/requisitionevaluation', {
		templateUrl : './pages/requisitionevaluation.html',
		controller : 'requisitionEvaluationController'
	});

	$routeProvider.when('/pages/requisitionevaluationempty', {
		templateUrl : './pages/requisitionevaluationempty.html',
		controller : 'emptyController'
	});

	$routeProvider.when('/pages/registration', {
		templateUrl : './pages/registration.html',
		controller : 'registrationController'
	});

	$routeProvider.when('/pages/requisitionresponse', {
		templateUrl : './pages/requisitionresponse.html',
		controller : 'requisitionResponseController'
	});
} ]);

// / *** RUNNERS *** / //
pqrsModule.run(function($rootScope, authentication) {
	$rootScope.$on('$routeChangeStart', function() {
		authentication.checkState();
	});
});

// / *** SERVICES *** / //
pqrsModule.service('solicitudesWebService', function($http) {
	this.findAllSolicitudes = function() {

		return ($http({
			method : 'GET',
			url : ALL_SOLICITUDES_WEB_SERVICE
		}));
	};
});

pqrsModule.service('registerClientWebService', function($http) {
	this.registerClient = function(fullName, lastName, cellPhoneNumber, email,
			idNumber, phoneNumber) {
		return ($http({
			method : 'POST',
			url : REGISTER_CLIENT_WEB_SERVICE,
			params : {
				fullName : fullName,
				lastName : lastName,
				cellPhoneNumber : cellPhoneNumber,
				email : email,
				idNumber : idNumber,
				phoneNumber : phoneNumber,
				profile : "cliente"
			}
		}));
	};
});

pqrsModule.service('loginWebService', function($http) {
	this.login = function(userIdNumber, password) {

		return ($http({
			method : 'GET',
			url : LOGIN_WEB_SERVICE,
			params : {
				idNumber : userIdNumber
			}
		}));
	};
});

pqrsModule.service('sucursalWebService', function($http) {
	this.getAllSucursals = function() {

		return ($http({
			method : 'GET',
			url : ALL_SUCURSALS_WEB_SERVICE
		}));
	};
});

pqrsModule.service('productWebService', function($http) {
	this.getAllProducts = function() {

		return ($http({
			method : 'GET',
			url : ALL_PRODUCTS_WEB_SERVICE
		}));
	};
});

pqrsModule.service('solicitudeTypeWebService', function($http) {
	this.getAllSolicitudeTypes = function() {

		return ($http({
			method : 'GET',
			url : ALL_SOLICITUDE_TYPES_WEB_SERVICE
		}));
	};
});

pqrsModule.service('doSolicitudeWebService', function($http) {
	this.doSolicitude = function(description, solicitudeType, product,
			idSucursal, userIdNumber) {
		return ($http({
			method : 'POST',
			url : DO_SOLICITUDE_WEB_SERVICE,
			params : {
				description : description,
				solicitudeType : solicitudeType,
				idSucursal : idSucursal,
				idNumber : userIdNumber,
				idProduct : product
			}
		}));
	};

});

pqrsModule.service('solicitudeResponseWebService', function($http) {
	this.answerSolicitude = function(description, solicitudeId) {
		return ($http({
			method : 'DELETE',
			url : SOLICITUDE_RESPONSE_WEB_SERVICE,
			params : {
				idSolicitude : solicitudeId,
				response : description
			}
		}));
	};

});

pqrsModule.service('shared', function() {
	var solicitude = {};
	return {
		getSolicitude : function() {
			return solicitude;
		},
		setSolicitude : function(value) {
			solicitude = value;
		}
	};
});

// / *** CONTROLLERS *** / //
pqrsModule
		.controller(
				'loginController',
				function($scope, loginWebService, authentication, $location,
						$cookies) {

					$scope.login = function() {
						if ($scope.userIdNumber != $scope.password) {
							alert("Por favor ingrese los datos correctamente");

							return;
						}

						loginWebService
								.login($scope.userIdNumber, $scope.password)
								.success(
										function(data) {
											$scope.password = '';
											if (data != '') {
												$scope.userIdNumber = '';
												$cookies.flag = false;

												authentication.login(
														data.email,
														data.idNumber,
														data.profile.profile,
														data.fullName,
														data.lastName);
											} else {
												alert('El Nombre de Usuario o Contraseña no son válidos.');
											}
										});
					};

					$scope.registerClient = function() {
						$cookies.flag = true;
						$location.url("/pages/registration");
					};
				});

pqrsModule.controller('requisitionEvaluationController', function($scope,
		$cookies, solicitudesWebService, $location, authentication, shared) {
	solicitudesWebService.findAllSolicitudes().success(function(data) {
		selectedSolicitude = undefined;
		var flag = false;
		if (data == '') {
			flag = true;
		}

		$scope.solicitudes = data.solicitude;

		if (flag) {
			$cookies.flag = false;
			$location.url("/pages/requisitionevaluationempty");
		}
	});

	$scope.evaluateSolitude = function() {
		if (typeof ($scope.selectedSolicitude) == 'undefined'
				|| angular.equals($scope.selectedSolicitude, "undefined")) {
			alert("Por favor seleccione una solicitud");
			return;
		}

		shared.setSolicitude($scope.selectedSolicitude);
		$location.url("/pages/requisitionresponse");
	};

	$scope.logout = function() {
		$cookies.flag = false;
		authentication.logout();
	};
});

pqrsModule.controller('requisitionResponseController', function($scope,
		$cookies, $location, authentication, shared,
		solicitudeResponseWebService) {
	$scope.s = shared.getSolicitude();

	$scope.evaluate = function() {
		if (typeof ($scope.solicitudeResponse) == 'undefined'
				|| angular.equals($scope.solicitudeResponse, "undefined")) {
			alert("Por favor ingrese una respuesta");
		}

		solicitudeResponseWebService.answerSolicitude(
				$scope.solicitudeResponse, $scope.s.idSolicitude).success(
				function(data) {
					if (data == "OK" || angular.equals(data, "OK")) {

						alert("Respuesta realizada correctamente");
					} else {

						alert("Ha ocurrido un error. Inténtelo más tarde");
					}

					$location.url("/pages/requisitionevaluation");
				});
	};

	$scope.logout = function() {
		$cookies.flag = false;
		authentication.logout();
	};
});

pqrsModule
		.controller(
				"requisitionController",
				function($scope, $cookies, authentication,
						doSolicitudeWebService, sucursalWebService,
						productWebService, solicitudeTypeWebService, $location) {
					sucursalWebService
							.getAllSucursals()
							.success(
									function(data) {
										$scope.sucursals = data.sucursal;
										productWebService
												.getAllProducts()
												.success(
														function(data) {
															$scope.products = data.product;
															solicitudeTypeWebService
																	.getAllSolicitudeTypes()
																	.success(
																			function(
																					data) {
																				$scope.solicitudeTypes = data.solicitudeType;
																			});
														});
									});

					$scope.apply = function() {
						if (typeof ($scope.solicitudeDescription) == 'undefined'
								|| typeof ($scope.solicitudeType) == 'undefined'
								|| typeof ($scope.product) == 'undefined'
								|| typeof ($scope.sucursal) == 'undefined') {

							alert("Por favor ingrese todos los datos");
							return;
						}

						doSolicitudeWebService
								.doSolicitude($scope.solicitudeDescription,
										$scope.solicitudeType, $scope.product,
										$scope.sucursal, $cookies.idNumber)
								.success(
										function(data) {
											if (data == "OK"
													|| angular.equals(data,
															"OK")) {
												$scope.solicitudeDescription = "";

												alert("Solicitud guardada exitosamente");
											} else {
												alert("Se ha producido un error. Inténtelo más tarde.");
											}
										});
					};

					$scope.logout = function() {
						$cookies.flag = false;
						authentication.logout();
					};
				});

pqrsModule
		.controller(
				'registrationController',
				function($scope, registerClientWebService, $location, $cookies) {
					$scope.register = function() {
						if (typeof ($scope.idNumberUser) == 'undefined'
								|| angular.equals($scope.idNumberUser,
										'undefined')
								|| typeof ($scope.fullName) == 'undefined'
								|| angular.equals($scope.fullName, 'undefined')
								|| typeof ($scope.lastName) == 'undefined'
								|| angular.equals($scope.lastName, 'undefined')
								|| typeof ($scope.email) == 'undefined'
								|| angular.equals($scope.email, 'undefined')
								|| typeof ($scope.phoneNumber) == 'undefined'
								|| angular.equals($scope.phoneNumber,
										'undefined')) {

							alert("Por favor llene los campos.");

							return;
						}

						registerClientWebService
								.registerClient($scope.fullName,
										$scope.lastName,
										$scope.cellPhoneNumber, $scope.email,
										$scope.idNumberUser, $scope.phoneNumber)
								.success(
										function(data) {
											if (data == "OK"
													|| angular.equals(data,
															"OK")) {
												$scope.fullName = "";
												$scope.lastName = "";
												$scope.cellPhoneNumber = "";
												$scope.email = "";
												$scope.idNumberUser = "";
												$scope.phoneNumber = "";

												alert("Registro Satisfactorio");
											} else {

												alert("Por favor verifique sus datos o ya se encuentra registrado");
											}
										});
					};

					$scope.returnLogin = function() {
						$cookies.flag = true;
						$location.url("/");
					};
				});

pqrsModule.controller('emptyController', function($scope, $location, $cookies) {

	$scope.returnPQRSEvaluation = function() {
		$cookies.flag = true;
		$location.url("/pages/requisitionevaluation");
	};
});