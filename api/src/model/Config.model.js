const mongoose = require('mongoose')
const { Schema } = mongoose

const ConfigSchema = new Schema({
    sysCode: { type: String, required: true },
    status: { type: Number, required: true }
}, {
    timestamps: true
})

module.exports = mongoose.model("Config", ConfigSchema)