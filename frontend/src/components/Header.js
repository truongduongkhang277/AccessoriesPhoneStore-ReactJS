import React from 'react'
import { Link } from 'react-router-dom';
import Navbar from './Navbar';

export default function Header() {
    return (               
        <div className="container">
            <Navbar></Navbar>
            <div className="row">
                <div className="col-2">
                    <h1>Give Your Phone<br /> A New Style !</h1>
                    <p>Success isn't always about greatness. It's about consistency. Consistent<br /> hard work gain success. Greatness will come.</p>
                    <Link to="/" className="btn">Explore Now &#8594;</Link>
                </div>
                <div className="col-2">
                    <img src="../images/image1.png" alt="banner"></img>
                </div>
            </div>
        </div>        
    )
}
