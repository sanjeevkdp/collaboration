///<script src="../../../assets/scripts/angular.js"></script
///<script src="../../../assets/scripts/angular-route.js"></script> 


app.config(['$routeProvider',function($routeProvider) {
	$routeProvider
	.when('/login',{

		templateUrl:"apps/components/views/login/login.html",
		controller:"LoginController",
		controllerAs:"vm"
		
			})
	.when('/signUp',{

		templateUrl:"apps/components/views/login/signUp.html",
		controller:"userController",
		controllerAs:"userCtrl"
		
			})
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
	.when('/slogin/',{

		templateUrl:"apps/components/views/login.html",
		controller:"loginController",
		controllerAs:"loginCtrl"
			})
	.when('/forum/',{

		templateUrl:"apps/components/views/forum/forum.html",
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
	.when('/forums/forumView/:forum_id',{

		templateUrl:"apps/components/views/forum/forumView.html",
		controller:"forumViewController",
		controllerAs:"forumViewCtrl"
		
			})
	.when('/blogs/blogView/:blog_id',{

		templateUrl:"apps/components/views/blog/blogSingleView.html",
		controller:"blogViewController",
		controllerAs:"blogViewCtrl"
		
			})
	.when('/landing/',{

		templateUrl:"home.html",
		controller:"landingController",
		controllerAs:"landingCtrl"
		
			})
	.when('/profile/',{

		templateUrl:"apps/components/views/profile/profile.html",
		controller:"profileController",
		controllerAs:"profileCtrl"
		
			})
	.when('/job/',{

		templateUrl:"apps/components/views/job/job.html",
		controller:"jobController",
		controllerAs:"jobCtrl"
		
			})
	.when('/chat/',{

		templateUrl:"apps/components/views/chating/chating.html",
		controller:"chatController",
		controllerAs:"chatCtrl"
		
			})
}]);
app.run(['$rootScope', '$location', '$cookieStore', '$http', function($rootScope, $location, $cookieStore, $http){
	$rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login','/signUp']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
}]);