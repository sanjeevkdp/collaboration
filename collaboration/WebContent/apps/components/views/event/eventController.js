var event=angular.module('collaborationAppEvent',['controllerEventservice','ngRoute']);
event.controller('eventController',[ 'EventService','$http',function(EventService,$http){
	var self=this;
	self.event={eventName:'',description:''};
	self.events=[];

	self.submit = submit;
    

	fetchAllEvent();
	function fetchAllEvent(){
		EventService
		.fetchAllEvent()
		.then(function(data){
			self.events=data;
		},function (errResponse) {
			console.error('Error while fetching the events');
		}
		);
	}
 
      function createEvent(event){
        EventService
        .createEvent(event)
            .then(
            fetchAllEvent,
            function(errResponse){
                console.error('Error while creating event');
            }
        );
    }
 
    function updateEvent(event, event_id){
        EventService
        .updateEvent(event, event_id)
            .then(
            fetchAllEvent,
            function(errResponse){
                console.error('Error while updating Event');
            }
        );
    }
 
    function deleteUser(event_id){
        EventService
        .deleteEvent(event_id)
            .then(
            fetchAllEvent,
            function(errResponse){
                console.error('Error while deleting Event');
            }
        );
    }
 function submit() {
            console.log('Saving New event', self.event);
            createEvent(self.event);
       /* reset();*/
    }
 

    
}]);
