import React from 'react'
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

export default function Navbar() {

    // từ giá trị file store.js lấy giá trị sản phâm thêm vào giỏ tương ứng
    const cart = useSelector((state) => state.cart);
    const { cartItems } = cart;

    const menutoggle = () => {
        
    };

    return (
        <div className="navbar">
            <div className="logo">
                <Link to="/"><img src="../images/logo.png" alt="Logo Store" width="250px"></img></Link>
            </div>
            <nav>
                <ul id = "MenuItems">
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="product.html">Product</Link></li>
                    <li><Link to="/">About</Link></li>
                    <li><Link to="/">Contact</Link></li>
                    <li><Link to="/signin">Account</Link></li>
                </ul>
            </nav>
            <Link to="/cart">
                <div className='cart-icon'>
                    
                    {cartItems.length > 0 && (
                        <span className="cart-items">{cartItems.length}</span>
                    )}
                    <img src="../images/cart.png" alt="icon cart" className="cart-icon"></img> 
                    
                </div>
            </Link>
            <img src="../images/menu.png" alt="icon menu" className="menu-icon" onClick={menutoggle}></img>
        </div>
    )
}
