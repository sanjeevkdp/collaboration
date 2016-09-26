/*var forum=angular.module('collaborationAppForum',[]);
forum.controller('forumController', function(){
	var fm=this;
	fm.toggle=false;
	var forum=[

      {name:"firstForum",title:"Hello this is first forum" ,
      forumPost:
			      [
			      {
			      	forumpst:"hi hello everone"
			      }
			      ]
			  },
     {name:"secondForum",title:"Hello this is first forum" ,
      forumPost:
			      [{
			      	forumpst:"hi hello everone"
			      }]},
			      {name:"thirdForum",title:"Hello this is first forum" ,
      forumPost:
			      [{forumpst:"hi hello everone"},{forumpst:"hi hello everone"}]
			  },
			      {name:"fourthForum",title:"Hello this is first forum" ,
      forumPost:
			      [{
			      	forumpst:"hi hello everone"
			      }]}

	];
	fm.forum=forum;
	
});*/
var forum=angular.module('collaborationAppForum',['controllerForumService','ngRoute']);
forum.controller('forumController', ['ForumService','$http',function(forumService,$http){
	var self=this;
	self.forum={};
	self.forums=[];

	/*self.submit = submit;
	self.edit=edit;
	self.remove=remove;
	self.reset=reset;*/
fetchAllForum();
function fetchAllForum(){
	forumService
	.fetchAllForum()
	.then(
		function(data){
			self.forums=data;
		},
		function(errResponse){
			console.log('Error while fetching data from forum');
		});
}

}]);