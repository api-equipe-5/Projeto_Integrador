const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');
const accountRouter = require('./api/account');
const deviceRouter = require('./api/device');
const authRouter = require('./api/auth');
const measurementRouter = require('./api/measurement');
const passportSetup = require('../bin/oauth/passport-setup');
const passport = require('passport');
const cookieSession = require('cookie-session');
const keys = require('../secrets/keys');
const { FRONTEND } = require('../app/config');

const app = express();

app.use(cors({ origin: FRONTEND.ADDRESS, credentials: true }));
app.use(bodyParser.json());
app.use(cookieParser());
app.use(cookieSession({
  maxAge: 24 * 60 * 60 * 1000,
  keys: [keys.session.cookieKey]
}));
app.use(passport.initialize());
app.use(passport.session());

app.use('/account', accountRouter);
app.use('/device', deviceRouter);
app.use('/auth', authRouter);

app.use((err, req, res, next) => {
  const statusCode = err.statusCode || 500;

  res.status(statusCode).json({
    type: 'error', message: err.message
  })
});

module.exports = app;