import {FetchWrapper} from "./FetchWrapper";


export const search = (params, paged) => {
  const suffix = paged ? "" : "typeahead"

  return FetchWrapper(`/search/${suffix}`,{
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(params)
  })
}
