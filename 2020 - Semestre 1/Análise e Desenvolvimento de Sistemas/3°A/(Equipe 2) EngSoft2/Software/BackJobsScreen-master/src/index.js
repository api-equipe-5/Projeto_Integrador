const express = require('express');
const bodyParser = require('body-parser');
const knex = require('knex')({
	  client: 'sqlite3',
	  connection: {
		      filename: "./dev.sqlite3"
		    }
});
const app = express();
app.use(bodyParser.urlencoded({ extended: true }));

app.use(express.json());

app.use((req, res, next) => {                                                                                              
   res.header('Access-Control-Allow-Origin', '*');                                                                          
   res.header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');                                    
	 res.header('Access-Control-Allow-Headers', 'X-Requested-With,content-type');   
   next();
 });


app.get('/', function (req, res) {
	  res.json({text:'Hello World!'});
});


app.route('/api/users')
	.get(function (req, res) {
	  knex('users').then(console.log)
	  knex('users').then(users => res.json({users}))
	})
	.post(function (req, res) {
	  console.log(req.body)
	  knex('users').insert(
		req.body.user
	  ).then( () => 
		res.json(users => res.json({users}))
	  )
	});

app.route('/api/jobs')
	.get(function (req, res) {
		knex('jobs').then(jobs => res.json({jobs}))
	})
	.post(function (req, res) {
		console.log(req.body)
		knex('jobs').insert(req.body.job)
		.then(() => 
		  res.json(jobs => res.json({jobs}))
		)
	})


app.route('/api/employee')
	.get(function (req, res) {
		knex('employee').then(employee => res.json({employee}))
	})
	.post(function (req, res) {
		console.log(req.body)
		knex('employee').insert(req.body.employee)
		.then(() => 
		  res.json(employee => res.json({employee}))
		)
	})

app.listen(5000, function () {
	  console.log('Example app listening on port 5000!');
});
