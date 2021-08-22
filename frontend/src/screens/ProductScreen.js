import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Rating from '../components/Rating';
import {Link} from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import LoadingBox from '../components/LoadingBox';
import MessageBox from '../components/MessageBox';
import { detailsProduct } from '../actions/ProductAction';
import Navbar from '../components/Navbar';
import RelatedProduct from '../components/RelatedProduct';

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
            <Navbar></Navbar>
            <div className="small-container single-product">
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
            <RelatedProduct></RelatedProduct>
            
        </div>
    )
}
