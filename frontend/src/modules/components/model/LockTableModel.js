import {IconButton, TableCell, TableRow} from "@mui/material";
import React from "react";
import HighlightOffIcon from '@mui/icons-material/HighlightOff';

export const LockTableModel = {
  title: 'Current Locks',
  header: () => (
      <TableRow>
        <TableCell width={140}>Locked Table</TableCell>
        <TableCell>Job ID with Lock</TableCell>
        <TableCell>Created</TableCell>
        <TableCell>Delete</TableCell>
      </TableRow>
  ),
  row: (lock, handleDelete) => (
      <TableRow key={lock.id}>
        <TableCell>{lock.table}</TableCell>
        <TableCell>{lock.job.id}</TableCell>
        <TableCell>{lock.created}</TableCell>
        <TableCell>
          <IconButton onClick={() => handleDelete(lock)}>
            <HighlightOffIcon />
          </IconButton>
        </TableCell>
      </TableRow>
  )
}
