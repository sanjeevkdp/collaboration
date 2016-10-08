var Login=angular.module('collaborationAppLogin',['controllerLoginService','controllerFlashService','ngRoute']);
Login.controller('LoginController',[ '$location', 'AuthenticationService', 'FlashService',function($location, AuthenticationService, FlashService){
    
        var vm = this;

        

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

      vm.login=  function(){
            debugger;
            vm.dataLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function(response) {
                if (response.status==200) {
                     debugger;
                    console.log("gfasdhjkl;slds;srdagldksf");
                    AuthenticationService.SetCredentials(vm.username, vm.password);
                    $location.path('/');
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };
    
}]);