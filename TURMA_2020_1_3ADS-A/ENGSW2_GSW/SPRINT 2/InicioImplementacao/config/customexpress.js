const express = require('express');
const consign = require('consign');
const bodyParser = require('body-parser');
const cors = require('cors');
const session = require('express-session');
const path = require('path');

module.exports = () => {
    const app = express();

    const corsOptions = {
        origin: 'http://localhost:4200',
        optionsSuccessStatus: 200
    };
    app.use(session({
        secret: 'secret',
        resave: true,
        saveUninitialized: true
    }));
    app.use(bodyParser.urlencoded({extended: true}));
    app.use(bodyParser.json());
    app.use(express.json());
    app.use(cors(corsOptions));

    consign()
        .include('controles')
        .into(app)

    return app
}
