import express from 'express';
import data from './data.js';

var express = require('express');
const app = express();
var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
     extended: true
}));

 // route mặc định
app.get('/', (req, res) => {
    res.send('Server is ready');
});

// lấy api product từ file data.js 
app.get('/api/products', (req, res) => {
    res.send(data.products);
});

 // chỉnh port
 app.listen(5000, function () {
    console.log('Server at http://localhost:5000');
 });
 
 module.exports = app;