import {useState} from 'react';
import {search} from '../api/SearchApi';

const DEFAULTS = {
  pageSize: 25,
  page: 0,
  sorting: []
}

const useDataEvents = () => {
  const [searchVal, setSearchVal] = useState('')
  const [pageSize, setPageSize] = useState(DEFAULTS.pageSize);
  const [page, setPage] = useState(DEFAULTS.page);
  const [sorting, setSorting] = useState(DEFAULTS.sort)
  const [results, setResults] = useState([]);
  const [rowCount, setRowCount] = useState(0);
  const [loading, setLoading] = useState(false);

  const onSearch = (val, page=DEFAULTS.page, pageSize=DEFAULTS.pageSize, sorting=DEFAULTS.sorting) => {
    setSearchVal(val);
    setPageSize(pageSize);
    setSorting(sorting);
    val !== searchVal ? setPage(0) : setPage(page);
    setLoading(true);
    search({ pageSize, page, sorting, ...val }, true).then(json => {
      setResults(json.results);
      setRowCount(json.totalResults);
    }).catch(error => {

    }).finally(() => {
      setLoading(false);
    })
  }


  const onPageChange = (pageNum) => {
    onSearch(searchVal, pageNum, pageSize, sorting);
  }

  const onPageSizeChange = (pageSize) => {
    onSearch(searchVal, page, pageSize, sorting);
  }

  const onSortChange = (sorting) => {
    onSearch(searchVal, 0, pageSize, sorting);
  }

  return {...{results, page, pageSize, sorting, rowCount, loading, onSearch, onPageChange, onPageSizeChange, onSortChange}}
}

export default useDataEvents;
