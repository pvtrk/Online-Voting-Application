const API_URL = `http://localhost:8080/api`;
   
    
const fetchFromDb = async function fetchSomething(url) {
    const response = await fetch(`${API_URL}${url}`);
    if(!response.ok) {
        const message = `Wystąpił błąd: ${response.status}!`;
        throw new Error(message);
    }
    const result = await response.json();
    return result;
  }
//
//const voteForCandidate = async function(url, data) {
//    const response = await fetch(`${API_URL}${url}`, {
//        method : 'POST',
//        headers : {
//            'Content-Type' : 'application/json'
//        },
//        body: JSON.stringify(data),
//    })
//    .then(response => response.json())
//    .then(data => console.log(data))
//    .catch(error => {
//        console.log("Error: ", error);
//    })
//}
