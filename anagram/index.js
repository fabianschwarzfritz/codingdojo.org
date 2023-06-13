const chai = require("chai"); 
const expect = chai.expect;


class Anagram {
  collection = [];

  generate(input) {
    this.collection = [];
    this.anagram(input, 0, input.length - 1);
    return this.collection;
  }

  anagram(str, start, end) {
    if (start == end) {
      // console.log("pushing, ", str);
      this.collection.push(str);
    } else {
      for (let i = start; i <= end; i++) {
        str = this.swap(str, start, i);
        this.anagram(str, start + 1, end);
        str = this.swap(str, start, i);
      }
    }
  }

  swap(input, from, to) {
    const arr = input.split("");
    const tmp = arr[from];
    arr[from] = arr[to];
    arr[to] = tmp;
    return arr.join("");
  }
}

describe("Anagram", function() {

  const input = [
    { in: "", out: [] },
    { in: "a", out: ["a"] },
    { in: "ab", out: ["ab", "ba"] },
    { in: "abc", out: [
      "bac",
      "bca",
      "cba",
      "cab",
      "acb",
      "abc"
    ]},
    { in: "abcd", out: [
      "abcd",
      "abdc",
      "acbd",
      "acdb",
      "adcb",
      "adbc",
      "bacd",
      "badc",
      "bcad",
      "bcda",
      "bdca",
      "bdac",
      "cbad",
      "cbda",
      "cabd",
      "cadb",
      "cdab",
      "cdba",
      "dbca",
      "dbac",
      "dcba",
      "dcab",
      "dacb",
      "dabc"
    ]},
  ];

  for (const i of input) {
    it(`generates all anagrams for ${i.in}`, function() {
      const ana = new Anagram();
      actual = ana.generate(i.in);
      expect(actual.length).equals(i.out.length, "length of " + actual + " should be " + i.out.length);
      expect(actual).to.include.members(i.out);
      expect(i.out).to.include.members(actual);
    });
  }
});
