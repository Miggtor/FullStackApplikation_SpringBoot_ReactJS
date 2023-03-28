import React from 'react';

class CustomerForm extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            vorname:'',
            nachname:'',
            mobil:'',
            email:'',
            aboutme:''
        };

        this.handleVorname = this.handleVorname.bind(this);
        this.handleNachname = this.handleNachname.bind(this);
        this.handleMobil = this.handleMobil.bind(this);
        this.handleEmail = this.handleEmail.bind(this);
        this.handleAboutme = this.handleAboutme.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleVorname(event){
        this.setState({vorname: event.target.value});
    }
    
    handleNachname(event){
        this.setState({nachname: event.target.value});
    }
    
    handleMobil(event){
        this.setState({mobil: event.target.value});
    }
    handleEmail(event){
        this.setState({email: event.target.value});
        }
    handleAboutme(event){
        this.setState({aboutme: event.target.value});
    }

    

    handleSubmit(event){
        event.preventDefault();
        
        /*const requestOptions = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(this.state)
        };*/
        var details = {
            'vorname':this.state.vorname,
            'nachname':this.state.nachname,
            'mobil':this.state.mobil, 
            'email':this.state.email,
            'aboutme': this.state.aboutme
            }
        
            var formBody = [];
            for (var property in details) {
              var encodedKey = encodeURIComponent(property);
              var encodedValue = encodeURIComponent(details[property]);
              formBody.push(encodedKey + "=" + encodedValue);
            }
            formBody = formBody.join("&");

            fetch("/customer/add", {
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
                    <label>Vorname</label>
                    <input type="text" value={this.state.vorname} onChange={this.handleVorname} minlength="3" maxlength="50" required></input>
                </div>
                <div>
                    <label>Nachname</label>
                    <input type="text" value={this.state.nachname} onChange={this.handleNachname} minlength="3" maxlength="50" required></input>
                </div>
                <div>
                    <label>Mobil</label>
                    <input type="text" value={this.state.mobil} onChange={this.handleMobil} minlength="3" maxlength="50" required></input>
                </div>
                <div>
                    <label>Email</label>
                    <input type="text" value={this.state.email} onChange={this.handleEmail} minlength="3" maxlength="50" required></input>
                </div>
                <div>
                    <label>Über mich</label>
                    <input type="text" value={this.state.aboutme} onChange={this.handleAboutme} minlength="3" maxlength="50" required></input>
                </div>
                <div>
                    <input type="submit" value="Send"/>
                </div>
            </form>
        );
    }
}

export default CustomerForm;