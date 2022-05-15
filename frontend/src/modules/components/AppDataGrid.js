import React, {useState} from 'react';
import {DataGrid} from '@mui/x-data-grid';
import Box from '@mui/material/Box';
import {DataGridColumnDefinition} from './model/DataGridColumnDefinition';

const AppDataGrid = ({ results, page, pageSize, rowCount, loading, onSortChange, onPageChange, onPageSizeChange }) => {
  const [rows, setRows] = useState([]);
  const [rowCountState, setRowCountState] = React.useState(rowCount);

  React.useEffect(() => {
    const vals = results.map((result, index) => {
      const val = { id: index }

      Object.getOwnPropertyNames(result)
          .forEach((prop) => val[prop] = result[prop]);

      return val;
    });
    setRows(vals);
  }, [results]);

  React.useEffect(() => {
    setRowCountState((prevRowCountState) =>
        rowCount !== undefined ? rowCount : prevRowCountState,
    );
  }, [rowCount, setRowCountState]);

  return (
      <Box height={700} marginTop={2}>
        <DataGrid
            loading={loading}
            rowCount={rowCountState}
            page={page}
            pageSize={pageSize}
            disableColumnResize={false}
            disableColumnMenu={true}
            disableColumnSelector={true}
            hideFooterSelectedRowCount={true}
            columns={DataGridColumnDefinition}
            sortingMode="server"
            paginationMode="server"
            onSortModelChange={onSortChange}
            onPageChange={onPageChange}
            onPageSizeChange={onPageSizeChange}
            disableSelectionOnClick={true}
            rows={rows} />
      </Box>
  )
}

export default AppDataGrid;
