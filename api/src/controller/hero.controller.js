const axios = require('axios')
const URI = require('../config/uri.api')
const Hero = require('../model/Hero.model')
const Config = require('../model/Config.model')

exports.updateDB = async (req, res) => {
    const _updateHeros = updateHero()
    let msg = "Actualizacion de BD correcta"
    if (_updateHeros == 1) { } else {
        msg = "La BD ya esta actualizada a la fecha"
    }
    res.json({ "status": 200, "msg": msg })
}

const updateHero = async function () {
    let res = 0;
    const configUpd = await Config.findOne({ syscode: 'UPD-HR' })

    if (configUpd == null) {
        const { data } = await axios.get(URI.base + URI.sync)
        data.forEach(function (hero) {
            let { hero_id, localized_name, name, primary_attr, attack_type, img, base_str, base_agi, base_int, move_speed, base_health, base_mana, base_armor, roles } = hero
            new Hero({
                heroId: hero_id,
                nameGame: name,
                namePublic: localized_name,
                attrPrimary: primary_attr,
                attackType: attack_type,
                image: URI.base + img,
                baseStr: base_str,
                baseAgi: base_agi,
                baseInt: base_int,
                moveSpeed: move_speed,
                baseHealth: base_health,
                baseMana: base_mana,
                baseArmor: base_armor,
                roles: roles
            }).save()
        })
        new Config({
            sysCode: "UPD-HR", status: 1
        }).save()

        res = 1
    }
    return res
}

exports.list = async (req, res) => {
    const data = await Hero
        .find({}, { heroId: 1, nameGame: 1, namePublic: 1, attrPrimary: 1, image: 1 })
        .sort({ nameGame: 'asc' });
    res.json({ "status": 200, "list": data })
}