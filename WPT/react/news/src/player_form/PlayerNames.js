import React, { useState } from "react";
import PlayerForm from "./PlayerForm";

function PlayerNames() {
  const [names, setNames] = useState([]);

  const addPlayer = (player) => {
    setNames(names.concat([player]));
  };

  const deletePlayer = (player, all) => {
    if (all) setNames([]);
    else
      setNames(
        names.filter((val) => val.toLowerCase() !== player.toLowerCase())
      );
  };

  return (
    <div className="container flex flex-col bg-slate-200 flex mx-auto ms-3 mt-2 mb-2 drop-shadow p-6 rounded">
      <div className="container my-2 mt-5 p-5 border-b border-gray-300">
        <ol className="list-decimal text-center text-slate-900 capitalize font-mono font medium text-xl">
          {names.map((player, id) =>
            React.createElement("li", { key: id }, player)
          )}
        </ol>
      </div>
      <PlayerForm onNewName={addPlayer} onDeletePlayer={deletePlayer} />
    </div>
  );
}

export default PlayerNames;
