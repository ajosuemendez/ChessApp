import React from "react";
import defaultChessboardState from "../utils/defaultChessboardState";
import Square from "./Square";
import "../styles/Board.css";

export default function Board() {

    const [chessboardState, setChessboardState] = React.useState(defaultChessboardState);

    const SquareList = chessboardState.map( (square) => {
        return( 
            <Square key={square.id}
                    id={square.id}
                    piece={square.piece} 
                    shapeFormat={square.shape}
                    color={square.color}
                    framePosition={square.centerPos}/>)
    })

    const handleMouseMove = (e) => {
        const x = e.pageX;
        const y = e.pageY;
        console.log(`X is ${x} and Y is ${y}`);
      };

    return (
        <div className="board">
        <svg width="2339" height="1771" viewBox="0 0 2339 1771" fill="none" xmlns="http://www.w3.org/2000/svg" onMouseMove={handleMouseMove}>
            {SquareList}
        </svg>
        </div>
    );
}
