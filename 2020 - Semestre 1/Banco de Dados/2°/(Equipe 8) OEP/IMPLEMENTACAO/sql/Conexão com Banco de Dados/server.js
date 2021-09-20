var express = require('express');
var bodyParser = require('body-parser');
var path = require('path');

var port = 1337;
var app = express();

app.use(express.static(path.join(__dirname, "public")));
app.use(bodyParser.urlencoded({ extended: true }));

app.listen(port, function(){
    console.log("Server is running on port "+port+"...");
});

var Promise = require('bluebird');
require("date-format-lite");

var mysql = require('promise-mysql');
var db = mysql.createPool({
  host: 'localhost',
  user: 'root',
  password: '',
  database: 'gantt'
});

app.get("/data", function (req, res) {
  Promise.all([
    db.query("SELECT * FROM gantt_tasks"),
    db.query("SELECT * FROM gantt_links")
  ]).then(function(results){
    var tasks = results[0],
    links = results[1];

    for (var i = 0; i < tasks.length; i++) {
      tasks[i].start_date = tasks[i].start_date.format("YYYY-MM-DD hh:mm:ss");
      tasks[i].open = true;
    }

    res.send({
      data: tasks,
      collections: { links: links }
    });

  }).catch(function(error) {
    sendResponse(res, "error", null, error);
  });
});
