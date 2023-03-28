import React from 'react';

class ProductForm extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name:'',
            category:'',
            price:'',
            eancode:''
        };

        this.handleName = this.handleName.bind(this);
        this.handleCategory = this.handleCategory.bind(this);
        this.handlePrice = this.handlePrice.bind(this);
        this.handleEancode = this.handleEancode.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleName(event){
        this.setState({name: event.target.value});
    }
    
    handleCategory(event){
        this.setState({category: event.target.value});
    }
    
    handlePrice(event){
        this.setState({price: event.target.value});
    }
    handleEancode(event){
        this.setState({eancode: event.target.value});
        }
    handleSubmit(event){
        event.preventDefault();
        
        /*const requestOptions = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(this.state)
        };*/
        var details = {
            'name':this.state.name,
            'category':this.state.category,
            'price':this.state.price,
            'eancode':this.state.eancode
        }
        
            var formBody = [];
            for (var property in details) {
              var encodedKey = encodeURIComponent(property);
              var encodedValue = encodeURIComponent(details[property]);
              formBody.push(encodedKey + "=" + encodedValue);
            }
            formBody = formBody.join("&");

            fetch("/product/add", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
                },
                body: formBody
            })
            formBody = [];
        /*fetch("/product/add", requestOptions)
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
                    <label>Name</label>
                    <input type="text" value={this.state.name} onChange={this.handleName} minlength="3" maxlength="50" required></input>
                </div>
                <div>
                    <label>Category</label>
                    <input type="text" value={this.state.category} onChange={this.handleCategory} minlength="3" maxlength="50" required></input>
                </div>
                <div>
                    <label>Price</label>
                    <input type="number" value={this.state.price} onChange={this.handlePrice} required></input>
                </div>
                <div>
                    <label>Eancode</label>
                    <input type="number" value={this.state.eancode} onChange={this.handleEancode} min="1" max="200" required></input>
                </div>
                <div>
                    <input type="submit" value="Send"/>
                </div>
            </form>
        );
    }
}

export default ProductForm;