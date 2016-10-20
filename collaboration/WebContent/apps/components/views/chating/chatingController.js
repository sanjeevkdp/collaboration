var chat=angular.module('collaborationAppChat',['controllerChatService','ngRoute']);
chat.controller('chatController',[ 'ChatService',function(ChatService){
	var self=this;
self.messages = [];
  self.message = "";
  self.max = 140;

  self.addMessage = function() {
    ChatService.send(self.message);
    self.message = "";
  };

  ChatService.receive().then(null, null, function(message) {
    self.messages.push(message);
  });

}]);