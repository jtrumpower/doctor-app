import React from 'react';
import './App.css';
import AppAppBar from './modules/views/AppAppBar';
import withRoot from './modules/withRoot';
import SearchPage from './modules/views/SearchPage';
import {Container} from '@mui/material';

function App() {
  return (
      <React.Fragment>
        <AppAppBar />
        <Container maxWidth="lg">
          <SearchPage />
        </Container>
      </React.Fragment>
  );
}

export default withRoot(App);
