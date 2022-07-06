const express = require('express')
const app = express()
const morgan = require('morgan')
const bodyParser = require('body-parser')



//CONFIGURATIONS
app.set('port', process.env.PORT || 1234)
app.set('json spaces', 2)

// ADD MIDDLEWARES
app.use(morgan("dev"))
app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())

// CONNECTION DB
require('./config/db')


// ROUTES
app.use(require('./routes/hero.route'))

// const cancionRoutes = require('./routes/Cancion')
// const artistaRoutes = require('./routes/Artista')
// const albumRoutes = require('./routes/Album')
// const playlistRoutes = require('./routes/Playlist')


// app.use(artistaRoutes)
// app.use(albumRoutes)
// app.use(cancionRoutes)
// app.use(playlistRoutes)


app.listen(app.get('port'), () => {
    console.log(`Server listening on port ${app.get('port')}`)
})