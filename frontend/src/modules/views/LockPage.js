import React from 'react';
import {Stack} from "@mui/material";
import GenericTable from "../components/GenericTable";
import {LockTableModel} from "../components/model/LockTableModel";
import {LockApi} from "../api/LockApi";
import {useSnackbar} from "notistack";

const LockPage = () => {
  const [locks, setLocks] = React.useState([]);
  const {enqueueSnackbar} = useSnackbar();

  React.useEffect(() => {
    refreshData();
  }, [])

  const handleDelete = (lock) => {
    LockApi.deleteLock(lock.id).then(() => {
      refreshData();
      enqueueSnackbar("Deleted Lock", {variant: 'success'});
    }).catch(error => {
      enqueueSnackbar(error, {variant: 'error'});
    });
  }

  const refreshData = () => {
    LockApi.getAllLocks().then(json => {
      setLocks(json);
    }).catch(error => {
      console.log(error);
    })
  }

  return (
      <Stack>
        <GenericTable
            title={LockTableModel.title}
            header={LockTableModel.header()}
            rows={locks.map(lock => LockTableModel.row(lock, handleDelete))}
            onInterval={refreshData}
        />
      </Stack>
  )
}

export default LockPage;