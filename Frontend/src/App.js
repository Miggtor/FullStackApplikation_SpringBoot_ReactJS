import './App.css';
import { 
  Routes,
  Route,
  Outlet
} from 'react-router-dom'

import Home from './Home.js';
import GlobalNavigation from './GlobalNavigation';
import ProductForm from './ProductForm';
import ProductList from './ProductList';
import CustomerForm from './Customerform';
import CustomerList from './CustomerList';
import ShopOrderList from './ShopOrderList';
import CustomerUpdate from './CustomerUpdate';
import ItemOrderList from './ItemOrderList';
import ShopOrderForm from './ShopOrderForm';
import ItemOrderForm from './ItemOrderForm';
function App(props) {
  
  return (
    
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<Home />} />
        <Route path="/products" element={<ProductList />}/>
        <Route path="/customerList" element={<CustomerList />}/>
        <Route path="/customerform" element={<CustomerForm />}/>
        <Route path="/customer/update:id" element={<CustomerForm />}/>
        <Route path="/productform" element={<ProductForm />}/>
        <Route path="/shoporder" element={<ShopOrderList />}/>
        <Route path="/shoporderform" element={<ShopOrderForm />}/>
        <Route path="/itemorder" element={<ItemOrderList />}/>
        <Route path="/itemorderform" element={<ItemOrderForm />}/>
      </Route>
      
      </Routes>
  );
}


function Layout(){
  return (
    <div className="App">
      <GlobalNavigation />
      <div className="content">
        <header className="App-header">
          <h1>Blendshop</h1>
          <hr/>
          <Outlet /> 
          <hr/>
        </header>
      </div>
    </div>
  );
}

export default App;
