package org.depaul.logic.events;

public record MoveEvent(EventType eventType, EventSource eventSource) {

    public EventType getEventType() {
        return eventType;
    }

    public EventSource getEventSource() {
        return eventSource;
    }
}
