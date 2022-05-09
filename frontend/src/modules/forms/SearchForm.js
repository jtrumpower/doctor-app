import {
  Button,
  Input,
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
        <Stack direction="row" alignItems="flex-end" spacing={1}>
          <Typography>
            Select what to search for:
          </Typography>
          <Select
              labelId={'type-label'}
              value={search.type}
              onChange={handleChange}
              variant="standard"
              inputProps={{
                name: 'type',
                id: 'type',
              }}
          >
            { SEARCH_TYPES.map((type, index) =>
                <MenuItem key={index} value={type.value}>{type.text}</MenuItem>) }
          </Select>
        </Stack>
        <Stack direction="row" alignItems="flex-end" spacing={1} marginTop={1}>
          <Typography>
            Enter the name of a doctor:
          </Typography>
          <Input id="name" name="name" type="text" sx={{ width: 200 }} value={search.name} required onChange={handleChange} />
          <Button type="submit" variant="outlined">Search</Button>
        </Stack>
      </form>
  )
}

export default SearchForm;
