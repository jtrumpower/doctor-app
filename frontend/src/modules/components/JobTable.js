import {
  Stack,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow, Typography
} from "@mui/material";
import React from "react";

const JobTable = ({ jobs, refreshJobs }) => {

  React.useEffect(() => {
    const interval = setInterval(refreshJobs, 5000);

    return () => clearInterval(interval);
  }, [])

  return (
      <Stack spacing={1} marginTop={3}>
        <Typography variant="h5">Job History</Typography>
        <Table sx={{ border: '1px gray solid'}}>
          <TableHead>
            <TableRow>
              <TableCell width={140}>Name</TableCell>
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
                  <TableCell width={100}>{row.took} sec</TableCell>
                  <TableCell>{row.statusDesc}</TableCell>
                </TableRow>
            ))}
          </TableBody>
        </Table>
      </Stack>

  )
}

export default JobTable;