import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import ProductScreen from './screens/ProductScreen';
import HomeScreen from './screens/HomeScreen';
import CartScreen from './screens/CartScreen';
import Footer from './components/Footer';
import SigninScreen from './screens/SigninScreen';
import RegisterScreen from './screens/RegisterScreen';

function App() {
  return (
    <BrowserRouter>
        <Route path = "/" component={HomeScreen} exact></Route>
        <Route path = "/product/:id" component={ProductScreen} exact></Route>
        <Route path = "/cart/:id" component={CartScreen} exact></Route>
        <Route path = "/cart" component={CartScreen} exact></Route>
        <Route path = "/signin" component={SigninScreen} exact></Route>
        <Route path = "/register" component={RegisterScreen} exact></Route>
        <Footer></Footer>
    </BrowserRouter>
  );
}

export default App;
