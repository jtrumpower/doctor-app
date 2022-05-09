import React, {useState} from 'react';
import {DataGrid} from '@mui/x-data-grid';
import Box from '@mui/material/Box';
import {DataGridColumnDefinition} from './model/DataGridColumnDefinition';

const AppDataGrid = ({ results }) => {
  const [rows, setRows] = useState([]);

  React.useEffect(() => {
    const vals = results.map((result, index) => ({
      id: index,
      ...Object.getOwnPropertyNames(result)
          .map(prop => ({ [`col${index + 1}`]: result[prop] }))
    }));
    setRows(vals);
  }, results)

  return (
      <Box height={700} marginTop={3}>
        <DataGrid columns={DataGridColumnDefinition} rows={rows} />
      </Box>
  )
}

export default AppDataGrid;
