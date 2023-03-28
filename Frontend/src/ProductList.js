import React from "react"
import Button from "./Button";




class ProductList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            products: typeof props.products === 'undefined' ? [] : props.products
        };
    }

    componentDidMount() {
        if (this.state.products == null || this.state.products.length == 0) {
            fetch("/product/")
                .then(response => response.json())
                .then(data => this.setState({products: data}));
        }
    }

    removeproduct(productId, listIndex){
        fetch("/product/delete?id=" + productId, { method:"DELETE"})
            .then(() => {
                this.setState(({ products }) => {
                    const tempproducts = [...products];
                    tempproducts.splice(listIndex,1);
                    return { products: tempproducts };
                });
            });
    }
   
    updateproduct() {
        // Simple PUT request with a JSON body using fetch
        const requestOptions = {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ title: 'React PUT Request Example' })
        };
        fetch('/product/', requestOptions)
            .then(response => response.json())
            .then(data => this.setState({ productId: data.id }));
    }
    render(){
        return (
            <table>
                <thead>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Eancode</th>
                </thead>
                <tbody>
                 {this.state.products.map((product, listIndex)=>(
                    <tr key={product.id} > 
                     <td>{product.id}</td>
                     <td>{product.name}</td>
                     <td>{product.category}</td>
                     <td>{product.price}</td>
                     <td>{product.eancode}</td>
                    <td>
                    <Button 
                            label="delete" 
                            key={"delete_"+product.id} 
                            onClick={() => this.removeproduct(product.id, listIndex)} />
                    </td>
                    </tr> ))}
                </tbody>
            </table>
         );
        }; 
    }


export default ProductList;