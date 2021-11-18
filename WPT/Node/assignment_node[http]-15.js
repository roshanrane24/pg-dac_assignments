const fs = require("fs");
const http = require("http");
const { parse } = require("url");
const rect = require("./Q5/rectangle");

function errorHandle(req, res) {
    if (req.method == "GET" && req.url == "/") {
        let file = fs.readFileSync("./Q15/rectangle.html").toString();
        res.writeHead(200, { "Content-Type": "text/html" });
        res.write(file);
        res.end();
    } else if (req.method == "GET" && req.url.startsWith("/answer")) {
        let query = parse(req.url, true).query;

        let area = rect.calcArea(parseInt(query.length),
                                 parseInt(query.breadth));
        let perimeter = rect.calcPerimeter(parseInt(query.length),
                                           parseInt(query.breadth));

        let output = JSON.stringify({area: area, perimeter: perimeter})
                     
        res.writeHead(200, {
            "Content-Length": output.length,
            "Content-Type": "text/json"
        });
     
        res.end(output);
    } else if (req.method == "GET" && req.url.startsWith("/favicon")) {
        fs.createReadStream("./Q15/favicon.ico").pipe(res);
    } else {
        res.writeHead(404, { "Content-Type": "text/html"})
        res.end("<h1>404 </h1><hr><h4>Error: Not Found</h4>");
    }
}


let server = http.createServer(errorHandle);

server.on('connection', (socket) => {
    console.log(`Connection on ${socket.remoteAddress}:${socket.remotePort}`);
})

server.listen(8080, "localhost");
console.log("Listening on port 8080");