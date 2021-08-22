import {createStore, compose, applyMiddleware, combineReducers} from 'redux';
import thunk from 'redux-thunk';
import { cartReducer } from './reducer/CartReducer';
import {productDetailsReducer, productListReducer} from './reducer/ProductReducer'

const initalState = {
    cart:{
        // lấy giá trị sản phẩm vào thêm vào giỏ từ action
        cartItems: localStorage.getItem('cartItems') 
        ? JSON.parse(localStorage.getItem('cartItems')) 
        : [],
    }
};
// hiển thị từ reducer
const reducer = combineReducers ({

    productList: productListReducer,
    productDetails: productDetailsReducer,
    cart: cartReducer,

})

const composeEnhancer = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const store = createStore(reducer, initalState, composeEnhancer(applyMiddleware(thunk)));

export default store;