///<script src="../../../assets/scripts/angular.js"></script
///<script src="../../../assets/scripts/angular-route.js"></script> 


app.config(['$routeProvider',function($routeProvider) {
	$routeProvider
	.when('/',{

		templateUrl:"apps/components/views/homeView.html",
		controller:"homeController",
		controllerAs:"homeCtrl"
		
			})
	.when('/home/',{

		templateUrl:"apps/components/views/homeView.html",
		controller:"homeController",
		controllerAs:"homeCtrl"
		
			})
	.when('/login/',{

		templateUrl:"apps/components/views/login.html",
		controller:"loginController",
		controllerAs:"loginCtrl"
			})
	.when('/forum/',{

		templateUrl:"apps/components/views/forum.html",
		controller:"forumController",
		controllerAs:"forumCtrl"
			})
	.when('/blog/',{

		templateUrl:"apps/components/views/blog/blogView.html",
		controller:"blogController",
		controllerAs:"blogCtrl"
			})
	.when('/event/',{

		templateUrl:"apps/components/views/event/event.html",
		controller:"eventController",
		controllerAs:"eventCtrl"
		
			})
}]);