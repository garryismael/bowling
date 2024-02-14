package com.codeandscale.bowling;

import com.codeandscale.bowling.domain.Constant;
import com.codeandscale.bowling.domain.Game;
import com.codeandscale.bowling.domain.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bowling")
public class Controller {

  private final Game game;

  public Controller(Game game) {
    this.game = game;
  }

  @GetMapping("/{pins}")
  public Response getMethodName(@PathVariable int pins) {
    return game.play(pins);
  }

  @GetMapping
  public Response getResponse() {
    return game.getResponse();
  }

  @PostMapping("/clear")
  public Response clean() {
    Constant.bowling.clearFrame();
    return game.getResponse();
  }
}
