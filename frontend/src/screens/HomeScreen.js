import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import Product from '../components/Product'
import LoadingBox from '../components/LoadingBox';
import MessageBox from '../components/MessageBox';
import { listProducts } from './../actions/ProductAction';
import Category from './../components/Category';
import Offer from './../components/Offer';
import Testimonial from './../components/Testimonial';
import Header from './../components/Header';
import Brand from '../components/Brand';

export default function HomeScreen() {    

    const dispatch = useDispatch();
    
    // từ giá trị file store.js, lấy reducer tương ứng
    const productList = useSelector((state) => state.productList);
    const {loading, error, products} = productList ;

    useEffect(() => {
        dispatch(listProducts());
    }, [dispatch]);

    return (
        <div>
            <div className="header"> 
                <Header></Header>
            </div>

            <Category></Category>

            <div className="small-container">
                {loading ? (<LoadingBox></LoadingBox>)
                :
                error? (<MessageBox variant="danger">{error}</MessageBox>) 
                :(
                    <div>
                        <h2 className="title">Feadtured Products</h2>
                    
                        <div className="row">
                            {
                                // từ các sản phẩm lấy được từ api, hiển thị lên trang
                                products.map(
                                    product => (
                                        <Product key={product.id} product = { product }></Product>
                                    )
                                )
                            }
                        </div>
                    </div>
                )
                }
                
            </div>

            <Offer></Offer>

            <Testimonial></Testimonial>

            <Brand></Brand>

        </div>
    )
}
