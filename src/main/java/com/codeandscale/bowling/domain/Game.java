package com.codeandscale.bowling.domain;

public interface Game {
  Response play(int pins);
  Response getResponse();
}
