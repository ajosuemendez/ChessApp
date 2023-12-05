import "../styles/Quadrant.css"
import PolygonSquare from "./PolygonSquare";

export default function Quadrant(props) {
    const firstQuadrantIds = [
                            ["H1", "H2", "H3", "H4"],
                            ["G1", "G2", "G3", "G4"],
                            ["F1", "F2", "F3", "F4"],
                            ["E1", "E2", "E3", "E4"],
                         ];


    const handleClick = (e) =>{
        console.log(e.target.id);
    }

    // const generatePoints = (rowIndex, columnIndex) => {
    //     // Generate points based on rowIndex and columnIndex
    //     let points;
    //     if (rowIndex === 0 && columnIndex == 0) {
    //         points = `${0},${0} ${100},${20} ${100},${100} ${0},${100}`;
    //     }
    //     else if (rowIndex === 1 && columnIndex == 0) {
    //         points = `${0},${0} ${50},${0} ${50},${50} ${0},${50}`;
    //     }
    //     else {
    //         points = `${0},${0} ${50},${0} ${50},${50} ${0},${50}`;
    //     }
    //     return points;
    // };

    // const generateSkew = (rowIndex, columnIndex) => {
    //     // Generate skew values based on rowIndex and columnIndex
    //     const baseSkewX = 0; // Adjust the base skew value
    //     const baseSkewY = 10; // Adjust the base skew value

    //     const skewX = `${(4 - columnIndex) * baseSkewX}deg`;
    //     const skewY = `${(4 - rowIndex) * baseSkewY}deg`;

    //     return `skew(${skewX}, ${skewY})`;
    // };

    // const generateTranslateY = (rowIndex) => {
    //     // Generate translateY value based on rowIndex
    //     // This is just an example, you'll need to replace it with your own logic
    //     let shift;
    //     if (rowIndex === 0) {
    //         shift = '-84%';
    //     } else if (rowIndex === 1) {
    //         shift = '-56%';
    //     } else if (rowIndex === 2) {
    //         shift = '-28%';
    //     } else {
    //         shift = '0%';
    //     }
    //     return `translateY(${shift})`;
    // };
    
    
    const firstQuadrantLayout = firstQuadrantIds.map((row, rowIndex) => {
        return (
            <div key={rowIndex} className="polygon-outer-layer">
                {row.map((id, columnIndex) => {
                    const color = (rowIndex + columnIndex) % 2 === 0 ? props.startColorSquare : props.endColorSquare;
                    // const shape = `shape${(rowIndex * 4 + columnIndex) % 16 + 1}`;
                    // const points = generatePoints(rowIndex, columnIndex);
                    // const skew = generateSkew(rowIndex, columnIndex);
                    // const translateY = generateTranslateY(rowIndex);
                    return <PolygonSquare key={id} id={`${columnIndex}-${rowIndex}`} properId={`${3 - columnIndex}-${3 - rowIndex}`} color={color} handleClick={handleClick}/>
                })}
            </div>
        )
    })

    // console.log(firstQuadrantLayout);
    
    return  <div className="quadrant" style={{transform: `rotate(${props.rotate}deg)`}}> {firstQuadrantLayout}</div>;
            
}