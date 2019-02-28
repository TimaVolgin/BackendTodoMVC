package ru.hh.school.main;

import ru.hh.nab.starter.NabApplication;

public class Application {

  public static void main(String[] args) {
    NabApplication.builder()
      .configureJersey(ApplicationJerseyConfig.class).bindToRoot()
      .build().run(ApplicationConfig.class);
  }
}
