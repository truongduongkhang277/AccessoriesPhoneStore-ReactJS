import React from 'react'
import Rating from './Rating';
import { Link } from 'react-router-dom';

export default function Product(props) {
    const { product } = props;
    return (
        <div key = {product.id} className="col-4">
            <Link href={`/product/${product.id}`}>
                <img src={product.image} alt={product.name}></img>
            </Link>
            <Link href={`/product/${product.id}`}>
                <h4>{product.name}</h4>
            </Link>
            <Rating rating ={product.rating} numReviews = {product.numReviews} ></Rating>
            <br />
            <h4>{product.price} VNĐ</h4>
        </div>
    )
}
