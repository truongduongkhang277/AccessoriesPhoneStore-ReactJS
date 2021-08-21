import {createStore, compose, applyMiddleware, combineReducers} from 'redux';
import thunk from 'redux-thunk';
import { cartReducer } from './reducer/CartReducer';
import {productDetailsReducer, productListReducer} from './reducer/ProductReducer'

const initalState = {};
// hiển thị từ reducer
const reducer = combineReducers ({

    productList: productListReducer,
    productDetails: productDetailsReducer,
    cart: cartReducer,

})

const composeEnhancer = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const store = createStore(reducer, initalState, composeEnhancer(applyMiddleware(thunk)));

export default store;