
const express = require('express')
const cHero = require('../controller/hero.controller')
const router = express.Router()

router.get('/hero/sync', cHero.updateDB)

router.get('/hero/list', cHero.list)

module.exports = router