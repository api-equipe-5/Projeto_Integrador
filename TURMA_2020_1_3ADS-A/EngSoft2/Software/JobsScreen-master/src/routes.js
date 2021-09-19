import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import Home from './Component/Home';
import Register from './Component/Register';


export default () => {
  window.console.log('a')
  return (
    <BrowserRouter>
      <div>
        <Route exact path="/" component={Home} />
        <Route path="/register" component={Register} />

      </div>
    </BrowserRouter>
  );
}