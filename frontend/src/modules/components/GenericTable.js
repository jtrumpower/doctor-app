import {
  Stack,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow, Typography
} from "@mui/material";
import React from "react";

const GenericTable = ({ title, rows, header, onInterval, interval=5000 }) => {

  React.useEffect(() => {
    if (onInterval) {
      const refreshInterval = setInterval(onInterval, interval);

      return () => clearInterval(refreshInterval);
    }
  }, [onInterval, interval])

  return (
      <Stack spacing={1} marginTop={3}>
        <Typography variant="h5">{title}</Typography>
        <Table sx={{ border: '1px gray solid'}}>
          <TableHead>
            {header}
          </TableHead>
          <TableBody>
            {rows}
          </TableBody>
        </Table>
      </Stack>

  )
}

export default GenericTable;