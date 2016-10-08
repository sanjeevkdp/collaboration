var profileService=angular.module('controllerProfileService',[]);
profileService.factory('UserService', ['$http','$q', function($http,$q){
     var REST_SERVICE_URI='http://localhost:8080/collaborationbackend/userDetails/';
     
     var factory={
     	fetchAllUser: fetchAllUser,
     	createUser:createUser,
        updateUser:updateUser,
        deleteUser:deleteUser
     };
	return factory;

	function fetchAllUser(){
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

	function createUser(userDetails) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, userDetails)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateUser(userDetails, userDetails_id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+userDetails_id, userDetails)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating userDetails');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteUser(userDetails_id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+userDetails_id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting userDetails');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);