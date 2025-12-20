package com.wwc.Controller;

import com.wwc.model.Event;
import com.wwc.Service.EventService;
import com.wwc.Controller.EventController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/events")



public class EventController {

    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents()
    {
        return ResponseEntity.ok(eventService.getAllEvents());
    }


}
