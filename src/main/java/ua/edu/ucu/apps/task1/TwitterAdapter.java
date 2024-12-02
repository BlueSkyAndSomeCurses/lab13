package ua.edu.ucu.apps.task1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TwitterAdapter implements User {
  private final TwitterUser twitterUser;

  @Override
  public long getActiveTime() {
    return twitterUser.getLastAriveAt();
  }

  @Override
  public String getEmail() {
    return twitterUser.getUserMail();
  }

  @Override
  public String getCountry() {
    return twitterUser.getCountryCode();
  }
}
