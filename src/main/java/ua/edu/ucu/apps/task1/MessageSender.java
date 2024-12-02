package ua.edu.ucu.apps.task1;

import java.time.Instant;

public class MessageSender {
  public void send(String text, User user, String country) {
    if (user.getCountry().equalsIgnoreCase(country)) {
      long currTime = Instant.now().toEpochMilli();
      long oneHourAgo = currTime - 3600 * 1000;

      if (user.getActiveTime() >= oneHourAgo) {
        System.out.println(text + " more than hour");
      } else {
        System.out.println(text + " meow");
      }
    }
  }
}
