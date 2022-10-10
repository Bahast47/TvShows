function hideLoader() {
    document.getElementById('loading').style.display = 'none';
}
const api_url = "http://localhost:8080/shows"

async function getApi() {
    const response = await fetch(api_url);
    let data = await response.json();
    if (response) {
        hideLoader();
    }
}

getApi(api_url)
    .catch((error) => console.error("FETCH ERROR:", error));


