import React from 'react';
import {
  Button,
  FormControl,
  FormHelperText,
  Grid,
  Input,
  InputLabel,
  Stack,
  Typography
} from '@mui/material';
import Box from '@mui/material/Box';
import {DataGrid} from '@mui/x-data-grid';

const SearchPage = () => {


  return (
      <Stack component="form" marginTop={3}>
        <Grid container alignItems="flex-end" spacing={3}>
          <Grid item>
            Enter the name of a doctor:
          </Grid>
          <Grid item>
            <Input id="Name" type="text" sx={{ width: 200 }} />
          </Grid>
          <Grid item>
            <Button type="submit" variant="outlined">Search</Button>
          </Grid>
        </Grid>
      </Stack>
  )
}

export default SearchPage;
