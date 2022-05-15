import {FetchWrapper} from "./FetchWrapper";

export const JobApi = ({
  getAllJobs: () => {
    return FetchWrapper("/jobs");
  },
  postJob: (params) => {
    return FetchWrapper("/jobs/dataloader", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(params)
    })
  },
  deleteJob: (id) => {
    return FetchWrapper(`/jobs/${id}`, {
      method: 'DELETE'
    })
  }
})