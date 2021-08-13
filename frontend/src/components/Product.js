import React from 'react'
import Rating from './Rating';

export default function Product(props) {
    const { product } = props;
    return (
        <div key = {product._id} className="col-4">
            <a href={`/product/${product._id}`}>
                <img src={product.image} alt={product.name}></img>
            </a>
            <a href={`/product/${product._id}`}>
                <h4>{product.name}</h4>
            </a>
            <Rating rating ={product.rating} numReviews = {product.numReviews} ></Rating>
            <br />
            <h4>{product.price}</h4>
        </div>
    )
}
