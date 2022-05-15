import {TableCell, TableRow} from "@mui/material";
import React from "react";

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
      </TableRow>
  ),
  row: (row) => (
      <TableRow key={row.id}>
        <TableCell>{row.name}</TableCell>
        <TableCell>{row.description}</TableCell>
        <TableCell>{row.type}</TableCell>
        <TableCell>{row.status}</TableCell>
        <TableCell>{row.created}</TableCell>
        <TableCell>{row.completed}</TableCell>
        <TableCell width={100}>{row.took} sec</TableCell>
        <TableCell>{row.statusDesc}</TableCell>
      </TableRow>
  )
}
