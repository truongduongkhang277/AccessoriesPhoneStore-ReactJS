import * as Axios from 'axios';
import { CART_ADD_ITEM, CART_REMOVE_ITEM } from './../constants/CartConstants';

export const addToCart = (productId, qty) => async (dispatch, getState) => {
    // lấy api của sản phẩm được chọn
    const {data} = await Axios.get(`/api/v1/products/${productId}`);
    
    dispatch({
        type: CART_ADD_ITEM,
        // lấy tên, ảnh, giá, số lượng tồn kho, id sản phẩm từ api và số lượng mua được truyền vào
        payload: {
          name: data.name,
          image: data.image,
          price: data.price,
          countInStock: data.countInStock,
          product: data.id,
          qty,
        },
    });
    // lưu lại thông tin sản phẩm được thêm vào giỏ hàng truyền đến store.js
    localStorage.setItem('cartItems', JSON.stringify(getState().cart.cartItems));
}

export const removeFromCart = (productId) => (dispatch, getState) => {
  dispatch({ type: CART_REMOVE_ITEM, payload: productId });
  localStorage.setItem('cartItems', JSON.stringify(getState().cart.cartItems));
};