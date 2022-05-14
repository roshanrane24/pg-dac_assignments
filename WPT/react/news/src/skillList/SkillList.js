import React from "react";
import SkillListComponent from "./SkillListComponent";

function SkillList() {
  return (
    <div className="container flex flex-column ml-10 mt-3">
      <SkillListComponent>
        <p>NodeJS</p>
        <p>ReactJS</p>
        <p>Angular 10</p>
        <p>Mongo DB </p>
      </SkillListComponent>
    </div>
  );
}

export default SkillList;
