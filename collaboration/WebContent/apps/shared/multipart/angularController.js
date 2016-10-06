$scope.submitUser = function(isValid) {

var file = $scope.myFile;
/* console.log('file is ' );
console.dir(file);*/
var uploadUrl = "user/saveUserDataAndFile";
var fd = new FormData();
fd.append('file', file);
fd.append('user',angular.toJson($scope.user,true));






console.log('Socpe of user'+$scope.user);




$http.post(uploadUrl, fd, {
transformRequest : angular.identity,
headers : {
'Content-Type' : undefined
}
}



).success(function() {
console.log('success');
}).error(function() {
console.log('error');
});
}