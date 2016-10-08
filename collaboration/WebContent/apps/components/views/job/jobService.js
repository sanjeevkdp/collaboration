var jobService=angular.module('controllerJobService',[]);
jobService.factory('JobService', ['$http','$q', function($http,$q){
     var REST_SERVICE_URI='http://localhost:8080/collaborationbackend/jobOportunities/';
     
     var factory={
     	fetchAllJob: fetchAllJob,
     	createJob:createJob,
        updateJob:updateJob,
        deleteJob:deleteJob
     };
	return factory;

	function fetchAllJob(){
		var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Jobs');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
	}

	function createJob(jobOportunities) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, jobOportunities)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Job');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateJob(jobOportunities, jobOportunities_id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+jobOportunities_id, jobOportunities)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating jobOportunities');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteJob(jobOportunities_id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+jobOportunities_id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting jobOportunities');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);