import React from 'react';
import './App.css';
import AppAppBar from './modules/views/AppAppBar';
import withRoot from './modules/withRoot';
import SearchPage from './modules/views/SearchPage';
import {Container} from '@mui/material';
import {Route, Routes} from "react-router-dom";
import JobPage from "./modules/views/JobPage";
import LockPage from "./modules/views/LockPage";
import {SnackbarProvider} from "notistack";

function App() {
  return (
      <SnackbarProvider maxSnack={3}>
        <AppAppBar />
        <Container maxWidth="lg">
          <Routes>
            <Route path="/" element={<SearchPage />} />
            <Route path="/jobs" exact element={<JobPage />} />
            <Route path="/locks" exact element={<LockPage />} />
          </Routes>
        </Container>
      </SnackbarProvider>
  );
}

export default withRoot(App);
