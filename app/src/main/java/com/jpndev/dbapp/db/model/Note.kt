package com.jpndev.dbapp.db.model

import com.google.gson.annotations.SerializedName

data class Note(
    @SerializedName("_id")
    var id: String = "",
    @SerializedName("created_at")
    var createdAt: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("tags")
    var tags: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("updated_at")
    var updatedAt: String = ""
)