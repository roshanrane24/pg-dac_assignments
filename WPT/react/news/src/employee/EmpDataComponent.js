import React, { Component } from "react";
import EmpRow from "./EmpRow";

export default class EmpDataComponent extends Component {
  empData = [];

  constructor(props) {
    super(props);
    this.empData = [
      { empId: 10, empName: "Eren", empSal: 5000 },
      { empId: 20, empName: "Tanjiro", empSal: 2500 },
      { empId: 30, empName: "Lufy", empSal: 1010920800 },
      { empId: 40, empName: "Naruto", empSal: 500500 },
      { empId: 50, empName: "Loid", empSal: 10005 },
    ];
  }

  render() {
    return (
      <div className="mx-auto">
        <div className="flex flex-col">
        <h1 className="text-3xl text-extrabold text-center m-5">
          Employee Data
        </h1>
        </div>
        <div className="flex justify-center w-full">
        <table className="m-5 w-full table-auto border border-gray-400">
          <thead className="border-b border-gray-300 bg-gray-200">
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
          </thead>
          <tbody className="text-center">
            {this.empData.map((emp) => (
              <EmpRow {...emp} />
            ))}
          </tbody>
        </table>
        </div>
      </div>
    );
  }
}
