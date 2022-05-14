import {Table, TableBody, TableCell, TableHead, TableRow} from "@mui/material";
import React from "react";

const JobTable = ({ jobs }) => {

  return (
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Name</TableCell>
            <TableCell>Description</TableCell>
            <TableCell>Job Status</TableCell>
            <TableCell>Created</TableCell>
            <TableCell>Completed On</TableCell>
            <TableCell>Took</TableCell>
            <TableCell>Status Description</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {jobs.map(row => (
              <TableRow key={row.id}>
                <TableCell>{row.name}</TableCell>
                <TableCell>{row.description}</TableCell>
                <TableCell>{row.status}</TableCell>
                <TableCell>{row.created}</TableCell>
                <TableCell>{row.completed}</TableCell>
                <TableCell>{row.took}</TableCell>
                <TableCell>{row.statusDesc}</TableCell>
              </TableRow>
          ))}
        </TableBody>
      </Table>
  )
}

export default JobTable;