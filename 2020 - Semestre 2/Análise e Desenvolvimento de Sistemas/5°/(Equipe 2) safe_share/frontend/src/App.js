import React from 'react';
import { BrowserRouter } from 'react-router-dom';

import Drawer from './components/Drawer/index';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Drawer />
      </BrowserRouter>
    </div>
  );
}

export default App;