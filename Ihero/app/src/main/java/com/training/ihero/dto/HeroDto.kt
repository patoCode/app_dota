package com.training.ihero.dto

import java.io.Serializable

data class HeroDto(
    var heroId : String,
    var nameGame : String,
    var namePublic : String,
    var attrPrimary : String,
    var attackType : String,
    var image : String,
    var baseStr : String,
    var baseAgi : String,
    var baseInt : String,
    var moveSpeed : String,
    var baseHealth : String,
    var baseMana : String,
    var baseArmor : String,
    var roles : List<*>
):Serializable