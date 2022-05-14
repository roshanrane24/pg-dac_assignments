import React, { useState } from "react";

function NameForm(props) {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");

  const firstNameHandler = (e) => {
      setFirstName(e.target.value);
  }

  const lastNameHandler = (e) => {
      setLastName(e.target.value);
  }

  const submitHandler = (e) => {
    e.preventDefault();
    props.onNewName(firstName + " " + lastName);
  };

  return (
    <form onSubmit={submitHandler}>
      <div className="container font-mono ">
        <div className="flex flex-row p-2">
          <label
            for="firstName"
            className="block text-center pr-5 align-middle text-medium font-medium text-gray-700"
          >
            First Name
          </label>
          <input
            type="text"
            name="firstName"
            id="company-website"
            value={firstName}
            onChange={firstNameHandler}
            className="focus:ring-indigo-500 shadow-md focus:border-indigo-500 flex-1 block w-full rounded rounded-r-md sm:text-sm border-gray-300"
            placeholder=""
          />
        </div>
        <div className="flex flex-row p-2">
          <label
            for="lastName"
            className="block pr-7 align-middle text-medium font-medium text-gray-700"
          >
            Last Name
          </label>
          <input
            type="text"
            name="lastName"
            id="company-website"
            value={lastName}
            onChange={lastNameHandler}
            className="focus:ring-indigo-500 shadow-md focus:border-indigo-500 flex-1 block w-full rounded rounded-r-md sm:text-sm border-gray-300"
            placeholder=""
          />
        </div>
        <div className="justify-center">
        <button class="justify-center bg-blue hover:bg-gray-100 text-gray-800 font-semibold py-2 px-4 border border-gray-400 rounded shadow">
        Submit
        </button>
        </div>
      </div>
    </form>
  );
}

export default NameForm;
