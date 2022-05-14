import React, { Component } from 'react'

export class EmpRow extends Component {

    constructor (props) {
        super();
        this.empId = props.empId;
        this.empSal = props.empSal;
        this.empName = props.empName;
    }

    render() {
        return (
            <>
            <tr className="border-b border-gray-200">
                <td>{this.empId}</td>
                <td>{this.empName}</td>
                <td>{this.empSal}</td>
            </tr>
            </>
        )
    }
}

export default EmpRow
