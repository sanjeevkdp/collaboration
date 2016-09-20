///<script src="../../../assets/scripts/angular.js"></script>
///<script src="../../../assets/scripts/angular-route.js"></script>
var blogService=angular.module('controllerAppBlogService',[]);
blogService.factory('BlogService', ['$http','$q', function($http,$q){
	var REST_SERVICE_URI ='http://localhost:8080/collaborationbackend/blogs/';
	var factory = {
		fetchAllBlog: fetchAllBlog
	};

	return factory;
	 function fetchAllBlog() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
	
}]);