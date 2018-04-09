package com.step.bootcamp;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class EventTest {
  @Test
  public void shouldCallTheListenerMethodFull() {
    Listener cityCouncil = mock(Listener.class);
    Event testEvent = new Event();
    testEvent.subscribe(cityCouncil);
    testEvent.broadcastFull();
    verify(cityCouncil, times(1)).full();
  }

  @Test
  public void shouldCallTheListenerMethodFullForBothListeners() {
    Listener cityCouncil = mock(Listener.class);
    Listener owner = mock(Listener.class);
    Event testEvent = new Event();
    testEvent.subscribe(cityCouncil);
    testEvent.subscribe(owner);
    testEvent.broadcastFull();
    verify(cityCouncil, times(1)).full();
    verify(owner, times(1)).full();
  }

  @Test
  public void shouldCallTheListenerMethodSpaceAvailable() {
    Listener cityCouncil = mock(Listener.class);
    Event testEvent = new Event();
    testEvent.subscribe(cityCouncil);
    testEvent.broadcastSpaceAvailable();
    verify(cityCouncil, times(1)).spaceAvailable();
  }

  @Test
  public void shouldCallTheListenerMethodSapceAvailableForBothListeners() {
    Listener cityCouncil = mock(Listener.class);
    Listener owner = mock(Listener.class);
    Event testEvent = new Event();
    testEvent.subscribe(cityCouncil);
    testEvent.subscribe(owner);
    testEvent.broadcastSpaceAvailable();
    verify(cityCouncil, times(1)).spaceAvailable();
    verify(owner, times(1)).spaceAvailable();
  }

  @Test
  public void shouldUnsubscribeListener() {
    Listener owner = mock(Listener.class);
    Event testEvent = new Event();
    testEvent.subscribe(owner);
    testEvent.unsubscribe(owner);
    testEvent.broadcastFull();
    verify(owner,never()).full();
  }
}
