package com.training.ihero.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ListHeroResponse(
    @SerializedName("status") val status : String,
    @SerializedName("list") val list : List<HeroListElement>
):Serializable