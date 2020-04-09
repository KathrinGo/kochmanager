function loadVorratTable(){
    const url = "../api/vorrat";

    fetch(url)//fetsh, ohne Angaben ist es automatisch ein get-Request
        .then(resp => resp.json())//in json umwandeln
        .then(vorratArray => {
            clearVorratTable();
            const vorratTable = document.querySelector("#tableVorreate");//Tabelle in Konstante speichern
            for (var i in vorratArray){ //über alle Einträge in der Tabelle iterieren
                let vorrat = vorratArray[i];//arrayplatz für bestimmtes objekt ansprechen
                let textNodeId = document.createTextNode(vorrat.id);      // "12"
                let textNodeName = document.createTextNode(vorrat.name);    // "Michael"
                let textNodeMDH = document.createTextNode(vorrat.mdh);      // "12"
                //let textNodeHaltbarkeit = document.createTextNode(vorrat.haltbar);
                let textNodeVorrat = document.createTextNode(vorrat.menge);

                let row = vorratTable.insertRow(-1);                   // <tr></tr>
                row.insertCell(0).appendChild(textNodeId);
                row.insertCell(1).appendChild(textNodeName);
                row.insertCell(2).appendChild(textNodeMDH);
                row.insertCell(3).appendChild(textNodeVorrat);
            }
        });
}

function clearVorratTable() {
    const vorratTable = document.querySelector("#tableVorreate");
    const vorratTableHeading = document.querySelector("#vorratHeader");

    vorratTable.innerHTML = "";
    vorratTable.appendChild(vorratTableHeading);
}