
const TokenType = {
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
    LSQIRLY: "{",
    RSQIRLY: "}",
};

class Token {
    constructor(type) {
        this.type = type;
    }
}

class Lexer {

    constructor(input) {
        this.position = 0;
        this.input = input.split("");
        this.char = "";
    }

    nextToken() {
        this.skipWhitespace();

        const token = this.getToken(this.char);

        if (token) {
            this.readChar();
            return token;
        }
    }

    getToken(char) {
        const lookup = new Map();
        lookup.set("=", new Token(TokenType.EQUAL));
        lookup.set("+", new Token(TokenType.PLUS));
        lookup.set(",", new Token(TokenType.COMMA));
        lookup.set(";", new Token(TokenType.SEMI));
        lookup.set("(", new Token(TokenType.LPAREN));
        lookup.set(")", new Token(TokenType.RPAREN));
        lookup.set("{", new Token(TokenType.LSQIRLY));
        lookup.set("}", new Token(TokenType.RSQIRLY));
        return lookup.get(char);
    }

    skipWhitespace() {
        const whitespaces = [" ", "\t", "\n", "\r", ""];
        let i = 0;
        while (whitespaces.includes(this.char)) {
            this.readChar();
            ++i;
        }
    }

    readChar() {
        this.char = this.peekChar();
        this.position++;
    }

    peekChar() {
        return  this.position < this.input.length ? this.input[this.position] : ""
    }
}

module.exports = {
    Lexer: Lexer,
    Token: Token,
    TokenType: TokenType
}
