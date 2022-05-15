import {IconButton, TableCell, TableRow} from "@mui/material";
import React from "react";
import HighlightOffIcon from "@mui/icons-material/HighlightOff";

export const JobTableModel = {
  title: 'Job History',
  header: () => (
      <TableRow>
        <TableCell width={140}>Name</TableCell>
        <TableCell>Description</TableCell>
        <TableCell>Type</TableCell>
        <TableCell>Status</TableCell>
        <TableCell>Created</TableCell>
        <TableCell>Completed On</TableCell>
        <TableCell>Took</TableCell>
        <TableCell>Status Description</TableCell>
        <TableCell>Delete</TableCell>
      </TableRow>
  ),
  row: (job, onDelete) => (
      <TableRow key={job.id}>
        <TableCell>{job.name}</TableCell>
        <TableCell>{job.description}</TableCell>
        <TableCell>{job.type}</TableCell>
        <TableCell>{job.status}</TableCell>
        <TableCell>{job.created}</TableCell>
        <TableCell>{job.completed}</TableCell>
        <TableCell width={100}>{job.took} sec</TableCell>
        <TableCell>{job.statusDesc}</TableCell>
        <TableCell>
          <IconButton onClick={() => onDelete(job)}>
            <HighlightOffIcon />
          </IconButton>
        </TableCell>
      </TableRow>
  )
}
