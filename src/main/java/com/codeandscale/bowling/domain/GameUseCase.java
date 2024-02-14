package com.codeandscale.bowling.domain;

import org.springframework.stereotype.Component;

@Component
public class GameUseCase implements Game {

  @Override
  public Response play(int pins) {
    Constant.bowling.knockDown(pins);

    return new Response(
      Constant.bowling.getScore(),
      Constant.bowling.getNumberOfLancer(),
      Constant.bowling.getNumberOfFrame()
    );
  }

  @Override
  public Response getResponse() {
    return new Response(
      Constant.bowling.getScore(),
      Constant.bowling.getNumberOfLancer(),
      Constant.bowling.getNumberOfFrame()
    );
  }
}
