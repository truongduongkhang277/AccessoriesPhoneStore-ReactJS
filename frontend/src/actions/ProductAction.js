
import { PRODUCT_LIST_REQUEST, PRODUCT_LIST_SUCCESS, PRODUCT_LIST_FAIL } from './../constants/ProductConstants';
import Axios from 'axios';

export const listProducts = () => async (dispatch) => {
    dispatch({
        type: PRODUCT_LIST_REQUEST,
    });
    try{
        const {data} = await Axios.get('/api/v1/products');
        dispatch({ type: PRODUCT_LIST_SUCCESS, payload: data});
    } catch (error) {
        dispatch({ type: PRODUCT_LIST_FAIL, payload: error.message})
    }
}