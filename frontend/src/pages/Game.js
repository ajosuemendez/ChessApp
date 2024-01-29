import React from "react";
import { useLocation } from "react-router-dom";

import Board from "../components/Board";
import Historytable from "../components/HistoryTable";
// import defaultChessboardState from "../utils/defaultChessboardState";


export default function Game() {

    const location = useLocation();
    const gameState = location.state?.gameData || {};
    const [chessboardState, setChessboardState] = React.useState(gameState.boardState);

    React.useEffect(() => {
        localStorage.setItem("gameId", JSON.stringify(gameState.gameId));
    }, [gameState.gameId]);


    const fetchData = async (squareId) => {
        const gameId = JSON.parse(localStorage.getItem("gameId"))
        const response = await fetch(`http://localhost:8080/${gameId}/${squareId}`);
        const data = await response.json();
        console.log(data);
        setChessboardState(data);
    };

    
    const handleClick = (e) => {
        const clickedSquare = e.target.id;
        console.log(`Making API call "Check Valid Moves": selected origin: ${clickedSquare}`);
        console.log("API response......");
        fetchData(clickedSquare);
        return;
    }


    return(
        <>
            <Board chessboardState={chessboardState} handleClick={handleClick}/>
            <Historytable moves={[]}/>
        </>
    );
}