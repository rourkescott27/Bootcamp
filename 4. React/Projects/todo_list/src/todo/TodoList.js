import React, { Component } from "react";

class TodoList extends Component {

    render() {
        return (
            <ul className="list-group list-group-flush">
                {
                    this.props.items.map((value, index) => {
                        return (
                            <React.Fragment key={index}>
                                <li className="list-group-item bg-light d-flex justify-content-between">
                                    {value}
                                    <br />
                                    <button className="btn text-danger badge" onClick={() => { this.props.deleteTodo(index) }}>
                                        x
                                    </button>
                                </li>
                            </React.Fragment>
                        )
                    })
                }

            </ul>
        );
    }
}

export default TodoList;