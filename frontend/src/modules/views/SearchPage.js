import React, {useState} from 'react';
import {Stack} from '@mui/material';
import AppDataGrid from '../components/AppDataGrid';
import useDataEvents from '../hooks/useDataEvents';
import SearchForm from '../forms/SearchForm';
import {SEARCH_TYPE_DEFAULT} from '../forms/model/SearchModels';

const SearchPage = () => {
  const [search, setSearch] = useState({ value: '', rowType: SEARCH_TYPE_DEFAULT.value });
  const data = useDataEvents();

  React.useEffect(() => {
    data.onSearch(search);
  }, []);

  const handleChange = (e) => {
    const newItem = { ...search };
    newItem[e.target.name] = e.target.value;

    setSearch(newItem);
  }

  const handleSubmit = (e) => {
    e.preventDefault();

    data.onSearch(search);
  }

  return (
      <Stack marginTop={3}>
        <SearchForm onSubmit={handleSubmit} {...{ search, handleChange }}/>
        <AppDataGrid {...data} />
      </Stack>
  )
}

export default SearchPage;
