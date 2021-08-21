import { Axios } from 'axios';
import { CART_ADD_ITEM } from './../constants/CartConstants';

export const addToCart = (productId, qty) => async( dispatch, getState) => {

    const {data} = await Axios.get(`/api/v1/products/${productId}`);
    dispatch({
        type: CART_ADD_ITEM, payload: {
            name: data.name,
            image: data.image,
            price: data.image,
            countInStock: data.countInStock,
            product: data.id,
            qty
        }
    })
}