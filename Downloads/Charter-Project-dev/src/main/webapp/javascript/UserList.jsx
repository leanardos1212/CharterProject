import React, { Component } from "react";




class UserList extends Component {
    render() {
        if (!this.props.users) {
            return <div>No Users yet...</div>
        }
        return (
        <table class="table table-striped">
           <thead class="thead-light">
            <tr>
                <th>Name</th>
                <th>Reward Points</th>
                <th>Total Purchases</th>
            </tr>
            </thead>
            {this.props.users.map(user => (
            <React.Fragment>
            <tr id="user-list">
                <td key={user.id}>
                    {user.name}

                </td>
                <td>
                    {user.rewardPoints}
                </td>
                <td>
                    {user.totalPurchases}
                </td>
                        <td key={transaction.id}>
                {transaction.total}
                  </td>
                     <td>
            {transaction.points}
                </td>
            </tr>
            </React.Fragment>
                ))}

        </table>

        );
    }
}

export default UserList;