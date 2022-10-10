function hideLoader() {
    document.getElementById('loading').style.display = 'none';
}
const api_url = "http://localhost:8080/shows"

async function getApi() {
    const response = await fetch(api_url);
    let data = await response.json();
    if (response) {
        hideLoader();
        show(data);
    }

}

getApi(api_url)
    .catch((error) => console.error("FETCH ERROR:", error));



function show(data) {
    const nameText = document.getElementsByClassName("nameText")[0];
    console.log(nameText);
    data.forEach((dataS) => {

        let itemP = document.createElement("H1");
        let itemPText = document.createTextNode(dataS.name);
        itemP.appendChild(itemPText);
        nameText.appendChild(itemP);
        console.log(itemP);
        console.log(dataS.name)
    })

}
