package ua.edu.ucu.apps.task2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DBAdabter {
  public final БазаДаних db;


  public String getUserData() {
    return db.отриматиДаніКористувача();
  }

  public String getStaticData() {
    return db.отриматиСтатистичніДані();
  }
}
