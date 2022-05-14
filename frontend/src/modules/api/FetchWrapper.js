
const url = "http://localhost:8080/api"

export const FetchWrapper = (path, options) => {

  return fetch(`${url}${path}`,options).then(async response => {
    if (response.status > 299) {
      return Promise.reject("An error occurred");
    } else if (response.status === 204) {
      return Promise.resolve({});
    }

    return response.json();
  })
}