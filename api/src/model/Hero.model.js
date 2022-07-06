const mongoose = require('mongoose')
const { Schema } = mongoose

const HeroSchema = new Schema({
    heroId: { type: Number, required: true },
    nameGame: { type: String },
    namePublic: { type: String },
    attrPrimary: { type: String },
    attackType: { type: String },
    image: { type: String },
    baseStr: { type: Number },
    baseAgi: { type: Number },
    baseInt: { type: Number },
    moveSpeed: { type: mongoose.Decimal128 },
    baseHealth: { type: mongoose.Decimal128 },
    baseMana: { type: mongoose.Decimal128 },
    baseArmor: { type: mongoose.Decimal128 },
    roles: [{ type: String }]
}, {
    timestamps: true
}, {
    query: {
        byHeroId(id) {
            return this.where({
                heroId: id
            })
        }
    }
}
)

module.exports = mongoose.model("Hero", HeroSchema)