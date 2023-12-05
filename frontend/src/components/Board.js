import Quadrant from "./Quadrant"
import "../styles/Board.css"

export default function Board() {

    const quadrantsInfo = [
        {startColorSquare:"white", endColorSquare:"black", rotation:"0"},
        {startColorSquare:"black", endColorSquare:"white", rotation:"60"},
        {startColorSquare:"white", endColorSquare:"black", rotation:"120"},
        {startColorSquare:"black", endColorSquare:"white", rotation:"180"},
        {startColorSquare:"white", endColorSquare:"black", rotation:"240"},
        {startColorSquare:"black", endColorSquare:"white", rotation:"300"},
    ];

    const quadrantList = quadrantsInfo.map((quadrant) => {
        return <Quadrant startColorSquare={quadrant.startColorSquare} endColorSquare={quadrant.endColorSquare} rotate={quadrant.rotation}/>
    })

    return(
        <div className="board">
            {quadrantList}
        {/* <Quadrant startColorSquare={"white"} endColorSquare={"black"} rotate={"0"}/>
        <Quadrant startColorSquare={"black"} endColorSquare={"white"} rotate={"60"}/>
        <Quadrant startColorSquare={"white"} endColorSquare={"black"} rotate={"120"}/>
        <Quadrant startColorSquare={"black"} endColorSquare={"white"} rotate={"180"}/> */}

        </div>
        
    );
}