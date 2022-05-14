import React, { useState } from "react";

function PlayerForm(props) {
  const [playerName, setPlayerName] = useState("");

  const playerNameHandler = (e) => {
    setPlayerName(e.target.value);
  };

  const deletePlayer = (e) => {
    props.onDeletePlayer(playerName, false);
  };

  const deletePlayers = (e) => {
    props.onDeletePlayer(playerName, true);
  };

  const submitHandler = (e) => {
    e.preventDefault();
    props.onNewName(playerName);
    e.target.value = ""
  };

  return (
    <form onSubmit={submitHandler}>
      <div className="container font-mono ">
        <div className="flex flex-row p-2">
          <label className="block text-center pr-5 align-middle text-medium font-medium text-gray-700">
            Player Name
          </label>
          <input
            type="text"
            name="palyername"
            value={playerName}
            onChange={playerNameHandler}
            className="focus:ring-indigo-500 shadow-md focus:border-indigo-500 flex-1 block w-full rounded rounded-r-md sm:text-sm border-gray-300"
            placeholder=""
          />
        </div>
        <div className="container flex flex-row place-content-evenly mt-2">
          <button
            type="submit"
            className="justify-center bg-blue hover:bg-gray-300 text-gray-800 font-semibold py-2 px-4 border border-gray-400 rounded shadow-md"
          >
            Add Player
          </button>
          <button
            type="button"
            onClick={deletePlayer}
            className="justify-center bg-blue hover:bg-gray-300 text-gray-800 font-semibold py-2 px-4 border border-gray-400 rounded shadow"
          >
            Delete Player
          </button>
          <button
            type="button"
            onClick={deletePlayers}
            className="bg-blue justify-center hover:bg-gray-300 text-gray-800 font-semibold py-2 px-4 border border-gray-400 rounded shadow"
          >
            Delete Players
          </button>
        </div>
      </div>
    </form>
  );
}

export default PlayerForm;
