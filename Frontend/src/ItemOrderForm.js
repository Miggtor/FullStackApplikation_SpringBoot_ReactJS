import React from 'react';

class ItemOrderForm extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            shopOrder_id:'',
            quantity:'',
            product_id:''
        };

        this.handleShopOrder_id = this.handleShopOrder_id.bind(this);
        this.handleQuantity = this.handleQuantity.bind(this);
        this.handleProduct_id = this.handleProduct_id.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleShopOrder_id(event){
        this.setState({shopOrder_id: event.target.value});
    }
    
    handleQuantity(event){
        this.setState({quantity: event.target.value});
    }
    
    handleProduct_id(event){
        this.setState({product_id: event.target.value});
        }

    

    handleSubmit(event){
        event.preventDefault();
        
        /*const requestOptions = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(this.state)
        };*/
        var details = {
            'shopOrder_id':this.state.shopOrder_id,
            'quantity':this.state.quantity,
            'product_id':this.state.product_id
            }
        
            var formBody = [];
            for (var property in details) {
              var encodedKey = encodeURIComponent(property);
              var encodedValue = encodeURIComponent(details[property]);
              formBody.push(encodedKey + "=" + encodedValue);
            }
            formBody = formBody.join("&");

            fetch("/orderitem/add", {
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
                    <label>shopOrder_id</label>
                    <input type="number" value={this.state.shopOrder_id} onChange={this.handleShopOrder_id} required ></input>
                </div>
                <div>
                    <label>quantity</label>
                    <input type="number" value={this.state.quantity} onChange={this.handleQuantity} min ="1" max="100" required></input>
                </div>
                <div>
                    <label>customer_id</label>
                    <input type="number" value={this.state.product_id} onChange={this.handleProduct_id} required></input>
                </div>
                <div>
                    <input type="submit" value="Send"/>
                </div>
            </form>
        );
    }
}

export default ItemOrderForm;