const api_url = "http://localhost:8080/shows"

async function getApi() {
    const response = await fetch(api_url);
    let data = await response.json();
    if (response) {
        hideLoader();
        showShows(data);
    }
}

getApi(api_url)
    .catch((error) => console.error("FETCH ERROR:", error));

function hideLoader() {
    document.getElementById('loading').style.display = 'none';
}

function showShows(data) {
    let list = document.getElementById("myList");

    data.forEach((item) => {
        for (const entry of Object.entries(item)) {
            let li = document.createElement("li");
            li.innerText = (`${entry[0]} : ${entry[1]}\n \n`);
            list.appendChild(li);
        }
    })
}



