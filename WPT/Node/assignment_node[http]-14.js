const greet = require("./Q1/greet");
var http = require("http");

function errorHandle(req, res) {
    let msg = greet.greet();

    res.writeHead(200, {
        "Content-Length": msg.length,
        "Content-Type": "text/plain"
    });
    res.write(msg)
    res.end();
}

let server = http.createServer(errorHandle);
server.listen(8080, "localhost");