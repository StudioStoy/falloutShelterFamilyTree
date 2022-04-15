
async function getInfo(){
    let response = await fetch("dweller", {method: "GET"})

    if (response.status === 200){
        let info = await response.json()
        console.log(info)
    }
}

getInfo()


var tree = new FamilyTree(document.getElementById("tree"), {
    nodeBinding: {
        field_0: "name"
    },
    nodes: [
        { id: 1, pids: [2], name: "Amber McKenzie" },
        { id: 2, pids: [1], name: "Ava Field" },
        { id: 3, mid: 1, fid: 2, name: "Peter Stevens" }
    ]
});