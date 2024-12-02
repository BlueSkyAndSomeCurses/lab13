package ua.edu.ucu.apps.task1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FacebookAdapter implements User {
  private final FacebookUser facebookUser;

  @Override
  public long getActiveTime() {
    return facebookUser.getUserActiveTime();
  }

  @Override
  public String getEmail() {
    return facebookUser.getEmail();
  }

  @Override
  public String getCountry() {
    return facebookUser.getUserCountry();
  }
}
