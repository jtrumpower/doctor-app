import {FetchWrapper} from "./FetchWrapper";

export const LockApi = ({
  getAllLocks: () => {
    return FetchWrapper("/locks");
  },
  deleteLock: (id) => {
    return FetchWrapper(`/locks/${id}`, {
      method: 'DELETE'
    })
  }
})