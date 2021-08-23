import { addToCart, removeFromCart } from '../actions/CartAction';
import { useDispatch, useSelector } from 'react-redux';
import { React, useEffect } from 'react';
import { Link } from 'react-router-dom';
import Navbar from '../components/Navbar';
import MessageBox from './../components/MessageBox';

export default function CartScreen(props) {
    // truyền vào giá trị id sản phẩm
    const productId = props.match.params.id;
    // lấy số lượng truyền vào qua sự kiện thêm vào giỏ hàng
    const qty = props.location.search ? Number(props.location.search.split('=')[1]):1;

    const dispatch = useDispatch();
    
    // từ giá trị file store.js, lấy reducer tương ứng
    const cart = useSelector(state => state.cart);
    const {cartItems} = cart;

    // truyền đến action id sản phẩm để lấy api, số lượng sản phẩm được mua
    useEffect(() => {
        if(productId){
            dispatch(addToCart(productId, qty));
        }
    }, [dispatch, productId, qty]);

    // tạo phương thức xóa sản phẩm khỏi giỏ hàng
    const removeFromCartHandler = (id) => {
        dispatch(removeFromCart(id));
    };
    
    const checkoutHandler = () => {
        props.history.push('/signin?redirect=shipping');
    };

    return (
        <div>
            <div>
                <Navbar></Navbar>
                <div class="small-container cart-page">                    
                                           
                        <h2 className="title">Shopping Cart</h2>
                        {cartItems.length === 0 ? <MessageBox>
                            Cart is empty. <Link to="/"> Go Shopping </Link>
                        </MessageBox>
                        : (
                        <div> 
                            <table>
                                <tr>
                                    <th >Sản phẩm</th>
                                    <th>Số lượng</th>
                                    <th>Giá tiền</th>
                                    <th>#</th>
                                </tr>
                                {cartItems.map((item) => (
                                    <tr key ={item.product}>
                                        <td>
                                            <div class="cart-info">
                                                <Link to={`/product/${item.product}`}><img src={item.image} alt={item.name}></img></Link>
                                                <div>
                                                    <Link to={`/product/${item.product}`}><p>{item.name}</p></Link>
                                                    <p>Item price: {item.price} VNĐ</p>                                               
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <select
                                                value={item.qty}
                                                onChange={(e) =>
                                                    dispatch(
                                                    addToCart(item.product, Number(e.target.value))
                                                    )
                                                }
                                            >
                                                {[...Array(item.countInStock).keys()].map((x) => (
                                                    <option key={x + 1} value={x + 1}>
                                                    {x + 1}
                                                    </option>
                                                ))}
                                            </select>
                                        </td>
                                        <td>{item.price * item.qty} VNĐ</td>
                                        <td>
                                            <button
                                                type="button"
                                                onClick={() => removeFromCartHandler(item.product)}
                                            >
                                                Xóa
                                            </button>
                                        </td>
                                    </tr>
                                ))}                                
                            </table>
                            <div class="total-price">
                                <table>
                                    <tr>
                                        <td>Tổng Tiền</td>
                                        <td>({cartItems.reduce((a,c) => a + c.qty, 0)} item) : {cartItems.reduce((a,c) => a + c.price * c.qty, 0)} VNĐ</td>
                                    </tr>
                                    <tr>
                                        <td>Thuế</td>
                                        <td>50000 VNĐ</td>
                                    </tr>
                                    <tr>
                                        <td>Tổng thanh toán</td>
                                        <td>350000 VNĐ</td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                        <button
                                            type="button"
                                            onClick={checkoutHandler}
                                            className="primary block"
                                            disabled={cartItems.length === 0}
                                        >
                                            Thanh toán
                                        </button>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        )
                        }                        
                </div>

            </div>
        </div>
    )
}
