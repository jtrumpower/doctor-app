import React from 'react';
import {
  FormControl,
  FormHelperText,
  Grid,
  Input,
  InputLabel,
  Stack,
  Typography
} from '@mui/material';
import Box from '@mui/material/Box';

const SearchPage = () => {


  return (
      <Stack component="form" marginTop={2}>
        <Grid container alignItems="flex-end" spacing={3}>
          <Grid item>
            Enter the name of a doctor:
          </Grid>
          <Grid item>
            <Input id="Name" type="text" />
          </Grid>
        </Grid>
      </Stack>
  )
}

export default SearchPage;
