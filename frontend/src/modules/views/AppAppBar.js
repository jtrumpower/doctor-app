import * as React from 'react';
import Box from '@mui/material/Box';
import Link from '@mui/material/Link';
import AppBar from '../components/AppBar';
import Toolbar from '../components/Toolbar';

function AppAppBar() {
  return (
      <div>
        <AppBar position="fixed">
          <Toolbar sx={{ justifyContent: 'center' }}>
            <Link
                variant="h6"
                underline="none"
                color="inherit"
                href="/premium-themes/onepirate/"
                sx={{ fontSize: 24 }}
            >
              {'Doctors'}
            </Link>
          </Toolbar>
        </AppBar>
        <Toolbar />
      </div>
  );
}

export default AppAppBar;
