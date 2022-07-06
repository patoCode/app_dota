package com.training.ihero.response

import java.io.Serializable

data class HeroListElement(
    val heroId: String,
    val nameGame: String,
    val namePublic: String,
    val attrPrimary: String,
    val image: String
):Serializable