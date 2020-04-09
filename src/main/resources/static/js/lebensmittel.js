function loadLebensmittelTable(){
    const url = "../api/lebensmittel";

    fetch(url)//fetsh, ohne Angaben ist es automatisch ein get-Request
        .then(resp => resp.json())//in json umwandeln
        .then(lebensmittelArray => {
            clearLebensmittelTable();
            const lebensmittelTable = document.querySelector("#tableLebensmittel");//Tabelle in Konstante speichern
            for (var i in lebensmittelArray){ //über alle Einträge in der Tabelle iterieren
                let lebensmittel = lebensmittelArray[i];//arrayplatz für bestimmtes objekt ansprechen
                let textNodeId = document.createTextNode(lebensmittel.id);      // "12"
                let textNodeName = document.createTextNode(lebensmittel.name);    // "Michael"

                let row = lebensmittelTable.insertRow(-1);                   // <tr></tr>
                row.insertCell(0).appendChild(textNodeId);
                row.insertCell(1).appendChild(textNodeName);
            }
        });
}

function clearLebensmittelTable() {
    const lebensmittelTable = document.querySelector("#tableLebensmittel");
    const lebensmittelTableHeading = document.querySelector("#lebensmittelHeading");

    lebensmittelTable.innerHTML = "";
    lebensmittelTable.appendChild(lebensmittelTableHeading);
}

