import { PRODUCT_LIST_REQUEST, 
         PRODUCT_LIST_SUCCESS, 
         PRODUCT_LIST_FAIL, 
         PRODUCT_DETAILS_REQUEST,
         PRODUCT_DETAILS_SUCCESS,
         PRODUCT_DETAILS_FAIL
                } from './../constants/ProductConstants';
import Axios from 'axios';

// lấy api hiển thị danh sách sản phẩm
// dựa vào thứ tự trạng thái mà thực hiện lệnh tương ứng
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

// dựa vào thứ tự trạng thái mà thực hiện lệnh tương ứng
export const detailsProduct = (productId) => async (dispatch) => {
    dispatch({ 
        type: PRODUCT_DETAILS_REQUEST, payload: productId 
    });
    try {
      const {data} = await Axios.get(`/api/v1/products/${productId}`);
      // hiển thị dữ liệu sản phẩm thông qua api lấy từ backend
      dispatch({ type: PRODUCT_DETAILS_SUCCESS, payload: data});
    } catch (error) {
        const message =
            error.response && error.response.data.message
            ? error.response.data.message
            : error.message;
        dispatch({ type: PRODUCT_DETAILS_FAIL, payload: message });
    }
};
  