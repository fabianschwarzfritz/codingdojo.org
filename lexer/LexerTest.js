
const { Lexer, Token, TokenType } = require("./Lexer");

let testIndex = 1;

function test(desc, fn) {
    console.log(desc)
    result = false;
    try {
        result = fn();
    } catch (err) {
        console.log("Error running test", desc, ". Failed with", err);
        result = false;
    }

    if (result === true) {
        console.log(`ok ${testIndex++} - ${desc}`);
    } else {
        console.log(`not ok ${testIndex++} - ${desc}`);
    }
}

function assertTokenTypeEquals(expected, actual) {
    if (!expected) {
        throw new Error("Expected token type cannot be null");
    }
    if (!actual) {
        throw new Error("Actual token type cannot be null");
    }
    if (expected.type !== actual.type) {
        const msg = `Expected token type ${expected.type} to equal ${actual.type}`;
        throw new Error(msg);
    }
}

test("Parse variable declaration", () => {
    const input = `
        {};
    `;

    const lexer = new Lexer(input);
    assertTokenTypeEquals(new Token(TokenType.LSQIRLY), lexer.nextToken());
    assertTokenTypeEquals(new Token(TokenType.RSQIRLY), lexer.nextToken());
    assertTokenTypeEquals(new Token(TokenType.SEMI), lexer.nextToken());

    return true;
});


