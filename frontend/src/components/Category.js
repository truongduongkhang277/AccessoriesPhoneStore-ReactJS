import React from 'react'

export default function Category() {
    return (
        <div className="category">
            <div className="small-container">
                <h2 className="title">Cateogry</h2>
                <div className="row">
                    <div className="col-3">
                        <img src="../images/category-1.jpg" alt="category 1 image"></img>
                    </div>
                    <div className="col-3">
                        <img src="../images/category-2.jpg" alt="category 2 image"></img>
                    </div>
                    <div className="col-3">
                        <img src="../images/category-3.jpg" alt="category 3 image"></img>
                    </div>
                </div>            
            </div>
        </div>
    )
}
