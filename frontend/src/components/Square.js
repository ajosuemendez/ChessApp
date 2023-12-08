import Piece from "./Piece";

export default function Square({id, piece, shapeFormat, color, framePosition}) {

    const handleClick = (e) => {
        console.log(e.target.id);
    };
    
    return(
        <g id="Frame 1" filter="url(#filter0_d_1_3)">
            <path onClick={handleClick} id={id} d={shapeFormat} fill={color} stroke="black" strokeWidth="1.2"/>
            <Piece pieceType={piece} theme={"classic"} framePosition={framePosition} />
        </g>
    );
}