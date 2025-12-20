package com.wwc.Service;
import com.wwc.WwcApplication;
import com.wwc.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventService {
    private List<Event>  events = new ArrayList<>();
    public List<Event> getAllEvents() {
        return events;
    }
    public Event getEventById(int id) {
        return events.stream().filter(e -> e.getId() == id).findFirst().orElse(null);

    }

    public Event addEvent(Event event) {
        events.add(event);
        return event;
    }

    public Event deleteEvent(Event event)
    {
        return event.removeIf(e -> e.getId()==id);
    }
}
