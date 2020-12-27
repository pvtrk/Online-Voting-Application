export const API_URL = `http://localhost:8080/api`;
   
    
export const fetchFromDb = async function fetchSomething(url) {
    const response = await fetch(`${API_URL}${url}`);
    if(!response.ok) {
        const message = `Wystąpił błąd: ${response.status}!`;
        throw new Error(message);
    }
    const result = await response.json();
    return result;
  }

export const voteForCandidate = async function(url, data) {
   const response = await fetch(`${API_URL}${url}`, {
       method : 'POST',
       headers : {
           'Content-Type' : 'application/json'
       },
       body: JSON.stringify(data),
   })
   if(!response.ok) {
       const message = `Wystąpił błąd + ${response.status}`;
       throw new Error(message);
   }
}
