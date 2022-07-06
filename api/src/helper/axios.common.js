const axios = require('axios').default

axios.get(url, data)
  .then(function (response) {
    return response
  })
  .catch(function (error) {
    console.log(error)
  })
  .then(function () {
    console.log(url, data)
  })

axios.post(url, data)
  .then(function (response) {
    return response
  })
  .catch(function (error) {
    console.log(error)
  })

module.exports = axios