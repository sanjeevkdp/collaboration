///<script src="../../../assets/scripts/angular.js"></script
///<script src="../../../assets/scripts/angular-route.js"></script> 


app.config(['$routeProvider',function($routeProvider) {
	$routeProvider
	.when('/home/',{

		templateUrl:"apps/components/views/homeView.html",
		controller:"homeController",
		
			})
}]);