/*package com.niit.backend.controller;

import java.util.Date;

import javax.mail.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.utility.OutputMessage;

@RestController
@RequestMapping("/")
public class ChatController {
    @Autowired
    OutputMessage outputMessage;
    @Autowired
    Message message;
  @MessageMapping("/chat")
  @SendTo("/topic/message")
  public OutputMessage sendMessage(com.niit.backend.utility.Message message) {
    return new OutputMessage(message, new Date());
  }
}*/