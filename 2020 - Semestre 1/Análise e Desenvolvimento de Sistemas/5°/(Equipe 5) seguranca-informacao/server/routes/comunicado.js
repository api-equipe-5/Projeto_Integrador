const express = require("express");
const router = express.Router();
const controller = require('../controllers/')

router.get('/:cod_comunicado', controller.comunicado.index);
router.get('/', controller.comunicado.retornarTodosComunicados);
router.post('/', controller.comunicado.criarComunicado);

module.exports = router;