import React, {useState} from 'react';
import {
  Button,
  Input,
  Stack, Typography,
} from '@mui/material';
import AppDataGrid from '../components/AppDataGrid';
import useDataEvents from '../hooks/useDataEvents';

const SearchPage = () => {
  const [name, setName] = useState('');
  const data = useDataEvents();

  const handleChange = (e) => setName(e.target.value)

  const handleSubmit = (e) => {
    e.preventDefault();

    data.onSearch(name);
  }

  return (
      <Stack marginTop={3}>
        <form onSubmit={handleSubmit}>
          <Stack direction="row" alignItems="flex-end" spacing={1}>
            <Typography>
              Enter the name of a doctor:
            </Typography>
            <Input id="Name" type="text" sx={{ width: 200 }} value={name} required onChange={handleChange} />
            <Button type="submit" variant="outlined">Search</Button>
          </Stack>
        </form>
        <AppDataGrid {...data} />
      </Stack>
  )
}

export default SearchPage;
