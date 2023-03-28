import React from "react"
import Button from "./Button";


class ShopOrderList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            shoporders: typeof props.shoporders === 'undefined' ? [] : props.shoporders
        };
    }

    componentDidMount() {
        if (this.state.shoporders == null || this.state.shoporders.length == 0) {
            fetch("/order/")
                .then(response => response.json())
                .then(data => this.setState({shoporders: data}));
        }
    }

    removeshoporder(shoporderId, listIndex){
        fetch("/order/delete?id=" + shoporderId, { method:"DELETE"})
            .then(() => {
                this.setState(({ shoporders }) => {
                    const tempshoporders = [...shoporders];
                    tempshoporders.splice(listIndex,1);
                    return { shoporders: tempshoporders };
                });
            });
    }
   

    render(){
        return (
            <table>
                <thead>
                    <th>Id</th>
                    <th>Date</th>
                    <th>Delivery Status</th>
                    <th>Payment Status</th>
                    <th>Customer Id</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Adress</th>
                    <th>Email</th>
                    <th>City</th>
                    <th>Postcode</th>
                </thead>
                <tbody>
                 {this.state.shoporders.map((shoporder, listIndex)=>(
                    <tr key={shoporder.id} > 
                     <td>{shoporder.id}</td>
                    <td>{shoporder.sqlDate}</td>
                    <td>{shoporder.deliveryStatus}</td>
                    <td>{shoporder.paymentStatus}</td>
                    <td>{shoporder.customer.id}</td>
                    <td>{shoporder.customer.name}</td>
                    <td>{shoporder.customer.surname}</td>
                    <td>{shoporder.customer.adress}</td>
                    <td>{shoporder.customer.email}</td>
                    <td>{shoporder.customer.city}</td>
                    <td>{shoporder.customer.postcode}</td>
                    <td>
                    <Button 
                            label="delete" 
                            key={"delete_"+shoporder.id} 
                            onClick={() => this.removeshoporder(shoporder.id, listIndex)} />
                    </td>
                    </tr> ))}
                </tbody>
            </table>
         );
        }; 
    }


export default ShopOrderList ;