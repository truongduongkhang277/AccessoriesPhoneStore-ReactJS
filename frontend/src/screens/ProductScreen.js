import React from 'react'
import Rating from '../components/Rating';
import {Link} from 'react-router-dom';
import data from '../data'

export default function ProductScreen(props) {
    // lấy sản phẩm mà id truyền từ props trùng với id ở data
    const product = data.products.find((x) => x._id === props.match.params.id);

    // nếu không có sản phẩm, trả thông báo null
    if(!product) {
        return <div>Product Not Found !!! </div>
    }

    return (
        <div>
            <div class="container">
                <div class="navbar">
                    <div class="logo">
                        <a href="/"><img src="../images/logo.png" alt="Logo Store" width="125px"></img></a>
                    </div>
                    <nav>
                        <ul id = "MenuItems">
                            <li><a href="/">Home</a></li>
                            <li><a href="product.html">Product</a></li>
                            <li><a href="">About</a></li>
                            <li><a href="">Contact</a></li>
                            <li><a href="account.html">Account</a></li>
                        </ul>
                    </nav>
                    <a href="cart.html"><img src="../images/cart.png" alt="icon cart" class="cart-icon"></img></a>
                    <img src="../images/menu.png" alt="icon menu" class="menu-icon" onclick="menutoggle()"></img>
                </div>
            </div>    

            <div class="small-container single-product">                
                <Link to="/">Back to home</Link>
                <div class="row">
                    <div class="col-2">
                        <img src={product.image} alt ={product.name}></img>
                        <div class="small-img-row">
                            <div class="small-img-col">
                                <img src="../images/gallery-1.jpg" alt="mini image product" width="100%" class="small-img"></img>
                            </div>
                            <div class="small-img-col">
                                <img src="../images/gallery-2.jpg" alt="mini image product" width="100%" class="small-img"></img>
                            </div>
                            <div class="small-img-col">
                                <img src="../images/gallery-3.jpg" alt="mini image product" width="100%" class="small-img"></img>
                            </div>
                            <div class="small-img-col">
                                <img src="../images/gallery-4.jpg" alt="mini image product" width="100%" class="small-img"></img>
                            </div>
                        </div>
                    </div>
                    <div class="col-2">
                        <p>Home / {product.category}</p>
                        <h2>{product.name}</h2>
                        <br/>
                        <Rating rating ={product.rating} numReviews = {product.numReviews}></Rating>
                        <h4>{product.price}</h4>
                        <select>
                            <option>Select Size</option>
                            <option>XXL</option>
                            <option>XL</option>
                            <option>Large</option>
                            <option>Medium</option>
                            <option>Small</option>
                        </select>
                        <div>
                            <h4>Status </h4>
                            <div>{product.countInStock > 0 ? (<span className="success"> In Stock </span>):(<span className="error"> Unavailable </span>) }</div>
                        </div>
                        <input type="number" value="1"></input>
                        <a href="" class="btn">Add To Cart</a>
                        <h3>
                            Product Details 
                            <i class="fa fa-indent" aria-hidden="true"> </i>
                        </h3>
                        <br/>
                        <p>{product.description}</p>
                    </div>
                </div>
            </div>

            <div class="small-container">
                <div class="row row-2">
                    <h2>Related Products</h2>
                    <p>View More</p>
                </div>
            </div>

            <div class="category">
                <div class="small-container">

                    <div class="row">
                        <div class="col-4">
                            <img src="../images/product-9.jpg" alt="product 9 image"></img>
                            <h4>Red Printed T-Shirt</h4>
                            <div class="rating">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half" aria-hidden="true"></i>
                            </div>
                            <p>100000VNĐ</p>
                        </div>
                        <div class="col-4">
                            <img src="../images/product-10.jpg" alt="product 10 image"></img>
                            <h4>Red Printed T-Shirt</h4>
                            <div class="rating">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half" aria-hidden="true"></i>
                            </div>
                            <p>100000VNĐ</p>
                        </div>
                        <div class="col-4">
                            <img src="../images/product-11.jpg" alt="product 11 image"></img>
                            <h4>Red Printed T-Shirt</h4>
                            <div class="rating">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half" aria-hidden="true"></i>
                            </div>
                            <p>100000VNĐ</p>
                        </div>                
                        <div class="col-4">
                            <img src="../images/product-12.jpg" alt="product 12 image"></img>
                            <h4>Red Printed T-Shirt</h4>
                            <div class="rating">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half" aria-hidden="true"></i>
                            </div>
                            <p>100000VNĐ</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="footer">
                <div class="container">
                    <div class="row">
                        <div class="footer-col-1">
                            <img src="../images/logo-white.png" alt="logo footer"></img>
                            <p>Our purpose is to sustainably Make the Pleasure and Benefits of Sports Accessible to the Many</p>
                        </div>
                        <div class="footer-col-2">
                            <h3>Useful Links</h3>
                            <ul>
                                <li>Coupons</li>
                                <li>Return Policy</li>
                                <li>Join Affiliate</li>
                            </ul>
                        </div>
                        <div class="footer-col-3">
                            <h3>Follow Us</h3>
                            <ul>
                                <li>Facebook</li>
                                <li>Instagram</li>
                                <li>Youtube</li>
                            </ul>
                            
                        </div>
                    </div>
                    <hr/>
                    <div class="create">
                        <p>Design By Trương Dương Khang - MSSV 1811546141</p>
                    </div>
                </div>
            </div>
        </div>
    )
}
