///<script src="../../../assets/scripts/angular.js"></script>
///<script src="../../../assets/scripts/angular-route.js"></script>
var blog=angular.module('collaborationAppBlog',['controllerAppBlogService','ngRoute']);
blog.controller('blogController', ['BlogService','$http', function(BlogService,$http){
	var blg=this;
	blg.blogs=[];
	fetchAllBlog();
	function fetchAllBlog () {
		BlogService
		.fetchAllBlog()
	    .then(function(data){
	   		blg.blogs = data;
		 },function (errResponse) {
			console.error('Error while fetching the blogs');
		})
	}
}]);