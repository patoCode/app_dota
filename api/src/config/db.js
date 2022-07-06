const mongoose = require("mongoose")

const PORT = 4000;
const MONGODB_URI = "mongodb://localhost/dota";


mongoose.connect(MONGODB_URI, {
  useNewUrlParser: true
}).then(db => console.log("DB OK"))
  .catch(err => console.error(err))  
