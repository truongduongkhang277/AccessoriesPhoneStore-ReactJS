import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import ProductScreen from './screens/ProductScreen';
import HomeScreen from './screens/HomeScreen';
import CartScreen from './screens/CartScreen';

function App() {
  return (
    <BrowserRouter>
    
        <Route path = "/" component={HomeScreen} exact></Route>
        <Route path = "/product/:id" component={ProductScreen} exact></Route>
        <Route path = "/cart/:id" component={CartScreen} exact></Route>
        
    </BrowserRouter>
  );
}

export default App;
