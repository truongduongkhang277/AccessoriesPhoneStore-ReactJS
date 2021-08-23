import { USER_SIGNIN_REQUEST, 
        USER_SIGNIN_SUCCESS, 
        USER_SIGNIN_FAIL, 
        USER_SIGNOUT,
           } from './../constants/UserConstants';
import Axios from 'axios';

// lấy api khi thực hiện đăng nhập
// dựa vào thứ tự trạng thái mà thực hiện lệnh tương ứng
export const signin = (email, password) => async (dispatch) => {
    dispatch({
        type: USER_SIGNIN_REQUEST, payload: {email, password}
    });
    try{
        const {data} = await Axios.post('/api/v1/signin', {email, password});
        console.log(await Axios.post(`/api/v1/signin/${email}/${password}`, {email, password}));
        console.log(await Axios.post('/api/v1/signin', {email, password}));
        dispatch({ type: USER_SIGNIN_SUCCESS, payload: data});
        localStorage.setItem('userInfo', JSON.stringify(data));
    } catch (error) {
        const message =
            error.response && error.response.data.message
            ? error.response.data.message
            : error.message;
        dispatch({ type: USER_SIGNIN_FAIL, payload: message });
    }
}