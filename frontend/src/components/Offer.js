import React from 'react'
import { Link } from 'react-router-dom';

export default function Offer() {
    return (
        <div className="offer">
            <div className="small-container">
                <div className="row">
                    <div className="col-2">
                        <img src="../images/exclusive.png" alt="exclusive image" className="offer-image"></img>
                    </div>
                    <div className="col-2">
                        <p>Exclusive Available On Accessories Store</p>
                        <h1>Smart Band 4</h1>
                        <small>The Mi Smart Band 4 feature a 39.9% larger (than Mi Band 3) AMOLED color full-touch display with adjustable brightness, so everything is clear as can be.<br /></small>
                        <Link to="/" className="btn">Buy Now &#8594;</Link>
                    </div>
                </div>
            </div>
        </div>
    )
}
