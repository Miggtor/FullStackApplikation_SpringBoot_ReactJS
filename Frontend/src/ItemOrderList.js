import React from "react"
import Button from "./Button";


class ItemOrderList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            orderitems: typeof props.orderitems === 'undefined' ? [] : props.orderitems
        };
    }

    componentDidMount() {
        if (this.state.orderitems == null || this.state.orderitems.length == 0) {
            fetch("/orderitem/")
                .then(response => response.json())
                .then(data => this.setState({orderitems: data}));
        }
    }

    removeorder(orderId, listIndex){
        fetch("/orderitem/delete?id=" + orderId, { method:"DELETE"})
            .then(() => {
                this.setState(({ orderitems }) => {
                    const temporderitems = [...orderitems];
                    temporderitems.splice(listIndex,1);
                    return { orderitems: temporderitems };
                });
            });
    }

    render(){
        return (
            <table>
                <thead>
                    <th>Id</th>
                    <th>Quantity</th>
                    <th>shopOrder Id</th>
                    <th>Date</th>
                    <th>Delivery Status</th>
                    <th>Payment Status</th>
                    <th>Customer Id</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Adress</th>
                    <th>City</th>
                    <th>Email</th>
                    <th>Postcode</th>
                </thead>
                <tbody>
                 {this.state.orderitems.map((orderitem, listIndex)=>(
                    <tr key={orderitem.id} > 
                     <td>{orderitem.id}</td>
                    <td>{orderitem.quantity}</td>
                    <td>{orderitem.shopOrder.id}</td>
                    <td>{orderitem.shopOrder.sqlDate}</td>
                    <td>{orderitem.shopOrder.deliveryStatus}</td>
                    <td>{orderitem.shopOrder.paymentStatus}</td>
                    <td>{orderitem.shopOrder.customer.id}</td>
                    <td>{orderitem.shopOrder.customer.name}</td>
                    <td>{orderitem.shopOrder.customer.surname}</td>
                    <td>{orderitem.shopOrder.customer.adress}</td>
                    <td>{orderitem.shopOrder.customer.city}</td>
                    <td>{orderitem.shopOrder.customer.email}</td>
                    <td>{orderitem.shopOrder.customer.postcode}</td>
                    <td>
                    <Button 
                            label="delete" 
                            key={"delete_"+orderitem.id} 
                            onClick={() => this.removeorder(orderitem.id, listIndex)} />
                    </td>
                    </tr> ))}
                </tbody>
            </table>
         );
        }; 
    }


export default ItemOrderList ;