import {useState} from 'react';
import {search} from '../api/SearchApi';

const DEFAULTS = {
  pageSize: 25,
  page: 0,
  sort: 'Change Type'
}

const useDataEvents = () => {
  const [searchVal, setSearchVal] = useState('')
  const [pageSize, setPageSize] = useState(DEFAULTS.pageSize);
  const [page, setPage] = useState(DEFAULTS.page);
  const [sort, setSort] = useState(DEFAULTS.sort)
  const [results, setResults] = useState([]);
  const [rowCount, setRowCount] = useState(0);

  const onSearch = (val='', page=DEFAULTS.page, pageSize=DEFAULTS.pageSize, sort=DEFAULTS.sort) => {
    setSearchVal(val);
    setPageSize(pageSize);
    setSort(sort);
    val !== searchVal ? setPage(0) : setPage(page);
    search({ name: val, pageSize, page }).then(json => {
      setResults(json.results);
      setRowCount(json.totalResults);
    }).catch(error => {

    })
  }


  const onPageChange = (pageNum) => {
    onSearch(searchVal, pageNum, pageSize, sort);
  }

  const onPageSizeChange = (pageSize) => {
    onSearch(searchVal, page, pageSize, sort);
  }

  const onSortChange = (sort) => {
    console.log(sort);
    onSearch(searchVal, 0, pageSize, sort);
  }

  return {...{results, page, pageSize, sort, rowCount, onSearch, onPageChange, onPageSizeChange, onSortChange}}
}

export default useDataEvents;
