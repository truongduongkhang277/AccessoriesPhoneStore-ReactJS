import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import ProductScreen from './screens/ProductScreen';
import HomeScreen from './screens/HomeScreen';

function App() {
  return (
    <BrowserRouter>
    
        <Route path = "/" component={HomeScreen} exact></Route>
        <Route path = "/product/:id" component={ProductScreen} exact></Route>
        
    </BrowserRouter>
  );
}

export default App;
