package com.codeandscale.bowling.domain.algo;

import java.util.ArrayList;
import java.util.List;

public class Frame {

  private List<Integer> pins;
  private List<Integer> nextPins;
  private boolean strike = false;
  private boolean spare = false;

  public Frame() {
    pins = new ArrayList<>();
    nextPins = new ArrayList<>();
    spare = false;
    strike = false;
  }

  public List<Integer> getPins() {
    return pins;
  }

  public void setPins(List<Integer> pins) {
    this.pins = pins;
  }

  public void addPin(Integer pin) {
    this.pins.add(pin);
  }

  public int getSumPins() {
    return this.pins.stream().mapToInt(pin -> pin).sum();
  }

  public List<Integer> getNextPins() {
    return nextPins;
  }

  public int getSumNextPins() {
    return this.nextPins.stream().mapToInt(nextPin -> nextPin).sum();
  }

  public void setNextPins(List<Integer> nextPins) {
    this.nextPins = nextPins;
  }

  public void addNextPin(Integer pin) {
    this.nextPins.add(pin);
  }

  public boolean isStrike() {
    return strike;
  }

  public void setStrike(boolean strike) {
    this.strike = strike;
  }

  public boolean isSpare() {
    return spare;
  }

  public void setSpare(boolean spare) {
    this.spare = spare;
  }
}
