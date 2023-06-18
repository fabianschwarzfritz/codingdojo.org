
const { Lexer } = require("./Lexer");

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

test("Parse variable declaration", () => {
    const input = `
        let a = 5;
    `;

    const lexer = new Lexer(inpujt);
    const token = lexer.nextToken();

    return false;
});


