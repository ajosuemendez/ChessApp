import React from "react";
import Piece from "./Piece";
import { getSquareColor } from "../utils/getSquareColor";

export default function Square({id, theme, piece, shapeFormat, isValid, framePosition, handleClick}) {

    let squareColor = getSquareColor(id) === "dark" ? theme.colors.darkSquareColor :  theme.colors.lightSquareColor;


    // Overwrite color if is a valid square
    if (isValid) {
        squareColor = theme.colors.strongSquareColor;
    } 
    if(piece === ""){
    return(
        <g id={`square-${id}`} >
            <path onClick={handleClick} id={id} d={shapeFormat} fill={squareColor} stroke="black" strokeWidth="1.2"/>
            <text style={{ pointerEvents: 'none' }} x={framePosition.x+3} y={framePosition.y+3} dominantBaseline="middle" textAnchor="middle" fill="white">
          {id}
        </text>
            
        </g>
    );
    }
    
    else{
    return(
        <g id={`square-${id}`} >
            <path onClick={handleClick} id={id} d={shapeFormat} fill={squareColor} stroke="black" strokeWidth="1.2"/>
            <Piece pieceType={piece} theme={theme.type} framePosition={framePosition} />
            <text style={{ pointerEvents: 'none' }} x={framePosition.x+3} y={framePosition.y+3} dominantBaseline="middle" textAnchor="middle" fill="white">
          {id}
        </text>
        </g>
    );
    }
}

// style={{ zIndex: 1000 + id }}