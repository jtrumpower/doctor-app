import {
  Button, FormControl, Grid,
  Input, InputLabel,
  MenuItem,
  Select,
  Stack,
  Typography
} from '@mui/material';
import React from 'react';
import {SEARCH_TYPES} from './model/SearchModels';


const SearchForm = ({ search, onSubmit, handleChange}) => {

  return (
      <form onSubmit={onSubmit}>
        <Stack direction="row" alignItems="flex-end" spacing={1} marginTop={1}>
          <Typography width={225}>
            Enter the name of a doctor:
          </Typography>
          <Input id="value" name="value" type="text" sx={{ width: 200 }} value={search.value} required onChange={handleChange} />
          <FormControl variant="standard">
            <InputLabel id="type-label">Column</InputLabel>
            <Select
                labelId={'type-label'}
                value={search.rowType}
                onChange={handleChange}
                sx={{ width: 200 }}
                inputProps={{
                  name: 'rowType',
                  id: 'rowType',
                }}
            >
              { SEARCH_TYPES.map((type, index) =>
                  <MenuItem key={index} value={type.value}>{type.text}</MenuItem>) }
            </Select>
          </FormControl>
          <Button type="submit" variant="outlined" sx={{ width: 80 }}>Search</Button>
        </Stack>
      </form>
  )
}

export default SearchForm;
