package ua.edu.ucu.apps.task2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthorizationAdapter {
  private final Авторизація auth;

  public boolean auth(DBAdabter db) {
    db.getUserData();
    return true;
  }


}
