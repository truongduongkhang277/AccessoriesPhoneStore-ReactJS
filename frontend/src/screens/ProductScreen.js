import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Rating from '../components/Rating';
import {Link} from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import LoadingBox from '../components/LoadingBox';
import MessageBox from '../components/MessageBox';
import { detailsProduct } from '../actions/ProductAction';

export default function ProductScreen(props) {

    const dispatch = useDispatch();
    // mỗi lần thay đổi số lượng sẽ là 1 đơn vị
    const [qty, setQty] = useState(1);
    // lấy id truyền vào
    const productId = props.match.params.id;
    // từ giá trị file store.js, lấy reducer tương ứng
    const productDetails = useSelector(state => state.productDetails);
    const {loading, error, product} = productDetails;

    useEffect(() => {
        dispatch(detailsProduct(productId));
    }, [dispatch, productId]);

    // sự kiện thêm vào giỏ hàng
    const addToCartHandler = () => {
        props.history.push(`/cart/${productId}?quantity=${qty}`);
    }

    return (
        <div>
            <div className="container">
                <div className="navbar">
                    <div className="logo">
                        <a href="/"><img src="../images/logo.png" alt="Logo Store" width="125px"></img></a>
                    </div>
                    <nav>
                        <ul id = "MenuItems">
                            <li><a href="/">Home</a></li>
                            <li><a href="product.html">Product</a></li>
                            <li><a href="/">About</a></li>
                            <li><a href="/">Contact</a></li>
                            <li><a href="account.html">Account</a></li>
                        </ul>
                    </nav>
                    <a href="cart.html"><img src="../images/cart.png" alt="icon cart" className="cart-icon"></img></a>
                    <img src="../images/menu.png" alt="icon menu" className="menu-icon"></img>
                </div>
            </div>    
            <div className="small-container  single-product">
                {loading ? (<LoadingBox></LoadingBox>)
                :
                error? (<MessageBox variant="danger">{error}</MessageBox>) 
                :(
                    <div>
                        <Link to="/">Back to home</Link>
                    <div className="row">
                        <div className="col-2">
                            <img src={product.image} alt ={product.name}></img>
                        </div>
                        <div className="col-2">
                            <p>Trang chủ / {product.category.name}</p>
                            <h2>{product.name}</h2>
                            <br/>
                            <h4>
                                Giá: {product.price} VNĐ
                            </h4>
                            <div>
                                <h4>Trạnh thái </h4>
                                <h4>{product.countInStock > 0 ? (<span className="success"> Đang bán </span>):(<span className="error"> Hết hàng </span>) }</h4>
                            </div>
                            {product.countInStock>0 && (
                                <div>                                    
                                    <div className="row">
                                        <h4>Số lượng</h4>
                                        <h4>
                                            {/* thiết lập sự kiện tăng giảm số lượng sản phẩm */}
                                            <select value={qty} onChange={(e) => setQty(e.target.value)}>
                                                {[...Array(product.countInStock).keys()].map(
                                                    (x) => (<option key={x + 1} value={x + 1}>
                                                                {x + 1}
                                                            </option>)
                                                )}
                                            </select>
                                        </h4>
                                    </div>                               
                                    <a className="btn" onClick={addToCartHandler}>
                                        Thêm vào giỏ hàng
                                    </a>                                    
                                </div>
                            )}
                            
                            <h3>
                                Chi tiết sản phẩm 
                                <i className="fa fa-indent" aria-hidden="true"> </i>
                            </h3>
                            <br/>
                            <p>{product.description}</p>
                            <br/>
                            <Rating rating ={product.rating} numReviews = {product.numReviews}></Rating>
                        </div>
                    </div>
                </div>
                )
                }                
            </div>

            <div className="small-container">
                <div className="row row-2">
                    <h2>Related Products</h2>
                    <p>View More</p>
                </div>
            </div>

            <div className="category">
                <div className="small-container">

                    <div className="row">
                        <div className="col-4">
                            <img src="../images/product-9.jpg" alt="product 9 image"></img>
                            <h4>Red Printed T-Shirt</h4>
                            <div className="rating">
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star-half" aria-hidden="true"></i>
                            </div>
                            <p>100000VNĐ</p>
                        </div>
                        <div className="col-4">
                            <img src="../images/product-10.jpg" alt="product 10 image"></img>
                            <h4>Red Printed T-Shirt</h4>
                            <div className="rating">
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star-half" aria-hidden="true"></i>
                            </div>
                            <p>100000VNĐ</p>
                        </div>
                        <div className="col-4">
                            <img src="../images/product-11.jpg" alt="product 11 image"></img>
                            <h4>Red Printed T-Shirt</h4>
                            <div className="rating">
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star-half" aria-hidden="true"></i>
                            </div>
                            <p>100000VNĐ</p>
                        </div>                
                        <div className="col-4">
                            <img src="../images/product-12.jpg" alt="product 12 image"></img>
                            <h4>Red Printed T-Shirt</h4>
                            <div className="rating">
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star-half" aria-hidden="true"></i>
                            </div>
                            <p>100000VNĐ</p>
                        </div>
                    </div>
                </div>
            </div>

            <div className="footer">
                <div className="container">
                    <div className="row">
                        <div className="footer-col-1">
                            <img src="../images/logo-white.png" alt="logo footer"></img>
                            <p>Our purpose is to sustainably Make the Pleasure and Benefits of Sports Accessible to the Many</p>
                        </div>
                        <div className="footer-col-2">
                            <h3>Useful Links</h3>
                            <ul>
                                <li>Coupons</li>
                                <li>Return Policy</li>
                                <li>Join Affiliate</li>
                            </ul>
                        </div>
                        <div className="footer-col-3">
                            <h3>Follow Us</h3>
                            <ul>
                                <li>Facebook</li>
                                <li>Instagram</li>
                                <li>Youtube</li>
                            </ul>
                            
                        </div>
                    </div>
                    <hr/>
                    <div className="create">
                        <p>Design By Trương Dương Khang - MSSV 1811546141</p>
                    </div>
                </div>
            </div>
        </div>
    )
}
