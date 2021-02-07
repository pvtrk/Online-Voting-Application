export const LOGIN_URL = `http://localhost:8080/login`;

export async function attemptLogin (data) {
    const response = await fetch(`${LOGIN_URL}`, {
        method : 'POST',
        headers : {
            'Content-Type' : 'application/json'
        },
        body: JSON.stringify({
            "username" : document.getElementById('username').value,
            "password" : document.getElementById('password').value
        })
    })
    if(!response.ok) {
        const message = `Wystąpił błąd + ${response.status}`;
        throw new Error(message);
    }
    else {
        console.log(response.headers.get('Authorization'));
    }
}
