import React from 'react';

class ShopOrderForm extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            date:'',
            paymentStatus:'',
            deliveryStatus:'',
            customer_id:''
        };

        this.handleDate = this.handleDate.bind(this);
        this.handlePaymentStatus = this.handlePaymentStatus.bind(this);
        this.handleDeliveryStatus = this.handleDeliveryStatus.bind(this);
        this.handleCustomer_id = this.handleCustomer_id.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleDate(event){
        this.setState({date: event.target.value});
    }
    
    handlePaymentStatus(event){
        this.setState({paymentStatus: event.target.value});
    }
    
    handleDeliveryStatus(event){
        this.setState({deliveryStatus: event.target.value});
    }
    handleCustomer_id(event){
        this.setState({customer_id: event.target.value});
        }

    

    handleSubmit(event){
        event.preventDefault();
        
        /*const requestOptions = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(this.state)
        };*/
        var details = {
            'date':this.state.date,
            'paymentStatus':this.state.paymentStatus,
            'deliveryStatus':this.state.deliveryStatus, 
            'customer_id':this.state.customer_id
            }
        
            var formBody = [];
            for (var property in details) {
              var encodedKey = encodeURIComponent(property);
              var encodedValue = encodeURIComponent(details[property]);
              formBody.push(encodedKey + "=" + encodedValue);
            }
            formBody = formBody.join("&");

            fetch("/order/add", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
                },
                body: formBody
            })
            formBody = [];
        /*fetch("/customer/add", requestOptions)
            .then(response => response.json())
            .then(jsonData => {
                // wir überprüfen die ID in der Konsole
                console.log(jsonData);
            });*/
    }

    render(){
        return(
            <form onSubmit={this.handleSubmit}>
                <div>
                    <label>date</label>
                    <input type="date" value={this.state.date} onChange={this.handleDate} required></input>
                </div> 
                <div>
                    <label>paymentStatus</label>
                    <input type="text" value={this.state.paymentStatus} onChange={this.handlePaymentStatus} minlength="3" maxlength="20" required></input>
                </div>
                <div>
                    <label>deliveryStatus</label>
                    <input type="text" value={this.state.deliveryStatus} onChange={this.handleDeliveryStatus} minlength="3" maxlength="20" required></input>
                </div>
                <div>
                    <label>customer_id</label>
                    <input type="number" value={this.state.customer_id} onChange={this.handleCustomer_id} required></input>
                </div>
                <div>
                    <input type="submit" value="Send"/>
                </div>
            </form>
        );
    }
}

export default ShopOrderForm;