import React from 'react'
import { addToCart } from '../actions/CartAction';
import { useDispatch } from 'react-redux';
import { useEffect } from 'react';

export default function CartScreen(props) {
    // truyền vào giá trị id sản phẩm
    const productId = props.match.params.id;
    // lấy số lượng truyền vào qua sự kiện thêm vào giỏ hàng
    const qty = props.location.search ? Number(props.location.search.split('=')[1]):1;

    const dispatch = useDispatch();

    useEffect(() => {
        if(productId){
            dispatchEvent(addToCart(productId, qty));
        }
    }, [dispatch, productId, qty]);

    return (
        <div>
            Cart screen
            <br/>
            add to cart : product Id : {productId} : quantity : {qty}
        </div>
    )
}
