import React, { useState } from "react";
import NameForm from "./NameForm";

function PersonName() {
  const [name, setName] = useState("");

  return (
    <div className="container flex flex-col bg-slate-200 flex mx-auto ms-3 mt-2 mb-2 drop-shadow p-6">
      <NameForm onNewName={setName} />
      <div className="container my-2 mt-5 p-5 border-t border-gray-300">
        <p className="text-center text-slate-900 capitalize font-mono font medium text-5xl">
          {name}
        </p>
      </div>
    </div>
  );
}

export default PersonName;
