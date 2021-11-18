const fs = require("fs");
var http = require("http");

function errorHandle(req, res) {
    let file = fs.readFileSync("./Q13/welcome.html").toString();

    res.writeHead(200, {
        "Content-Length": file.length,
        "Content-Type": "text/html"
    });
    res.end(file);
}

let server = http.createServer(errorHandle);
server.listen(8080, "localhost");