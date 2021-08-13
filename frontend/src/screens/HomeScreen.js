import React from 'react'
import Product from '../components/Product'
import data from '../data'

export default function HomeScreen() {
    return (
        <div className="small-container">
            <h2 class="title">Feadtured Products</h2>
            
            <div className="row">
                {
                    data.products.map(
                        product => (
                            <Product key={product._id} product = { product }></Product>
                        )
                    )
                }
            </div>
        </div>

    )
}
