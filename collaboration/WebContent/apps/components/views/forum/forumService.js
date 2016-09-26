var forumService=angular.module('controllerForumService',[]);
forumService.factory('ForumService', ['$http','$q', function($http,$q){
	var REST_SERVICE_URI='http://localhost:8080/collaborationbackend/forums/';

	var factory={
		fetchAllForum: fetchAllForum
		/*,
		createForum:createForum,
		updateForum:updateForum,
		deleteForum:deleteForum*/
	};
	return factory;

	function fetchAllForum(){
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI)
		.then(
			function (response) {
				deferred.resolve(response.data);
			},
			function(errResponse){
				console.error('Error while fetching Events');
				deferred.reject(errResponse);
			}
			);
		return deferred.promise;
	}




}]);
