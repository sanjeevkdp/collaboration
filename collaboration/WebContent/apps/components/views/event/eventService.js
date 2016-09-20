var eventService=angular.module('controllerEventservice',[]);
eventService.factory('EventService', ['$http','$q', function($http,$q){
     var REST_SERVICE_URI='http://localhost:8080/collaborationbackend/events/';
     var factory={

     	fetchAllEvent: fetchAllEvent
     }
	return factory;

	function fetchAllEvent(){
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