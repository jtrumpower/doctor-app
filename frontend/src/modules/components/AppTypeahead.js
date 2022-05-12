import React from 'react';
import {Autocomplete, TextField} from "@mui/material";
import {SEARCH_TYPES} from "../forms/model/SearchModels";
import {search as searchApi} from '../api/SearchApi';
import {StringUtil} from '../util/StringUtil';

const AppTypeahead = ({ search, handleChange }) => {
  const [results, setResults] = React.useState([]);
  const [loading, setLoading] = React.useState(false);

  React.useEffect(() => {
    let timer = setTimeout(() => {
      if (search.value && !loading) {
        setLoading(true);
        searchApi({ pageSize: 5, ...search}).then(json => {
          setResults(json.results);
        }).catch((error) => {

        }).finally(() => {
          setLoading(false);
        });
      }
    }, 250);

    return () => clearTimeout(timer);
  }, [search.value, setLoading, setResults]);

  React.useEffect(() => {
    setResults([]);
  }, [search.columns]);

  const getLabel = (option) => {
    const type = SEARCH_TYPES.find(type => type.value === search.columns)||"";
    const vals = (type.value && type.value.split("|").map(t => option[t])) || "";

    return StringUtil.pascal(vals.join(" "));
  }

  return (
      <Autocomplete
          loading={loading}
          options={results}
          clearOnBlur={false}
          getOptionLabel={option => getLabel(option) }
          renderOption={(props, option) => (
              <li {...props}>
                {getLabel(option)}
              </li>
          )}
          onSelect={handleChange}
          renderInput={(params) =>
            <TextField
                {...params}
                id="value"
                variant="standard"
                name="value"
                label="Search"
                sx={{ width: 200 }} value={search.value} onChange={handleChange} />} />
  )
}

export default AppTypeahead;