import React, { Component } from 'react';
import { useParams } from 'react-router-dom';
import { Nav, Button } from 'react-bootstrap';


class GitHubUser extends Component {

    constructor(props) {
        super(props);
        // this.handleClick = this.handleClick.bind(this);
    }

    // handleClick(e) {
    //     this.props.history.push("/github");
    // }

    render() {
        const { id, login } = this.props.params;
        return (
            <div>
                <h1>User Login: {login}</h1>
                <h2>User Id: {id}</h2>`
                <Nav.Link href="/github">
                    <Button>
                        Go to GitHub Users
                    </Button>
                </Nav.Link>

            </div>
        );
    }
}

export default (props) => (
    <GitHubUser
        {...props}
        params={useParams()}
    />
);