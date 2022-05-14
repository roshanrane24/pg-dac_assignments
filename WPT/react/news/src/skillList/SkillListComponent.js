import React from "react";

function SkillListComponent(props) {
  return (
    <ol className="list-decimal list inside">
      {props.children.map((c, i) =>
        React.createElement("li", { key: i }, c.props.children)
      )}
    </ol>
  );
}

export default SkillListComponent;
