const { Router } = require('express');
const router = new Router();
const passport = require('passport');
const { FRONTEND } = require('../config');

router.get('/google', passport.authenticate('google', {
    scope: ['profile']
}));

router.get('/google/redirect', passport.authenticate('google'), (req, res) => {
    res.redirect(`${FRONTEND.ADDRESS}/auth-redirect`);
});

module.exports = router;