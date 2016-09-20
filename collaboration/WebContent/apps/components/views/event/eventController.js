var event=angular.module('collaborationAppEvent',['controllerEventservice','ngRoute']);
event.controller('eventController',[ 'EventService','$http',function(EventService,$http){
	var evt=this;
	evt.events=[];
	fetchAllEvent();
	function fetchAllEvent(){
		EventService
		.fetchAllEvent()
		.then(function(data){
			evt.events=data;
		},function (errResponse) {
			console.error('Error while fetching the blogs');
		})
	}
}]);