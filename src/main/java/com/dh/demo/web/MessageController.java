package com.dh.demo.web;

import com.dh.demo.common.Response;
import com.dh.demo.service.DestinationMessageService;
import com.dh.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Juan Zapata on 7/15/2017.
 */
@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    DestinationMessageService destinationMessageService;

    @Autowired(required = true)
    Response res;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Response getAll(){
        res.setSuccess(true);
        res.setResponseObject(destinationMessageService.getAll());
        return res;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public Response createMessage(
        @RequestBody MessageRequestDTO messageRequestDTO
    ){
        res.setSuccess(true);
        res.setResponseObject(messageService.createMessage( messageRequestDTO.getFrom(),
                                                            messageRequestDTO.getTo(),
                                                            messageRequestDTO.getMessage()));
        return res;

    }

    @RequestMapping(value = "/conversation/{from}/{to}", method = RequestMethod.GET, produces = "application/json")
    public Response getConversation(
            @PathVariable("from") String from,
            @PathVariable("to") String to
    ){
        res.setSuccess(true);
        res.setResponseObject(destinationMessageService.getByConversation(from,to));

        return res;
    }

    public static class MessageRequestDTO{
        private String from;
        private String to;
        private String message;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
