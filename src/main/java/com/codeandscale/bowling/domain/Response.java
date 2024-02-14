package com.codeandscale.bowling.domain;

public class Response {

  private int score;
  private int lancer;
  private int frame;

  public Response(int score, int lancer, int frame) {
    this.score = score;
    this.lancer = lancer;
    this.frame = frame;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getLancer() {
    return lancer;
  }

  public void setLancer(int lancer) {
    this.lancer = lancer;
  }

  public int getFrame() {
    return frame;
  }

  public void setFrame(int frame) {
    this.frame = frame;
  }
}
