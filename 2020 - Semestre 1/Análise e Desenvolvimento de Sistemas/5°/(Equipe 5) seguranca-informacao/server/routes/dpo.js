const express = require("express");
const router = express.Router();
const controller = require('../controllers/')

router.get('/', controller.dpo.retornarTodosDPO);
router.get('/:cod_dpo', controller.dpo.index);
router.post('/', controller.dpo.criarDPO);
router.put('/:cod_dpo', controller.dpo.alterarDPO);
router.delete('/:cod_dpo', controller.dpo.deletarDPO);

module.exports = router;