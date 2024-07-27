const express = require('express')
const morgan = require('morgan')
const bodyParser = require('body-parser')

//App Created
const app = express()

//App Middlewares
app.use(morgan('dev'))
app.use(bodyParser.json())

//Routes
const routes = require('./routes')
routes(app)

//Server
app.listen(3000, () => {
    console.log('Server started on http://localhost:3000')
})

