const express = require("express");
const router = express.Router();
const controller = require('../controllers')

router.post('/', controller.login.validarLogin);

module.exports = router;