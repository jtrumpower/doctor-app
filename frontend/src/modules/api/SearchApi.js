const url = "http://localhost:8080/api/search"

export const search = (params) => {

  return fetch(url,{
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(params)
  }).then(async response => {
    if (response.status !== 200) {
      return Promise.reject("An error occurred");
    }

    return response.json();
  })
}
