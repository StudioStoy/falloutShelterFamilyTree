
// This server is used to run the app on heroku
const express = require('express');
const path = require('path');
const port = process.env.PORT || 3000;
const app = express();

app.use(express.static(__dirname));
import fetch from 'node-fetch';

// The router overwrites this
app.get('*', function (request, response) {
    response.sendFile(path.resolve(__dirname, 'index.html'));
});

app.listen(port);
console.log("server started on port " + port);

async function getInfo(){
    let response = await fetch("dweller", {method: "GET"})

    if (response.status === 200){
        let info = await response.json()
        console.log(info)
    }
}

getInfo()

//
// var tree = new FamilyTree(document.getElementById("tree"), {
//     nodeBinding: {
//         field_0: "name"
//     },
//     nodes: [
//         { id: 1, pids: [2], name: "Amber McKenzie" },
//         { id: 2, pids: [1], name: "Ava Field" },
//         { id: 3, mid: 1, fid: 2, name: "Peter Stevens" }
//     ]
// });