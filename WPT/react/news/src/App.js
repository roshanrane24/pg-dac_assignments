import "./App.css";
import React from "react";
import News from "./News";
import EmpDataComponent from "./employee/EmpDataComponent";
import SkillList from "./skillList/SkillList";
import PersonName from "./name_form/PersonName";
import PlayerNames from "./player_form/PlayerNames";

let articles = [
  {
    id: 1,
    title: "Champion Verstappen to run No.1 on Red Bull in 2022",
    body: `Max Verstappen says he will run with the number one on his Red Bull
           when he begins his Formula 1 World Champion title defence in 2022.`,
    img: "https://www.topgear.com/sites/default/files/2021/12/7%20Max%20Verstappen%20F1%20champion.jpg?w=892&h=502",
  },
  {
    id: 2,
    title: "NASA’s James Webb telescope launch delayed to December 24",
    body: `The launch of the James Webb Space Telescope, touted as NASA’s next
           great space observatory, has yet again been delayed as the team is
           working to fix a communication issue.`,
    img: "https://www.spaceflightinsider.com/wp-content/uploads/2017/03/JWST_16519914560_5b0d2ac9c4_L-1600.jpg",
  },
  {
    id: 3,
    title:
      "Semiconductor shortage: Cabinet approves Rs 76,000 crore incentive plan to woo manufacturers",
    body: `The Union Cabinet on Wednesday approved the much-awaited incentive
           plan to push manufacturing of semiconductors in the country.`,
    img: "http://www.householdappliancesworld.com/files/2016/09/semiconductor.jpg",
  },
];

const topArticles = articles
// [{}, {}, {}];

function App() {
  return (
    // <News briefArticles={articles} topArticles={topArticles}/>
    // <EmpDataComponent />
    // <SkillList />
    <PlayerNames />
    );
}

export default App;
