
const url = "http://localhost:8080/api"

export const FetchWrapper = (path, options) => {

  return fetch(`${url}${path}`,options).then(response => {
    if (response.status === 204) {
      return Promise.resolve({});
    }

    return response.json();
  }).then(json => {
    if (!json || (json.status && json.status !== 200)) {
      return Promise.reject(
          json ? json.message : "Error occurred, please try again later");
    }

    return json;
  }).catch(error => {
    if (typeof error === 'object') {
      return Promise.reject("An error occurred")
    }

    return Promise.reject(error);
  });
}