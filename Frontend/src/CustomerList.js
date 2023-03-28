import React from "react"
import { Link } from "react-router-dom";
import Button from "./Button";
import CustomerUpdate from "./CustomerUpdate";




class CustomerList extends React.Component {

    
    constructor(props) {
        super(props);
        this.state = {
            customers: typeof props.customers === 'undefined' ? [] : props.customers
        };
        
    }

    componentDidMount() {
        if (this.state.customers == null || this.state.customers.length == 0) {
            fetch("/customer/")
                .then(response => response.json())
                .then(data => this.setState({customers: data}));
        }
    }

    removeCustomer(customerId, listIndex){
        fetch("/customer/delete?id=" + customerId, { method:"DELETE"})
            .then(() => {
                this.setState(({ customers }) => {
                    const tempCustomers = [...customers];
                    tempCustomers.splice(listIndex,1);
                    return { customers: tempCustomers };
                });
            });
    }
/*
    selectCustomer(id){
        console.warn("function",customers[id-1])
        let item=customers[id-1];
    }
    */
  

  
    editCustomer(customerId, listIndex){
        this.props.history.push("/customer/delete?id=" + customerId)
    }
   

    render(){
        return (
            <table>
                <thead>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Adress</th>
                    <th>Email</th>
                    <th>City</th>
                    <th>Postcode</th>
                </thead>
                <tbody>
                 {this.state.customers.map((customer, listIndex)=>(
                    <tr key={customer.id} > 
                     <td>{customer.id}</td>
                     <td>{customer.name}</td>
                     <td>{customer.surname}</td>
                     <td>{customer.adress}</td>
                     <td>{customer.email}</td>
                     <td>{customer.city}</td>
                     <td>{customer.postcode}</td>
                    <td>
                    <Button 
                            label="delete" 
                            key={"delete_"+customer.id} 
                            onClick={() => this.removeCustomer(customer.id, listIndex)} />
                    </td>
                    </tr> ))}
                </tbody>
            </table>
         );
        }; 
    }


export default CustomerList;