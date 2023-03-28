import React from 'react';
import { Link } from 'react-router-dom';

class GlobalNavigation extends React.Component{
    constructor(props){
        super(props);
    }

    render(){
        return(
          <nav>
            <ul>
              <li>
                <Link to="/">Home</Link>
              </li>
              <li>
                <Link to="/products">Products</Link>
              </li>
              <li>
                <Link to="/productform">ProductsForm</Link>
              </li>
              <li>
                <Link to="/customerlist">Customer</Link>
              </li>
              <li>
                <Link to="/customerform">Customer Form</Link>
              </li>
              <li>
                <Link to="/shoporder">Shoporder</Link>
              </li>
              <li>
                <Link to="/shoporderform">ShopOrder Form</Link>
              </li>
              <li>
                <Link to="/itemorder">Itemorder</Link>
              </li>
              
              <li>
                <Link to="/itemorderform">Itemorder Form</Link>
              </li>
            </ul>
          </nav>
        )
    }
}

export default GlobalNavigation;