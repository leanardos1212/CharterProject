import React, { Component } from "react";
import ReactDOM from 'react-dom';
import UserList from './UserList';
import '../css/Main.css';


class Main extends Component {
    constructor(props) {
        super(props)
        this.state = {
            users: [] ,
            transactions: []
        }
    }

    componentDidMount() {
        this.fetchUsers();
    }

    fetchUsers() {
        fetch("/api/users")
            .then(res => res.json())
            .then(
                (response) => {
                    this.setState({
                        users: response,
                        transactions: response
                    });
                },
                (error) => {
                    alert(error);
                }
            )
    }

    handleSubmit(evt) {
        evt.preventDefault();
        fetch("/api/users", {
            method: "POST",
            body: new FormData(evt.target)
        }).then((response) => {
                if (response.ok) {
                    this.fetchUsers();
                } else {
                    alert("Failed to create user");
                }
            }
        ).catch((error) => {
            alert(error);
        });
        evt.target.reset();
        return false;
    }

    render() {
        return (
            <div id="main">
                <h1>Reward Points</h1>
                <UserList users={this.state.users}/>
                <form onSubmit={this.handleSubmit.bind(this)}>
                    <div class="row">
                        <div class="col">
                            <input id="name" name="name" type="text" placeholder="Enter name"/>
                        </div>
                        <div class="col">
                            <input id="transaction" name="transaction" placeholder="$0.00"/>
                        </div>
                        <div class="col">
                            <button class="btn btn-primary" type='submit'>Create</button>
                        </div>
                    </div>
                </form>
            </div>
        );
    }
}

ReactDOM.render(
    <Main />,
    document.getElementById('react-mountpoint')
);
