import React from 'react';

import {BrowserRouter, Route} from 'react-router-dom';

//Pages
import Home from './pages/Home';
import Shape from './pages/Shape';
import Post from './pages/Postgis';
import Guide from './pages/HowToUse';

function Routes() {
    return (
        <BrowserRouter>
            <Route path="/" component={Home} exact/>
            <Route path="/post" component={Post}/>
            <Route path="/shape" component={Shape}/>
            <Route path="/how-to-use" component={Guide}/>
    
        </BrowserRouter>
    )
}

export default Routes;