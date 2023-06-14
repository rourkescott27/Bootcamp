import React, { Component } from "react";
import AddProduct from './AddProduct';
import { Table } from 'reactstrap';

class Cart extends Component {
    render() {
        return (
            <div className="container">
                <Table>
                    <thead>
                        <tr>
                            <th align="center">Product Name</th>
                            <th align="center">Product Price</th>
                            <th>#</th>
                        </tr>
                    </thead>
                    {/* ****** */}
                    <AddProduct addProduct={this.props.onAddProduct} />
                    <tbody>
                        {this.props.productCart.map(productData => (
                            <tr key={productData.productName}>
                                <td>{productData.productName}</td>
                                <td>{productData.productPrice}</td>
                                <td onClick={() =>
                                    this.props.onDeleteProduct(productData)}>Remove</td>
                            </tr>
                        ))}
                    </tbody>
                </Table>
                <span>Total Amount: {this.props.totalCost}</span>
            </div>
        );
    }
};
export default Cart;