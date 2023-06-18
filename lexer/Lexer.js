
const Tokens = {
    ILLEGAL: "ILLEGAL",
    EOF: "EOF",
    IDENT: "IDENT",
    INT: "INT",
    FUNCTION: "FUNCTION",
    LET: "LET",
    EQUAL: "=",
    PLUS: "+",
    COMMA: ",",
    SEMI: ";",
    LPAREN: "(",
    RPAREN: ")",
    LBRACE: "{",
    RBRACE: "}",
};

class Lexer {

    constructor(input) {
        this.position = 0;
        this.input = input.split("");
        this.char = "";
    }

    nextToken() {
        this.skipWhitespace();

        
    }

    skipWhitespace() {
        const whitespaces = [" ", "\t", "\n", "\r"];
        while (whitespaces.includes(this.char)) {
            this.readChar();
        }
    }

    readChar() {
        this.position++;
        if (this.position < this.input.length) {
            this.char = this.position[this.input];
        } else {
            this.char = "";
        }
    }
}

module.exports = {
    Lexer: Lexer
}
