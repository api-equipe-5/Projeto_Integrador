const express = require("express");
const router = express.Router();
const controller = require('../controllers/log');


router.get('/:hash_comunicado', controller.index);

module.exports = router;