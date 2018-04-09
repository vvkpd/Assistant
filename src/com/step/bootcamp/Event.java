package com.step.bootcamp;

import java.util.ArrayList;

public class Event {
  private final ArrayList<Listener> listeners;

  public Event() {
    listeners = new ArrayList<>();
  }

  public void broadcastSpaceAvailable() {
    for (Listener listener : listeners) {
      listener.spaceAvailable();
    }
  }

  public void subscribe(Listener listener) {
    listeners.add(listener);
  }

  public void broadcastFull() {
    for (Listener listener : listeners) {
      listener.full();
    }
  }

  public void unsubscribe(Listener listener) {
    listeners.remove(listener);
  }
}
