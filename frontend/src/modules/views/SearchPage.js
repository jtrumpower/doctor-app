import React, {useState} from 'react';
import {
  Button,
  Grid,
  Input,
  Stack,
} from '@mui/material';
import AppDataGrid from '../components/AppDataGrid';
import {search} from '../api/SearchApi';

const SearchPage = () => {
  const [name, setName] = useState('');
  const [results, setResults] = useState([]);

  const handleChange = (e) => setName(e.target.value)

  const handleSubmit = (e) => {
    e.preventDefault();

    search({ name: name, pageSize: 25 }).then(json => {
      setResults(json.results);
    }).catch(error => {

    })
  }

  return (
      <Stack component="form" marginTop={3} onSubmit={handleSubmit}>
        <Grid container alignItems="flex-end" spacing={3}>
          <Grid item>
            Enter the name of a doctor:
          </Grid>
          <Grid item>
            <Input id="Name" type="text" sx={{ width: 200 }} value={name} required onChange={handleChange} />
          </Grid>
          <Grid item>
            <Button type="submit" variant="outlined">Search</Button>
          </Grid>
        </Grid>
        <AppDataGrid results={results} />
      </Stack>
  )
}

export default SearchPage;
