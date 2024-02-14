package com.codeandscale.bowling.domain.algo;

import java.util.ArrayList;
import java.util.List;

public class Bowling {

  public static final int MAX_PINS = 15;
  public static final int MAX_FRAME_PER_PLAYER = 5;
  public static final int LANCERS_PER_FRAME = 3;
  private List<Frame> frames;
  private int numberOfFrame;
  private int numberOfLancer;
  private int score;

  public Bowling() {
    frames = new ArrayList<>();
    numberOfFrame = 1;
    numberOfLancer = 1;
    score = 0;
  }

  public void knockDown(int pins) {
    if (pins < 0 || pins > MAX_PINS) {
      throw new IllegalArgumentException("Invalid pins Value.");
    }

    if (isDone()) {
      clearFrame();
    }

    if (frames.size() == 0) {
      frames.add(new Frame());
    }
    Frame frame = frames.getLast();

    if (
      (frame.isStrike() && frame.getNextPins().size() < LANCERS_PER_FRAME) ||
      (frame.isSpare() && frame.getNextPins().size() < LANCERS_PER_FRAME - 1)
    ) {
      frame.addNextPin(pins);
      if (frame.getNextPins().size() < LANCERS_PER_FRAME) {
        numberOfLancer += 1;
      }

      if (pins == MAX_PINS) {
        if (numberOfFrame < MAX_FRAME_PER_PLAYER) {
          numberOfFrame += 1;
        }
        numberOfLancer = 1;
      } else if (frame.getSumNextPins() == MAX_PINS) {
        numberOfFrame += 1;
        numberOfLancer = 1;
      }
      if (
        (frame.isStrike() && frame.getNextPins().size() == LANCERS_PER_FRAME) ||
        (frame.isSpare() && frame.getNextPins().size() == LANCERS_PER_FRAME - 1)
      ) {
        score += MAX_PINS + frame.getSumNextPins();
        if (frames.size() < MAX_FRAME_PER_PLAYER) {
          Frame newFrame = new Frame();
          List<Integer> nextPins = frame.getNextPins();
          int nextPinsSize = frame.getNextPins().size();
          int sumOfNextPins = frame.getSumNextPins();
          if (frame.getNextPins().getFirst() == MAX_PINS) {
            newFrame.setStrike(true);
            newFrame.setNextPins(frame.getNextPins().subList(1, nextPinsSize));
          } else if (sumOfNextPins == MAX_PINS) {
            newFrame.setSpare(true);
            newFrame.setPins(frame.getNextPins().subList(0, nextPinsSize - 1));
          } else if (sumOfNextPins > MAX_PINS) {
            int indexOfSpare = getIndexOfSpare(nextPins);
            List<Integer> newPins = nextPins.subList(0, indexOfSpare);
            List<Integer> newNextPins = nextPins.subList(
              indexOfSpare + 1,
              LANCERS_PER_FRAME
            );
            newFrame.setSpare(true);
            newFrame.setPins(newPins);
            newFrame.setNextPins(newNextPins);
          } else {
            newFrame.setPins(nextPins);
          }
          frames.add(newFrame);
          if (newFrame.getPins().size() == LANCERS_PER_FRAME) {
            score += sumOfNextPins;
            if (frames.size() < MAX_FRAME_PER_PLAYER) {
              frames.add(new Frame());
              numberOfFrame += 1;
              numberOfLancer = 1;
            }
          }
        }
      }
    } else {
      int sumPins = frame.getSumPins() + pins;
      if (pins == MAX_PINS && frame.getPins().size() == 0) {
        frame.setStrike(true);
        numberOfLancer = 1;
        if (numberOfFrame < MAX_FRAME_PER_PLAYER) {
          numberOfFrame += 1;
        }
      } else if (sumPins == MAX_PINS) {
        frame.setSpare(true);
        numberOfLancer = 1;
        if (numberOfFrame < MAX_FRAME_PER_PLAYER) {
          numberOfFrame += 1;
        }
      } else if (pins < MAX_PINS) {
        frame.addPin(pins);
        numberOfLancer += 1;
        if (frame.getPins().size() == LANCERS_PER_FRAME) {
          score += frame.getSumPins();
          if (frames.size() < MAX_FRAME_PER_PLAYER) {
            frames.add(new Frame());
          }
          numberOfFrame += 1;
          numberOfLancer = 1;
        }
      }
    }
  }

  public int getScore() {
    return score;
  }

  private int getIndexOfSpare(List<Integer> nextPins) {
    int sum = nextPins.getFirst();
    int i = 1;
    while (sum < MAX_PINS) {
      sum += nextPins.get(i);
      if (sum < MAX_PINS) {
        i++;
      }
    }
    return i;
  }

  public List<Frame> getFrames() {
    return frames;
  }

  public void clearFrame() {
    this.frames.clear();
  }

  public boolean isDone() {
    if (frames.size() == MAX_FRAME_PER_PLAYER) {
      Frame lastFrame = frames.getLast();
      if (
        !lastFrame.isStrike() &&
        !lastFrame.isSpare() &&
        lastFrame.getPins().size() == LANCERS_PER_FRAME
      ) {
        return true;
      }

      if (
        lastFrame.isStrike() &&
        lastFrame.getNextPins().size() == LANCERS_PER_FRAME
      ) {
        return true;
      }

      if (
        lastFrame.isSpare() &&
        lastFrame.getNextPins().size() == LANCERS_PER_FRAME - 2
      ) {
        return true;
      }
    }
    return false;
  }

  public int getNumberOfFrame() {
    return numberOfFrame;
  }

  public int getNumberOfLancer() {
    return numberOfLancer;
  }
}
