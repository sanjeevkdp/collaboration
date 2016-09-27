var forum=angular.module('collaborationAppForumView',['controllerForumViewService','ngRoute']);
forum.controller('forumViewController', ['ForumViewService','$http','$routeParams',function(ForumViewService,$http,$routeParams){
	var self=this;
	self.forumView={forum_id:'',title:'',description:'',forumPost:[{
	forumPost_id:'',forumDescription:''}]};
	self.submitPost = submitPost;
	self.forumPost={forumPost_id:'',forumDescription:''};
	self.forumPosts=[];
	self.edit=edit;
	self.remove=remove;
	self.reset=reset;
	var forum_id=$routeParams.forum_id;
fetchSingleForum(forum_id);
function fetchSingleForum(forum_id){
	ForumViewService
	.fetchSingleForum(forum_id)
	.then(
		function(data){
			self.forumView=data;
		},
		function(errResponse){
			console.log('Error while fetching data from forum');
		});
}

fetchAllPost();
function fetchAllPost(){
	ForumViewService
	.fetchAllPost()
	.then(
		function(data){
		self.forumPosts=data;
	},
	function(errResponse){
		console.log('error while  fetch all post');
	});
}
 function createPost(forumView,forumPost){
	var forum_id=forumView.forum_id;
		ForumViewService
		.createPost(forumView,forumPost)
		.then(
			fetchSingleForum(forum_id),
			function(errResponse){
				console.error('Error while creating blog');
			}
			);
	}
	function deletePost(forumPost_id){
		ForumViewService
		.deletePost(forumPost_id)
		.then(
			fetchSingleForum(forum_id),
			function(errResponse){
				console.error('error while delete the blog_id',forumPost_id);
			}
			);

	}
	function submitPost(){
		if (self.forumPost.forumPost_id===''){
		console.log('forumView created with forumPost_id',self.forumView,self.forumPost);
			createPost(self.forumView,self.forumPost.forumDescription);
		
		}else{
			console.log('forumView updated with the forumPost_id',self.forumView.forumPost_id)
			updatePost(self.forumView, self.forumView.forumPost_id);
		}
		reset();
	}
	function edit(forumPost_id){
		console.log('id to be edited', blog_id);
		for(var i = 0; i < self.blogs.length; i++){
			if(self.blogs[i].blog_id === blog_id) {
				self.blog= angular.copy(self.blogs[i]);
				break;
			}
		}
	}
	function remove(forumPost_id){
		console.log('id to be deleted', forumPost_id);
        if(self.forumPost.forumPost_id === forumPost_id) {//clean form if the blog to be deleted is shown there.
        	reset();
        }
        deletePost(forumPost_id);
    }
	function reset(){
		self.forumPost={forumPost_id:'',forumDescription:''};
	}

}]);