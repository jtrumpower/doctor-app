import {
  Button, FormControl, Grid,
  Input, InputLabel,
  MenuItem,
  Select,
  Stack, TextField,
  Typography
} from '@mui/material';
import React from 'react';
import {SEARCH_TYPES} from './model/SearchModels';
import AppTypeahead from "../components/AppTypeahead";
import styled from "@emotion/styled";

const StyledExportButton = styled(Button)({
  width: 80,
  backgroundColor: "green",
  color: "white",
  '&:hover': {
    backgroundColor: "darkgreen"
  }
})

const SearchForm = ({ search, onSubmit, handleChange}) => {

  const download = () => {
    const paramsKeyVal = [];
    Object.getOwnPropertyNames(search)
        .forEach(prop => paramsKeyVal.push(`${prop}=${search[prop]}`));
    window.open(`http://localhost:8080/api/download?${encodeURI(paramsKeyVal.join('&'))}`, "_blank")
  }

  return (
      <form onSubmit={onSubmit}>
        <Stack direction="row" alignItems="flex-end" spacing={1} justifyContent="space-between">
          <Stack direction="row" alignItems="flex-end" spacing={1} marginTop={1}>
            <AppTypeahead {...{search, handleChange}} />
            <FormControl variant="standard">
              <InputLabel id="type-label">Column</InputLabel>
              <Select
                  labelId={'type-label'}
                  value={search.columns}
                  onChange={handleChange}
                  sx={{ width: 200 }}
                  inputProps={{
                    name: 'columns',
                    id: 'columns',
                  }}
              >
                { SEARCH_TYPES.map((type, index) =>
                    <MenuItem key={index} value={type.value}>{type.text}</MenuItem>) }
              </Select>
            </FormControl>
            <Button type="submit" variant="outlined" sx={{ width: 80 }}>Search</Button>
          </Stack>
          <StyledExportButton variant="outlined" onClick={download}>Export</StyledExportButton>
        </Stack>

      </form>
  )
}

export default SearchForm;
