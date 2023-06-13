const chai = require("chai"); 
const expect = chai.expect;


class Game {

  points = [];

  roll(pins) {
    this.points.push(pins);
  }

  score() {
    let that = this;
    let sum = 0;

    for (let i = 0; i < this.points.length; i++) {

      function isSpare() {
        return that.points[i] + that.points[i+1] === 10;
      }

      function isStrike() {
        return that.points[i] === 10;
      }

      if (isSpare()) {
        // This roll plus next roll
        sum += 10;
        i += 2;
        sum += this.points[i];
      } else if (isStrike()) {
        // This roll plus next two rolls
        sum += 10;
        sum += this.points[i+1];
        sum += this.points[i+2];
        i += 2;
      } else {
        sum += this.points[i];
      }
    }

    return sum;
  }
}


describe("Bowling", function() {
  let game;

  function rollStrike() {
    game.roll(10);
  }

  function rollSpare() {
    game.roll(2);
    game.roll(8);
  }

  function roll(times, points) {
    for (let i = 0; i < times; i++) {
      game.roll(points);
    }
  }

  it("extra last frame spare", function() {
    game = new Game();
    // Roll 9 frames
    roll(18, 1);
    rollSpare();
    game.roll(7); // bonus
    expect(game.score()).equals(18 + 10 + 7);
  });


  it("extra last frame strike", function() {
    game = new Game();
    // Roll 9 frames
    roll(18, 1);
    rollStrike();
    game.roll(7); // bonus
    game.roll(1); // bonus
    expect(game.score()).equals(18 + 10 + 7 + 1);
  });

  it("strike", function() {
    game = new Game();
    // Frame 1
    rollStrike();
    game.roll(2); // Extra roll 1
    game.roll(7); // Extr roll 2
    // Frame 2
    game.roll(3);
    game.roll(0);
    expect(game.score()).equals(22);
  });

  it("spare", function() {
    game = new Game();
    // Frame 1
    rollSpare();
    game.roll(2); // Extra throw
    // Frame 2
    game.roll(2);
    game.roll(7);
    expect(game.score()).equals(21);
  });

  it("sums up basic rolls", function() {
    game = new Game();
    game.roll(2);
    game.roll(7);
    expect(game.score()).equals(9);
  });

});
