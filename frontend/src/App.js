import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import ProductScreen from './screens/ProductScreen';
import HomeScreen from './screens/HomeScreen';

function App() {
  return (
    <BrowserRouter>
        <div>
            <div className="header">        
                <div className="container">
                    <div className="navbar">
                        <div className="logo">
                            <a href="/"><img src="./images/logo.png" alt="Logo Store" width="250px"></img></a>
                        </div>
                        <nav>
                            <ul id = "MenuItems">
                                <li><a href="/">Home</a></li>
                                <li><a href="/product">Product</a></li>
                                <li><a href="/about">About</a></li>
                                <li><a href="/contact">Contact</a></li>
                                <li><a href="/signin">Account</a></li>
                            </ul>
                        </nav>
                        <a href="/cart"><img src="./images/cart.png" alt="icon cart" className="cart-icon"></img></a>
                        <img src="./images/menu.png" alt="icon menu" className="menu-icon"></img>
                    </div>
                    <div className="row">
                        <div className="col-2">
                            <h1>Give Your Phone<br /> A New Style !</h1>
                            <p>Success isn't always about greatness. It's about consistency. Consistent<br /> hard work gain success. Greatness will come.</p>
                            <a href="/" className="btn">Explore Now &#8594;</a>
                        </div>
                        <div className="col-2">
                            <img src="./images/image1.png" alt="banner"></img>
                        </div>
                    </div>
                </div>        
            </div>
            <div className="category">
                <div className="small-container">
                    <h2 class="title">Cateogry</h2>
                    <div className="row">
                        <div className="col-3">
                            <img src="./images/category-1.jpg" alt="category 1 image"></img>
                        </div>
                        <div className="col-3">
                            <img src="./images/category-2.jpg" alt="category 2 image"></img>
                        </div>
                        <div className="col-3">
                            <img src="./images/category-3.jpg" alt="category 3 image"></img>
                        </div>
                    </div>            
                </div>
            </div>
            
            <Route path = "/" component={HomeScreen} exact></Route>
            <Route path = "/product/:id" component={ProductScreen} exact></Route>

            <div className="offer">
                <div className="small-container">
                    <div className="row">
                        <div className="col-2">
                            <img src="./images/exclusive.png" alt="exclusive image" className="offer-image"></img>
                        </div>
                        <div className="col-2">
                            <p>Exclusive Available On Accessories Store</p>
                            <h1>Smart Band 4</h1>
                            <small>The Mi Smart Band 4 feature a 39.9% larger (than Mi Band 3) AMOLED color full-touch display with adjustable brightness, so everything is clear as can be.<br /></small>
                            <a href="/" className="btn">Buy Now &#8594;</a>
                        </div>
                    </div>
                </div>
            </div>
            <div className="testimonial">
                <div className="small-container">
                    <div className="row">
                        <div className="col-3">                    
                            <i className="fa fa-quote-left" aria-hidden="true"></i>
                            <p>Lorem input is simply dummy text of the printing and typesetting industry. Lorem input has been the industry's standard dummy text ever.</p>
                            <div className="rating">
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star-half" aria-hidden="true"></i>
                            </div> 
                            <img src="./images/user-1.png" alt="user 1 image"></img>
                            <h3>Sean Parker</h3>
                        </div>
                        <div className="col-3">                    
                            <i className="fa fa-quote-left" aria-hidden="true"></i>
                            <p>Lorem input is simply dummy text of the printing and typesetting industry. Lorem input has been the industry's standard dummy text ever.</p>
                            <div className="rating">
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star-half" aria-hidden="true"></i>
                            </div> 
                            <img src="./images/user-2.png" alt="user 2 image"></img>
                            <h3>Mike Smith</h3>
                        </div>
                        <div className="col-3">                    
                            <i className="fa fa-quote-left" aria-hidden="true"></i>
                            <p>Lorem input is simply dummy text of the printing and typesetting industry. Lorem input has been the industry's standard dummy text ever.</p>
                            <div className="rating">
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star" aria-hidden="true"></i>
                                <i className="fa fa-star-half" aria-hidden="true"></i>
                            </div> 
                            <img src="./images/user-3.png" alt="user 3 image"></img>
                            <h3>Mabel Joe</h3>
                        </div>
                    </div>
                </div>
            </div>
            <div className="brand">
                <div className="small-container">
                    <div className="row">
                        <div className="col-5">
                            <img src="./images/logo-coca-cola.png" alt=""></img>
                        </div>
                        <div className="col-5">
                            <img src="./images/logo-godrej.png" alt=""></img>
                        </div>
                        <div className="col-5">
                            <img src="./images/logo-oppo.png" alt=""></img>
                        </div>
                        <div className="col-5">
                            <img src="./images/logo-paypal.png" alt=""></img>
                        </div>
                        <div className="col-5">
                            <img src="./images/logo-philips.png" alt=""></img>
                        </div>
                    </div>
                </div>
            </div>
            <div className="footer">
                <div className="container">
                    <div className="row">
                        <div className="footer-col-1">
                            <img src="./images/logo-white.png" alt="logo footer"></img>
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
    </BrowserRouter>
  );
}

export default App;
