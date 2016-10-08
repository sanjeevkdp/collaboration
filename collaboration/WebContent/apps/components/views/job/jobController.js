var job=angular.module('collaborationAppJob',['controllerJobService','ngRoute']);
job.controller('jobController',[ '$scope','JobService','$http',function($scope,JobService,$http){
	var self=this;
	self.jobOportunities={jobOportunities_id:'',title:'',description:''}
	self.jobOportunitiess=[];

	self.submit = submit;
	self.edit=edit;
	self.remove=remove;
	self.reset=reset;


	fetchAllJob();
	function fetchAllJob(){
		JobService
		.fetchAllJob()
		.then(function(data){
			self.jobOportunitiess=data;
		},function (errResponse) {
			console.error('Error while fetching the jobOportunitiess');
		}
		);
	}

	function createJob(jobOportunities){
		JobService
		.createJob(jobOportunities)
		.then(
			fetchAllJob
			,
			function(errResponse){
				console.error('Error while creating jobOportunities');
				if(errResponse.status==409){
					alert("already exit with email name",self.jobOportunities);
				}
				else{
					alert("Please try another time.....");
				}
			}
			);
	}

	function updateJob(jobOportunities, jobOportunities_id){
		JobService
		.updateJob(jobOportunities, jobOportunities_id)
		.then(
			fetchAllJob,
			function(errResponse){
				console.error('Error while updating Job');
			}
			);
	}

	function deleteJob(jobOportunities_id){
		JobService
		.deleteJob(jobOportunities_id)
		.then(
			fetchAllJob,
			function(errResponse){
				console.error('Error while deleting Job');
			}
			);
	}
	function submit() {
		if(self.jobOportunities.jobOportunities_id===''){
			console.log('Saving New jobOportunities', self.jobOportunities);
			createJob(self.jobOportunities);
		}else{
			console.log('Job updated with jobOportunities_id ', self.jobOportunities.jobOportunities_id);
			updateJob(self.jobOportunities, self.jobOportunities.jobOportunities_id);
		}

		reset();
	}
	function edit(jobOportunities_id){
		console.log('id to be edited', jobOportunities_id);
		for(var i = 0; i < self.jobOportunitiess.length; i++){
			if(self.jobOportunitiess[i].jobOportunities_id === jobOportunities_id) {
				self.jobOportunities= angular.copy(self.jobOportunitiess[i]);
				break;
			}
		}
	}
	function remove(jobOportunities_id){
		console.log('id to be deleted', jobOportunities_id);
        if(self.jobOportunities.jobOportunities_id === jobOportunities_id) {//clean form if the jobOportunities to be deleted is shown there.
        	reset();
        }
        deleteJob(jobOportunities_id);
    }
    function reset(){
    	self.jobOportunities={jobOportunities_id:'',title:'',description:''};
       // $scope.myForm.$setPristine(); //reset Form
    }
    
}]);
