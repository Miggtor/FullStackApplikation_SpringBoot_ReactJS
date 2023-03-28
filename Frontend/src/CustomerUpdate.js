import React from "react";
import { ReactDOM } from "react";

class CustomerUpdate extends React.Component {

	constructor(props) {
		super(props);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleSubmit(e) {
		e.preventDefault();
		const updatedCustomer = {};
		this.props.attributes.forEach(attribute => {
			updatedCustomer[attribute] = ReactDOM.findDOMNode(this.refs[attribute]).value.trim();
		});
		this.props.onUpdate(this.props.customer, updatedCustomer);
		window.location = "#";
	}

	render() {
		const inputs = this.props.attributes.map(attribute =>
			<p key={this.props.customer.entity[attribute]}>
				<input type="text" placeholder={attribute}
					   defaultValue={this.props.customer.entity[attribute]}
					   ref={attribute} className="field"/>
			</p>
		);

		const dialogId = "updateCustomer-" + this.props.customer.entity._links.self.href;

		return (
			<div key={this.props.customer.entity._links.self.href}>
				<a href={"#" + dialogId}>Update</a>
				<div id={dialogId} className="modalDialog">
					<div>
						<a href="#" title="Close" className="close">X</a>

						<h2>Update a customer</h2>

						<form>
							{inputs}
							<button onClick={this.handleSubmit}>Update</button>
						</form>
					</div>
				</div>
			</div>
		)
	}

};

export default CustomerUpdate;